package com.fustania.backend.service;

import com.fustania.backend.dto.DressDTO;
import com.fustania.backend.dto.MessageDTO;
import com.fustania.backend.exception.InvalidUserDataException;
import com.fustania.backend.model.Dress;
import com.fustania.backend.model.Message;
import com.fustania.backend.model.Country;
import com.fustania.backend.model.User;
import com.fustania.backend.repository.DressRepository;
import com.fustania.backend.repository.MessageRepository;
import com.fustania.backend.repository.CountryRepository;
import com.fustania.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class DressService {
    @Autowired
    private DressRepository dressRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    public List<DressDTO> getAllDresses(String category, String countryName, Double maxPrice, String size, String color, String city, String sellerName) {
        List<Dress> dresses;
        if (category != null && !category.isEmpty()) {
            dresses = dressRepository.findByCategory(category);
        } else if (countryName != null && !countryName.isEmpty()) {
            dresses = dressRepository.findByCountryName(countryName);
        } else if (maxPrice != null) {
            dresses = dressRepository.findByPriceLessThanEqual(maxPrice);
        } else if (size != null && !size.isEmpty()) {
            dresses = dressRepository.findBySize(size);
        } else if (color != null && !color.isEmpty()) {
            dresses = dressRepository.findByColor(color);
        } else if (city != null && !city.isEmpty()) {
            dresses = dressRepository.findByCity(city);
        } else if (sellerName != null && !sellerName.isEmpty()) {
            dresses = dressRepository.findBySellerNameContaining(sellerName);
        } else {
            dresses = dressRepository.findAll();
        }
        return dresses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DressDTO getDressById(Long id) {
        Optional<Dress> dressOptional = dressRepository.findById(id);
        if (dressOptional.isEmpty()) {
            throw new InvalidUserDataException("Dress not found");
        }
        return convertToDTO(dressOptional.get());
    }

    public void createDress(DressDTO dressDTO) {
        if (dressDTO.getName() == null || dressDTO.getName().isEmpty()) {
            throw new InvalidUserDataException("Dress name is required");
        }
        if (dressDTO.getPrice() == null || dressDTO.getPrice() <= 0) {
            throw new InvalidUserDataException("Price must be positive");
        }
        if (dressDTO.getSellerId() == null) {
            throw new InvalidUserDataException("Seller ID is required");
        }
        if (dressDTO.getCountryName() == null || dressDTO.getCountryName().isEmpty()) {
            throw new InvalidUserDataException("Country is required");
        }

        Optional<User> sellerOptional = userRepository.findById(dressDTO.getSellerId());
        if (sellerOptional.isEmpty()) {
            throw new InvalidUserDataException("Seller not found");
        }
        User seller = sellerOptional.get();
        if (!seller.getRole().toString().equals("SELLER")) {
            throw new InvalidUserDataException("User must be a seller to create a dress listing");
        }

        Country country = countryRepository.findByName(dressDTO.getCountryName());
        if (country == null) {
            throw new InvalidUserDataException("Invalid country");
        }

        Dress dress = convertToEntity(dressDTO);
        dressRepository.save(dress);
    }

    public void sendMessageAndOffer(MessageDTO messageDTO) {
        if (messageDTO.getSenderEmail() == null || messageDTO.getSenderEmail().isEmpty()) {
            throw new InvalidUserDataException("Sender email is required");
        }
        if (messageDTO.getContent() == null || messageDTO.getContent().isEmpty()) {
            throw new InvalidUserDataException("Message content is required");
        }
        Optional<Dress> dressOptional = dressRepository.findById(messageDTO.getDressId());
        if (dressOptional.isEmpty()) {
            throw new InvalidUserDataException("Dress not found");
        }
        Optional<User> sellerOptional = userRepository.findById(messageDTO.getSellerId());
        if (sellerOptional.isEmpty()) {
            throw new InvalidUserDataException("Seller not found");
        }
        if (messageDTO.getOfferPrice() != null && messageDTO.getOfferPrice() <= 0) {
            throw new InvalidUserDataException("Offer price must be positive");
        }

        Message message = new Message();
        message.setSenderEmail(messageDTO.getSenderEmail());
        message.setContent(messageDTO.getContent());
        message.setOfferPrice(messageDTO.getOfferPrice());
        message.setDress(dressOptional.get());
        message.setSeller(sellerOptional.get());
        messageRepository.save(message);
    }

    public List<DressDTO> getDressesBySellerId(Long sellerId) {
        List<Dress> dresses = dressRepository.findBySellerId(sellerId);
        return dresses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<MessageDTO> getMessagesBySellerId(Long sellerId) {
        List<Message> messages = messageRepository.findBySellerId(sellerId);
        return messages.stream().map(this::convertMessageToDTO).collect(Collectors.toList());
    }

    public DressDTO convertToDTO(Dress dress) {
        DressDTO dto = new DressDTO();
        dto.setId(dress.getId());
        dto.setName(dress.getName());
        dto.setDescription(dress.getDescription());
        dto.setPrice(dress.getPrice());
        dto.setCategory(dress.getCategory());
        dto.setSize(dress.getSize());
        dto.setColor(dress.getColor());
        dto.setCity(dress.getCity());
        dto.setPhotoUrl(dress.getPhotoUrl());
        dto.setCountryName(dress.getCountry().getName());
        dto.setSellerId(dress.getSeller().getId());
        dto.setSellerName(dress.getSeller().getFirstName() + " " + dress.getSeller().getLastName());
        dto.setSellerEmail(dress.getSeller().getEmail());
        dto.setSellerAddress(dress.getSeller().getAddress());
        return dto;
    }

    public Dress convertToEntity(DressDTO dto) {
        Dress dress = new Dress();
        dress.setId(dto.getId());
        dress.setName(dto.getName());
        dress.setDescription(dto.getDescription());
        dress.setPrice(dto.getPrice());
        dress.setCategory(dto.getCategory());
        dress.setSize(dto.getSize());
        dress.setColor(dto.getColor());
        dress.setCity(dto.getCity());
        dress.setPhotoUrl(dto.getPhotoUrl());
        Country country = countryRepository.findByName(dto.getCountryName());
        if (country == null) {
            throw new InvalidUserDataException("Invalid country");
        }
        dress.setCountry(country);
        User seller = userRepository.findById(dto.getSellerId()).orElse(null);
        if (seller == null) {
            throw new InvalidUserDataException("Invalid seller");
        }
        dress.setSeller(seller);
        return dress;
    }

    public MessageDTO convertMessageToDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setSenderEmail(message.getSenderEmail());
        dto.setContent(message.getContent());
        dto.setOfferPrice(message.getOfferPrice());
        dto.setDressId(message.getDress().getId());
        dto.setSellerId(message.getSeller().getId());
        return dto;
    }
}
package com.fustania.fustania_backend.service;

import com.fustania.fustania_backend.dto.DressRequest;
import com.fustania.fustania_backend.dto.DressResponse;
import com.fustania.fustania_backend.model.Dress;
import com.fustania.fustania_backend.model.User;
import com.fustania.fustania_backend.repository.DressRepository;
import com.fustania.fustania_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DressService {

    private final DressRepository dressRepository;
    private final UserRepository userRepository;

    public DressService(DressRepository dressRepository, UserRepository userRepository) {
        this.dressRepository = dressRepository;
        this.userRepository = userRepository;
    }

    public DressResponse createDress(DressRequest dressRequest, List<MultipartFile> photos, String email) {
        Optional<User> seller = userRepository.findByEmail(email);
        if (seller.isEmpty() || !seller.get().getRole().equals("SELLER")) {
            throw new RuntimeException("Only sellers can create dresses");
        }

        Dress dress = new Dress();
        dress.setDescription(dressRequest.getDescription());
        dress.setPrice(dressRequest.getPrice());
        dress.setSize(dressRequest.getSize());
        dress.setColor(dressRequest.getColor());
        dress.setQyteti(dressRequest.getQyteti());
        dress.setShteti(dressRequest.getShteti());
        dress.setDesigner(dressRequest.getDesigner());
        dress.setSeller(seller.get());

        List<String> photoPaths = photos.stream()
                .map(file -> {
                    String path = "uploads/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    try {
                        file.transferTo(new File(path));
                        return "http://localhost:8080/uploads/" + path.substring(8);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to save photo");
                    }
                })
                .collect(Collectors.toList());
        dress.setPhotos(photoPaths);

        Dress savedDress = dressRepository.save(dress);
        return mapToDressResponse(savedDress);
    }

    public List<DressResponse> getAllDresses(Map<String, String> filters) {
        String designer = filters.get("designer").isEmpty() ? null : "%" + filters.get("designer").toLowerCase() + "%";
        String size = filters.get("size").isEmpty() ? null : filters.get("size");
        Double maxPrice = filters.get("maxPrice").isEmpty() ? null : Double.parseDouble(filters.get("maxPrice"));
        String color = filters.get("color").isEmpty() ? null : "%" + filters.get("color").toLowerCase() + "%";
        String qyteti = filters.get("qyteti").isEmpty() ? null : "%" + filters.get("qyteti").toLowerCase() + "%";
        String shteti = filters.get("shteti").isEmpty() ? null : filters.get("shteti");

        return dressRepository.findByFilters(designer, size, maxPrice, color, qyteti, shteti)
                .stream()
                .map(this::mapToDressResponse)
                .collect(Collectors.toList());
    }

    public DressResponse getDressById(Long id) {
        Dress dress = dressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dress not found"));
        return mapToDressResponse(dress);
    }

    public List<DressResponse> getDressesBySeller(String email) {
        Optional<User> seller = userRepository.findByEmail(email);
        if (seller.isEmpty()) {
            throw new RuntimeException("Seller not found");
        }
        return dressRepository.findBySeller(seller.get())
                .stream()
                .map(this::mapToDressResponse)
                .collect(Collectors.toList());
    }

    public void deleteDress(Long id) {
        if (!dressRepository.existsById(id)) {
            throw new RuntimeException("Dress not found");
        }
        dressRepository.deleteById(id);
    }

    private DressResponse mapToDressResponse(Dress dress) {
        DressResponse response = new DressResponse();
        response.setId(dress.getId());
        response.setDescription(dress.getDescription());
        response.setPrice(dress.getPrice());
        response.setSize(dress.getSize());
        response.setColor(dress.getColor());
        response.setQyteti(dress.getQyteti());
        response.setShteti(dress.getShteti());
        response.setDesigner(dress.getDesigner());
        response.setPhotos(dress.getPhotos());
        response.setSellerId(dress.getSeller().getId());
        response.setSellerName(dress.getSeller().getFirstName() + " " + dress.getSeller().getLastName());
        response.setSellerEmail(dress.getSeller().getEmail());
        return response;
    }
}
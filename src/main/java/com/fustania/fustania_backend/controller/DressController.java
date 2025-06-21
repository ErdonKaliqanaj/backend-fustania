package com.fustania.fustania_backend.controller;

import com.fustania.fustania_backend.dto.DressRequest;
import com.fustania.fustania_backend.dto.DressResponse;
import com.fustania.fustania_backend.service.DressService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dresses")
public class DressController {

    private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    @PostMapping
    public ResponseEntity<DressResponse> createDress(
            @RequestPart("dress") DressRequest dressRequest,
            @RequestPart("photos") List<MultipartFile> photos) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        DressResponse dressResponse = dressService.createDress(dressRequest, photos, email);
        return ResponseEntity.ok(dressResponse);
    }

    @GetMapping
    public ResponseEntity<List<DressResponse>> getAllDresses(
            @RequestParam(required = false) String designer,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String qyteti,
            @RequestParam(required = false) String shteti) {
        Map<String, String> filters = Map.of(
                "designer", designer != null ? designer : "",
                "size", size != null ? size : "",
                "maxPrice", maxPrice != null ? maxPrice.toString() : "",
                "color", color != null ? color : "",
                "qyteti", qyteti != null ? qyteti : "",
                "shteti", shteti != null ? shteti : ""
        );
        List<DressResponse> dresses = dressService.getAllDresses(filters);
        return ResponseEntity.ok(dresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DressResponse> getDressById(@PathVariable Long id) {
        DressResponse dress = dressService.getDressById(id);
        return ResponseEntity.ok(dress);
    }

    @GetMapping("/my-dresses")
    public ResponseEntity<List<DressResponse>> getMyDresses() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        List<DressResponse> dresses = dressService.getDressesBySeller(email);
        return ResponseEntity.ok(dresses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDress(@PathVariable Long id) {
        dressService.deleteDress(id);
        return ResponseEntity.noContent().build();
    }
}

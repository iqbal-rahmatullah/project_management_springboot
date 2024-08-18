package com.project_management_springboot.controller;

import com.project_management_springboot.model.Lokasi;
import com.project_management_springboot.response.ResponseHandler;
import com.project_management_springboot.service.LokasiService;
import com.project_management_springboot.service.ProyekService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    LokasiService lokasiService;

    @GetMapping
    public ResponseEntity<Object> all() {
        return ResponseHandler.responseBuilder("Berhasil mendapatkan semua lokasi", HttpStatus.OK, lokasiService.all());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Lokasi lokasi) {
        Lokasi result = lokasiService.create(lokasi);
        return ResponseHandler.responseBuilder("Lokasi berhasil dibuat", HttpStatus.CREATED, result);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid Lokasi lokasi) {
        Lokasi result = lokasiService.update(lokasi);
        return ResponseHandler.responseBuilder("Lokasi berhasil diupdate", HttpStatus.OK, result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") int id) {
        Lokasi result = lokasiService.delete(id);
    return ResponseHandler.responseBuilder("Lokasi berhasil dihapus", HttpStatus.OK, result);
    }
}

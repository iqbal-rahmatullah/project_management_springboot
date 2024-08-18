package com.project_management_springboot.controller;

import com.project_management_springboot.data.ProyekDTO;
import com.project_management_springboot.model.Lokasi;
import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.response.ResponseHandler;
import com.project_management_springboot.service.LokasiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.project_management_springboot.service.ProyekService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proyek")
public class ProyekController {
    @Autowired
    ProyekService proyekService;
    @Autowired
    LokasiService lokasiService;

    @GetMapping
    public ResponseEntity<Object> all() {
        return ResponseHandler.responseBuilder("Berhasil mendapatkan semua proyek", HttpStatus.OK,  proyekService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProyekById(@PathVariable(name = "id") int id) {
        return ResponseHandler.responseBuilder("Berhasil mendapatkan proyek dengan id: " + id, HttpStatus.OK, proyekService.getProyekById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ProyekDTO proyek) {
        if (proyek.getTanggalMulai().isAfter(proyek.getTanggalSelesai())) {
            return ResponseHandler.responseBuilder("Tanggal mulai tidak boleh lebih besar dari tanggal selesai", HttpStatus.BAD_REQUEST, Map.of(
                    "tanggalMulai", proyek.getTanggalMulai(),
                    "tanggalSelesai", proyek.getTanggalSelesai()
            ));
        }

        List<Lokasi> lokasi = lokasiService.getLokasiById(proyek.getLokasiId());
        if (lokasi.isEmpty()) {
            return ResponseHandler.responseBuilder("Lokasi yang dimasukkan salah", HttpStatus.BAD_REQUEST, Map.of(
                    "lokasiId", proyek.getLokasiId()
            ));
        }

        return ResponseHandler.responseBuilder("Proyek berhasil dibuat", HttpStatus.CREATED,  proyekService.create(proyek));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") int id) {
        return ResponseHandler.responseBuilder("Proyek berhasil dihapus", HttpStatus.OK, proyekService.delete(id));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid ProyekDTO proyek) {
        if (proyek.getTanggalMulai().isAfter(proyek.getTanggalSelesai())) {
            return ResponseHandler.responseBuilder("Tanggal mulai tidak boleh lebih besar dari tanggal selesai", HttpStatus.BAD_REQUEST, Map.of(
                    "tanggalMulai", proyek.getTanggalMulai(),
                    "tanggalSelesai", proyek.getTanggalSelesai()
            ));
        }

        List<Lokasi> lokasi = lokasiService.getLokasiById(proyek.getLokasiId());
        if (lokasi.isEmpty()) {
            return ResponseHandler.responseBuilder("Lokasi yang dimasukkan salah", HttpStatus.BAD_REQUEST, Map.of(
                    "lokasiId", proyek.getLokasiId()
            ));
        }
        return ResponseHandler.responseBuilder("Proyek berhasil diupdate", HttpStatus.OK, proyekService.update(proyek));
    }
}

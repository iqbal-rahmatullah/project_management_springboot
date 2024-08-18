package com.project_management_springboot.service.impl;

import com.project_management_springboot.exception.ResourceNotFoundException;
import com.project_management_springboot.model.Lokasi;
import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.repository.LokasiRepository;
import com.project_management_springboot.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokasiServiceImpl implements LokasiService {
    @Autowired
    LokasiRepository lokasiRepository;

    @Override
    public List<Lokasi> all() {
        List<Lokasi> allLokasi = lokasiRepository.findAll();
        if (allLokasi.isEmpty()) {
            throw new ResourceNotFoundException("Belum ada lokasi yang tersedia");
        }
        return allLokasi;
    }

    @Override
    public Lokasi create(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    @Override
    public Lokasi update(Lokasi lokasi) {
        lokasiRepository.findById(lokasi.getId()).orElseThrow(() -> new ResourceNotFoundException("Lokasi tidak ditemukan dengan id: " + lokasi.getId()));
        return lokasiRepository.save(lokasi);
    }

    @Override
    public Lokasi delete(int id) {
        Lokasi lokasi = lokasiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lokasi tidak ditemukan dengan id: " + id));
        lokasi.getProyek().clear();
        lokasiRepository.save(lokasi);
        lokasiRepository.delete(lokasi);
        return lokasi;
    }

    @Override
    public List<Lokasi> getLokasiById(List<Integer> id) {
        return lokasiRepository.findAllById(id);
    }
}

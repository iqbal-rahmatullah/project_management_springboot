package com.project_management_springboot.service.impl;

import com.project_management_springboot.data.ProyekDTO;
import com.project_management_springboot.exception.ResourceNotFoundException;
import com.project_management_springboot.model.Lokasi;
import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.repository.LokasiRepository;
import com.project_management_springboot.repository.ProyekRepository;
import com.project_management_springboot.response.ResponseHandler;
import com.project_management_springboot.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.project_management_springboot.service.ProyekService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProyekServiceImpl implements ProyekService {
    @Autowired
    ProyekRepository proyekRepository;
    @Autowired
    LokasiService lokasiService;
    @Autowired
    LokasiRepository lokasiRepository;

    @Override
    public Proyek create(ProyekDTO proyek) {
        Proyek newProyek = new Proyek(proyek.getNamaProyek(), proyek.getClient(), proyek.getTanggalMulai(), proyek.getTanggalSelesai(), proyek.getPimpinanProyek(), proyek.getKeterangan());

        Set<Lokasi> lokasiSet = new HashSet<>(lokasiService.getLokasiById(proyek.getLokasiId()));
        newProyek.setLokasi(new HashSet<>(lokasiSet));
        for (Lokasi lokasi : lokasiSet) {
            lokasi.getProyek().add(newProyek);
        }
        proyekRepository.save(newProyek);


        return newProyek;
    }

    @Override
    public List<Proyek> all() {
         List<Proyek> allProyek = proyekRepository.findAll();
            if (allProyek.isEmpty()) {
                throw new ResourceNotFoundException("Belum ada proyek yang tersedia");
            }
            return allProyek;
    }

    @Override
    public Proyek getProyekById(int id) {
        return proyekRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyek tidak ditemukan dengan id: " + id));
    }

    @Override
    public Proyek update(ProyekDTO proyek) {
        Proyek updateProyek = proyekRepository.findById(proyek.getId()).orElseThrow(() -> new ResourceNotFoundException("Proyek tidak ditemukan dengan id: " + proyek.getId()));

        Set<Lokasi> lokasiExisting = updateProyek.getLokasi();
        Set<Lokasi> lokasiBaru = new HashSet<>(lokasiService.getLokasiById(proyek.getLokasiId()));

        for (Lokasi lokasi : lokasiExisting) {
            if (!lokasiBaru.contains(lokasi)) {
                lokasi.getProyek().remove(updateProyek);
            }
        }

        updateProyek.setLokasi(lokasiBaru);

        for (Lokasi lokasi : lokasiBaru) {
            lokasi.getProyek().add(updateProyek);
        }
        updateProyek.setNamaProyek(proyek.getNamaProyek());
        updateProyek.setClient(proyek.getClient());
        updateProyek.setTanggalMulai(proyek.getTanggalMulai());
        updateProyek.setTanggalSelesai(proyek.getTanggalSelesai());
        updateProyek.setPimpinanProyek(proyek.getPimpinanProyek());
        updateProyek.setKeterangan(proyek.getKeterangan());

       return proyekRepository.save(updateProyek);
    }

    @Override
    public Proyek delete(int id) {
        Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyek tidak ditemukan dengan id: " + id));
        for (Lokasi lokasi : proyek.getLokasi()) {
            lokasi.getProyek().remove(proyek);
            lokasiRepository.save(lokasi);
        }

        proyek.getLokasi().clear();
        proyekRepository.save(proyek);

        proyekRepository.delete(proyek);

        return proyek;
    }
}

package com.project_management_springboot.service.impl;

import com.project_management_springboot.exception.ResourceNotFoundException;
import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.repository.ProyekRepository;
import com.project_management_springboot.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project_management_springboot.service.ProyekService;

import java.util.List;

@Service
public class ProyekServiceImpl implements ProyekService {
    @Autowired
    ProyekRepository proyekRepository;

    @Override
    public Proyek create(Proyek proyek) {
        return proyekRepository.save(proyek);
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
    public Proyek update(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    @Override
    public Proyek delete(int id) {
        Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyek tidak ditemukan dengan id: " + id));
        proyekRepository.delete(proyek);
        return proyek;
    }
}

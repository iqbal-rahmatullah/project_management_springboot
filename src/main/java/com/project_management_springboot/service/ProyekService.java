package com.project_management_springboot.service;

import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProyekService {
    public Proyek create(Proyek proyek);
    public List<Proyek> all();
    public Proyek getProyekById(int id);
    public Proyek update(Proyek proyek);
    public Proyek delete(int id);
}

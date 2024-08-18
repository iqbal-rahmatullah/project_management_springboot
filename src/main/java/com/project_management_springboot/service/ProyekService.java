package com.project_management_springboot.service;

import com.project_management_springboot.data.ProyekDTO;
import com.project_management_springboot.model.Proyek;
import com.project_management_springboot.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProyekService {
    public Proyek create(ProyekDTO proyek);
    public List<Proyek> all();
    public Proyek getProyekById(int id);
    public Proyek update(ProyekDTO proyek);
    public Proyek delete(int id);
}

package com.project_management_springboot.repository;

import com.project_management_springboot.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}

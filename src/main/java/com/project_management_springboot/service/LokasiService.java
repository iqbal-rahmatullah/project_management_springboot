package com.project_management_springboot.service;

import com.project_management_springboot.model.Lokasi;

import java.util.List;
import java.util.Set;

public interface LokasiService {
    public List<Lokasi> all();
    public Lokasi create(Lokasi lokasi);
    public Lokasi update(Lokasi lokasi);
    public Lokasi delete(int id);
    public List<Lokasi> getLokasiById(List<Integer> id);
}

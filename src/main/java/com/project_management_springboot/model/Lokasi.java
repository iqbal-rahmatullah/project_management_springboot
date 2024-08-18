package com.project_management_springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nama lokasi tidak boleh kosong")
    @Size(max = 100, message = "Nama lokasi tidak boleh melebihi 100 karakter")
    private String namaLokasi;

    @NotBlank(message = "Negara tidak boleh kosong")
    @Size(max = 100, message = "Negara tidak boleh melebihi 100 karakter")
    private String negara;

    @NotBlank(message = "Provinsi tidak boleh kosong")
    @Size(max = 100, message = "Provinsi tidak boleh melebihi 100 karakter")
    private String provinsi;

    @NotBlank(message = "Kota tidak boleh kosong")
    @Size(max = 100, message = "Kota tidak boleh melebihi 100 karakter")
    private String kota;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "lokasi_id"),
            inverseJoinColumns = @JoinColumn(name = "proyek_id")
    )
    @JsonIgnore
    private Set<Proyek> proyek;

    public Lokasi(String provinsi, String namaLokasi, String negara, String kota) {
        this.provinsi = provinsi;
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.kota = kota;
    }

    public Lokasi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Nama lokasi tidak boleh kosong") @Size(max = 100, message = "Nama lokasi tidak boleh melebihi 100 karakter") String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(@NotBlank(message = "Nama lokasi tidak boleh kosong") @Size(max = 100, message = "Nama lokasi tidak boleh melebihi 100 karakter") String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public @NotBlank(message = "Negara tidak boleh kosong") @Size(max = 100, message = "Negara tidak boleh melebihi 100 karakter") String getNegara() {
        return negara;
    }

    public void setNegara(@NotBlank(message = "Negara tidak boleh kosong") @Size(max = 100, message = "Negara tidak boleh melebihi 100 karakter") String negara) {
        this.negara = negara;
    }

    public @NotBlank(message = "Provinsi tidak boleh kosong") @Size(max = 100, message = "Provinsi tidak boleh melebihi 100 karakter") String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(@NotBlank(message = "Provinsi tidak boleh kosong") @Size(max = 100, message = "Provinsi tidak boleh melebihi 100 karakter") String provinsi) {
        this.provinsi = provinsi;
    }

    public @NotBlank(message = "Kota tidak boleh kosong") @Size(max = 100, message = "Kota tidak boleh melebihi 100 karakter") String getKota() {
        return kota;
    }

    public void setKota(@NotBlank(message = "Kota tidak boleh kosong") @Size(max = 100, message = "Kota tidak boleh melebihi 100 karakter") String kota) {
        this.kota = kota;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Proyek> getProyek() {
        return proyek;
    }

    public void setProyek(Set<Proyek> proyek) {
        this.proyek = proyek;
    }
}

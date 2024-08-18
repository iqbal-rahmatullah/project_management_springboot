package com.project_management_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nama Proyek tidak boleh kosong")
    @Size(max = 100, message = "Nama proyek tidak boleh melebihi 100 karakter")
    private String namaProyek;

    @NotBlank(message = "Nama client tidak boleh kosong")
    @Size(max = 100, message = "Nama client tidak boleh melebihi 100 karakter")
    private String client;

    @NotNull(message = "Tanggal mulai tidak boleh kosong")
    @FutureOrPresent(message = "Tanggal mulai tidak boleh kurang dari hari ini")
    private LocalDate tanggalMulai;

    @NotNull(message = "Tanggal selesai tidak boleh kosong")
    @FutureOrPresent(message = "Tanggal selesai tidak boleh kurang dari hari ini")
    private LocalDate tanggalSelesai;

    @NotBlank(message = "Pimpinan proyek tidak boleh kosong")
    @Size(max = 100, message = "Pimpinan proyek tidak boleh melebihi 100 karakter")
    private String pimpinanProyek;

    @Size(max = 255, message = "Keterangan tidak boleh melebihi 255 karakter")
    private String keterangan;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "proyek_lokasi",
        joinColumns = @JoinColumn(name = "proyek_id"),
        inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Lokasi> lokasi;

    public Proyek(String namaProyek, String client, LocalDate tanggalMulai, LocalDate tanggalSelesai, String pimpinanProyek, String keterangan) {
        this.namaProyek = namaProyek;
        this.client = client;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
    }

    public Proyek() {
    }

    public @NotNull(message = "Tanggal selesai tidak boleh kosong") @FutureOrPresent(message = "Tanggal selesai tidak boleh kurang dari hari ini") LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(@NotNull(message = "Tanggal selesai tidak boleh kosong") @FutureOrPresent(message = "Tanggal selesai tidak boleh kurang dari hari ini") LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public @NotBlank(message = "Nama Proyek tidak boleh kosong") @Size(max = 100, message = "Nama proyek tidak boleh melebihi 100 karakter") String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(@NotBlank(message = "Nama Proyek tidak boleh kosong") @Size(max = 100, message = "Nama proyek tidak boleh melebihi 100 karakter") String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public @NotBlank(message = "Nama client tidak boleh kosong") @Size(max = 100, message = "Nama client tidak boleh melebihi 100 karakter") String getClient() {
        return client;
    }

    public void setClient(@NotBlank(message = "Nama client tidak boleh kosong") @Size(max = 100, message = "Nama client tidak boleh melebihi 100 karakter") String client) {
        this.client = client;
    }

    public @NotNull(message = "Tanggal mulai tidak boleh kosong") @FutureOrPresent(message = "Tanggal mulai tidak boleh kurang dari hari ini") LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(@NotNull(message = "Tanggal mulai tidak boleh kosong") @FutureOrPresent(message = "Tanggal mulai tidak boleh kurang dari hari ini") LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public @NotBlank(message = "Pimpinan proyek tidak boleh kosong") @Size(max = 100, message = "Pimpinan proyek tidak boleh melebihi 100 karakter") String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(@NotBlank(message = "Pimpinan proyek tidak boleh kosong") @Size(max = 100, message = "Pimpinan proyek tidak boleh melebihi 100 karakter") String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public @Size(max = 255, message = "Keterangan tidak boleh melebihi 255 karakter") String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(@Size(max = 255, message = "Keterangan tidak boleh melebihi 255 karakter") String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.project_management_springboot.data;

import com.project_management_springboot.model.Lokasi;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ProyekDTO {
    private Integer id;

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

    @NotEmpty(message = "Lokasi tidak boleh kosong")
    private List<Integer> lokasiId;

    public ProyekDTO() {}

    public ProyekDTO(Integer id, String namaProyek, String client, LocalDate tanggalMulai, LocalDate tanggalSelesai, String pimpinanProyek, String keterangan, List<Integer> lokasiId) {
        this.id = id;
        this.namaProyek = namaProyek;
        this.client = client;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.lokasiId = lokasiId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public @NotNull(message = "Tanggal selesai tidak boleh kosong") @FutureOrPresent(message = "Tanggal selesai tidak boleh kurang dari hari ini") LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(@NotNull(message = "Tanggal selesai tidak boleh kosong") @FutureOrPresent(message = "Tanggal selesai tidak boleh kurang dari hari ini") LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
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

    public @NotEmpty(message = "Lokasi tidak boleh kosong") List<Integer> getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(@NotEmpty(message = "Lokasi tidak boleh kosong") List<Integer> lokasiId) {
        this.lokasiId = lokasiId;
    }
}

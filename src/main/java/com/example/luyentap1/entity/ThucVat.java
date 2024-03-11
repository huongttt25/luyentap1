package com.example.luyentap1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ThucVat {

    @Id
    private Integer id;

    private String loaiCay;

    private String ten;

    private Integer tuoi;

    private Boolean gioiTinh;

    private String khuVuc;
}

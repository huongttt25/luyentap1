package com.example.luyentap1.service;

import com.example.luyentap1.entity.ThucVat;

import java.util.List;

public interface ThucVatService {

    List<ThucVat> getAll();

    void addThucVat(ThucVat tv);

    ThucVat detailThucVat(Integer id);

    void xoaThucVat(Integer id);

    ThucVat updateThucVat(Integer id, ThucVat tv);

    List<ThucVat> timKiemThucVat(String ten, int tuoiMax, int tuoiMin);
}

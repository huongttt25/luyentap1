package com.example.luyentap1.service.impl;

import com.example.luyentap1.entity.ThucVat;
import com.example.luyentap1.service.ThucVatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThucVatServiceImpl implements ThucVatService {

    private List<ThucVat> list = new ArrayList<>();

    public ThucVatServiceImpl(){
        list.add(new ThucVat(1, "Category 1", "C1", 1, true,"1"));
        list.add(new ThucVat(2, "Category 1", "C1", 1, true,"1"));
        list.add(new ThucVat(3, "Category 1", "C1", 1, true,"1"));
        list.add(new ThucVat(4, "Category 1", "C1", 1, true,"1"));
        list.add(new ThucVat(5, "Category 1", "C1", 1, true,"1"));
        list.add(new ThucVat(6, "Category 1", "C1", 1, true,"1"));
    }
    @Override
    public List<ThucVat> getAll() {
        return list;
    }

    @Override
    public void addThucVat(ThucVat tv) {
        list.add(tv);
    }

    @Override
    public ThucVat detailThucVat(Integer id) {
        for(int i =0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public void xoaThucVat(Integer id) {
        for(int i =0; i < list.size(); i++) {
            list.remove(i);
            break;
        }
    }

    @Override
    public ThucVat updateThucVat(Integer id, ThucVat tv) {
        for(int i =0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return list.set(i, tv);
            }
        }
        return tv;
    }

    @Override
    public List<ThucVat> timKiemThucVat(String ten, int tuoiMax, int tuoiMin) {
        List<ThucVat> result = new ArrayList<>();
        for (ThucVat tv : list) {
            if ((ten.isEmpty() || tv.getTen().contains(ten))
                    && tv.getTuoi() >= tuoiMin && tv.getTuoi() <= tuoiMax) {
                result.add(tv);
            }
        }
        return result;
    }
}

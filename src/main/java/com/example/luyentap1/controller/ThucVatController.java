package com.example.luyentap1.controller;

import com.example.luyentap1.entity.ThucVat;
import com.example.luyentap1.service.impl.ThucVatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ThucVatController {

    @Autowired
    ThucVatServiceImpl service;

    List<ThucVat> list;

    @GetMapping("/thuc-vat/hien-thi-tat-ca")
    public String hienThiThucVat(Model model){
        list = service.getAll();
        model.addAttribute("list", list);
        return "thucvat";
    }

    @GetMapping("/thuc-vat/detail/{id}")
    public String detailThucVat(@PathVariable("id") Integer id, Model model) {
        ThucVat tv = service.detailThucVat(id);
        model.addAttribute("tv", tv);
        list = service.getAll();
        model.addAttribute("list", list);
        return"thucvat";
    }

    @GetMapping("/thuc-vat/remove/{id}")
    public String removeThucVat(@PathVariable("id") Integer id) {
        service.xoaThucVat(id);
        return"redirect:/thuc-vat/hien-thi-tat-ca";
    }

    @GetMapping("/thuc-vat/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        ThucVat tv = service.detailThucVat(id);
        model.addAttribute("tv", tv);
        return "view-update";
    }

    @PostMapping("/thuc-vat/add")
    public String addThucVat(@RequestParam Integer id,
                             @RequestParam String loaiCay,
                             @RequestParam String ten,
                             @RequestParam Integer tuoi,
                             @RequestParam Boolean gioiTinh,
                             @RequestParam String khuVuc) {
        ThucVat tv = ThucVat.builder()
                .loaiCay(loaiCay)
                .gioiTinh(gioiTinh)
                .id(id)
                .ten(ten)
                .tuoi(tuoi)
                .khuVuc(khuVuc)
                .build();
        service.addThucVat(tv);
        return "redirect:/thuc-vat/hien-thi-tat-ca";
    }

//    @PostMapping("/thuc-vat/update")
//    public String updateThucVat(@RequestParam Integer id,
//                                @RequestParam String loaiCay,
//                                @RequestParam String ten,
//                                @RequestParam Integer tuoi,
//                                @RequestParam Boolean gioiTinh,
//                                @RequestParam String khuVuc) {
//        ThucVat tv = ThucVat.builder()
//                .loaiCay(loaiCay)
//                .gioiTinh(gioiTinh)
//                .id(id)
//                .ten(ten)
//                .tuoi(tuoi)
//                .khuVuc(khuVuc)
//                .build();
//        service.updateThucVat(id, tv);
//        return "redirect:/thuc-vat/hien-thi-tat-ca";
//    }
    @PostMapping("/thuc-vat/update/{id}")
    public String updateThucVat(@PathVariable("id") Integer id, ThucVat tv,  Model model) {
        service.updateThucVat(id, tv);
        model.addAttribute("tv", tv);
        return "redirect:/thuc-vat/hien-thi-tat-ca";
    }

    @GetMapping("/thuc-vat/tim-kiem")
    public String timKiemThucVat(@RequestParam("ten") String ten,
                                        @RequestParam("tuoiMin") Integer tuoiMin,
                                        @RequestParam("tuoiMax") Integer tuoiMax,
                                        Model model) {
        model.addAttribute("list", service.timKiemThucVat(ten, tuoiMin, tuoiMax));
        return "redirect:/thuc-vat/hien-thi-tat-ca";
    }
}

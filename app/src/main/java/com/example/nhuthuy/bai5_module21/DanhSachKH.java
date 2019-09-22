package com.example.nhuthuy.bai5_module21;

import java.util.ArrayList;

public class DanhSachKH {
    ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();

    public void addKH(KhachHang kh){
        listKH.add(kh);
    }

    public double tongDT(){
        double tien = 0.0;
        for(KhachHang kh:listKH){
            tien+=kh.thanhTien();
        }
        return  tien;
    }

    public int tongKH(){
        return  listKH.size();
    }

    public  int tongKHVip(){
        int s = 0;
        for(KhachHang kh:listKH){
            if(kh.isVip())
                s++;
        }
        return s;
    }
}

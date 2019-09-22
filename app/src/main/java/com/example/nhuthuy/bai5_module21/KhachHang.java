package com.example.nhuthuy.bai5_module21;

public class KhachHang {
    private String tenKH;
    private int slmua;
    private boolean isVip;
    public static final int GIA=20000;

    public KhachHang() {
    }

    public KhachHang(String tenKH, int slmua, boolean isVip) {
        this.tenKH = tenKH;
        this.slmua = slmua;
        this.isVip = isVip;
    }

    public String getTenKH() {
        return tenKH;
    }

    public int getSlmua() {
        return slmua;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSlmua(int slmua) {
        this.slmua = slmua;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public double thanhTien(){
        return (!isVip?slmua*GIA:slmua*GIA*0.9);
    }
}

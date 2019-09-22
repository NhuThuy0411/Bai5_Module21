package com.example.nhuthuy.bai5_module21;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edKH, edSL, edtongKH, edtongKHV, edTongTT;
    TextView tvTT;
    CheckBox chkVip;
    Button btnTT, btnTiep, btnTK;
    ImageButton imbtnThoat;
    DanhSachKH danhsach = new DanhSachKH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        addEvent();
    }

    private void getControls(){
        btnTT = (Button) findViewById(R.id.btn_tinhTien);
        btnTiep = (Button) findViewById(R.id.btn_Tiep);
        btnTK = (Button)findViewById(R.id.btn_thongKe);
        imbtnThoat = (ImageButton) findViewById(R.id.btn_Thoat);
        edKH = (EditText) findViewById(R.id.ed_Ten);
        edSL = (EditText) findViewById(R.id.ed_Sach);
        edtongKH = (EditText) findViewById(R.id.ed_tongKH);
        edtongKHV = (EditText) findViewById(R.id.ed_tongKHVIP);
        edTongTT = (EditText) findViewById(R.id.ed_tongDT);
        tvTT = (TextView) findViewById(R.id.tv_thanhTien);
        chkVip = (CheckBox) findViewById(R.id.chk_KHV);
    }

    private void addEvent(){
        btnTT.setOnClickListener(new ProcessMyEvent());
        btnTiep.setOnClickListener(new ProcessMyEvent());
        btnTK.setOnClickListener(new ProcessMyEvent());
        imbtnThoat.setOnClickListener(new ProcessMyEvent());
    }


    private  void doTinhTien(){
        KhachHang kh = new KhachHang();
        kh.setTenKH(edKH.getText()+"");
        kh.setSlmua(Integer.parseInt(edSL.getText()+""));
        kh.setVip(chkVip.isChecked());
        tvTT.setText(kh.thanhTien()+"");
        danhsach.addKH(kh);
    }

    private void doTiep(){
        edKH.setText("");
        edSL.setText("");
        tvTT.setText("");
        edKH.requestFocus();
    }

    private void doThongKe(){
        edtongKH.setText(danhsach.tongKH()+"");
        edtongKHV.setText(danhsach.tongKHVip()+"");
        edTongTT.setText(danhsach.tongDT()+"");
    }

    private void doThoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hoi thoat chuong trinh");
        builder.setMessage("Ban muon thoat chuong trinh?");
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

    private class ProcessMyEvent implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_tinhTien: doTinhTien();
                break;

                case R.id.btn_Tiep: doTiep();
                break;

                case  R.id.btn_thongKe: doThongKe();
                break;

                case R.id.btn_Thoat: doThoat();
                break;
            }
        }
    }
}

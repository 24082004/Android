package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityBai1 extends AppCompatActivity {
    Spinner sp ;
    TextView edtName, edtAddress;
    Button btSubmit;
    ArrayList<School> list = new ArrayList<>();

    public static final String KEY_COSO = "coso";
    public static final String KEY_TEN_SV = "ten";
    public static final String KEY_DIA_CHI = "diachi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai1);

        sp = findViewById(R.id.spn_school);
        edtName = findViewById(R.id.edt_Ten);
        edtAddress = findViewById(R.id.edt_diachi);
        btSubmit = findViewById(R.id.btn_Submit);

        list.add(new School(R.drawable.hnpoly,"FPoly Hà Nội"));
        list.add(new School(R.drawable.dnpoly,"FPoly Đà Nẵng"));
        list.add(new School(R.drawable.tnpoly,"FPoly Tây Nguyên"));
        list.add(new School(R.drawable.hcmpoly,"FPoly Hồ Chí Minh"));
        list.add(new School(R.drawable.ctpoly,"FPoly Cần Thơ"));

        SinhVien svModel = (SinhVien) getIntent().getSerializableExtra(MainActivityBai2.KEY_SV_MODEL);

        School_Adapter adapter = new School_Adapter(list, MainActivityBai1.this);
        sp.setAdapter(adapter);

        if (svModel != null) { // sua sinh vien
            edtName.setText(svModel.hoTen);
            edtAddress.setText(svModel.diaChi);

            int position = list.indexOf(svModel.coSo);
            sp.setSelection(position);
        }

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index= sp.getSelectedItemPosition();
                String cs=list.get(index).ten;

                String name = edtName.getText().toString();
                String adr = edtAddress.getText().toString();

                if (name.trim().equals("")) {
                    Toast.makeText(MainActivityBai1.this, "Tên SV không được để trống!", Toast.LENGTH_SHORT).show();
                } else if (adr.trim().equals("")) {
                    Toast.makeText(MainActivityBai1.this, "Địa chỉ không được để trống!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent();
                    Bundle b = new Bundle();

                    b.putString(KEY_COSO,cs);
                    //Log.d("coso", cs);

                    b.putString(KEY_TEN_SV,name);
                    b.putString(KEY_DIA_CHI,adr);
                    i.putExtras(b);
                    setResult(RESULT_OK,i);
                    finish();
                }


            }
        });
    }
}
package com.example.lab5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityBai2 extends AppCompatActivity {
    Button btThemMoi;
    ListView lstview;
    ArrayList<SinhVien> list = new ArrayList<>();
    SinhVien_Adapter sva;

    ActivityResultLauncher<Intent> data = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent i = result.getData();
                        Bundle b = i.getExtras();
                        String cs = b.getString(MainActivityBai1.KEY_COSO);
                        //Log.d("coso", "nhan " + cs);
                        String ten = b.getString(MainActivityBai1.KEY_TEN_SV);
                        String dc = b.getString(MainActivityBai1.KEY_DIA_CHI);
                        list.add(new SinhVien(cs, ten, dc));
                        fill();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai2);

        btThemMoi = findViewById(R.id.btThemMoi);
        lstview = findViewById(R.id.lstview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        list.add(new SinhVien("FPoly Hà Nội", "Nguyễn Đắc Lợi", "Hà nội"));
        list.add(new SinhVien("FPoly Hồ Chí Minh", "Nguyễn Thị Thanh Mai", "Bình Phước"));
        list.add(new SinhVien("FPoly Đà Nẵng", "Hoàng Phương Nhi", "Đà Nẵng"));
        fill();

        btThemMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityBai2.this,MainActivityBai1.class);
                data.launch(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_qlsv, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sva.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sva.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    public void fill() {
        SinhVien_Adapter adapter = new SinhVien_Adapter(list, MainActivityBai2.this);
        lstview.setAdapter(adapter);
    }
    public void deleteSV(int index){
        list.remove(index);
        fill();
    }


    public static final String KEY_SV_MODEL = "sv_model";

    private SinhVien svModel;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.menu_add_sv) {
            Intent i = new Intent(MainActivityBai2.this, MainActivityBai1.class);
            data.launch(i);
        } else if (item.getItemId() == R.id.menu_dang_xuat) {
            onBackPressed();
        } else if (item.getItemId() == R.id.menu_bang_diem) {
            Toast.makeText(this, "Bảng điểm", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_diem_danh) {
            Toast.makeText(this, "Điểm danh", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    ActivityResultLauncher<Intent> goToEditSV = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent i = result.getData();
                        Bundle b = i.getExtras();
                        String cs = b.getString(MainActivityBai1.KEY_COSO);
                        String ten = b.getString(MainActivityBai1.KEY_TEN_SV);
                        String dc = b.getString(MainActivityBai1.KEY_DIA_CHI);

                        svModel.hoTen = ten;
                        svModel.diaChi = dc;
                        svModel.coSo = cs;

                        fill();
                    }
                }
            }
    );

    public void updateSV(int position) {

        Intent intent = new Intent(MainActivityBai2.this, MainActivityBai1.class);

        svModel = list.get(position);
        intent.putExtra(KEY_SV_MODEL, svModel);


        goToEditSV.launch(intent);


    }
}

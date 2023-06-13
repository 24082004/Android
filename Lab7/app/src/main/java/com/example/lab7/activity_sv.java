package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class activity_sv extends AppCompatActivity {
    public static final String KEY_DATA = "data";
    public static final String KEY_SAVE = "data2.txt";
    ArrayList <HocSinhModel> list = new ArrayList<>();
    Adapter_SV adapter_sv  ;
    ActivityResultLauncher getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==1){
                        Intent intent = result.getData();

                        HocSinhModel hocSinh = (HocSinhModel) intent.getSerializableExtra(KEY_DATA);
                        list.add(hocSinh);
                        ghi();
                        adapter_sv.notifyDataSetChanged();
                    }
                }
            }
    );
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_sv);

        ListView lv_hs = findViewById(R.id.lv_sv);
        Button them = findViewById(R.id.btn_them);
        doc();
        adapter_sv = new Adapter_SV(activity_sv.this,list);
        lv_hs.setAdapter(adapter_sv);



        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_sv.this,add_sv.class);
                getData.launch(intent);
            }
        });


    }
    public void ghi (){
        try {
            FileOutputStream fileOutputStream = openFileOutput(KEY_SAVE,MODE_PRIVATE);
            ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (Exception e){

        }

    }

    public void doc(){
        try {
            FileInputStream fileInputStream = openFileInput(KEY_SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<HocSinhModel>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){

        }
    }
    public class Adapter_SV extends BaseAdapter{
        Activity activity;
        ArrayList <HocSinhModel> list = new ArrayList<>();

        public Adapter_SV(Activity activity, ArrayList<HocSinhModel> list) {
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.model_sv,parent,false);
            HocSinhModel hocSinh = list.get(position);
            TextView name = convertView.findViewById(R.id.tv_name);
            TextView id = convertView.findViewById(R.id.tv_id_sv);
            TextView diem = convertView.findViewById(R.id.tv_diem);
            Button xoa = convertView.findViewById(R.id.btn_xoa);
            name.setText(hocSinh.getName());
            id.setText(hocSinh.getIdSV());
            diem.setText(hocSinh.getDiem()+"");

            xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    ghi();
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }
    }
}


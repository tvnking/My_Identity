package com.example.ghost.giaodienmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghost.giaodienmau.model.CanCuoc;
import com.example.ghost.giaodienmau.model.CoBan;
import com.example.ghost.giaodienmau.model.Global;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CanCuocActivity extends AppCompatActivity {

    private DatabaseReference database;

    private String ID;
    private TextView text_so,text_hoten,text_ngaysinh,text_gioitinh,text_quoctich,text_quequan,text_diachi,text_dacdiem,text_giatri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_cuoc);
        ID = Global.getId();
        database = FirebaseDatabase.getInstance().getReference().child("Data").child(ID);
        text_so = findViewById(R.id.text_so);
        text_hoten = findViewById(R.id.text_hoten);
        text_ngaysinh = findViewById(R.id.text_ngaysinh);
        text_gioitinh = findViewById(R.id.text_gioitinh);
        text_quoctich = findViewById(R.id.text_quoctich);
        text_quequan = findViewById(R.id.text_quequan);
        text_diachi = findViewById(R.id.text_diachi);
        text_dacdiem = findViewById(R.id.text_dacdiem);
        text_giatri = findViewById(R.id.text_giatri);

        database.child("CoBan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                switch (dataSnapshot.getKey().toString())
                {
                    case "gioitinh":
                            text_gioitinh.setText(dataSnapshot.getValue().toString());
                            break;
                    case "hoten":
                        text_hoten.setText(dataSnapshot.getValue().toString());
                        break;
                    case "ngaysinh":
                        text_ngaysinh.setText(dataSnapshot.getValue().toString());
                        break;
                    case "noithuongtru":
                        text_diachi.setText(dataSnapshot.getValue().toString());
                        break;
                    case "quoctich":
                        text_quoctich.setText(dataSnapshot.getValue().toString());
                        break;
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        database.child("CanCuoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                switch (dataSnapshot.getKey().toString())
                {
                    case "hansudung":
                        text_giatri.setText(dataSnapshot.getValue().toString());
                        break;
                    case "nhandang":
                        text_dacdiem.setText(dataSnapshot.getValue().toString());
                        break;
                    case "quequan":
                        text_quequan.setText(dataSnapshot.getValue().toString());
                        break;
                    case "so":
                        text_so.setText(dataSnapshot.getValue().toString());
                        break;

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.khancap, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {


            case R.id.khancap: {
                Intent in = new Intent(CanCuocActivity.this, KhanCapActivity.class);
                startActivity(in);
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }
}

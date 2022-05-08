package com.example.witsoverflow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class posts extends AppCompatActivity {

    DatabaseReference database;
    //FirebaseDatabase firebaseDatabase;

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<Post> list;
    ImageButton add, mypro;
    SearchView tags;
    //String Student_num = getIntent().getStringExtra("Stud_Num"); //so we know who's online

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        recyclerView = findViewById(R.id.postlist);


        FloatingActionButton fab = findViewById(R.id.fab_btn);
        String Student_num = getIntent().getStringExtra("Stud_Num");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(posts.this,CreatePost.class);
                switchActivityIntent.putExtra("Stud_Num",Student_num);
                startActivity(switchActivityIntent);
            }
        });

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
        
        BottomNavigationView bottomNavigationView = findViewById(R.id.Bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.myProfile);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Intent switchActivityIntent = new Intent(posts.this,ProfileUI.class);
                switchActivityIntent.putExtra("Stud_Num",Student_num);
                startActivity(switchActivityIntent);
            }
        });


        //database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://witsoverflow-c83b5-default-rtdb.europe-west1.firebasedatabase.app/");
        database = FirebaseDatabase.getInstance().getReference("Posts");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);




        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Post post1 = dataSnapshot.getValue(Post.class);
                    list.add(post1);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

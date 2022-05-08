package com.example.witsoverflow;

import androidx.appcompat.app.AppCompatActivity;
import static android.content.ContentValues.TAG;

import static java.lang.System.currentTimeMillis;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.UUID;


public class CreatePost extends AppCompatActivity {
    DatabaseReference databaseReference;
    private EditText caption;
    EditText post;
    EditText tags;
    Button home;
    Button Post;
    //Button Back;
    Timestamp timestamp = new Timestamp(currentTimeMillis());
    int vote = 0;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post); // was previously activity_createpost ->create_post xml file
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://witsoverflow-c83b5-default-rtdb.europe-west1.firebasedatabase.app/");
        caption = findViewById(R.id.editInputCaption);
        post = findViewById(R.id.editInputPost);
        tags = findViewById(R.id.editInputTags);
        home = findViewById(R.id.buttonBack);
        Post = findViewById(R.id.buttonPost);
        String Student_num = getIntent().getStringExtra("Stud_Num");
        //Back = findViewById(R.id.buttonBack);

        //goes back to the home page when user presses the back button
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(CreatePost.this,posts.class); //Uppercased the Post, changed from Home->posts
                startActivity(switchActivityIntent);
            }
        });


        //uploading all the info onto the database when user presses the post button
        Post.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //get data from EditText into string variables
                final String S_caption = caption.getText().toString();
                final String S_post = post.getText().toString();
                final String S_tags = tags.getText().toString();
                String uuid = UUID.randomUUID().toString();
                timestamp = new Timestamp(currentTimeMillis());
                time=timestamp.toString();
                if(!checkDataEntered()){
                    Toast.makeText(CreatePost.this,"Please fill all required fields",Toast.LENGTH_SHORT).show(); //uppercased post
                }

                else{
                    databaseReference.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            databaseReference.child("Posts").child(uuid ).child("username").setValue(Student_num);
                            databaseReference.child("Posts").child(uuid ).child("caption").setValue(S_caption);
                            databaseReference.child("Posts").child(uuid ).child("post").setValue(S_post);
                            databaseReference.child("Posts").child(uuid ).child("tags").setValue(S_tags);
                            databaseReference.child("Posts").child(uuid ).child("timestamp").setValue(time);
                            databaseReference.child("Posts").child(uuid ).child("upvote").setValue(vote);
                            databaseReference.child("Posts").child(uuid ).child("downvote").setValue(vote);

                            Toast.makeText(getApplicationContext(),"Post successfully uploaded!",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to Write values.", error.toException());
                        }
                    });
                }
            }
        });
    }



    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public boolean checkDataEntered() {
        if (isEmpty(caption)) {
            caption.setError("Caption is required!");
            return false;
        } else if (isEmpty(post)) {
            post.setError("Post is empty!");
            return false;
        } else if (isEmpty(tags)) {
            tags.setError("Tags are required!");
            return false;
        } else {
            return true;
        }
    }
}











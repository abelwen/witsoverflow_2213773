package com.example.witsoverflow;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
  
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
  
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
 
public class Vote extends AppCompatActivity{
    private ImageButton upVBtn, dnVBtn;
    private TextView txtUsername;
  
    /*
    String id;
    List plist;
    int postIndex;
    
    public Vote(int idx, List ls){
        this.postIndex = idx;
        this.plist = ls;
        //this.id = plist.get(postIndex);
    }
    
    public void setId(){
        id = plist.get(postIndex);
    }
    
    public string getId(){
        return id;
    }
    */

    //variable stores the updated number of votes.
    private  int newNumVotes;

    // creating a variable for firebasefirestore.
    //private FirebaseFirestore db;

    //function increases number of votes       -//or use Votingfunctions constructor
    public int AddVote(int numVotes){
        int tVotes=0;
        tVotes = numVotes + 1;
        return tVotes;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        // getting our instance from Firebase Firestore.
        //db = FirebaseFirestore.getInstance();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("Posts");

        // initializing buttons and textedit
        upVBtn = findViewById(R.id.imageVupVote);
        dnVBtn = findViewById(R.id.imageVdownVote);
        txtUsername = findViewById(R.id.userName);

        //database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://witsoverflow-c83b5-default-rtdb.europe-west1.firebasedatabase.app/");
      
        //when up vote clicked
        upVBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Student_num = txtUsername.getText().toString();

                //get number of votes from database
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(Student_num)){
                            //student number exist in firebase database
                            int NoOfUpVts= snapshot.child(Student_num).child("upvote").getValue(Integer.class);

                            newNumVotes = AddVote(NoOfUpVts);

                        }
                      
                        /*
                        if(snapshot.hasChild(id)){
                            //student number exist in firebase database
                            int NoOfUpVts= snapshot.child(id).child("upvote").getValue(Integer.class);

                            newNumVotes = AddVote(NoOfUpVts);

                        }
                        */
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                //get update number of votes in database
                database.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        database.child("Posts").child(Student_num).child("upvote").setValue(newNumVotes);
                        //database.child("Posts").child(id).child("upvote").setValue(newNumVotes);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to Write values.", error.toException());
                    }
                });

            }
        });
      
        //when down vote clicked
        dnVBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Student_num = txtUsername.getText().toString();

                //get number of votes from database
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(Student_num)){
                            //student number exist in firebase database
                            int NoOfUpVts= snapshot.child(Student_num).child("downvote").getValue(Integer.class);

                            newNumVotes = AddVote(NoOfUpVts);

                        }
                      
                        /*
                        if(snapshot.hasChild(id)){
                            //student number exist in firebase database
                            int NoOfUpVts= snapshot.child(id).child("downvote").getValue(Integer.class);

                            newNumVotes = AddVote(NoOfUpVts);

                        }
                        */
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                //get update number of votes in database
                database.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        database.child("Posts").child(Student_num).child("downvote").setValue(newNumVotes);
                        //database.child("Posts").child(id).child("downvote").setValue(newNumVotes);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to Write values.", error.toException());
                    }
                });

            }
        });

    }
}

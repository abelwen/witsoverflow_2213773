package com.example.witsoverflow;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
  
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
  
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
 
public class Vote extends AppCompatActivity{
    private ImageButton upVBtn, dnVBtn;

    //variable stores the updated number of votes.
    private  int newNumVotes;

    // creating a variable for firebasefirestore.
    private FirebaseFirestore db;

    public int AddVote(int numVotes){
        int tVotes = numVotes + 1;
        return tVotes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        // getting our instance from Firebase Firestore.
        //db = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance().getReference("Posts");
        
        // initializing buttons and textedit
        upVBtn = findViewById(R.id.imageVupVote);
        dnVBtn = findViewById(R.id.imageVdownVote);
        txtUsername = findViewById(R.id.userName);

        //database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://witsoverflow-c83b5-default-rtdb.europe-west1.firebasedatabase.app/");
        

        upVBtn.setOnClickListener(new View.OnClickListener{
            @Override
            public void onClick(View view) {
                final String Student_num = txtUsername.getText().toString();

                database.addValueEventListener(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(Student_num)){
                            //student number exist in firebase database
                            int NoOfUpVts= snapshot.child(Student_num).child("upvote").getValue(Integer.class);
                            
                            newNumVotes = AddVote(NoOfUpVts);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                }); 

                databaseReference.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Posts").child(L_stud_num).child("upvote").setValue(newNumVotes);
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

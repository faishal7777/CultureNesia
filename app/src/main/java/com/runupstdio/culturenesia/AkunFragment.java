package com.runupstdio.culturenesia;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.runupstdio.culturenesia.Model.User;
import com.runupstdio.culturenesia.Splash.SplashActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class AkunFragment extends Fragment {

    TextView viewEmail, viewUsername, viewHighscore;
    CircleImageView viewImgProfil;
    FirebaseAuth mAuth;
    FirebaseUser user;
    ViewLoad loading;
    LinearLayout mLogOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_akun, container, false);
        loading = new ViewLoad(getActivity());
        loading.showDialog();

        mLogOut = v.findViewById(R.id.logout);
        viewImgProfil = v.findViewById(R.id.img_Profil_Akun);
        viewUsername = v.findViewById(R.id.username_Akun);
        viewEmail = v.findViewById(R.id.email_Akun);
        viewHighscore = v.findViewById(R.id.highScore);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        loadUserInfo();

        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent logOut= new Intent(v.getContext(), SplashActivity.class);
                logOut.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                logOut.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logOut);

            }
        });

        return  v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null){
            startActivity(new Intent(AkunFragment.this.getActivity(), SplashActivity.class));
        }
    }

    private void loadUserInfo() {
        user = mAuth.getCurrentUser();

        String currentUrlProduct = "https://pbs.twimg.com/profile_images/1114801544468127745/g1_G2KBC_400x400.png";

//        url_db = FirebaseDatabase.getInstance().getReference().child(retrievedName).child("Url");
//        StorageReference ref = FirebaseStorage.getInstance().getReference().child(retrievedName).child("images/profile_image");
//        ref.putFile(filePath)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        @SuppressWarnings("VisibleForTests") Uri downloadUrl =
//                                taskSnapshot.getDownloadUrl();
//                        uploadImageUrl = downloadUrl.toString();
//
//                        url_db.setValue(uploadImageUrl);
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(User.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });

        if (user != null){
            if (user.getEmail() != null){
                viewEmail.setText(user.getEmail());
            }

            if (user.getPhotoUrl() != null){
                Glide.with(this)
                        .asBitmap()
                        .load(currentUrlProduct)
                        .into(viewImgProfil);

                Log.d("url : ", user.getPhotoUrl().toString());
            }

            if (user.getDisplayName() != null){
                viewUsername.setText(user.getDisplayName());
            }

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User userInfo = dataSnapshot.getValue(User.class);
                    String score = userInfo.getScore();
                    Log.d("score", score);
                    viewHighscore.setText(score);
                    loading.hideDialog();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}

package com.runupstdio.culturenesia;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.runupstdio.culturenesia.Splash.SplashActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class AkunFragment extends Fragment {

    TextView viewEmail, viewUsername;
    CircleImageView viewImgProfil;
    FirebaseAuth mAuth;
    FirebaseUser user;
//    FirebaseDatabase

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_akun, container, false);

        viewImgProfil = v.findViewById(R.id.img_Profil_Akun);
        viewUsername = v.findViewById(R.id.username_Akun);
        viewEmail = v.findViewById(R.id.email_Akun);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        loadUserInfo();

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

        String currentUrlProduct = "http://cdn2.tstatic.net/bangka/foto/bank/images/tukul-arwana_20160509_104925.jpg";

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
            }

            if (user.getDisplayName() != null){
                viewUsername.setText(user.getDisplayName());
            }
        }
    }
}

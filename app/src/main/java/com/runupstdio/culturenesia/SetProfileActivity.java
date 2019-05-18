package com.runupstdio.culturenesia;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class SetProfileActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth mAuth;
    Button mBtnSetProfile;
    ImageView imgProfileRegister;
    EditText usernameSetProfile;
    Uri pickedImgUri;
    String profileImgUrl;
    private ProgressDialog progressDialog;
    static int PReqCode = 1;
    static int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        usernameSetProfile = findViewById(R.id.username_Set_Profile);
        mBtnSetProfile = findViewById(R.id.btn_Set_Profile);
        mBtnSetProfile.setOnClickListener(this);
        imgProfileRegister = findViewById(R.id.img_Profil_Register);
        imgProfileRegister.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESTCODE && data != null && data.getData() != null) {
            pickedImgUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), pickedImgUri);
                imgProfileRegister.setImageBitmap(bitmap);

                UpdateUserInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getImageRegister(){
        if (Build.VERSION.SDK_INT >= 22){
            checkAndRequestForPermission();
        } else {
            openGallery();
        }
    }

    private void openGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESTCODE);
    }

    private void checkAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "Please accept for required permission.", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }
        } else {
            openGallery();
        }
    }

    private void UpdateUserInfo() {
        StorageReference mStorage = FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");

        if (pickedImgUri != null) {
            progressDialog.setMessage("Uploading");
            progressDialog.show();
            mStorage.putFile(pickedImgUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            profileImgUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(SetProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void saveUserInfo() {
        String mUsername = usernameSetProfile.getText().toString();
        if (mUsername.isEmpty()){
            usernameSetProfile.setError("Name Required");
            usernameSetProfile.requestFocus();
            return;
        }
        FirebaseUser user = mAuth .getCurrentUser();
        if (user != null){
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(mUsername)
                    .setPhotoUri(Uri.parse(profileImgUrl))
                    .build();
            user.updateProfile(profile)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SetProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SetProfileActivity.this, BottomNavbarActivity.class));
                                finish();
                            }
                        }
                    });
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnSetProfile){
            saveUserInfo();
        } else if (v == imgProfileRegister){
            getImageRegister();
        }
    }
}

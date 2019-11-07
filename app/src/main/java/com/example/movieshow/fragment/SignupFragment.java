package com.example.movieshow.fragment;



import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movieshow.R;
import com.example.movieshow.SessionManager;
import com.example.movieshow.activity.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    private FirebaseAuth mAuth;
    SessionManager sessionManager;
    public static final String TAG="SignUpFragment";
    private Button signupBtn;
    private EditText etEmail;
    private EditText etPassword;
    private EditText et_userName;

    private String email;
    private String userName;
    private String password;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        sessionManager=new SessionManager(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_signup, container, false);
        etEmail = view.findViewById(R.id.et_email);
        etPassword = view.findViewById(R.id.et_password);
        et_userName =view.findViewById(R.id.et_username);
        signupBtn = view.findViewById(R.id.signUpBtn);
        // Initialize Firebase Auth



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=et_userName.getText().toString();
                email=etEmail.getText().toString().trim();
                password=etPassword.getText().toString().trim();
                LoginNewUser();
            }
        });

    }

    private void LoginNewUser() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            sessionManager.createLoginSession(email,password);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent= new Intent(getContext(), HomeActivity.class);
                           // intent.putExtra("userName",userName);
                            startActivity(intent);
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //  updateUI(null);
                        }

                        // ...
                    }
                });
    }


}

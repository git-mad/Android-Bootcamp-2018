package com.gitmad.buzzchat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton mSignInButton;
    private FirebaseAuth mAuth;

    private static final int RC_SIGN_IN = 3718;
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        /* TODO 18b: Follow the tutorial here to finish the login with Google sign-in. Dependencies
         * are taken care of for you.
         * https://developers.google.com/identity/sign-in/android/sign-in
         *
         * When you're done, you'll be able to see your Google account as a user. Go to
         * https://firebase.google.com/ and log in with these credentials to view the Firebase
         * Console:
         *
         * username: gitmad2443
         * password: Android2443
         */
    }




    /*
     * TODO 20b: In firebaseAuthWithGoogle, we create an intent and start an activity if the auth is
     * successful. After the intent is created, add the display name as an intent extra.
     * Then start the activity. We'll use this extra as a "username"
     */
}

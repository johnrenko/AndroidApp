package jd.secrets;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    protected EditText mEmail;
    protected EditText mPassword;
    protected Button mLoginButton;



    protected TextView mSignUpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText)findViewById(R.id.userNameField);
        mPassword = (EditText)findViewById(R.id.passwordField);
        mLoginButton = (Button)findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String username = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            AlertDialog.Builder builder3 = new AlertDialog.Builder(LoginActivity.this);
                            builder3.setMessage(e.getMessage())
                                    .setTitle(R.string.signUpErrorTitle)
                                    .setPositiveButton(android.R.string.ok, null);
                            AlertDialog dialog = builder3.create();
                            dialog.show();
                        }
                    }
                });
            }
        });

        mSignUpTextView = (TextView) findViewById(R.id.changeToSignUp);
        mSignUpTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

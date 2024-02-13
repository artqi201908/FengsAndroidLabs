/*package algonquin.cst2335.fengqi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(TAG, "In onCreate() - Activity is being created, initializing the activity's layout and state.");

        // Setup for the login button
        Button buttonLogin = findViewById(R.id.buttonLogin); // Ensure ID matches your layout
        buttonLogin.setOnClickListener(view -> {
            // Get the email and password from user input
            EditText editTextEmail = findViewById(R.id.editTextEmail);
            String email = editTextEmail.getText().toString();
            EditText editTextPassword = findViewById(R.id.editTextPassword);
            String password = editTextPassword.getText().toString();

            // Check if email or password fields are empty
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Email or password cannot be empty.", Toast.LENGTH_SHORT).show();
                return;
            }

            // If input is valid, proceed to SecondActivity
            Log.d(TAG, "Proceeding with valid input.");
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("EXTRA_EMAIL", email); // Pass email
            intent.putExtra("EXTRA_PASSWORD", password); // Pass password
            startActivity(intent); // Start SecondActivity
        });

        // Other lifecycle methods and logging as before, no changes needed
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "In onStart() - The application is now visible on screen.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "In onResume() - The application is now in the foreground and interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "In onPause() - The activity is about to enter the background.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "In onStop() - The application is no longer visible to the user.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "In onDestroy() - The activity is about to be destroyed.");
    }
}*/

package algonquin.cst2335.fengqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private Button loginButton;
    private TextView emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d( TAG, "Message");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );


        loginButton = findViewById(R.id.loginButton);
        emailEditText = findViewById(R.id.emailEditText);
        // Load email address
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String savedEmailAddress = prefs.getString("LoginName", "");
        emailEditText.setText(savedEmailAddress);
        loginButton.setOnClickListener(clk -> {
            String emailAddress = emailEditText.getText().toString();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("LoginName", emailAddress);
            editor.apply();

            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            nextPage.putExtra( "EmailAddress", emailEditText.getText().toString() );
            startActivity(nextPage);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w( "MainActivity", "In onStart() - The application is now visible on screen" );
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - The application is now responding to user input" );
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - The application is pausing, no longer in the foreground" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w( "MainActivity", "In onStop() - The activity is no longer visible on screen" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "In onDestroy() - The activity is being destroyed" );
    }

}
package algonquin.cst2335.fengqi;

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
}


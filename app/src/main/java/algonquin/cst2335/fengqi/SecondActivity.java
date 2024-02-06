/*package algonquin.cst2335.fengqi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.receivedTextView);
        textView.setText(message);
    }
}*/
/*package algonquin.cst2335.fengqi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the Intent that started this activity and extract the email string
        Intent intent = getIntent();
        String email = intent.getStringExtra("EXTRA_EMAIL"); // Adjusted to use the correct key

        // If you also want to retrieve and display the password, you can do so like this:
        // String password = intent.getStringExtra("EXTRA_PASSWORD");

        // Capture the layout's TextView and set the email as its text
        // If you wanted to display both the email and password, you could concatenate them or use another TextView
        TextView textView = findViewById(R.id.receivedTextView); // Ensure this ID exists in your XML
        textView.setText(email); // Display the email
    }
}*/
/*package algonquin.cst2335.fengqi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;


public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PERMISSION = 101; // Unique code for the permission request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String email = intent.getStringExtra("EXTRA_EMAIL");
        String password = intent.getStringExtra("EXTRA_PASSWORD");

        TextView emailTextView = findViewById(R.id.receivedEmailTextView);
        if (email != null) {
            emailTextView.setText(email);
        } else {
            emailTextView.setText("No email received.");
        }

        TextView passwordTextView = findViewById(R.id.receivedPasswordTextView);
        if (password != null) {
            passwordTextView.setText(password);
        } else {
            passwordTextView.setText("No password received.");
        }

        // Code to make phone calls
        Button callButton = findViewById(R.id.buttonCallNumber);
        callButton.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Permission not granted, request it
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                // Permission granted, make the call
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        String phoneNumber = editTextPhone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                // Permission was denied. Handle the failure accordingly.
            }
        }
    }
}*/

package algonquin.cst2335.fengqi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PERMISSION = 101; // Unique code for call permission request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Setting the content view to the layout for this activity

        // Retrieve the intent that started this activity to get the data passed from MainActivity
        Intent intent = getIntent();
        String email = intent.getStringExtra("EXTRA_EMAIL");
        String password = intent.getStringExtra("EXTRA_PASSWORD");

        // Display the received email
        TextView emailTextView = findViewById(R.id.receivedEmailTextView);
        if (email != null) {
            emailTextView.setText(email); // Set text if email is received
        } else {
            emailTextView.setText("No email received."); // Default text if no email was received
        }

        // Display the received password
        TextView passwordTextView = findViewById(R.id.receivedPasswordTextView);
        if (password != null) {
            passwordTextView.setText(password); // Set text if password is received
        } else {
            passwordTextView.setText("No password received."); // Default text if no password was received
        }

        // Setup to make phone calls upon button click
        Button callButton = findViewById(R.id.buttonCallNumber);
        callButton.setOnClickListener(v -> {
            // Check if CALL_PHONE permission is granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Request the permission if not granted
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                // Permission already granted, proceed to make the call
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        // Get the phone number from user input
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        String phoneNumber = editTextPhone.getText().toString();
        // Create an Intent to make a phone call
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber)); // Set the data of intent to the phone number
        startActivity(intent); // Start the call intent
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed to make the call
                makePhoneCall();
            } else {
                // Permission denied, you can handle the denial here, e.g., show a message to the user
            }
        }
    }
}




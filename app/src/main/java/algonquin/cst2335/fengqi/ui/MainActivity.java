/*package algonquin.cst2335.fengqi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import algonquin.cst2335.fengqi.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private TextView mytext;
    private Button mybutton;
    private EditText myedit;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TextView, Button, and EditText by ID
        TextView mytext = findViewById(R.id.textview);
        Button mybutton = findViewById(R.id.mybutton);
        myedit = findViewById(R.id.myedittext);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editString = myedit.getText().toString();
                mytext.setText("Your edit text has: " + editString);
            }
        });


    }
}
*/
package algonquin.cst2335.fengqi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;  // Add this line
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView; // Add this import statement
import android.widget.ImageButton;
import android.widget.Toast;
import algonquin.cst2335.fengqi.data.MainViewModel;
import algonquin.cst2335.fengqi.databinding.ActivityMainBinding;
import algonquin.cst2335.fengqi.R;


public class MainActivity extends AppCompatActivity {

    private MainViewModel model;

    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Connecting AppCompatActivity to ViewModel
        model = new ViewModelProvider(this).get(MainViewModel.class);
        // Use View Binding to inflate the layout
        // Inside onCreate after instantiating the ViewModel
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        /*// View Binding and LiveData
        // Setting initial value of myText from the ViewModel
        variableBinding.myText.setText(model.editString);
        // Adding a click listener to the button using LiveData
        variableBinding.myButton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myEditText.getText().toString());
        });

        // Observer Pattern
        model.editString.observe(this, s -> {
            variableBinding.myText.setText("Your edit text has " + s);
        });*/

        // Connect the CompoundButtons to the ViewModel
        model.isSelected.observe(this, selected -> {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            variableBinding.switchButton.setChecked(selected);

            // Show a Toast message
            Toast.makeText(this, "The value is now: " + selected, Toast.LENGTH_SHORT).show();
        });

        // Set OnCheckedChangeListener using Lambda for each CompoundButton
        variableBinding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        // Initialize the ImageView variable
        //ImageView myImageView = variableBinding.myImageView;
        ImageView myImageView = findViewById(R.id.myImageView);
        myImageView.setImageResource(R.drawable.logo_algonquin);

        // Set the image resource for the ImageView
        myImageView.setImageResource(R.drawable.logo_algonquin);

        // Add any necessary listeners to the ImageView
        myImageView.setOnClickListener(view -> {
            // Your onClick logic for ImageView here
        });

        // Initialize the ImageButton variable
        ImageButton myImageButton = variableBinding.myImageButton;

        // Add an onClickListener
        myImageButton.setOnClickListener(view -> {
            // Show Toast with width and height
            int width = myImageButton.getWidth();
            int height = myImageButton.getHeight();
            Toast.makeText(this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });

        // Now you can access views using variableBinding
        //The code you provided for accessing views using variableBinding is actually unnecessary.
        // Since you are already using LiveData and the Observer Pattern, the automatic updates to
        // the UI will be handled by the observer.
        /*variableBinding.mybutton.setOnClickListener(view -> {
            String editString = variableBinding.myedittext.getText().toString();
            variableBinding.textview.setText("Your edit text has: " + editString);
        });*/
    }
}

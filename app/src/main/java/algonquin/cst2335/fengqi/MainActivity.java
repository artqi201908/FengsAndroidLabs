package algonquin.cst2335.fengqi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.LinearInterpolator;
import android.annotation.SuppressLint;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ImageView and Switch by finding them by their ID.
        imgView = findViewById(R.id.imageView);
        sw = findViewById(R.id.spin_switch);

        // Set a listener on the Switch to handle the check state change.
        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Check if the switch is checked
            if (isChecked) {
                // Create a new RotateAnimation from 0 to 360 degrees.
                // The pivot points are set to 0.5f (center) for both X and Y axis to rotate around the center of the view.
                RotateAnimation rotate = new RotateAnimation(
                        0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                // Set the duration of the animation to 5 seconds.
                rotate.setDuration(5000);
                // Set the animation to repeat indefinitely.
                rotate.setRepeatCount(Animation.INFINITE);
                // Set a LinearInterpolator to keep the speed constant.
                rotate.setInterpolator(new LinearInterpolator());

                // Start the animation on the ImageView.
                imgView.startAnimation(rotate);
            } else {
                // If the switch is not checked, stop the animation.
                imgView.clearAnimation();
            }
        });
    }
}

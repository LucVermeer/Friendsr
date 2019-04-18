package vermeer.luc.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        String name = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        int drawableId = retrievedFriend.getDrawableId();

        ImageView image = findViewById(R.id.profile_image);
        image.setImageResource(drawableId);

        TextView nameView = findViewById(R.id.profile_name);
        TextView bioView = findViewById(R.id.profile_bio);

        nameView.setText(name);
        bioView.setText(bio);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        RatingBarListener ratingBarListener = new RatingBarListener();
        ratingBar.setOnRatingBarChangeListener(ratingBarListener);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float rating = prefs.getFloat(name, 0.0f);

        if (rating != 0.0f) {
            // we have something stored under "example_key"
            ratingBar.setRating(rating);
        }
        else {
            // there is nothing stored under "example_key"
            ratingBar.setRating(0.0f);
        }

    }

    private class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            // Save the current rating when it is changed
            TextView name = findViewById(R.id.profile_name);
            String key = name.getText().toString();
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(key, rating);
            editor.apply();
        }
    }
}

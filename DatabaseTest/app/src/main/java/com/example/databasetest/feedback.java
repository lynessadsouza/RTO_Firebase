package com.example.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class feedback extends AppCompatActivity {

    DatabaseReference databaseReference;

    private RatingBar ratingBar;
    private TextView tvRateCount,tvRateMessage;
    private float ratedValue;
    Button save_feed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Feedback");
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        tvRateCount = (TextView) findViewById(R.id.tvRateCount);
        tvRateMessage = (TextView) findViewById(R.id.tvRateMessage);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratedValue = ratingBar.getRating();
                tvRateCount.setText("Your Rating : "
                        + ratedValue + "/5.");

                if(ratedValue<1){
                    tvRateMessage.setText("ohh ho...");
                }else if(ratedValue<2){
                    tvRateMessage.setText("Ok.");
                }else if(ratedValue<3){
                    tvRateMessage.setText("Not bad.");
                }else if(ratedValue<4){
                    tvRateMessage.setText("Nice");
                }else if(ratedValue<5){
                    tvRateMessage.setText("Very Nice");
                }else if(ratedValue==5){
                    tvRateMessage.setText("Thank you..!!!");
                }
            }
        });

        save_feed=(Button)findViewById(R.id.button9);

        save_feed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Toast.makeText(getApplicationContext(),"Before func",Toast.LENGTH_LONG).show();
                saveFeedback();
                //    Toast.makeText(getApplicationContext(),"after func",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void saveFeedback() {

        int rate_value = (int) ratingBar.getRating();
        String id = databaseReference.push().getKey();
        UserFeedback userFeedback = new UserFeedback(id, rate_value);
        databaseReference.child(id).setValue(userFeedback);
        Toast.makeText(this, "Stored successfully", Toast.LENGTH_LONG).show();

        Intent i=new Intent(this,Menu.class);
        startActivity(i);
    }


}

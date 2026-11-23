
package com.example.artspace;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.artspace.databinding.ActivityArtworkDetailsBinding;

import android.content.Intent;

import android.content.Intent;
import android.net.Uri;

import android.content.Intent;




public class ArtworkDetailsActivity extends AppCompatActivity {

    private ActivityArtworkDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityArtworkDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String artist = intent.getStringExtra("artist");
        String year = intent.getStringExtra("year");

        binding.tvDetails.setText(
                "Title: " + title +
                        "\nArtist: " + artist +
                        "\nYear: " + year
        );


        binding.btnBack.setOnClickListener(v -> {
            finish();
        });


        binding.btnVisitWebsite.setOnClickListener(v -> {

            Intent websiteIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
            );

            startActivity(websiteIntent);
        });

















    }

}

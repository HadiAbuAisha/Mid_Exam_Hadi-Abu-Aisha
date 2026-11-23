
package com.example.artspace;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artspace.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int currentIndex = 0;

    private int[] images = {
            R.drawable.art1,
            R.drawable.art2,
            R.drawable.art3,
            R.drawable.art4,
            R.drawable.art5,
            R.drawable.art6
    };

    private String[] titles = {
            "The Great Wave off Kanagawa",
            "The Starry Night",
            "Mona Lisa",
            "The Scream",
            "Girl with a Pearl Earring",
            "The Kiss"
    };

    private String[] artists = {
            "Katsushika Hokusai",
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Edvard Munch",
            "Johannes Vermeer",
            "Gustav Klimt"
    };

    private String[] years = {
            "1831",
            "1889",
            "1503-1519",
            "1893",
            "1665",
            "1907-1908"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Restore current artwork after rotation
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("index", 0);
        }

        updateArtwork();

        // Next artwork
        binding.btnNext.setOnClickListener(v -> {
            if (currentIndex < images.length - 1) {
                currentIndex++;
                updateArtwork();
            }
        });

        // Previous artwork
        binding.btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtwork();
            }
        });

        // Open artwork details and send information
        binding.imgArtwork.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ArtworkDetailsActivity.class
            );

            intent.putExtra("title", titles[currentIndex]);
            intent.putExtra("artist", artists[currentIndex]);
            intent.putExtra("year", years[currentIndex]);

            startActivity(intent);
        });
    }

    // Update artwork image and information
    private void updateArtwork() {

        binding.imgArtwork.setImageResource(images[currentIndex]);

        binding.tvTitle.setText(titles[currentIndex]);

        binding.tvArtistYear.setText(
                artists[currentIndex] + " (" + years[currentIndex] + ")"
        );

        binding.tvCounter.setText(
                (currentIndex + 1) + " / " + images.length
        );

        binding.btnPrevious.setEnabled(currentIndex > 0);

        binding.btnNext.setEnabled(currentIndex < images.length - 1);
    }

    // Save current artwork during screen rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("index", currentIndex);
    }
}

package com.example.praktinis1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean keitimas = false;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button3);
        Button button2 = findViewById(R.id.button4);
        progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("Pirminis tekstas")) {
                    textView.setText("Antrinis tekstas");
                } else {
                    textView.setText("Pirminis tekstas");
                }
                progress(5);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (keitimas) {
                    textView.setTextColor(Color.RED);
                } else {
                    textView.setTextColor(Color.BLUE);
                }
                keitimas = !keitimas;
                progress(10);
            }
        });
    }

    private void progress(int amount) {
        int dabartinis = progressBar.getProgress();
        int naujas = dabartinis + amount;
        if (naujas >= 100) {
            naujas = 100;
            Toast.makeText(this, "Pasiektas 100%", Toast.LENGTH_SHORT).show();
        }
        progressBar.setProgress(naujas);
    }
}
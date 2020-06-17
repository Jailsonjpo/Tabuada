package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonJogar, buttonTabuada, buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = findViewById(R.id.buttonJogar);
        buttonTabuada = findViewById(R.id.buttonTabuada);
        buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Obrigado por usar nosso APP volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EscolhaJogoActivity.class);
                startActivity(intent);

            }
        });

        buttonTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity33.class);
                startActivity(intent);
            }
        });

    }
}

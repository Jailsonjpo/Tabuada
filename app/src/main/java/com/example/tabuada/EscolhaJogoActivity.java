package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EscolhaJogoActivity extends AppCompatActivity {

    private Button escolhaTab2;
    private Button escolhaTab3;
    private Button escolhaTab4;
    private Button escolhaTab5;
    private Button escolhaTab6;
    private Button escolhaTab7;
    private Button escolhaTab8;
    private Button escolhaTab9;
    private Button escolhaTab10;
    private int tabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_jogo);

        escolhaTab2 = findViewById(R.id.escolhaTab2);
        escolhaTab3 = findViewById(R.id.escolhaTab3);
        escolhaTab4 = findViewById(R.id.escolhaTab4);
        escolhaTab5 = findViewById(R.id.escolhaTab5);
        escolhaTab6 = findViewById(R.id.escolhaTab6);
        escolhaTab7 = findViewById(R.id.escolhaTab7);
        escolhaTab8 = findViewById(R.id.escolhaTab8);
        escolhaTab9 = findViewById(R.id.escolhaTab9);
        escolhaTab10 = findViewById(R.id.escolhaTab10);
    }

    public void tabuada(View view){

        switch (view.getId()){

            case(R.id.escolhaTab2): tabu = 2;
                capturaNumero();
                break;
            case(R.id.escolhaTab3): tabu = 3;
                capturaNumero();
                break;
            case(R.id.escolhaTab4): tabu = 4;
                capturaNumero();
                break;
            case(R.id.escolhaTab5): tabu = 5;
                capturaNumero();
                break;
            case(R.id.escolhaTab6): tabu = 6;
                capturaNumero();
                break;
            case(R.id.escolhaTab7): tabu = 7;
                capturaNumero();
                break;
            case(R.id.escolhaTab8): tabu = 8;
                capturaNumero();
                break;
            case(R.id.escolhaTab9): tabu = 9;
                capturaNumero();
                break;
            case(R.id.escolhaTab10): tabu = 10;
                capturaNumero();
                break;

        }
    }

    public void capturaNumero(){

        Intent intent = new Intent(getApplicationContext(), JogoActivity.class);
        intent.putExtra("tabuada", tabu);
        startActivity(intent);

    }

}

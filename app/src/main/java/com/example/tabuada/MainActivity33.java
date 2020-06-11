package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity33 extends AppCompatActivity {

    private Button tabuada2;
    private Button tabuada3;
    private Button tabuada4;
    private Button tabuada5;
    private Button tabuada6;
    private Button tabuada7;
    private Button tabuada8;
    private Button tabuada9;
    private Button tabuada10;
   // private TextView textViewResultado;

    private int tabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Estudo da Tabuada");     //Titulo para ser exibido na sua Action Bar em frente à seta

        tabuada2 = findViewById(R.id.tabuada2);
        tabuada3 = findViewById(R.id.tabuada3);
        tabuada4 = findViewById(R.id.tabuada4);
        tabuada5 = findViewById(R.id.tabuada5);
        tabuada6 = findViewById(R.id.tabuada6);
        tabuada7 = findViewById(R.id.tabuada7);
        tabuada8 = findViewById(R.id.tabuada8);
        tabuada9 = findViewById(R.id.tabuada9);
        tabuada10 = findViewById(R.id.tabuada10);

    }

    public void tabuada(View view){
       // int tabu = 0;
        switch (view.getId()){

            case(R.id.tabuada2): tabu = 2;
                mostrarTabuada();
            break;
            case(R.id.tabuada3): tabu = 3;
                mostrarTabuada();
                break;
            case(R.id.tabuada4): tabu = 4;
                mostrarTabuada();
                break;
            case(R.id.tabuada5): tabu = 5;
                mostrarTabuada();
                break;
            case(R.id.tabuada6): tabu = 6;
                mostrarTabuada();
                break;
            case(R.id.tabuada7): tabu = 7;
                mostrarTabuada();
                break;
            case(R.id.tabuada8): tabu = 8;
                mostrarTabuada();
                break;
            case(R.id.tabuada9): tabu = 9;
                mostrarTabuada();
                break;
            case(R.id.tabuada10): tabu = 10;
                mostrarTabuada();
                break;

        }
        }

        public void mostrarTabuada(){

            Intent intent = new Intent(getApplicationContext(), TabuadaActivity.class);
            intent.putExtra("tabuada", tabu);
            startActivity(intent);

        }
        //String tabu = tabuada2 .getText().toString();

       // String resultado = "";

      //  textViewResultado.setText("O Número escolhido foi " + tabu );

    }



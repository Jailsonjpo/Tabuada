package com.example.tabuada;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    private TextView countLabel;
    private Button buttonResposta1;
    private Button buttonResposta2;
    private Button buttonResposta3;
    private Button buttonResposta4;
    private TextView textPergunta;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] =  {

            {"4 x 4", "16","34","44","40"},
            {"5 x 4", "20","34","23","63"},
            {"9 x 3", "27","56","63","54"},
            {"3 x 3", "9","29","66","23"},
            {"6 x 5", "30","45","23","34"},
            {"7 x 7", "49","35","56","22"},
            {"8 x 8", "64","56","81","17"},
            {"2 x 10", "20","25","45","78"},
            {"2 x 7", "14","34","53","78"},
            {"2 x 9", "18","14","56","81"},

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        countLabel = (TextView) findViewById(R.id.countLabel);
        buttonResposta1 = (Button) findViewById(R.id.buttonResposta1);
        buttonResposta2 = (Button) findViewById(R.id.buttonResposta2);
        buttonResposta3 = (Button) findViewById(R.id.buttonResposta3);
        buttonResposta4 = (Button) findViewById(R.id.buttonResposta4);
        textPergunta = findViewById(R.id.textPergunta);

        for(int i = 0; i <quizData.length; i++){
            //Prepare array

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Country (País)
            tmpArray.add(quizData[i][1]); // Resposta Certa
            tmpArray.add(quizData[i][2]); // Alternativa 1
            tmpArray.add(quizData[i][3]); // Alternativa 2
            tmpArray.add(quizData[i][4]); // Alternativa 3

            //Add tmpArray to quizArray
            quizArray.add(tmpArray);
        }

        showNextQuiz();

        //pergunta();
    }
    //kjk


    public void showNextQuiz(){

        //update quizCountLabel
        countLabel.setText("Questão" + quizCount);

        //Generate random number between 0 and 14 (quizArray size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);


       //random r = new Random();
/*
       /* int min = 1;
        int max = 10;

        int num1 = r.nextInt((max - min)+ 1) + min;
        int num2 = r.nextInt((max - min)+ 1) + min;*/

        textPergunta.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set Choices

        buttonResposta1.setText(quiz.get(0));
        buttonResposta2.setText(quiz.get(1));
        buttonResposta3.setText(quiz.get(2));
        buttonResposta4.setText(quiz.get(3));

        //Remove this quiz from quizArray
        quizArray.remove(randomNum);


       /* textPergunta.setText(num1 + " X " + num2);
        resposta(num1,num2);*/
    }

    public void verificaResposta(View view){


        //-------------------------------------------- inicio --------------------------
        //Get pushed button

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            alertTitle = "Correto";
            rightAnswerCount++;
        }else{

            alertTitle = "Errado!.";
        }

        //Create Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT){
                    //SHOW RESULTADO
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });

        builder.setCancelable(false);
        builder.show();
    }

        //----------------------------------------------fim------------------------------



       /* Random r2 = new Random();

        int min = 1;
        int max = 100;

        int resp1 = r2.nextInt((max - min)+1)+min;
        int resp2 = r2.nextInt((max - min)+1)+min;
        int resp3 = r2.nextInt((max - min)+1)+min;
        int resp4 = num1*num2;

        int numero = new Random().nextInt(4);*/

       // for()

        //for (int cont=1; cont<=4; cont++){
       //     aux=aux + tabu + " X " + cont + " = " + (tabu*cont) + "\n";
        //}

       // for (int cont=1; cont<=4; cont++) {


          /*  int[] opcoes = {resp1, resp2, resp3, resp4};
            int opcaoApp = opcoes[numero];
        Collections.shuffle(Collections.singletonList(opcoes));*/

            //int emba = new Random().nextInt(opcoes[3]);


           /* switch (opcaoApp){
                case 1:  buttonResposta1.setText(String.valueOf(resp1));
                    break;
            }
*/
        //int emba = opcaoApp;

       /* buttonResposta1.setText(String.valueOf(opcoes[0]));
        buttonResposta2.setText(String.valueOf(opcoes[1]));
        buttonResposta3.setText(String.valueOf(opcoes[2]));
        buttonResposta4.setText(String.valueOf(opcoes[3]));

    }
*/
   /* public void verificaResposta(){

      //  String respostaBotao = buttonResposta1.getText().toString();

        Toast.makeText(this, "teste", Toast.LENGTH_LONG).show();

    }*/

/*        buttonResposta1.setOnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //faca um cast para Button
                Button botao = (Button) view;
                //pegue o texto
                String respostaBotao = botao.getText().toString();
                switch (view.getId()) {
                    case (R.id.buttonResposta1):
                        Toast.makeText(JogoActivity.this, respostaBotao, Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext(), respostaBotao);

                        //codigo caso clicar resposta 1
                        break;
                    case (R.id.buttonResposta2):
                        //codigo caso clicar resposta 2
                        break;
                    case (R.id.buttonResposta3):
                        //codigo caso clicar resposta 2
                        break;
                    case (R.id.buttonResposta4):
                        //codigo caso clicar resposta 2
                        break;
                }
            }
        };*/

   // }
}

package com.example.tabuada;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

public class JogoActivity extends AppCompatActivity {

    private TextView countLabel;
    private Button buttonResposta1;
    private Button buttonResposta2;
    private Button buttonResposta3;
    private Button buttonResposta4;
    private TextView textPergunta;

    private ProgressBar progressBarHorizontal;
    private int progresso = 0;
    private int counter;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

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
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);

        String quizData[][] = {

                {"2 x 1", "2", "34", "23", "63"},
                {"2 x 2", "4", "6", "9", "54"},
                {"2 x 3", "6", "29", "12", "23"},
                {"2 x 4", "8", "45", "23", "34"},
                {"2 x 5", "10", "15", "56", "22"},
                {"2 x 6", "12", "56", "8", "17"},
                {"2 x 7", "14", "25", "15", "78"},
                {"2 x 8", "16", "34", "57", "78"},
                {"2 x 9", "18", "14", "56", "81"},
                {"2 x 10", "20", "14", "37", "81"}

                /*{"5 x 4", "20","34","23","63"},
                {"9 x 3", "27","56","63","54"},
                {"3 x 3", "9","29","66","23"},
                {"6 x 5", "30","45","23","34"},
                {"7 x 7", "49","35","56","22"},
                {"8 x 8", "64","56","81","17"},
                {"2 x 10", "20","25","45","78"},
                {"2 x 7", "14","34","53","78"},
                {"2 x 9", "18","14","56","81"},*/
        };

        for (int linha = 0; linha < quizData.length; linha++) {

            for (int coluna = 0; coluna < quizData[linha].length; coluna++) {

                Random r = new Random();

                int min = 1;
                int max = 10;

                int num = r.nextInt((max - min) + 1) + min;
                int num2 = r.nextInt((max - min) + 1) + min;

                int resp = num * num2;

                Random r2 = new Random();

                int min2 = 1;
                int max2 = 10;

                int num3 = r2.nextInt((max2 - min2) + 1) + min2;
                int num4 = r2.nextInt((max2 - min2) + 1) + min2;
                int num5 = r2.nextInt((max2 - min2) + 1) + min2;

               /* Set numeros = new TreeSet();
                Random rand = new Random();
//Vamos sortear 20 números de 0 até 100 sem repetição
               // while (numeros.size() < 3) {
                    numeros.add(rand.nextInt(max2));
             //   }
*/
                quizData[linha][0] = String.valueOf(num + " X " + num2);
                quizData[linha][1] = String.valueOf(resp);
                quizData[linha][coluna] = String.valueOf(num3);
                quizData[linha][coluna] = String.valueOf(num4);
                quizData[linha][coluna] = String.valueOf(num5);
            }

            for (int i = 0; i < quizData.length; i++) {

                //Prepare array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizData[i][0]); //Pergunta
                tmpArray.add(quizData[i][1]); // Resposta Certa
                tmpArray.add(quizData[i][2]); // Alternativa 1
                tmpArray.add(quizData[i][3]); // Alternativa 2
                tmpArray.add(quizData[i][4]); // Alternativa 3

                //Add tmpArray to quizArray
                quizArray.add(tmpArray);
            }
            showNextQuiz();
        }
    }
        public void showNextQuiz(){

        //update quizCountLabel
        countLabel.setText("Questão" + quizCount);

        //Generate random number between 0 and 10 (quizArray size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

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

        carregarProgressBar();
    }

    public void carregarProgressBar() {

        // progressBar Horizontal
        progressBarHorizontal.setVisibility(View.VISIBLE);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {


            @Override
            public void run() {
               // counter = 0;
                counter++;
                //progressBarHorizontal.setVisibility(View.VISIBLE);
                progressBarHorizontal.setProgress(counter);

              //  if(counter == 100){
                //    progressBarHorizontal.setVisibility(View.GONE);
                    //btnText.equals(rightAnswer);
                  //  counter = 0;
                    //  t.cancel();
                    //  quizCount++;

                    //showNextQuiz();

                    // showNextQuiz();
                //}
            }
        };
        t.schedule(tt, 0, 100);
    }

    public void verificaResposta(View view){

        progressBarHorizontal.setVisibility(View.GONE);

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
                    //progressBarHorizontal.setVisibility(View.GONE);
                   // t.cancel();
                    counter = 0;
                    showNextQuiz();
                }
            }
        });

        builder.setCancelable(false);
        builder.show();
    }
        //----------------------------------------------fim------------------------------
}

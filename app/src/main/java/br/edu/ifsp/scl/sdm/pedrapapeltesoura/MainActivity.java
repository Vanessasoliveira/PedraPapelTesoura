 package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private RadioGroup opcaoRg;
     private Button pedra, papel, tesoura;
     private TextView resultadoTv;
     private String valorFinal, valorComputador1, valorComputador2;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         opcaoRg = findViewById(R.id.opcaoRg);
         pedra = findViewById(R.id.pedra);
         papel = findViewById(R.id.papel);
         tesoura = findViewById(R.id.tesoura);
         resultadoTv = findViewById(R.id.resultadoTv);

         pedra.setOnClickListener(this);
         papel.setOnClickListener(this);
         tesoura.setOnClickListener(this);


     }


     @Override
     public void onClick(View view) {
         int jogada = 1;
        // String valorFinal;
         switch (view.getId()) {
             case R.id.pedra:
                 jogada = 0;
                 valorFinal = " Pedra ";
                 break;
             case R.id.papel:
                 jogada = 1;
                 valorFinal = " Papel ";
                 ;
                 break;
             case R.id.tesoura:
                 jogada = 2;
                 valorFinal = " Tesoura ";

                 break;
             default:
                 break;
         }
         jogarJokenpo(jogada);
     }




     private void jogarJokenpo (int jogada){
         Random random  = new Random(System.currentTimeMillis());
         Random random2 = new Random(System.currentTimeMillis());
         int jogadaComputador1 = random.nextInt(3);
         int jogadaComputador2 = random2.nextInt(3);



         switch (jogadaComputador1) {
             case 0:
                 jogadaComputador1 = 0;
                 valorComputador1 = " Pedra ";
                 break;
             case 1:
                 jogadaComputador1 = 1;
                 valorComputador1 = " Papel ";
                 break;
             case 2:
                 jogadaComputador1 = 2;
                 valorComputador1 = " Tesoura ";

                 break;
             default:
                 break;
         }



         StringBuilder resultadoSb = new StringBuilder();
         resultadoSb.append("Sua jogada: ");
         resultadoSb.append(valorFinal);


         //jogada do computador 1
         resultadoSb.append("\n Computador 1: ");
         resultadoSb.append(valorComputador1);
         resultadoSb.append("\n ");



         if (opcaoRg.getCheckedRadioButtonId() == R.id.doisJogadoresRb) {

             valorComputador2 = " Não jogou esta partida";

             if (jogada == jogadaComputador1) {
                 resultadoSb.append(" Empate!");
             } else if (jogada == 0 && jogadaComputador1 == 1) {
                 resultadoSb.append("   Você perdeu! Computador ganhou! ");
             } else if (jogada == 0 && jogadaComputador1 == 2) {
                 resultadoSb.append(" Você ganhou! Computador perdeu! ");
             } else if (jogada == 1 && jogadaComputador1 == 2) {
                 resultadoSb.append(" Você perdeu! Computador ganhou! ");
             } else if (jogada == 1 && jogadaComputador1 == 0) {
                 resultadoSb.append(" Você ganhou! Computador perdeu! ");
             } else if (jogada == 2 && jogadaComputador1 == 1) {
                 resultadoSb.append(" Você ganhou! Computador perdeu! ");
             } else if (jogada == 2 && jogadaComputador1 == 0) {
                 resultadoSb.append(" Você perdeu! Computador ganhou! ");
             }
         }
            if (opcaoRg.getCheckedRadioButtonId() == R.id.tresJogadoresRb) {

                 switch (jogadaComputador2) {
                     case 0:
                         jogadaComputador2 = 0;
                         valorComputador2 = " Pedra ";
                         break;
                     case 1:
                         jogadaComputador2 = 1;
                         valorComputador2 = " Papel ";
                         break;
                     case 2:
                         jogadaComputador2 = 2;
                         valorComputador2 = " Tesoura ";
                         break;
                     default:
                         break;
                 }

                //jogada do computador 2
                resultadoSb.append("Computador 2: ");
                resultadoSb.append(valorComputador2);
                resultadoSb.append("\n");

                if ((jogada == jogadaComputador1) && (jogada == jogadaComputador2) && (jogadaComputador1 == jogadaComputador2)) {
                     resultadoSb.append(" Os três empataram!");
                 } else if ((jogada != jogadaComputador1) && (jogada != jogadaComputador2) && (jogadaComputador1 != jogadaComputador2)) {
                     resultadoSb.append(" GAME OVER!!! Ninguém ganhou, pois a tesoura corta o papel, o papel embrulha a pedra e a pedra quebra a tesoura!!!");
                 }else if((jogada == 0) && (jogadaComputador1 == 1) && (jogadaComputador1 == jogadaComputador2)) {
                    resultadoSb.append(" Você perdeu e os outros dois empataram!");
                }
                else if((jogada == 0) && (jogadaComputador1 == 2) && (jogadaComputador1 == jogadaComputador2)) {
                    resultadoSb.append(" Você ganhou e os outros dois empataram!");
                }else if((jogada == 1) && ( jogadaComputador1 == 2) && (jogadaComputador1 == jogadaComputador2)) {
                    resultadoSb.append(" Você perdeu e os outros dois empataram!");
                }else if((jogada == 1) && ( jogadaComputador1 == 0) && (jogadaComputador1 == jogadaComputador2)) {
                        resultadoSb.append(" Você ganhou e os outros dois empataram!");
                }else if((jogada == 2) && (jogadaComputador1 == 0) && (jogadaComputador1 == jogadaComputador2)) {
                    resultadoSb.append(" Você perdeu e os outros dois empataram!");
                }else if((jogadaComputador1 == 0) && (jogada == 1) && (jogada == jogadaComputador2))
                    {
                        resultadoSb.append(" Você perdeu e os outros dois empataram!");
                    }
                else if((jogadaComputador1 == 1) && (jogada == 2) && (jogada == jogadaComputador2))
                {
                    resultadoSb.append(" Você empatou! Computador 1 perdeu!");
                }
                else if((jogada == 2) && (jogadaComputador1 == 1) && (jogadaComputador1 == jogadaComputador2)) {
                    resultadoSb.append(" Você ganhou e os outros dois empataram!");
                }
                else if((jogadaComputador2 == 2) && (jogadaComputador1 == 1) && (jogadaComputador1 == jogada)) {
                    resultadoSb.append(" Computador 2 ganhou! ");
                }
                else if((jogadaComputador2 == 2) && (jogadaComputador1 == 0) && (jogadaComputador1 == jogada)) {
                    resultadoSb.append(" Computador 2 perdeu e você empatou na vitória! ");
                }


             }
         resultadoTv.setText(resultadoSb.toString());
            }




         }





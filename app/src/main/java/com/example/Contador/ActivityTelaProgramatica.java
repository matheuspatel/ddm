package com.example.Contador;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;

    public class ActivityTelaProgramatica extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setGravity(Gravity.CENTER_HORIZONTAL);
        //pra definir os parametros e aplicar
            LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );

            layout.setLayoutParams(parametros);

            TextView texto = new TextView(this);
            texto.setText("Olá Mundo");

            Button botao = new Button(this);
            botao.setText("Clica aqui");

            // P add as views no lilayout
            layout.addView(texto);
            layout.addView(botao);

            LinearLayout.LayoutParams parametrosElementos = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
 //p aplicar
            texto.setLayoutParams(parametrosElementos);
            botao.setLayoutParams(parametrosElementos);

            // msm coisa de escolher o layout xml, mas aqui a gente fala p pegar o nosso daqui da classe
            setContentView(layout);

        }
    }
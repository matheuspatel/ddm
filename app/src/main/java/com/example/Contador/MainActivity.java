package com.example.Contador;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        Button bProx, bBack;
        ImageView imgV;
        int imagens [] = new int []{R.drawable.mia,R.drawable.messi,R.drawable.vini,R.drawable.bozo,R.drawable.davi,R.drawable.kratos,R.drawable.dorao};

        int posicao=0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            bProx = findViewById(R.id.btProx);
            bBack = findViewById(R.id.btBack);
            imgV = findViewById(R.id.imgVi);

            bProx.setOnClickListener( v -> {
                posicao++;
                if (posicao>= imagens.length) {
                    posicao=0;
                }
                imgV.setImageResource(imagens[posicao]);
        });

            bBack.setOnClickListener( v -> {
                posicao--;
                if (posicao < 0) {
                    posicao = imagens.length - 1;
                }
                imgV.setImageResource(imagens[posicao]);

            });

        }

        @Override
        protected void onResume() {
            super.onResume();
            posicao = 0;
            imgV.setImageResource(imagens[posicao]);
        }
    }
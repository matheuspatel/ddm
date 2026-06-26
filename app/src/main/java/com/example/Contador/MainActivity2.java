package com.example.Contador;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView peso;
    TextView altura;
    TextView result;
    TextView classf;
    ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        imgResult = findViewById(R.id.imgResultado);
        imgResult.setImageResource(R.drawable.perfil);
        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        result = findViewById(R.id.resultado);
        classf = findViewById(R.id.classf);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            double IMC = bundle.getDouble("chaveIMC");
            double vPeso = bundle.getDouble("chaveVPeso");
            double vAltura = bundle.getDouble("chaveVAltura");

            peso.setText("Peso: " + vPeso + " kg");
            altura.setText("Altura: " + vAltura + " m");
            result.setText(String.format("IMC: %.1f", IMC));

            if (IMC < 18.5) {
                classf.setText("Abaixo do peso");
                imgResult.setImageResource(R.drawable.abaixopeso);
                return;
            }
            if (IMC <= 24.9) {
                classf.setText("Peso normal");
                imgResult.setImageResource(R.drawable.normal);
                return;
            }
            if (IMC <= 29.9) {
                classf.setText("Sobrepeso");
                imgResult.setImageResource(R.drawable.sobrepeso);
                return;
            }
            if (IMC <= 34.9) {
                classf.setText("Obesidade grau 1");
                imgResult.setImageResource(R.drawable.obesidade1);
                return;
            }
            if (IMC <= 39.9) {
                classf.setText("Obesidade grau 2");
                imgResult.setImageResource(R.drawable.obesidade2);
                return;
            }
            //agr nn vai precisar do if pq ja teve os returns, so sobra isso
            classf.setText("Obesidade grau 3");
            imgResult.setImageResource(R.drawable.obesidade3);
        }

        }
    }
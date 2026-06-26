package com.example.Contador;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        Button bCalcular;
        ImageView imgInicio;
        EditText peso;
        EditText altura;
        double vPeso;
        double vAltura;
        double IMC;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            imgInicio = findViewById(R.id.imgInicio);
            imgInicio.setImageResource(R.drawable.perfil);
            bCalcular = findViewById(R.id.buCalcular);
            peso = findViewById(R.id.peso);
            altura = findViewById(R.id.altura);

            bCalcular.setOnClickListener(v -> {
//pra tranformar pro tipo double decimal
                vPeso = Double.parseDouble(peso.getText().toString());
                vAltura = Double.parseDouble(altura.getText().toString());
//formula propria do imc
                IMC = vPeso / (vAltura * vAltura);
//molda pra 1 casa, o set smp define o texto, e o format tbm arredonda

                Intent i = new Intent(this, MainActivity2.class);
                i.putExtra("chaveIMC", IMC);
                i.putExtra("chaveVPeso", vPeso);
                i.putExtra("chaveVAltura", vAltura);
                startActivity(i);

            });

        }
    }
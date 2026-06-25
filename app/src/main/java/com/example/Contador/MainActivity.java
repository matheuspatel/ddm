package com.example.Contador;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        Button bCalcular;
        ImageView imgResult;
        EditText peso;
        EditText altura;
        TextView result;
        TextView classf;
        double vPeso;
        double vAltura;
        double IMC;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            imgResult = findViewById(R.id.imgResultado);
            imgResult.setImageResource(R.drawable.perfil);
            bCalcular = findViewById(R.id.buCalcular);
            peso = findViewById(R.id.peso);
            altura = findViewById(R.id.altura);
            result = findViewById(R.id.resultado);
            classf = findViewById(R.id.classf);

            bCalcular.setOnClickListener(v -> {
//pra tranformar pro tipo double decimal
                vPeso = Double.parseDouble(peso.getText().toString());
                vAltura = Double.parseDouble(altura.getText().toString());
//formula propria do imc
                IMC = vPeso / (vAltura * vAltura);
//molda pra 2 casas, o set smp define o texto
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
            });

        }
    }
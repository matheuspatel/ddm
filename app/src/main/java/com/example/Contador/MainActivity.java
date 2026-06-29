package com.example.Contador;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        TextView titulo;
        TextView tela;
        Button bProg;
        Button bForm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            titulo = findViewById(R.id.titulo);
            tela = findViewById(R.id.tela);
            bProg = findViewById(R.id.bProg);
            bForm = findViewById(R.id.bForm);

            bProg.setOnClickListener(v -> {
                Intent i = new Intent(this, ActivityTelaProgramatica.class);
                startActivity(i);
            });
            bForm.setOnClickListener(v -> {
                Intent i = new Intent(this, ActivityFormularioConstraint.class);
                startActivity(i);
            });
        }
    }
package com.example.Contador;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//pra funcionar o random aleatorio:
import java.util.Random;

    public class MainActivity extends AppCompatActivity {

        Button sorteio;
        TextView result;
        EditText n1;
        EditText n2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);

            sorteio = findViewById(R.id.sorteio);
            result = findViewById(R.id.result);
            n1 = findViewById(R.id.n1);
            n2 = findViewById(R.id.n2);

            sorteio.setOnClickListener(this::fazSorteio);
        }

        private void fazSorteio(View view) {
            try {
                int nu1 = Integer.parseInt(n1.getText().toString());
                int nu2 = Integer.parseInt(n2.getText().toString());

                int res = new Random().nextInt((nu2 - nu1)+1)+nu1;
                result.setText("O sorteio foi: " + res);

            } catch (Exception e) {

                new AlertDialog.Builder(this).setMessage("Digite 2 números para o sorteio:").show();

            }

        }
    }
package com.example.Contador;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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
            setContentView(R.layout.activity_main);

            sorteio = findViewById(R.id.sorteio);
            result = findViewById(R.id.result);
            n1 = findViewById(R.id.n1);
            n2 = findViewById(R.id.n2);

            sorteio.setOnClickListener(this::fazSort);
        }

        private void fazSort(View view) {
            if (n1.getText().toString().isEmpty() ||
                    n2.getText().toString().isEmpty()) {

                new AlertDialog.Builder(this)
                        .setMessage("Digite 2 números para o sorteio")
                        .show();

                return;
            }

                int nu1 = Integer.parseInt(n1.getText().toString());
                int nu2 = Integer.parseInt(n2.getText().toString());

                int res = new Random().nextInt((nu2 - nu1)+1)+nu1;
                result.setText("O sorteio foi: " + res);

             /* poderíamos usar o try e o : catch (Exception e) {
                result.setText("ERRO");
                isso pra verificar erros como se tentarem colocar letras, mas como nos testes ja tá puxando apenas numero, estamos usando o if pra verificar e usar o dialog
*/
            }

        }
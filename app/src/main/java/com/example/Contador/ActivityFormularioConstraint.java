package com.example.Contador;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFormularioConstraint extends AppCompatActivity {

    EditText nome;
    EditText endereco;
    EditText cidade;
    EditText email;
    EditText telefone;
    EditText cep;
    EditText aniversario;
    Spinner estado;
    ImageButton bAniversario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_constraint);

        nome = findViewById(R.id.nome);
        endereco = findViewById(R.id.endereco);
        cidade = findViewById(R.id.cidade);
        email = findViewById(R.id.email);
        telefone = findViewById(R.id.telefone);
        estado = findViewById(R.id.estado);
        cep = findViewById(R.id.cep);
        aniversario = findViewById(R.id.aniversario);
        bAniversario = findViewById(R.id.bAniversario);

    }
}
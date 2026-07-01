package com.example.Contador;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;

    public class MainActivity extends AppCompatActivity {
        //declarando a variável, e é privada pra ser segura apenas nessa classe:
        private SQLiteDatabase banco;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//executando o metodo que cria ou abre um banco de dados no sqlite com o nome banco
            //o metodo ta no contexto da activity, e o banco é aberto com o parametro modo privado, só uma activity acessa por vez
            //o this faz com que seja obrigado a estar na activity que tem acesso ao contexto do sistema pra acessar
            banco = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);
            //criar a tabela
            banco.execSQL("CREATE TABLE IF NOT EXISTS alunos (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome_UC TEXT NOT NULL, nota DECIMAL NOT NULL)");

        }
        //metodos inserir nota e show
        public void insereNota(){

        }
        public void showAlunos(){

        }
    }
package com.example.Contador;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//Código com os cometários de estudo

public class MainActivity extends AppCompatActivity {
        //declarando a variável, e é privada pra ser segura apenas nessa classe:
        private SQLiteDatabase banco;

        private EditText editTextCodigo,editTextNomeUC,editTextNota;
        private ListView listView;
        private Button bInserir;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
            editTextNomeUC = (EditText) findViewById(R.id.editTextNomeUC);
            editTextNota  = (EditText) findViewById(R.id.editTextNota);
            bInserir = (Button) findViewById(R.id.bInserir);

//executando o metodo que cria ou abre um banco de dados no sqlite com o nome banco:
            //o metodo ta no contexto da activity, e o banco é aberto com o parametro modo privado, só uma activity acessa por vez
            //o this faz com que seja obrigado a estar na activity que tem acesso ao contexto do sistema pra acessar
            banco = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);
            //criar a tabela com as colunas
            banco.execSQL("CREATE TABLE IF NOT EXISTS notas (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome_UC TEXT NOT NULL, nota DECIMAL NOT NULL)");

            //botão pra chamar o metodo insere:
            bInserir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    insereNota();
                }
            });
            //chamar o metodo pra mostrar as notas que tem:
            showNotas();
        }
        //metodos inserir nota e show:
        public void insereNota(){
            //pra fazer a inserção de dados, usar o contentValues, que é uma variavel especial hashmap pra
            //empilhar uma lista de chave-valor, que é bem o que se passa ao inserir dados com insert no sql.
            //então criamos e instanciamos:
            ContentValues contentValues = new ContentValues();
            //pegar o que tem nas variaveis pra colocar como chave-valor na coluna:
            contentValues.put("nome_UC",editTextNomeUC.getText().toString());
            contentValues.put("nota",editTextNota.getText().toString());
            //metodo q diz q nessa classe, no banco, rola o insert pra inserir os dados:
            //usa o insert passando a tabela como primeiro parametro, o segundo null,
            //e o terceiro o content:
            this.banco.insert("notas",null,contentValues );

            // Chama de nv o metodo show pra mostrar como tá a lista:
            showNotas();
        }

        public void showNotas(){
            //pra consultar/recuperar dados, executa o rawQuery e passa o select, vem em uma matriz tipo cursor
            //select vai buscar todos os nomes da tabela notas e id e vai por na matriz conforme vai passando o ponteiro:
            Cursor cursor = banco.rawQuery("SELECT _id, nome_UC FROM notas", null);
            //pra apontar pro primeiro item pq o cursor vai estar no último:
            cursor.moveToFirst();
            //tem q ter uma array list pra carregar a listview
            ArrayList<String> itens = new ArrayList<>();
            //laço pra pegar cada elemento do cursor e colocar no itens
            do {
                //pegar a string da linha que o cursor ta apontando, e o getColum vai pegar o nome da
                //coluna e retornar o indice dela, pra aí sim trazer o nome:
                String s = cursor.getString(cursor.getColumnIndex("nome_UC"));
                //adiciono a string no arraylist:
                itens.add(s);
            }
            //faz até quando for possivel o cursor estar indo pro proximo e para
            while (cursor.moveToNext()) ;
            ListView list;
            list = findViewById(R.id.listView);
            //carregar o adapter:
            ArrayAdapter<String> adapter = new ArrayAdapter<String> (
                    //recebendo como parametros o contexto, o xml e o id do item já prontos do Android(dd uma linha e um campo tv,
                    // e o array que tem os itens pra por no text1:
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    itens);
            //carregar a lista e apresentar:
            list.setAdapter(adapter);

        }
    }
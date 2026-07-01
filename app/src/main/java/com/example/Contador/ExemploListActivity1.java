package com.example.Contador;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//como não encontrei slide desponibilizado e havia faltado em um dia de aula, utilizei o livro sobre
//programação para Android do Ricardo Lechete para estudar e realizar atividade.
//O livro havia sido recomendado pelo prof Romulo no fim de um vídeo sobre SQL no canal do YT, em que
//disse que o livro continha conteúdos sobre SQL e também adapter. Como o livro não constava a recycler,
// optei por pesquisar sobre, mas não adicioná-la no código para não utilizar IA

//estendendo a classe pra classe ListView, pra herdar as funções dela de ListView:
public class ExemploListActivity1 extends ListActivity {
    @Override
    //como o livro é antigo, ele tava usando o bundle com nome de icicle, e pelo que pesquisei
    //antigamente era usado assim pq eles entendiam que congelava o estado da tela e dps descongelava, girando o cllr etc
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//a gente não vai usar o setContentView pq a classe ListActivity já cria uma tela com lista por padrão
//array de strings pra visualizar na lista:
        String[] motos = new String[] { "YBR Factor", "Fazer", "CG Fan", "KTM", "XR" };

        //Criando o ArrayAdapter pra ser o intermediário, e usando um layout padrão do Windows pra cada linha:
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, motos);

        // Pra colocar o adaptador na ListActivity
        setListAdapter(arrayAdapter);
    }

    // Criando o metodo pra detectar quando o usuário clica em algum item da lista:
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // Pega o item clicado conforme a posição dele, 1, 2 etc, pois chama o adapter pra pegar o objeto da posição. O object é variável genérica pq poderia ser um número o item.
        Object o = this.getListAdapter().getItem(position);
        String motoSelecionada = o.toString();

        // Mostra uma mensagem na tela, com o lenght short faz ela ser rápida:
        Toast.makeText(this, "Você clicou em: " + motoSelecionada, Toast.LENGTH_SHORT).show();
    }
}

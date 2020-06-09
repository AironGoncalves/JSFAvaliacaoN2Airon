package br.edu.faculdadedelta.jsfavaliacaon2airon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.faculdadedelta.jsfavaliacaon2airon.adapter.ViagemAdapterAiron;
import br.edu.faculdadedelta.jsfavaliacaon2airon.dao.ViagemDAOAiron;
import br.edu.faculdadedelta.jsfavaliacaon2airon.modelo.ViagemAiron;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLista;
    private ViagemDAOAiron dao = new ViagemDAOAiron();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLista = findViewById(R.id.lvlista);


        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViagemAiron viagemSelecionado = (ViagemAiron) parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("viagemSelecionado", viagemSelecionado);
                startActivity(intent);
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ViagemAiron viagemSelecionado = (ViagemAiron) parent.getItemAtPosition(position);
                dao.excluir(viagemSelecionado);
                carregarLista();
                return false;
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    private void carregarLista(){
        ViagemAdapterAiron adapter = new ViagemAdapterAiron(dao.listar(), getBaseContext());
        lvLista.setAdapter(adapter);
    }

    public void novo(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);


    }

}

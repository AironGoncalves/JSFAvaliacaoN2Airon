package br.edu.faculdadedelta.jsfavaliacaon2airon.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.faculdadedelta.jsfavaliacaon2airon.R;
import br.edu.faculdadedelta.jsfavaliacaon2airon.modelo.ViagemAiron;

public class ViagemAdapterAiron extends BaseAdapter {

    private List<ViagemAiron> listaViagem;
    private Context context;

    public ViagemAdapterAiron(List<ViagemAiron> listaViagem, Context context) {
        this.listaViagem = listaViagem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaViagem.size();
    }

    @Override
    public Object getItem(int position) {
        return listaViagem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViagemAiron viagem = (ViagemAiron) getItem(position);

        View viewRetorno = view.inflate(context, R.layout.item_lista, null);

        TextView tvId = viewRetorno.findViewById(R.id.tvId);
        tvId.setText("Id: "+viagem.getId());

        TextView tvMotorista = viewRetorno.findViewById(R.id.tvMotorista);
        tvMotorista.setText("Motorista: "+viagem.getMotorista());

        TextView tvCategoria = viewRetorno.findViewById(R.id.tvCategoria);
        tvCategoria.setText("Categoria: "+viagem.getCategoria());

        TextView tvDestino = viewRetorno.findViewById(R.id.tvDestino);
        tvDestino.setText("Destino: "+viagem.getDestino());

        TextView tvDistancia = viewRetorno.findViewById(R.id.tvDistancia);
        tvDistancia.setText("Distancia: "+ viagem.getDistancia());

        TextView tvValor = viewRetorno.findViewById(R.id.tvValor);
        tvValor.setText("Valor: "+viagem.getValorKm());


        TextView tvData = viewRetorno.findViewById(R.id.tvData);

        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

        tvData.setText("Data da Corrida: : "+sf.format(viagem.getDataCorrida()));



        if (position % 2 == 0) {
            viewRetorno.setBackgroundColor(R.color.colorAccent);
        }

        return viewRetorno;
    }
}

package br.edu.faculdadedelta.jsfavaliacaon2airon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.faculdadedelta.jsfavaliacaon2airon.dao.ViagemDAOAiron;
import br.edu.faculdadedelta.jsfavaliacaon2airon.modelo.ViagemAiron;

public class MainActivity extends AppCompatActivity {

    private EditText etMotorista;
    private EditText etCategoria;
    private EditText etDestino;
    private EditText etDistancia;
    private EditText etValor;
    private EditText etDataCorrida;

    private String dataFinal = "01/01/2021";

    private ViagemAiron viagem = new ViagemAiron();
    private ViagemDAOAiron dao = new ViagemDAOAiron();

    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataHoje = new Date();

    Date dataAux = null;

    {
        try {
            dataAux = sf.parse(dataFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMotorista = findViewById(R.id.etMotorista);
        etCategoria = findViewById(R.id.etCategoria);
        etDestino = findViewById(R.id.etDestino);
        etDistancia = findViewById(R.id.etDistancia);
        etValor = findViewById(R.id.etValor);
        etDataCorrida = findViewById(R.id.etDataCorrida);

        Intent intent = getIntent();


        if (intent != null) {
            ViagemAiron viagemSelecionado = (ViagemAiron) intent.getSerializableExtra("viagemSelecionado");
            if(viagemSelecionado != null){
                popularFormulario(viagemSelecionado);
            }

        }
    }

    private void popularFormulario(ViagemAiron viagemSelecionado){

        etMotorista.setText(viagemSelecionado.getMotorista());
        etCategoria.setText(viagemSelecionado.getCategoria());
        etDestino.setText(viagemSelecionado.getDestino());
        etDistancia.setText(viagemSelecionado.getDistancia());
        etValor.setText(String.valueOf(viagemSelecionado.getValorKm()));
        etDataCorrida.setText(sf.format(viagemSelecionado.getDataCorrida()));

    }


    private void popularModelo(){

        viagem.setMotorista(etMotorista.getText().toString());
        viagem.setCategoria(etCategoria.getText().toString());
        viagem.setDestino(etDestino.getText().toString());
        viagem.setDistancia(etDistancia.getText().toString());
        viagem.setValorKm(Double.parseDouble(etValor.getText().toString()));

        Date data = null;

        try {
            data = sf.parse(etDataCorrida.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        viagem.setDataCorrida(data);


    }

    public void salvar(View view) throws ParseException {

        String motorista = etMotorista.getText().toString();
        String categoria = etCategoria.getText().toString();
        String destino = etDestino.getText().toString();
        String distancia = etDistancia.getText().toString();
        String valor = etValor.getText().toString();
        String dataCorrida = etDataCorrida.getText().toString();

        String dataSistemaTexto = sf.format(dataHoje);

        Date dataSistema = sf.parse(dataSistemaTexto);

        String dataSistemaTextoB = sf.format(dataAux);

        Date dataSistemaB = sf.parse(dataSistemaTextoB);


        Date dataDigitada = null;

        try {
            dataDigitada = sf.parse(etDataCorrida.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }




        if (motorista.isEmpty() && categoria.isEmpty() && destino.isEmpty() && distancia.isEmpty() && valor.isEmpty() && dataCorrida.isEmpty()) {
            Toast.makeText(getBaseContext(), "Todos os campos são obrigatórios!",
                    Toast.LENGTH_LONG).show();
        } else if (motorista.isEmpty()) {
            Toast.makeText(getBaseContext(), "O campo Motorista é obrigatório!",
                    Toast.LENGTH_LONG).show();
            etMotorista.requestFocus();
        } else if (motorista.length() > 20 ) {
            Toast.makeText(getBaseContext(), "O campo Motorista não pode ter mais do que 20 caracteres",
                    Toast.LENGTH_LONG).show();
            etMotorista.requestFocus();
        }else if(categoria.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo Categoria é obrigatório!",
                    Toast.LENGTH_LONG).show();
            etCategoria.requestFocus();
        }else if (destino.isEmpty()) {
            Toast.makeText(getBaseContext(), "O campo Destino é obrigatório!",
                    Toast.LENGTH_LONG).show();
            etDestino.requestFocus();
        }else if (destino.length() > 30) {
            Toast.makeText(getBaseContext(), "O campo Destino não pode ter mais do que 30 caracteres!",
                    Toast.LENGTH_LONG).show();
            etDestino.requestFocus();
        }else if (distancia.isEmpty()) {
            Toast.makeText(getBaseContext(), "O campo Distância é obrigatório!",
                    Toast.LENGTH_LONG).show();
            etDistancia.requestFocus();
        }else if (valor.isEmpty()) {
            Toast.makeText(getBaseContext(), "O campo Valor é obrigatório!",
                    Toast.LENGTH_LONG).show();
            etValor.requestFocus();
        } else if (dataCorrida.isEmpty()) {
            Toast.makeText(getBaseContext(), "O campo Data da Corrida é obrigatório !",
                    Toast.LENGTH_LONG).show();
            etDataCorrida.requestFocus();
        }else if (dataDigitada.before(dataHoje)  || dataDigitada.after(dataAux) || dataDigitada.equals(dataSistema) || dataDigitada.equals(dataSistemaB)) {

            if (dataDigitada.before(dataHoje)) {
                Toast.makeText(getBaseContext(), "A Data da Corrida deve ser maior que a data atual!",
                        Toast.LENGTH_LONG).show();
                etDataCorrida.requestFocus();
            } else if (dataDigitada.after(dataAux)) {
                Toast.makeText(getBaseContext(), "A Data da Corrida deve ser menor que a data de 01/01/2021!",
                        Toast.LENGTH_LONG).show();
                etDataCorrida.requestFocus();
            } else if (dataDigitada.equals(dataSistema)) {
                Toast.makeText(getBaseContext(), "A Data da Corrida deve ser maior que a data atual!!",
                        Toast.LENGTH_LONG).show();
                etDataCorrida.requestFocus();
            }else if (dataDigitada.equals(dataSistemaB)) {
                Toast.makeText(getBaseContext(), "A Data da Corrida deve ser menor que a data de 01/01/2021!!",
                        Toast.LENGTH_LONG).show();
                etDataCorrida.requestFocus();
            }

        }else {
            popularModelo();


            if (viagem.getId() == null) {
                dao.incluir(viagem);
                Toast.makeText(getBaseContext(), "Inclusão realizada com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();
            } else {
                dao.alterar(viagem);
                Toast.makeText(getBaseContext(), "Alteração realizada com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();
            }

            etMotorista.requestFocus();

        }



    }

    public void limparCampos(){
        etMotorista.setText("");
        etCategoria.setText("");
        etDestino.setText("");
        etDistancia.setText("");
        etValor.setText("");
        etDataCorrida.setText("");
        viagem = new ViagemAiron();
        etMotorista.requestFocus();
    }

    public void limpar(View view){
        limparCampos();
    }

    public void listar(View view){
        finish();
    }

}

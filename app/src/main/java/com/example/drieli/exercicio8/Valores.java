package com.example.drieli.exercicio8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Drieli on 17/04/2016.
 */
public class Valores extends AppCompatActivity {
    public final static String EXTRA_VALOR_TOTAL = "com.example.drieli.atividade8.VALOR_TOTAL";
    public final static String EXTRA_VALOR_DIVIDIDO = "com.example.drieli.atividade8.EXTRA_VALOR_DIVIDIDO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valores);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_valores:
                showValores();
                return true;
            case R.id.menu_calculo:
                showCalculo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showValores(){
        Intent intent = new Intent(this, Valores.class);
        startActivity(intent);
    }

    public void showCalculo(){
        Intent intent = new Intent(this, Calculo.class);
        startActivity(intent);
    }

    public void calcular(View v){

        EditText valorConta = (EditText) findViewById(R.id.valores);
        EditText valorTaxa = (EditText) findViewById(R.id.taxa_servico);
        EditText qtdPessoas = (EditText) findViewById(R.id.pessoas);

        double valor =  Double.parseDouble(valorConta.getText().toString());
        double taxa =  Double.parseDouble(valorTaxa.getText().toString());
        int pessoas =  Integer.parseInt(qtdPessoas.getText().toString());

        double valorTotal = valor + taxa;
        double valorDividido = valorTotal/pessoas;

        Intent intent = new Intent(this, Calculo.class);
        Bundle bValorTotal = new Bundle();
        bValorTotal.putDouble("valorTotal", valorTotal);
        Bundle bValorDividido = new Bundle();
        bValorDividido.putDouble("valorDividido", valorDividido);
        intent.putExtras(bValorTotal);
        intent.putExtras(bValorDividido);

        startActivity(intent);

    }

}

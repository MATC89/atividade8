package com.example.drieli.exercicio8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Drieli on 17/04/2016.
 */
public class Calculo extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo);

        Intent intent = getIntent();
        String valorTotal = intent.getStringExtra(Valores.EXTRA_VALOR_TOTAL);
        String valorDividido = intent.getStringExtra(Valores.EXTRA_VALOR_DIVIDIDO);

        TextView total = (TextView) findViewById(R.id.total);
        total.setText(valorTotal);

        TextView valor_dividido = (TextView) findViewById(R.id.valor_dividido);
        valor_dividido.setText(valorDividido);
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

}

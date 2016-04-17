package com.example.drieli.exercicio8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial);
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

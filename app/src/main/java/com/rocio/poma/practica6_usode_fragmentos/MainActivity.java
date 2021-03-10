package com.rocio.poma.practica6_usode_fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ContadorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentUno fragmentUno = new FragmentUno();
        fragmentUno.setConttadorListener(this);
        FragmentDos fragmentDos= new FragmentDos();
        fragmentDos.setConttadorListener(this);

        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentUno);
                transaction.commit();
            }
        });

        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentDos);
                transaction.commit();
            }
        });

    }

    //CONTADOR
    int cont=0;
    @Override
    public void incrementarContador() {
        cont++;
    }

    @Override
    public int getValorActualContador() {
        return cont;
    }
}
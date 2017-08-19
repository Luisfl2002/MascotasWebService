package com.angel_fere.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Angel_Fere on 25/07/2017.
 */

public class contacto extends AppCompatActivity {

        private EditText etnombre;
        private EditText etemail;
        private EditText etsugerencias;
        private Button bsig;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        etnombre = (EditText) findViewById(R.id.etnombre);
        etemail = (EditText) findViewById(R.id.etemail);
        etsugerencias = (EditText) findViewById(R.id.etsugerencias);
        bsig = (Button) findViewById(R.id.bsig);

        bsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etemail.getText().toString().equals("")){
                    enviarMail();
                }
            }
        });

    }

    public void enviarMail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{etemail.getText().toString()});
       intent.putExtra(Intent.EXTRA_SUBJECT,etsugerencias.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,etsugerencias.getText().toString());
        try{
            startActivity(intent.createChooser(intent,"Enviando correo"));


        }catch(Exception e){
            e.printStackTrace();

        }

    }



}

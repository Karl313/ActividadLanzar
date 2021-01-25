package com.example.a2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText pass;
    private RadioButton registrar;
    private RadioButton acceder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.tuser);
        pass = findViewById(R.id.tpasss);
        registrar = findViewById(R.id.rbregistrar);
        acceder = findViewById(R.id.rbacceder);

    }

    public void Lanzar(View v) {
        String usuario = this.usuario.getText().toString();
        String pass = this.pass.getText().toString();
        SharedPreferences sp = getSharedPreferences("basededatos", Context.MODE_PRIVATE);
        if (registrar.isChecked()) {

            SharedPreferences.Editor editor = sp.edit();
            editor.putString(usuario, pass);
            editor.commit();
            //guarda la contraseña y el usser en un hashmap en un archivo temporal
        } else{
            if(comprobar(usuario, pass,sp.getAll())) {
                Intent i =new Intent(this,homepage.class);
                i.putExtra("user",usuario);
                startActivity(i);
            }else{
                Toast.makeText(this, "Contraseña erronea,º prueba de nuevo", Toast.LENGTH_SHORT).show();
            }

        }


    }

    public boolean comprobar(String usser, String pass, Map<String, ?> basededatos) {
        String contraseniaBuena = (String) basededatos.get(usser);
        if (contraseniaBuena.equals(pass)) {
            return true;

        }
        return false;
    }

}
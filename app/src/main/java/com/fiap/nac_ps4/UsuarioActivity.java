package com.fiap.nac_ps4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


    final EditText nome = (EditText) findViewById(R.id.etNome);
    final TextView login = (TextView) findViewById(R.id.tvUsuario);
    final Button salvar = (Button) findViewById(R.id.btSalvar);

    salvar.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View view) {

            SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = pref.edit();
            ed.putString("nome", nome.getText().toString());
            ed.apply();
            Toast.makeText(getBaseContext(), "salvo com sucesso", Toast.LENGTH_SHORT).show();

            login.setText(pref.getString("nome", "não encontrado"));
        }
    });


    final Button lembrar = (Button) findViewById(R.id.btLembrar);
    lembrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            login.setText(prefs.getString("nome", "nops"));
        }
    });
}

    public void entrar(View view){
        Intent intent1 = new Intent(getApplicationContext(), JogosActivity.class);
        startActivity(intent1);
        finish();
    }
}

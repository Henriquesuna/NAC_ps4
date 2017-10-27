package com.fiap.nac_ps4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.fiap.nac_ps4.adapter.JogosAdapter;
import com.fiap.nac_ps4.dao.JogosDAO;
import com.fiap.nac_ps4.model.Jogos;

import java.util.ArrayList;
import java.util.List;

public class JogosActivity extends AppCompatActivity {


    private TextView tvUsuario;

    private EditText etJogo;

    private List<Jogos> jogos = new ArrayList<>();
    private ListView lvJogos;
    private List<Jogos> listaJogos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);


        tvUsuario = (TextView)findViewById(R.id.tvUsuario);
        etJogo = (EditText) findViewById(R.id.etJogo);
        lvJogos = (ListView) findViewById(R.id.lvJogos);

        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        tvUsuario.setText(prefs.getString("nome", "nops"));
    }

    public void cadastrar(View view) {

        JogosDAO jogosDAO = new JogosDAO (this);
        Jogos jogo = new Jogos(0, etJogo.getText().toString());
        jogos.add(jogo);

        jogosDAO.add(jogo);

        lvJogos.setAdapter(new JogosAdapter(JogosActivity.this, jogos));
    }



}

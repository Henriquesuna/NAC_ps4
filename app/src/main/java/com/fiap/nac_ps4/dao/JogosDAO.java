package com.fiap.nac_ps4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fiap.nac_ps4.R;
import com.fiap.nac_ps4.model.Jogos;
import com.fiap.nac_ps4.model.JogosViewHolder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 27/10/2017.
 */

public class JogosDAO {

    private DBOpenHelder banco;
    public JogosDAO(Context context) {

        banco = new DBOpenHelder(context);

    }

    public static final String TABELA_PRODUTOS = "jogos";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";

    public List<Jogos> getAll() {
        List<Jogos> jogos = new LinkedList<>();
        String query = "SELECT  * FROM " + TABELA_PRODUTOS;
        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Jogos jogo = null;
        if (cursor.moveToFirst()) {
            do {
                jogo = new Jogos(
                        cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
                );
                jogos.add(jogo);
            } while (cursor.moveToNext());
        }
        return jogos;
    }

    public Jogos getBy(int id) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String colunas[] = {COLUNA_ID, COLUNA_NOME};
        String where = "id = " + id;
        Cursor cursor = db.query(true, TABELA_PRODUTOS, colunas, where, null, null,
                null, null, null);
        Jogos jogo = null;
        if (cursor != null) {
            cursor.moveToFirst();
            jogo = new Jogos(
                    cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
            );
        }

        return jogo;
    }

    public String add(Jogos jogo) {
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, jogo.getNome());
        resultado = db.insert(TABELA_PRODUTOS,
                null,
                values);
        db.close();
        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }
}

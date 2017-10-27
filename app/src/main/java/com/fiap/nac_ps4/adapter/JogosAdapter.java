package com.fiap.nac_ps4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fiap.nac_ps4.R;
import com.fiap.nac_ps4.model.Jogos;
import com.fiap.nac_ps4.model.JogosViewHolder;

import java.util.List;

/**
 * Created by User on 27/10/2017.
 */

public class JogosAdapter extends BaseAdapter {
    private Context context;
    private List<Jogos> jogos;
    public JogosAdapter(Context context, List<Jogos> jogos) {
        this.context = context;
        this.jogos = jogos;
    }

    @Override
    public int getCount() {
        return jogos.size();
    }

    @Override
    public Object getItem(int position) {
        return jogos.get(position);
    }

    @Override
    public long getItemId(int position)
    {return jogos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        JogosViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jogos, parent, false);
            holder = new JogosViewHolder(view);
            view.setTag(holder);
        }
        else {
            view = convertView;
            holder = (JogosViewHolder) view.getTag();
        }

        Jogos jogo = jogos.get(position);

        holder.tvNome.setText(jogo.getNome());

        return view;
    }
}

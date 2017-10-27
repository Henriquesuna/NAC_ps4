package com.fiap.nac_ps4.model;

import android.view.View;
import android.widget.TextView;

import com.fiap.nac_ps4.R;

/**
 * Created by User on 27/10/2017.
 */

public class JogosViewHolder {
    public final TextView tvNome;

    public JogosViewHolder(View view) {
        tvNome = (TextView)view.findViewById(R.id.tvJogos);
    }
}

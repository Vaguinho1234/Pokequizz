package com.example.aluno.pokequizz;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 23/05/18.
 */

public class adapterPokemon extends BaseAdapter {

    private Context contexto;
    private List <Pokemon> lista;
    private AppPokequizz app;

    public adapterPokemon(Context contexto, List<Pokemon> lista, AppPokequizz app) {
        this.contexto = contexto;
        this.lista = lista;
        this.app = app;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v = view.inflate(contexto,R.layout.itempokemon,null);



        ImageView imageView =   v.findViewById(R.id.ImagePokemon);
        TextView textView = v.findViewById(R.id.NomePokemon);
        RatingBar ratingBar = v.findViewById(R.id.ratingBar);

        textView.setText(lista.get(i).nome);
        imageView.setImageDrawable(contexto.getResources().getDrawable(lista.get(i).imagem));
        ratingBar.setRating(lista.get(i).rate);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                app.SalvarPokemon(contexto,i,v);
            }
        });
        return v;
    }
}

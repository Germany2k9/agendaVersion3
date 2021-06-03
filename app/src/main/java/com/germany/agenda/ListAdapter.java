package com.germany.agenda;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.germany.agenda.ListaDatos.listaNotas;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.vistaViewHolder> {
    private ArrayList<NotaItem> lista;
    private LayoutInflater miImflater;
    private Context contexto;

    public  ListAdapter( ArrayList<NotaItem> lista,  Context contexto){
        this.lista = lista;
        this.contexto = contexto;
        this.miImflater = LayoutInflater.from(contexto);
    }


    @Override
    public vistaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View miVistaHolder = miImflater.inflate(R.layout.notas_item, parent, false);

        return  new vistaViewHolder(miVistaHolder, this);
    }

    @Override
    public void onBindViewHolder( ListAdapter.vistaViewHolder holder, int position) {
        String actividadNota = lista.get(position).getActividad();
        String fechaNota = lista.get(position).getfechaString();


        Glide.with(contexto).load(lista.get(position).getImageResource()).into(holder.imgNota);
        holder.actividadNota.setText( actividadNota);
        holder.fechaNota.setText(fechaNota);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class vistaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int mPosition = getLayoutPosition();

        ImageView imgNota;
        TextView  fechaNota;
        TextView  actividadNota;
        ListAdapter listaAdapter;

        public vistaViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            imgNota = itemView.findViewById(R.id.idImagenResource);
            fechaNota= itemView.findViewById(R.id.IdTxtFechaSelec);
            actividadNota= itemView.findViewById(R.id.IdTxtActividad);
            listaAdapter = adapter;
            itemView.setOnClickListener(this);




        }

        @Override
        public void onClick(View v) {
            int posicion = getAdapterPosition();
//            NotaItem currentNota = lista.get(getAdapterPosition());
            Intent detalleNota = new Intent(contexto, updateNotaItem.class);
            detalleNota.putExtra("Item", posicion);
            contexto.startActivity(detalleNota);
            Toast.makeText(contexto, "Item Seleccionado", Toast.LENGTH_LONG).show();
            // Use that to access the affected item in mWordList.

        }
    }

}

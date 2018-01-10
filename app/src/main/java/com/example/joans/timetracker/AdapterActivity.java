package com.example.joans.timetracker;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;



public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.TascaViewHolder> {

    private List<DadesActivitat> items;
    private OnTascaClickedListener onTascaClickedListener;


    public AdapterActivity() {
        items = new ArrayList<>();
    }
    //
    @Override
    public TascaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TascaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_adapter, parent, false));
    }

    //Función que fija las imagenes a las actividades y atributos correspondientes
    @Override
    public void onBindViewHolder(final TascaViewHolder holder, final int position) {
        final DadesActivitat dadesActivitat = items.get(position);
        if(dadesActivitat.isTasca()){
            if(dadesActivitat.isCronometreEngegat()) {
                holder.tascaPlay.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.pause));

            }else if(!dadesActivitat.isCronometreEngegat()){
                holder.tascaPlay.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.play));

            }
        }else{
            holder.tascaPlay.setImageResource(android.R.color.transparent);
        }

        holder.tascaTitol.setText(dadesActivitat.getNom()+ "\n" +dadesActivitat.getDataInicial());


        holder.tascaTimer.setText(dadesActivitat.toString());

        holder.tascaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTascaClickedListener.onPlayClicked(holder.getAdapterPosition());

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTascaClickedListener.onItemClicked(holder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void clear() {
        items.clear();
    }

    public void setItems(ArrayList<DadesActivitat> items) {
        this.items = items;
    }

    //Referenciamos el click del item de la lista al del adaptador
    public void setOnTascaClickedListener(OnTascaClickedListener onTascaClickedListener) {
        this.onTascaClickedListener = onTascaClickedListener;
    }

    //Items del adaptador de actividades
    public class TascaViewHolder extends RecyclerView.ViewHolder {


        TextView tascaTitol;
        ImageButton tascaPlay;
        ImageButton tascaInfo;
        TextView tascaTimer;


        public TascaViewHolder(View itemView) {
            super(itemView);

            tascaPlay = (ImageButton) itemView.findViewById(R.id.imageButton);
            tascaTitol = (TextView) itemView.findViewById(R.id.actionInfo);
            tascaTimer = (TextView) itemView.findViewById(R.id.durCount);

        }
    }

    public interface OnTascaClickedListener {
        void onItemClicked(int pos);
        void onPlayClicked(int pos);
    }
}
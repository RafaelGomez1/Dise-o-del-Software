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

import nucli.Interval;


public class IntervalAdapter extends RecyclerView.Adapter<IntervalAdapter.IntervalViewHolder> {

    private List<DadesInterval> intervalos;



    public IntervalAdapter() {
        intervalos = new ArrayList<>();
    }
    //
    @Override
    public IntervalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IntervalViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.interval_adapter, parent, false));
    }

    //Función que fija las imagenes a las actividades y atributos correspondientes
    @Override
    public void onBindViewHolder(final IntervalViewHolder holder, final int position) {
        final DadesInterval dadesInterval = intervalos.get(position);
        /*if(dadesInterval.){
            if(dadesActivitat.isCronometreEngegat()) {
                holder.tascaPlay.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.pause));

            }else if(!dadesActivitat.isCronometreEngegat()){
                holder.tascaPlay.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.play));

            }
        }else{
            holder.tascaPlay.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.folder));
        }

*/

        if(dadesInterval.getState()) {
            holder.imagenIntervalo.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.runinte));
        } else {
            holder.imagenIntervalo.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.mipmap.stopinter));
        }
        holder.horaInicial.setText(dadesInterval.horaInicial());
        holder.horaFinal.setText(dadesInterval.horaFinal());
        holder.duracion.setText(dadesInterval.toString());




    };




    @Override
    public int getItemCount() {
        return intervalos != null ? intervalos.size() : 0;
    }

    public void clear() {
        intervalos.clear();
    }

    public void setItems(ArrayList<DadesInterval> intervalos) {
        this.intervalos = intervalos;
    }
/*
    //Referenciamos el click del item de la lista al del adaptador
    public void setOnTascaClickedListener(OnTascaClickedListener onTascaClickedListener) {
        this.onTascaClickedListener = onTascaClickedListener;
    }*/

    //Items del adaptador de actividades
    public class IntervalViewHolder extends RecyclerView.ViewHolder {


        TextView horaInicial;
        TextView horaFinal;
        ImageButton imagenIntervalo;
        TextView duracion;



        public IntervalViewHolder(View itemView) {
            super(itemView);
            imagenIntervalo = (ImageButton) itemView.findViewById(R.id.intervalState);
            horaInicial = (TextView) itemView.findViewById(R.id.horaInitView);
            horaFinal = (TextView) itemView.findViewById(R.id.horaFinalView);
            duracion = (TextView) itemView.findViewById(R.id.duradaView);

        }
    }

    public interface OnTascaClickedListener {
        void onItemClicked(int pos);
        void onPlayClicked(int pos);
    }
}
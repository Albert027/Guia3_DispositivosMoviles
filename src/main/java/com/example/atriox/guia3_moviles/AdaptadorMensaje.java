package com.example.atriox.guia3_moviles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 30/8/17.
 */

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {

    //TODO constructor con 2 parametros : el contexto y la lista de objetos (Contacto)
    public AdaptadorMensaje(Context context, List<Mensaje> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Mensaje mensaje = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
        TextView lblMensaje = (TextView) convertView.findViewById(R.id.lblMensaje);
        // mostrar los datos
        lblFecha.setText(mensaje.fecha);
        lblMensaje.setText(mensaje.mensaje);
        // Return la convertView ya con los datos
        return convertView;
    }
}
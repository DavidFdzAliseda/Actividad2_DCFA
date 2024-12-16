package com.david.actividad2_dcfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.david.actividad2_dcfa.Model.CharacterModel;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    // Lista que contiene los objetos de tipo CharacterModel que se mostrarán en el RecyclerView
    private List<CharacterModel> characterList;

    // Listener para manejar los clics en los ítems del RecyclerView
    private OnItemClickListener listener;

    // Interfaz para manejar los clics en los ítems del RecyclerView
    public interface OnItemClickListener {
        void onItemClick(CharacterModel characterModel);
    }

    // Constructor del adaptador, recibe la lista de personajes y el listener para manejar los clics
    public CharacterAdapter(List<CharacterModel> characterList, OnItemClickListener listener) {
        this.characterList = characterList;
        this.listener = listener;
    }

    // Método llamado cuando el RecyclerView necesita crear un nuevo ViewHolder
    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla el layout del ítem que será utilizado para cada elemento de la lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view); // Retorna un nuevo CharacterViewHolder con la vista inflada
    }

    // Método llamado para vincular los datos al ViewHolder en una posición específica
    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        // Obtiene el objeto CharacterModel en la posición correspondiente
        CharacterModel character = characterList.get(position);

        // Asigna los valores de los atributos del personaje a las vistas
        holder.nameTextView.setText(character.getName());  // Asigna el nombre del personaje
        holder.imageView.setImageResource(character.getImageId());  // Asigna la imagen del personaje usando su ID de imagen

        // Configura el listener para el clic en el ítem
        holder.itemView.setOnClickListener(v -> listener.onItemClick(character)); // Llama al método onItemClick del listener cuando el ítem es clickeado
    }

    // Retorna el número total de ítems que tiene el RecyclerView
    @Override
    public int getItemCount() {
        return characterList.size(); // Retorna el tamaño de la lista de personajes
    }

    // ViewHolder que contiene las vistas (ImageView y TextView) para cada ítem
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;   // Vista para mostrar la imagen del personaje
        TextView nameTextView; // Vista para mostrar el nombre del personaje

        // Constructor que asocia las vistas del layout con las variables de la clase
        public CharacterViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);  // Asocia el ImageView con su ID del layout
            nameTextView = itemView.findViewById(R.id.textViewName); // Asocia el TextView con su ID del layout
        }
    }
}

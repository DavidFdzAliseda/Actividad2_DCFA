package com.david.actividad2_dcfa.Listener;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.david.actividad2_dcfa.Adapter.CharacterAdapter;
import com.david.actividad2_dcfa.Activity.CharacterDetailActivity;
import com.david.actividad2_dcfa.Model.CharacterModel;
import com.david.actividad2_dcfa.R;

public class CharacterClickListener implements CharacterAdapter.OnItemClickListener {

    private Context context;

    public CharacterClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(CharacterModel characterModel) {
        // Mostrar un Toast con el nombre del personaje seleccionado
        Toast.makeText(context, context.getString(R.string.toast) + characterModel.getName(), Toast.LENGTH_SHORT).show();

        // Iniciar la actividad de detalles
        Intent intent = new Intent(context, CharacterDetailActivity.class);
        intent.putExtra("character", characterModel);
        context.startActivity(intent);
    }
}

package com.david.actividad2_dcfa.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.david.actividad2_dcfa.Model.CharacterModel;
import com.david.actividad2_dcfa.R;

public class CharacterDetailActivity extends AppCompatActivity {

    private ImageView detailImageView;
    private TextView detailNameTextView, detailDescriptionTextView, detailSkillsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        // Inicializar vistas
        detailImageView = findViewById(R.id.detailImageView);
        detailNameTextView = findViewById(R.id.detailNameTextView);
        detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);
        detailSkillsTextView = findViewById(R.id.detailSkillsTextView);

        // Obtener el personaje que fue enviado desde MainActivity
        CharacterModel character = (CharacterModel) getIntent().getSerializableExtra("character");

        // Mostrar los detalles del personaje
        if (character != null) {
            detailImageView.setImageResource(character.getImageId());
            detailNameTextView.setText(character.getName());
            detailDescriptionTextView.setText(character.getDescription());
            detailSkillsTextView.setText(getString(R.string.habilidades) + character.getSkills());
        }

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}


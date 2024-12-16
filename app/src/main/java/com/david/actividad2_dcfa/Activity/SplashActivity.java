package com.david.actividad2_dcfa.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.david.actividad2_dcfa.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Redirigir al RecyclerView después de 2-3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Iniciar la actividad del RecyclerView (Lista de personajes)
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad de Splash para que no vuelva atrás
            }
        }, 3000); // 3000 milisegundos (3 segundos)
    }
}

package com.david.actividad2_dcfa;

import android.content.SharedPreferences;

import android.content.res.Configuration;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.david.actividad2_dcfa.Model.CharacterModel;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private List<CharacterModel> characterList;
    private NavigationView navigationView;
    private Switch languageSwitch;
    private SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // Establecer el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Usar CharacterUtils para obtener la lista de personajes
        characterList = CharacterUtils.getCharacterList(this);

        // Configurar el adaptador
        adapter = new CharacterAdapter(characterList, new CharacterClickListener(this));
        recyclerView.setAdapter(adapter);

        // Mostrar el Snackbar al cargar la lista
        Snackbar.make(findViewById(R.id.recyclerView), getString(R.string.snackbar), Snackbar.LENGTH_LONG).show();

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE);

        // Inicializar el LanguageHelper
        LanguageHelper languageHelper = new LanguageHelper(this);

        // Verificar si el navigationView está presente
        if (navigationView != null) {
            // Obtener el SwitchCompat desde el MenuItem 'nav_switch_language'
            Menu menu = navigationView.getMenu();
            MenuItem languageMenuItem = menu.findItem(R.id.nav_switch_language);
            SwitchCompat languageSwitch = (SwitchCompat) languageMenuItem.getActionView(); // Usamos SwitchCompat

            // Verificar si el SwitchCompat ha sido encontrado
            if (languageSwitch != null) {
                // Configurar el estado inicial del Switch basado en el idioma guardado
                String currentLanguage = sharedPreferences.getString("language", "en");
                languageSwitch.setChecked(currentLanguage.equals("en"));

                // Configurar el listener para cambiar el idioma
                languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    // Al cambiar el idioma, guardar la preferencia y cambiar el idioma
                    String newLanguage = isChecked ? "en" : "es";
                    changeLanguage(newLanguage);
                    // Cambiar el idioma utilizando el LanguageHelper
                    languageHelper.setLocale(newLanguage);
                });
            }
        }
    }

    // Método para cambiar el idioma
    private void changeLanguage(String languageCode) {
        // Cambiar la configuración de idioma
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        // Guardar el idioma seleccionado en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", languageCode);
        editor.apply();

        // Reiniciar la actividad para aplicar el cambio de idioma
        recreate();
    }

    // Método para cambiar el idioma
    public class LanguageHelper {

        private final AppCompatActivity activity;

        public LanguageHelper(AppCompatActivity activity) {
            this.activity = activity;
        }

        // Método para comprobar si el idioma es inglés
        public boolean isEnglish() {
            String language = Locale.getDefault().getLanguage();
            return language.equals("en");
        }

        // Método para establecer el idioma
        public void setLocale(String languageCode) {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            android.content.res.Configuration config = new android.content.res.Configuration();
            config.setLocale(locale);
            activity.getResources().updateConfiguration(config, activity.getResources().getDisplayMetrics());

            // Guardar el idioma seleccionado en SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("language", languageCode);
            editor.apply();

            // Reiniciar la actividad para aplicar el nuevo idioma
            activity.recreate();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            DialogHelper.showAboutDialog(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

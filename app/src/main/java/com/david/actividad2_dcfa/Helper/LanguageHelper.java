package com.david.actividad2_dcfa.Helper;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LanguageHelper {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "app_preferences";
    private static final String LANGUAGE_KEY = "language";

    public LanguageHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Cambia el idioma de la aplicación.
     * @param languageCode El código de idioma (por ejemplo, "en" o "es").
     * @param context El contexto de la aplicación.
     */
    public void setLocale(String languageCode, Context context) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = context.getResources().getConfiguration();
        config.setLocale(locale);
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

        // Guardamos el idioma seleccionado en SharedPreferences
        sharedPreferences.edit().putString(LANGUAGE_KEY, languageCode).apply();
    }

    /**
     * Verifica si el idioma actual es inglés.
     * @return true si el idioma es inglés, false si no lo es.
     */
    public boolean isEnglish() {
        String language = sharedPreferences.getString(LANGUAGE_KEY, "es"); // Por defecto "es"
        return language.equals("en");
    }

    /**
     * Obtiene el idioma actual de la aplicación desde SharedPreferences.
     * @return El código de idioma actual (por ejemplo, "en" o "es").
     */
    public String getCurrentLanguage() {
        return sharedPreferences.getString(LANGUAGE_KEY, "es"); // Devuelve el idioma por defecto "es"
    }
}

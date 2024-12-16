package com.david.actividad2_dcfa.Model;

import java.io.Serializable;

public class CharacterModel implements Serializable {
    // Esta clase representa un modelo de personaje. Implementa Serializable para permitir que los objetos de esta clase sean guardados.

    // Atributos del personaje
    private String name;        // El nombre del personaje (tipo String)
    private int imageId;        // El ID de la imagen asociada al personaje
    private String description; // Descripción del personaje (tipo String)
    private String skills;      // Habilidades del personaje (tipo String)

    // Constructor para inicializar un objeto CharacterModel con los valores proporcionados
    public CharacterModel(String name, int imageId, String description, String skills) {
        this.name = name;               // Asigna el nombre del personaje
        this.imageId = imageId;         // Asigna el ID de la imagen del personaje
        this.description = description; // Asigna la descripción del personaje
        this.skills = skills;           // Asigna las habilidades del personaje
    }

    // Getters y Setters para acceder y modificar los atributos del personaje

    public String getName() {
        return name; // Retorna el nombre del personaje
    }

    public void setName(String name) {
        this.name = name; // Modifica el nombre del personaje
    }

    public int getImageId() {
        return imageId; // Retorna el ID de la imagen del personaje
    }

    public void setImageId(int imageId) {
        this.imageId = imageId; // Modifica el ID de la imagen del personaje
    }

    public String getDescription() {
        return description; // Retorna la descripción del personaje
    }

    public void setDescription(String description) {
        this.description = description; // Modifica la descripción del personaje
    }

    public String getSkills() {
        return skills; // Retorna las habilidades del personaje
    }

    public void setSkills(String skills) {
        this.skills = skills; // Modifica las habilidades del personaje
    }
}

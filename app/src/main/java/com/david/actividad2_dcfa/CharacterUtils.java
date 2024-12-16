package com.david.actividad2_dcfa;

import android.content.Context;

import com.david.actividad2_dcfa.Model.CharacterModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterUtils {

    public static List<CharacterModel> getCharacterList(Context context) {
        List<CharacterModel> characterList = new ArrayList<>();
        characterList.add(new CharacterModel(
                context.getString(R.string.mario_name),
                R.drawable.mario,
                context.getString(R.string.mario_description),
                context.getString(R.string.mario_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.luigi_name),
                R.drawable.luigi,
                context.getString(R.string.luigi_description),
                context.getString(R.string.luigi_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.peach_name),
                R.drawable.peach,
                context.getString(R.string.peach_description),
                context.getString(R.string.peach_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.toad_name),
                R.drawable.toad,
                context.getString(R.string.toad_description),
                context.getString(R.string.toad_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.yoshi_name),
                R.drawable.yoshi,
                context.getString(R.string.yoshi_description),
                context.getString(R.string.yoshi_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.bowser_name),
                R.drawable.bowser,
                context.getString(R.string.bowser_description),
                context.getString(R.string.bowser_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.donkey_kong_name),
                R.drawable.donkey_kong,
                context.getString(R.string.donkey_kong_description),
                context.getString(R.string.donkey_kong_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.wario_name),
                R.drawable.wario,
                context.getString(R.string.wario_description),
                context.getString(R.string.wario_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.waluigi_name),
                R.drawable.waluigi,
                context.getString(R.string.waluigi_description),
                context.getString(R.string.waluigi_skills)
        ));
        characterList.add(new CharacterModel(
                context.getString(R.string.koopa_troopa_name),
                R.drawable.koopa_troopa,
                context.getString(R.string.koopa_troopa_description),
                context.getString(R.string.koopa_troopa_skills)
        ));
        return characterList;
    }
}


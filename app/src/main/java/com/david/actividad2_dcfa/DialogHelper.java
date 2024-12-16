package com.david.actividad2_dcfa;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;

public class DialogHelper {

    public static void showAboutDialog(Context context) {
        new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.acerca))
                .setMessage(context.getString(R.string.acerca_message))
                .setIcon(R.drawable.ic_info)
                .setPositiveButton(context.getString(R.string.ok), null)
                .show();
    }
}

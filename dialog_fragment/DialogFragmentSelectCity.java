package com.studio.okheart.okheartweatherapp.dialog_fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.studio.okheart.okheartweatherapp.MainActivity;
import com.studio.okheart.okheartweatherapp.R;

public class DialogFragmentSelectCity extends DialogFragment {

    public static DialogFragmentSelectCity newInstance(){
        return new DialogFragmentSelectCity();
    }


    @NonNull
    @SuppressLint("NewApi")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_fragment_select_city, null);

        builder.setView(view)
                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText ed = view.findViewById(R.id.et_fragment_dialog);
                        ((MainActivity) getActivity()).addItem(ed.getText().toString());
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }
}

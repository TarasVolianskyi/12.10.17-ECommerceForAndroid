package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tarasvolianskyi on 25.11.17.
 */

public class DialogNumItem extends DialogFragment {
    private TextView tvValue;
    private int count = 1;
    private View.OnClickListener onClickMinus = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (count != 1) {
                count--;
            }
            tvValue.setText("" + count);
        }
    };
    private View.OnClickListener onclickPlus = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            tvValue.setText("" + count);
        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("name");
        builder.setView(createContent());
        builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

    private LinearLayout createContent() {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        Button btnMinus = new Button(getActivity());
        btnMinus.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnMinus.setText("-");
        btnMinus.setOnClickListener(onClickMinus);

        tvValue = new TextView(getActivity());
        tvValue.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvValue.setText("" + count);

        Button btnPlus = new Button(getActivity());
        btnPlus.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnPlus.setText("+");
        btnPlus.setOnClickListener(onclickPlus);

        linearLayout.addView(btnMinus);
        linearLayout.addView(tvValue);
        linearLayout.addView(btnPlus);

        return linearLayout;

    }
}

package org.communiquons.pourcentage;

import android.content.Context;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Pierre HUBERT on 21/07/2016 for the Pourcentage app.
 * Utils functions
 */
public class utils {

    /**
     * Variables declaration
     */
    ScrollView mainView;

    /** Method creation
     *
     * Required to access the TextViews
     */
    public utils(ScrollView getMainView) {
        mainView = getMainView;
    }

    /**
     * Write result on the screen
     *
     * @param number is result to show
     */
    public void writeResultPercent(int number) {
        changeTextViewText(R.id.resultTarget, number + "%");
    }

    /**
     * Show the labels for the activity
     *
     */
    public void showLabels(String mainTitle, String label1, String label2) {
        changeTextViewText(R.id.main_title, mainTitle);
        changeTextViewText(R.id.champ1_label, label1);
        changeTextViewText(R.id.champ2_label, label2);
    }


    /**
     * Convert an CharSequence var to int var
     * Pierre HUBERT 2016
     *
     * @param origin to be converted to an int
     */
    public int StringToInt(String origin) {

        int value;

        //Si aucune valeur n'a été saisie, on choisit 0 par défaut
        if(origin.length() == 0)
             value = 0;
        else
             value = (Integer.decode(origin)*1);

        return value;
    }

    /**
     * Get the value of a TextView
     *
     * @param TextViewId is the id of the TextView
     */
    public String getTextViewText(int TextViewId) {
        TextView textView = (TextView)mainView.findViewById(TextViewId);
        return textView.getText().toString();
    }

    /**
     * Fonction renvoyant une erreur spécifée
     */
    public void showErreur(String erreur) {
        //changeTextViewText(R.id.error_target, erreur);
        makeToast(erreur, mainView.getContext());
    }

    /**
     * Change the value of a TextView
     *
     * @param TextViewId is the id of the TextView
     * @param newText is a string containing the new text.
     */
    public void changeTextViewText(int TextViewId, String newText) {
        TextView textView = (TextView) mainView.findViewById(TextViewId);
        textView.setText(String.format("%s", newText));
    }

    /**
     * Make a Toast
     *
     */
    public void makeToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Change of Activity
     */
   /* public void changeActivity(View view, Class newActivity, Activity activity) {
        Intent intent = new Intent(view.getContext(), newActivity);
        Activity.startActivity(intent);
    }*/

}

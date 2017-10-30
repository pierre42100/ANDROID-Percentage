package org.communiquons.pourcentage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class CalcPercentDifference extends AppCompatActivity {

    utils utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        //Calling the utilities class
        utilities = new utils((ScrollView) findViewById(R.id.main_scrollview));

        //Affichage des labels
        utilities.showLabels(getResources().getString(R.string.calcPercentOfChange), getResources().getString(R.string.firstValue), getResources().getString(R.string.secondValue));

        /**
         * Bouton de retour
         */
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    * Fonction de calcul
    */
    public void performCalcul(View view) {

        //Récupération des valeurs
        String firstValueString = getFirstValue();
        String secondValueString = getSecondValue();

        //Converions nécessaires
        int firstValue = utilities.StringToInt(firstValueString);
        int secondValue = utilities.StringToInt(secondValueString);

        //Vérification de l'échantillon total
        if(firstValue == 0 || secondValue == 0) {
            //Affichage de l'erreur
            utilities.showErreur(getResources().getString(R.string.errorValueMustBeMoreThanZero));

            return;
        }

        //Calcul
        int newPercent = (secondValue*100)/firstValue;

        int result = newPercent-100;

        //Ecriture du résultat
        utilities.writeResultPercent(result);
    }


    /**
     * Récupère la quantité de l'échantillon donnera le pourcentage
     *
     * @return String la valeur en CharSequence
     */
    private String getFirstValue() {
        return utilities.getTextViewText(R.id.champ1_value);
    }


    /**
     * Récupère la quantité total
     *
     * @return la valeur en CharSequence
     */
    private String getSecondValue() {
        return  utilities.getTextViewText(R.id.champ2_value);
    }
}

package org.communiquons.pourcentage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class CalcPercentActivity extends AppCompatActivity {

    utils utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        //Calling the utilities class
        utilities = new utils((ScrollView) findViewById(R.id.main_scrollview));

        //Affichage des labels
        utilities.showLabels(getResources().getString(R.string.calcPercentWithValues),getResources().getString(R.string.valeurEchantillon), getResources().getString(R.string.quantiteTotale));

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

        //Quantité de l'échantillon
        String echantillonCharSequence = getValueEchantillon();

        //Quantité totale
        String totalCharSequence = getTotalValue();

        //Converions nécessaires
        int quantityEchantillon = utilities.StringToInt(echantillonCharSequence);
        int quantityTotale = utilities.StringToInt(totalCharSequence);

        //Vérification de l'échantillon total
        if(quantityTotale == 0) {
            //Affichage de l'erreur
            utilities.showErreur(getResources().getString(R.string.errorValueMustBeMoreThanZero));

            return;
        }

        //Calcul
        int result = (quantityEchantillon*100)/quantityTotale;

        //Ecriture du résultat
        utilities.writeResultPercent(result);
    }


    /**
     * Récupère la quantité de l'échantillon donnera le pourcentage
     *
     * @return la valeur en CharSequence
     */
    private String getValueEchantillon() {
        return utilities.getTextViewText(R.id.champ1_value);
    }


    /**
     * Récupère la quantité total
     *
     * @return la valeur en CharSequence
     */
    private String getTotalValue() {
        return  utilities.getTextViewText(R.id.champ2_value);
    }
}

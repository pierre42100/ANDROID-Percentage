package org.communiquons.pourcentage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class MainActivity extends AppCompatActivity {

    utils utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling the utilities class
       utilities = new utils((ScrollView) findViewById(R.id.main_scrollview));


        /**
         * Calcul simple de pourcentage
         */
        Button calcPercentWithValuesButton = (Button) findViewById(R.id.calcPercentWithValuesButton);
        calcPercentWithValuesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(view.getContext(), CalcPercentActivity.class);
                startActivity(intent);

            }
        });

        /**
         * Percentages de différence entre deux valeurs
         */
        Button calcPercentOfDifferenceButton = (Button) findViewById(R.id.calcPercentOfDifferenceButton);
        calcPercentOfDifferenceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(view.getContext(), CalcPercentDifference.class);
                startActivity(intent);

            }
        });

    }


}

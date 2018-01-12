package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import  android.view.MenuItem;
import android.widget.EditText;
import com.example.joans.timetracker.R;

/**
 * Mostra la llista d'intervals d'alguna tasca. De cada interval mostra les
 * dates inicial i final en format dd-MM-aa hh:mm. Si la tasca està sent
 * cronometrada, veiem com el temps i data final va canviant.
 * <p>
 * Aquesta Activity es torna la activa quan, navegant per l'arbre a
 * {@link LlistaActivitatsActivity}, fem un click normal sobre una tasca. En prémer la
 * tecla o botó 'back', 'pugem' un nivell a l'arbre i tornem a veure la tasca i
 * les seves activitats germanes.
 *
 * @author joans
 * @version 6 febrer 2012
 */
public class ProjectCreator extends AppCompatActivity {

    /**
     * Estableix com a intervals a visualitzar els de la tasca
     * <code>tascaPare</code>. Aquest mètode és invocat just a l'inici del cicle
     * de vida de la Activity.
     *
     * @param savedInstanceState de tipus Bundle, però no el fem servir ja que el pas de
     *                           paràmetres es fa via l'objecte aplicació
     *                           <code>TimeTrackerApplication</code>.
     * @see LlistaActivitatsActivity#onCreate
     */
    @Override
    public final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_action);


    }
    //Funcion que inicializa la barra personalizada


    //Funcion de guardar el proyecto y redireccionamiento al llistActivitats
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acceptButton:

                EditText editTextTaskName = (EditText) findViewById(R.id.nameInput);
                EditText editTextTaskDescription = (EditText) findViewById(R.id.descInput);

                Intent inte = new Intent("afegirProjecte");
                inte.putExtra("projectName", editTextTaskName.getText().toString());
                inte.putExtra("projectDescription", editTextTaskDescription.getText().toString());
                sendBroadcast(inte);

                Intent intent = new Intent(ProjectCreator.this, LlistaActivitatsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.example.wizytauweterynarza;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    EditText imie;

    SeekBar I_lat;

    EditText cel;

    EditText godzina;

    ListView lista;

    TextView Ilemalat,inf;

    final String[] list = {"Pies","Kot","Świnka Morska"};
    int maxS;

    String wybranyE;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imie = findViewById(R.id.imie_nazw);
        I_lat = findViewById(R.id.ilosc_l);
        cel = findViewById(R.id.cel);
        godzina = findViewById(R.id.godzi);
        lista = findViewById(R.id.lista);
        Ilemalat = findViewById(R.id.lata);
        button = findViewById(R.id.przycisk);
        inf = findViewById(R.id.info);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lista.setAdapter(arrayAdapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wybranyE = (String) lista.getItemAtPosition(position);
                if (wybranyE.equals("Pies")){
                    maxS = 18;
                    I_lat.setMax(maxS);
                } else if(wybranyE.equals("Kot")){
                    maxS = 20;
                    I_lat.setMax(maxS);
                } else if(wybranyE.equals("Świnka Morska")){
                    maxS = 9;
                    I_lat.setMax(maxS);
                }
            }
        });

        I_lat.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int lat = I_lat.getProgress();
                Ilemalat.setText("Ile ma lat? " + lat);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        button.setOnClickListener(v -> {
            String tekst = cel.getText().toString();
            int wiek = I_lat.getProgress();
            inf.setText(imie.getText().toString()+", "+wybranyE+", "+ wiek +", "+tekst+", "+godzina.getText().toString());
        });

    }
}
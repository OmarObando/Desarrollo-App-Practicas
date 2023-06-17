package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {
    private EditText editText_initialTemperature;
    private TextView textView_finalTemperature;
    Button button_convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText_initialTemperature = findViewById(R.id.initial_temperature);
        this.textView_finalTemperature = findViewById(R.id.textView_finalTemperature);
        this.button_convert = findViewById(R.id.button_convert);

        button_convert.setOnClickListener(v->this.convertTemperature());
    }

    private void convertTemperature(){
        try{
            this.checkEmptyFields();
            Double initialTemperature = Double.valueOf(this.editText_initialTemperature.getText().toString());
            Double finalTemperature =((initialTemperature - 32)*5)/9;
            this.textView_finalTemperature.setText(finalTemperature.toString());
        }catch(DataFormatException dfException){
            Toast.makeText(this, "Debes ingresar primero la información en el campo :P", Toast.LENGTH_SHORT).show();
        }

    }

    private void checkEmptyFields() throws DataFormatException{
        if(this.editText_initialTemperature.getText().toString().isEmpty()){
            throw new DataFormatException();
        }
    }
}
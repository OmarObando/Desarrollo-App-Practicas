package com.example.imc_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.imc_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(v->{
            try {
                double peso = Double.parseDouble(binding.userWeight.getText().toString());
                double kaltura = Double.parseDouble(binding.userHeight.getText().toString());
                //binding.textResult.setText(String.valueOf(this.calc_imc(peso,kaltura)));
                openResultActivity(peso,kaltura);
            }catch(NumberFormatException nfException){
                Log.e("MainActivity",nfException.toString());
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openResultActivity(double peso, double altura) {
        double imc = calc_imc(peso, altura);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.WEIGHT_KEY,peso);
        intent.putExtra(ResultActivity.HEIGHT_KEY,altura);
        intent.putExtra(ResultActivity.IMC_KEY, imc);
        startActivity(intent);
    }

    private double calc_imc(double peso,double kaltura){
        double kaltura_m = kaltura/100;
        return peso/(kaltura_m*kaltura_m);
    }


}
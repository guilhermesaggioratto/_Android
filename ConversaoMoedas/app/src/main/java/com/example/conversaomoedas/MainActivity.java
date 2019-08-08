package com.example.conversaomoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.editValue = findViewById(R.id.text_real);
        mViewHolder.textDolar = findViewById(R.id.text_dolar);
        mViewHolder.textEuro = findViewById(R.id.text_euro);
        mViewHolder.btnCalcula = findViewById(R.id.btn_calcula);

        this.mViewHolder.btnCalcula.setOnClickListener(this);

        this.LimpaValores();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calcula)
        {
            String value = this.mViewHolder.editValue.getText().toString();

            if(value.isEmpty())
            {
                Toast.makeText(this, "Digite um valor válido em Reais", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //Assume cotação dolar 3 reais e euro 4 reais
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f",real/3));
                this.mViewHolder.textEuro.setText(String.format("%.2f",real/4));
            }
        }
    }

    private static class ViewHolder
    {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button btnCalcula;
    }

    private void LimpaValores()
    {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }
}

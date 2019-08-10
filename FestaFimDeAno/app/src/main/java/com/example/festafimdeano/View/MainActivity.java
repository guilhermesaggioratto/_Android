package com.example.festafimdeano.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.R;
import com.example.festafimdeano.contants.FimDeAnoConstants;
import com.example.festafimdeano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mviewholder = new ViewHolder();
    private static SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        mviewholder.text_days_left = findViewById(R.id.text_days);
        mviewholder.text_today = findViewById(R.id.text_today);
        mviewholder.btn_confirma = findViewById(R.id.btn_confirma);

        mviewholder.btn_confirma.setOnClickListener(this);

        mviewholder.text_today.setText(date_format.format(Calendar.getInstance().getTime()));
        mviewholder.text_days_left.setText(String.format("%s %s", String.valueOf(EndYearDaysLeft()), "dias"));

        this.verificaPresenca();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_confirma)
        {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        }
    }

    private void verificaPresenca()
    {
        String presence = mSecurityPreferences.GetStoredString(FimDeAnoConstants.CONFIRMATION_KEY);
        if(presence.equals(""))
        {
            this.mviewholder.btn_confirma.setText("Não Confirmado");
        }
        else if(presence.equals(FimDeAnoConstants.CONFIRMATION_YES))
        {
            this.mviewholder.btn_confirma.setText("Sim");
        }
        else if(presence.equals(FimDeAnoConstants.CONFIRMATION_NO))
        {
            this.mviewholder.btn_confirma.setText("Não");
        }
    }

    private int EndYearDaysLeft()
    {
        Calendar calendartoday = Calendar.getInstance();
        int today = calendartoday.get(Calendar.DAY_OF_YEAR);

        int lastday = calendartoday.getActualMaximum(Calendar.DAY_OF_YEAR);

        return lastday - today;
    }

    private static class ViewHolder
    {
        TextView text_days_left;
        TextView text_today;
        Button btn_confirma;
    }


}

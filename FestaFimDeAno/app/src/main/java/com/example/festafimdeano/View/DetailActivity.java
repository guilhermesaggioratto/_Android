package com.example.festafimdeano.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.R;
import com.example.festafimdeano.contants.FimDeAnoConstants;
import com.example.festafimdeano.data.SecurityPreferences;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.check_participate = findViewById(R.id.check_participate);
        this.mViewHolder.check_participate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.check_participate)
        {
            if(mViewHolder.check_participate.isChecked())
            {
                this.mSecurityPreferences.storeString(FimDeAnoConstants.CONFIRMATION_KEY, FimDeAnoConstants.CONFIRMATION_YES);
            }
            else
            {
                this.mSecurityPreferences.storeString(FimDeAnoConstants.CONFIRMATION_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder
    {
        CheckBox check_participate;
    }


}


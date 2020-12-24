package com.example.wattpadclone.Write;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wattpadclone.R;

public class RadioButtonCategoryActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    int selectedId;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_category);
        Toolbar toolbar = findViewById(R.id.toolbar_write_radio);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.menu_write_edit_layout);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()== R.id.toolbar_check)
                {
                    onBackPressed();
                }
                return false;
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radio_cate_group);
        radioGroup.check(R.id.checked);

    }


    @Override
    public void onBackPressed() {
        selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);
        result = radioButton.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("radio", result);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
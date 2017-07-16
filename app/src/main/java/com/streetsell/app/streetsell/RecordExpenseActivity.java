package com.streetsell.app.streetsell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by zoehenry on 7/15/17.
 */

public class RecordExpenseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_expense);

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), RecordExpenseActivity.class);
                EditText purchaseInputView = (EditText) findViewById(R.id.editText3);
                String purchaseInputText = (String) purchaseInputView.getText().toString();
                EditText costInputView = (EditText) findViewById(R.id.editText4);
                String costInputText = (String) costInputView.getText().toString();
                i.putExtra("purchase", purchaseInputText);
                i.putExtra("cost", costInputText);
                setResult(RESULT_OK, i);

                CharSequence text = "Your expenses have been saved!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getBaseContext(), text, duration);
                toast.setGravity(Gravity.TOP, 0, 450);
                toast.show();

                finish();
            }
        });
    }
}

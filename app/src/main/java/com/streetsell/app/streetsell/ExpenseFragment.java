package com.streetsell.app.streetsell;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zoehenry on 7/15/17.
 */

public class ExpenseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View expenseView = inflater.inflate(R.layout.activity_expense, container, false);
        Button save = (Button)expenseView.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
        Context context = getActivity();

            @Override
            public void onClick(View view) {
                CharSequence text = "Your expenses have been saved!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, 0, 450);
                toast.show();
            }
        });
        return expenseView;
    }

}

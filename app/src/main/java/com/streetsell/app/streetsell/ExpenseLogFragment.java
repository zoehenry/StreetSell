package com.streetsell.app.streetsell;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zoehenry on 7/15/17.
 */

public class ExpenseLogFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View expenseLogView = inflater.inflate(R.layout.fragment_expense_log, container, false);
        final View expenseView = inflater.inflate(R.layout.fragment_expense, container, false);
        Button button = (Button)expenseLogView.findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            Context context = getActivity();

            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.expenseFragment, new TestFragment(), "fragment_screen");
                ft.commit();
                return expenseView;
            }
        });
    }
}

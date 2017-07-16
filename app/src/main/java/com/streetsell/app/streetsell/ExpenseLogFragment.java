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
    private OnRecordExpenseListener mListener;

    public interface OnRecordExpenseListener{
        public void onRecordExpense(View view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View expenseLogView = inflater.inflate(R.layout.fragment_expense_log, container, false);

        Button button = (Button) expenseLogView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRecordExpense(view);
            }
        });
        return expenseLogView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnRecordExpenseListener)getActivity();
    }
}

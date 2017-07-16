package com.streetsell.app.streetsell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by emontano on 7/15/17.
 */

    public class TransactionMaker extends Fragment {

    private OnTransactionMakerListener mListener;

    public interface OnTransactionMakerListener{
        public void changeText(View view);
        public void submitTransaction(View view);
    }
        private static final String ARG_NAME = "arg name";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            System.out.println("stasrted on create view for transaction mkaer");
            View view = inflater.inflate(R.layout.transaction_maker, container, false);
            Bundle args = getArguments();
            return view;
        }

        public static TransactionMaker newInstance() {
            Bundle args = new Bundle();
            com.streetsell.app.streetsell.TransactionMaker fragment = new TransactionMaker();
            return fragment;
        }

    }


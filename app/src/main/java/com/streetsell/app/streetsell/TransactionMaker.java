package com.streetsell.app.streetsell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by emontano on 7/15/17.
 */

    public class TransactionMaker extends Fragment {
        private static final String ARG_NAME = "arg name";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_test, container, false);
            Bundle args = getArguments();
            TextView nameView = view.findViewById(R.id.name);
            nameView.setText(args.getString(ARG_NAME));
            return view;
        }


        public static TransactionMaker newInstance() {
            Bundle args = new Bundle();
            com.streetsell.app.streetsell.TransactionMaker fragment = new TransactionMaker();
            return fragment;
        }

    }


package com.streetsell.app.streetsell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;
import java.util.Vector;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity
        implements ExpenseLogFragment.OnRecordExpenseListener,
        SalesTracker.OnFragmentInteractionListener,
        SalesTracker.OnSalesTrackerListener,
        TransactionMaker.OnTransactionMakerListener {

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inititializePaging();
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */

    private void inititializePaging() {
        List<Fragment> fragments = new Vector<>();
        fragments.add(TransactionMaker.newInstance());
        fragments.add(new SalesTracker());
        fragments.add(new ExpenseLogFragment());
        this.mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(this.mPagerAdapter);
    }

    @Override
    public void onRecordExpense(View view) {
        Intent i = new Intent(this, RecordExpenseActivity.class);
        startActivityForResult(i, 20);
    }

    @Override
    public void changeText(View view) {
        Integer viewId = view.getId();
        System.out.println("IT WORKED 8:46");
        System.out.println(view);
        TextView textView = null;
        Integer dif = 0;
        switch (viewId) {
            case R.id.imageButton:
                textView = (TextView) findViewById(R.id.editText6);
                dif = 1;
                break;
            case R.id.imageButton2:
                textView = (TextView) findViewById(R.id.editText6);
                dif = -1;
                break;
            case R.id.imageButton5:
                textView = (TextView) findViewById(R.id.textView8);
                dif = 1;
                break;
            case R.id.imageButton6:
                textView = (TextView) findViewById(R.id.textView8);
                dif = -1;
                break;

        }

        System.out.println(textView);
        Integer quantity = Integer.parseInt(textView.getText().toString());
        quantity += dif;
        if (quantity < 0) {quantity = 0;};
        textView.setText(quantity.toString());
        System.out.println("Changed quantity to " + quantity);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 20) {
            String item = data.getExtras().getString("purchase");
            String text = item;
            String cost = data.getExtras().getString("cost");
            String number = "$" + cost;
            TextView whatCost = (TextView) findViewById(R.id.textView79);
            whatCost.setText(number);
            TextView whatFood = (TextView) findViewById(R.id.textView81);
            whatFood.setText(text);
            TextView date = (TextView) findViewById(R.id.textView82);
            date.setText("07/16/17");
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getBaseContext(), text, duration);
            toast.setGravity(Gravity.TOP, 0, 450);
            toast.show();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    GraphView graph;

    public  void lastWeek(View v){
        if( graph != null )
            graph.removeAllSeries();
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
        });
        graph.addSeries(series);
    }

    public  void lastMonth(View v){
        if( graph != null )
            graph.removeAllSeries();
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(3, 2),
                new DataPoint(1, 3),
                new DataPoint(3, 1),
                new DataPoint(4, 2),
        });
        graph.addSeries(series);
    }

    public  void last3Months(View v){
        if( graph != null )
            graph.removeAllSeries();
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(3, 2),
                new DataPoint(1, 3),
                new DataPoint(3, 1),
                new DataPoint(4, 2),
                new DataPoint(4, 2),
                new DataPoint(4, 2),
                new DataPoint(5, 16),
                new DataPoint(4, 2),
                new DataPoint(4, 2),

        });
        graph.addSeries(series);
    }



}

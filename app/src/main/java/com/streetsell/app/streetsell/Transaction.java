package com.streetsell.app.streetsell;

import android.graphics.Point;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by emontano on 7/16/17.
 */

class Transaction {
    private Vector<ArrayList<Point>> transactions;
    private Integer dayNum;
    private Integer counter;

    Transaction(int intitialDay) {
        counter = 0;
        transactions = new Vector<ArrayList<Point>>();
        dayNum = intitialDay;
        transactions.add(new ArrayList<Point>());
        System.out.println("Transaction created!!!!!" + transactions.size());
    }

    // data is (time(hours since start), amount)
    public void addTransaction(Point data) {
        counter++;
        System.out.println("ADDING A TRANSACTION FOR TIME " + data.x + " \n\n\n " + data.y);
        System.out.println("DIF BETWEEN DAYNUM AND DAY IS " + (data.x/24-dayNum));
        System.out.println("COUNTER IS CURRENTLY " + counter);
        Integer currentDay = (Integer) ((int)data.x/24);
        if (currentDay > dayNum) {
            transactions.add(new ArrayList<Point>());
            //fillInDays(currentDay);
            dayNum = currentDay;
        }
        transactions.lastElement().add(new Point(data));
    }

    private void fillInDays(int currentDay) {
        int numFillIn = currentDay - dayNum;
        for (int i = 0; i < numFillIn; i++) {
            transactions.add(new ArrayList<Point>());
            //transactions.lastElement().add(new Point(1 +i,5 + i*2));
            System.out.println("ADDING A NEW ARRAY OBJECT " + transactions.size() + " is current size");
        }
    }

    public ArrayList<Point> getDailyList(ArrayList<ArrayList<Point>> list) {
        ArrayList<Point> finalList = new ArrayList<Point>();
        for(int i = 0; i < list.size(); i++) {
            int daytotal = 0;
            for(int j = 0; j < list.get(i).size(); j++) {
                daytotal += list.get(i).get(j).y;
            }
            //finalList.add();

        }
        return finalList;
    }

    private DataPoint[] getArrayFromList(ArrayList<DataPoint> list) {
        DataPoint[] points = new DataPoint[list.size()];
        for(int i = 0; i < list.size(); i++) {
            points[i] = list.get(i);
        }
        return points;
    }

    private DataPoint[] getData(int numDays) {
        int startIdx = 0;
        int endIdx = transactions.size();
        System.out.println("TRANSACTIONS LIST SIZE IS THIS!!!!!!! : " + transactions.size());
        if (endIdx > 6) {startIdx = endIdx - numDays;}
        ArrayList<DataPoint> finalList = new ArrayList<DataPoint>();
        //finalList.add(new DataPoint(1,1));
        List<ArrayList<Point>> list = transactions.subList(startIdx, endIdx);
        for(int i = 0; i < list.size(); i++) {
            int daytotal = 0;
            for(int j = 0; j < list.get(i).size(); j++) {
                daytotal += list.get(i).get(j).y;
            }
            if(list.get(i).size() > 0) {
                finalList.add(new DataPoint(list.get(i).get(0).x/24.0, daytotal));
            }

        }
        System.out.println("FINAL LIST SIZE IS!!!!!!!!!!!         !!! ! !" + finalList.size());
        return getArrayFromList(finalList);
    }

    public DataPoint[] getWeekData() {
        ArrayList<DataPoint> datalist = null;
        return getData(8);
        //for(int i = 0; i < dayTransactions.size(); i++) {
    }

    public DataPoint[] getOneMonthData() {
        ArrayList<DataPoint> datalist = null;
        return getData(30);
        //for(int i = 0; i < dayTransactions.size(); i++) {
    }

    public DataPoint[] getThreeMonthData() {
        ArrayList<DataPoint> datalist = null;
        return getData(30*3);
    }

    private ArrayList<ArrayList<Point>> getOneMonth() {
        int startIdx = 0;
        int endIdx = transactions.size() - 1;
        if (endIdx > 24) {startIdx = endIdx - 24;}
        return (ArrayList<ArrayList<Point>>) transactions.subList(startIdx, endIdx);

    }

    private ArrayList<ArrayList<Point>> getThreeMonth() {
        int startIdx = 0;
        int endIdx = transactions.size() - 1;
        if (endIdx > 72) {startIdx = endIdx - 72;}
        return (ArrayList<ArrayList<Point>>) transactions.subList(startIdx, endIdx);

    }
}

package com.example.grocerystore.HelperClasses;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import java.util.List;

public class Charts {
//TODO
//make charts take entries to set the data

    private ArrayList<String> departments;

    public Charts(PieChart pieChart) {

        departments = new ArrayList<>();


        departments.add("Registers");
        departments.add("Produce");
        departments.add("Dry Goods");
        departments.add("Frozen");
        departments.add("Dairy");
    }


    public static PieChart pieChart(PieChart pieChart1, ArrayList<String> labels, ArrayList<Integer> colors) {

        pieChart1.setUsePercentValues(true);
        pieChart1.getDescription().setEnabled(false);
        pieChart1.setExtraOffsets(0, 0, 0, 0);
        pieChart1.setDragDecelerationFrictionCoef(0.95f);
        pieChart1.setDrawHoleEnabled(false);
        // pieChart1.setHoleColor(Color.WHITE);
        // pieChart1.setTransparentCircleRadius(61f);


        ArrayList<PieEntry> values = new ArrayList<>();

//TODO take values from excel once balances
        for (String temp : labels) {
            values.add(new PieEntry(60f, temp));

        }


        PieDataSet dataset = new PieDataSet(values, "");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);

        dataset.setColors(colors);
        dataset.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);


        PieData data = new PieData(dataset);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(12f);


        pieChart1.getLegend().setEnabled(false);
        //pieChart1.getLegend().setWordWrapEnabled(true);
        //pieChart1.getDescription().setText("Description of my chart");
        //pieChart1.getDescription().setEnabled(true);
        pieChart1.setData(data);
        pieChart1.setDrawSliceText(false);

        pieChart1.spin(1400, 0, -90f, Easing.EaseInOutQuad);

        return pieChart1;

    }


    public static LineChart lineChart(LineChart lineChart) {
        ArrayList<String> foods;
        foods = new ArrayList<>();
        foods.add("Apples");
        foods.add("Bananas");
        foods.add("Cereal");
        foods.add("Cookies");
        foods.add("Pizza");
        foods.add("Dessert");
        foods.add("Milk");
        foods.add("Eggs");

        List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(0f, 34f));
        entries1.add(new Entry(1f, 75f));
        entries1.add(new Entry(2f, 80f));
        entries1.add(new Entry(3f, 22f));
        entries1.add(new Entry(4f, 90f));
        entries1.add(new Entry(5f, 22f));


        LineDataSet dataset1 = new LineDataSet(entries1, "Test Set");
        dataset1.setAxisDependency(YAxis.AxisDependency.LEFT);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // final String[] testData = new String[]{"Milk", "Eggs", "Test3", "Test4", "Test5", "Test6"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(foods);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);


//data from food types


        List<ILineDataSet> datasets = new ArrayList<ILineDataSet>();
        datasets.add(dataset1);

        LineData data = new LineData(datasets);
        lineChart.setData(data);
        lineChart.invalidate();
        //lineChart.animateXY(22,22);

        return lineChart;

    }

    public static BarChart barChart(BarChart barChart, ArrayList<String> titles, ArrayList<Integer> color, ArrayList<BarEntry> entries) {


        BarDataSet barDataSet = new BarDataSet(entries, "");
        //BarDataSet barDataSet2 = new BarDataSet(getData(), "Data2");
        //BarDataSet barDataSet3 = new BarDataSet(getData(), "Data3");

        barDataSet.setColors(color);
        // barDataSet2.setColor(Color.RED);
        // barDataSet3.setColor(Color.YELLOW);


        barDataSet.setBarBorderWidth(0.1f);
        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setStackLabels(new String[]{
                "FOH", "BOH", "Transit"
        });

        BarData barData = new BarData(barDataSet);//, barDataSet2, barDataSet3);
        barData.setBarWidth(.5f);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //final String[] testData = new String[]{"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(titles);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.getLegend().setEnabled(true);
        //barChart.groupBars(0,0.3f,.02f);
        //barChart.animateXY(5000, 5000);
        barChart.invalidate();


        return barChart;
    }


    public static HorizontalBarChart barChartH(HorizontalBarChart barChart, ArrayList<String> shifts, ArrayList<Integer> color, ArrayList<BarEntry> entries) {


        BarDataSet barDataSet = new BarDataSet(entries, "Data1");
        //BarDataSet barDataSet2 = new BarDataSet(getData(), "Data2");
        //BarDataSet barDataSet3 = new BarDataSet(getData(), "Data3");

        barDataSet.setColors(color);
        // barDataSet2.setColor(Color.RED);
        // barDataSet3.setColor(Color.YELLOW);


        barDataSet.setBarBorderWidth(0.1f);
        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);//, barDataSet2, barDataSet3);
        barData.setBarWidth(.5f);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //final String[] testData = new String[]{"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(shifts);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.getLegend().setEnabled(true);
        //barChart.groupBars(0,0.3f,.02f);
        //barChart.animateXY(5000, 5000);
        barChart.invalidate();


        return barChart;
    }


    private static ArrayList getData() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 70f));
        entries.add(new BarEntry(5f, 60f));
        return entries;
    }
}

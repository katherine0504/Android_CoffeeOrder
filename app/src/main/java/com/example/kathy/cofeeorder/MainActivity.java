package com.example.kathy.cofeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int numberOfCoffee = 2;
    public int price = 5;

    public void submitOrder(View view) {
        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whipped);
        boolean hasWhippedCream = whippedCheckBox.isChecked();
        String priceMessage = createOrderSummary(numberOfCoffee*price, hasWhippedCream);
        displayMessage(priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void displayIncrement(View view) {
        numberOfCoffee ++;
        display(numberOfCoffee);
    }

    public void displayDecrement(View view) {
        numberOfCoffee --;
        if ( numberOfCoffee <0 )
            numberOfCoffee = 0;
        display(numberOfCoffee);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary (int price, boolean addWhippedCream) {
        String priceMessage = "Name : Kathy";
        priceMessage += "\nAdd whipped Cream : " + addWhippedCream;
        priceMessage += "\nQuantity : " + numberOfCoffee;
        priceMessage += "\nTotal : $" + price;
        priceMessage += "\nThank You!!";

        return priceMessage;
    }


}

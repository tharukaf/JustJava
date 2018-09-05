package com.tj.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int orderQuantity = 0;
    double coffeePrice = 3.00;
    double whippedCreamPrice;
    double chocolatePrice;

    public void submitOrder(View view){
        addChocolate(view);
        addWhippedCream(view);
        double finalPrice = (orderQuantity*coffeePrice) + whippedCreamPrice +chocolatePrice;
        setOrderSummary(finalPrice);
    }


    public void addQuantity(View view){
        orderQuantity +=1;
        setOrderQuantity(orderQuantity);
    }
    public void removeQuantity(View view){
        if(orderQuantity>=1) {
            orderQuantity -= 1;
            setOrderQuantity(orderQuantity);
        }
    }

    public boolean addWhippedCream(View view){
        CheckBox whippedCreamView = (CheckBox) findViewById(R.id.whippedCreamBox);
        boolean whippedCreamVar = whippedCreamView.isChecked();
        if(whippedCreamVar==true){
            whippedCreamPrice = orderQuantity * 0.25;
        }
        else if(whippedCreamVar==false){
            whippedCreamPrice = 0;
        }
        return whippedCreamVar;
    }

    public boolean addChocolate(View view){
        CheckBox chocolateView = (CheckBox) findViewById(R.id.chocolateBox);
        boolean chocolateVar = chocolateView.isChecked();
        if(chocolateVar==true){
            chocolatePrice = orderQuantity * 0.5;
        }
        else if(chocolateVar==false){
            chocolatePrice=0;
        }
        return chocolateVar;
    }


    public void setOrderSummary(double a){
        EditText customerName = (EditText) findViewById(R.id.nameText);
        String name = customerName.getText().toString();
        String output = name.substring(0, 1).toUpperCase() + name.substring(1);

        TextView orderSummaryText = (TextView) findViewById(R.id.orderSummaryText);
        orderSummaryText.setText(
                "Thank you for ordering " + output + "\n" +
                "Order Total: $" +a + "\n" + "Have a Nice Day" +
                "\n"
        );

    }


    public void setOrderQuantity(int currentOrderQuantity){
        TextView quantityText = (TextView) findViewById(R.id.orderNumberText);
        quantityText.setText("" +currentOrderQuantity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}

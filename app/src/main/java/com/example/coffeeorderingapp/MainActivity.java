package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void order(View view){
        displayPrice();
    }
    public void increment(View view){
        number+=1;
        displayQuantity();;
    }
    public void decrement(View view){
        if(number>0)
            number-=1;
        displayQuantity();;
    }
    public void displayQuantity(){
        TextView quantity=(TextView)findViewById(R.id.quantityTextView);
        quantity.setText(String.valueOf(number));
    }
    public void displayPrice(){
        TextView price=(TextView)findViewById(R.id.priceTextView);
        price.setText(String.valueOf(number*5));
    }
}
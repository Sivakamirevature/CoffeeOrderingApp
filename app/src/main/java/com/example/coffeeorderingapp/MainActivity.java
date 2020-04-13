package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int topping1_price=10, topping2_price = 15, topping_price = 0, number=0, billAmount=0;
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
        topping_price *= number;
        billAmount = topping_price + number*5;
        price.setText(String.valueOf(billAmount));
        sendMail();
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.toping1:
                if (checked) {
                    topping_price += topping1_price;
                }
            else{
                    topping_price -= topping1_price;
                }
                break;
            case R.id.topping2:
                if (checked){
                    topping_price += topping2_price;
                }
            else{
                    topping_price -= topping2_price;
                }
                break;
        }
    }

    public void sendMail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Ordering Details");
        intent.putExtra(Intent.EXTRA_TEXT, "Rs. " + String.valueOf(billAmount));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Toast mail_send_successfully = Toast.makeText(this, "Mail Send Successfully", 1000);
    }
}
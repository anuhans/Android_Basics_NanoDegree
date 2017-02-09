package com.example.rishabhgoyal.coffeecounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.name;

public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    int base_price=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if(quantity>=100) {
            Toast.makeText(this,"You can't have more than 100 cups", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity==1) {
            Toast.makeText(this,"You can't have leass than 1 cup of coffee",Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity - 1;
        display(quantity);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whipped_cream=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasCream=whipped_cream.isChecked();
        CheckBox chocolate=(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolate1=chocolate.isChecked();
        EditText name_field=(EditText) findViewById(R.id.name_field);
        String name=name_field.getText().toString();
        int price=calculatePrice(hasCream,chocolate1);
        String priceMessage=createOrderSummary(price,hasCream,name,chocolate1);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for" + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(priceMessage);
    }
    private int calculatePrice(boolean addcream,boolean chocolate) {
        int base_price=5;
        if(addcream)
        {
            base_price=base_price+1;
        }
        if(chocolate)
        {
            base_price=base_price+2;
        }
        int price = quantity *base_price;
        return price;
    }

    /**Order Summary*/
    private String createOrderSummary(int price,boolean addcream,String name,boolean chocolate1)
    {
        String priceMessage=name;
        priceMessage=priceMessage+"\nQuantity :"+ quantity;
        priceMessage=priceMessage+"\nHas Whipped Cream ? :" +addcream;
        priceMessage=priceMessage+"\nHas Chocolate ? " + chocolate1;
        priceMessage=priceMessage+"\nPrice :$" + price;
        priceMessage=priceMessage+ "\nThank You!";
        return priceMessage;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen.
     */


}
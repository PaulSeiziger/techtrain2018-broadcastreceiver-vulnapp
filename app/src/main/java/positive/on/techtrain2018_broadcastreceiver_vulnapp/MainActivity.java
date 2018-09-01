package positive.on.techtrain2018_broadcastreceiver_vulnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button makeTransaction = (Button) findViewById(R.id.button);
        makeTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView to = (TextView) findViewById(R.id.transaction_to);
                TextView amount = (TextView) findViewById(R.id.transaction_amount);
                TextView delay = (TextView) findViewById(R.id.transaction_delay);

                final Intent notificationIntent = new Intent();
                notificationIntent.setAction("positive.on.techtrain2018.TRANSACTION_FINISHED");
                notificationIntent.putExtra("to", to.getText().toString());
                notificationIntent.putExtra("amount", amount.getText().toString());

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                sendBroadcast(notificationIntent);
                                Log.d("VulnApp","Transaction has been sent");
                            }
                        },
                        Integer.parseInt(delay.getText().toString(),10));

            }
        });
    }
}

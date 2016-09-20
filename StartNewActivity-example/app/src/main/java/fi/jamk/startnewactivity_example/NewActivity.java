package fi.jamk.startnewactivity_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // textview in layout
        TextView textView = (TextView) findViewById(R.id.textView2);

        // intent and data (line of string)
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String line = extras.getString("text"); // line
             textView.setText(line);
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("result",20); // -> 20 -> MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }
}

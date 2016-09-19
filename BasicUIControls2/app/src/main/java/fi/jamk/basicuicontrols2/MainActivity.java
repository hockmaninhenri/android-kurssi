package fi.jamk.basicuicontrols2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView)
                findViewById(R.id.login); // add stings to control
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]
                        {"Pasi","Juha","Kari","Jouni","Esa","Hannu"});
        actv.setAdapter(aa);
    }

    public void showLoginInfo(View view) {
        // find login
        EditText editText = (EditText) findViewById(R.id.login);
        String login = editText.getText().toString();

        // find passwd
        EditText editPass = (EditText) findViewById(R.id.passWord);
        String passwd = editPass.getText().toString();

        // toast message to screen
        Toast.makeText(getApplicationContext(), login +" "+ passwd,
                Toast.LENGTH_LONG).show();
    }
}

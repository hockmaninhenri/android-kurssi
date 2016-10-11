package fi.jamk.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button asyncTaskButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTaskButton = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void asynctaskButtonClicked(View view){
        // Start a new thread with AsyncTask
        new MyTask().execute();
    }

    // Our own class is extending AsyncTask
    private class MyTask extends AsyncTask<Void,Integer,Void>{

        // 1.
        @Override
        protected void onPreExecute(){
            asyncTaskButton.setEnabled(false);
        }

        // 2.
        @Override
        protected Void doInBackground(Void... params) {
            // do your heavy things here
            for(int i=1;i<=100;i++) {
                publishProgress(i); // -> onProgressUpdate method
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.d("APPNAME", "Exception");
                }
            }
            return null;
        }

        // 3.
        protected void onProgressUpdate(Integer... params){
            progressBar.setProgress(params[0]);
        }

        // 4.
        protected void onPostExecute (Void params){
            asyncTaskButton.setEnabled(true);
        }
    }

}

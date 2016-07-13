package at.telvla.browserkids;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends Activity {
    private static final String TAG = "MyApp";
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/index.html");


       new ParserTask().execute();

      /*  URL = "http://www.plastekcosmetic.ru/novosti/pojmaj-nastroenie.html";
        try {

            DOC  = Jsoup.connect("http://www.plastekcosmetic.ru/novosti/pojmaj-nastroenie.html").get();
            Elements mainHeaderElements = DOC.select("h1");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Результат " + mainHeaderElements, Toast.LENGTH_SHORT);
            toast.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    class ParserTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... params) {
            Document doc = null;
            String URL = "http://www.plastekcosmetic.ru/novosti/pojmaj-nastroenie.html";

            try {
                 doc  = Jsoup.connect(URL).get();
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG, "Это мое сообщение для записи в журнале");

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

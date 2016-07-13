package at.telvla.browserkids;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test extends Activity {
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        String html = "<html>\n" +
                "<head>\n" +
                "<title>test doc</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<img src=\"img_test.png\" width=\"800\"/>\n" +
                "\t<h2>work</h2>\n" +
                "\t<div class=\"news\">work2</div>\n" +
                "</body>\n" +
                "</html>";
        Document doc = Jsoup.parse(html);

        Elements H_Elements = doc.select("h2");
        //doc.html()
        String title = doc.title();
        Elements links = doc.getElementsByTag("a");


        Toast toast = Toast.makeText(getApplicationContext(),
                "Результат " + title, Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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

package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ActivityInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://drive.google.com/drive/folders/11fU9d26Rnv2AuNw5BY7MpJ2UYyqO_BFT?usp=sharing");

    }
}
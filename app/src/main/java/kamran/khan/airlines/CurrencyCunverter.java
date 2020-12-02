package kamran.khan.airlines;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyCunverter extends AppCompatActivity {
    private WebView myWebView;
    public ProgressBar progressStyle3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emirates);
        myWebView=findViewById(R.id.Emirates);
        WebSettings webSettings=myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www1.oanda.com/currency/converter/");
        progressStyle3=findViewById(R.id.progressBar1);
        myWebView.setWebViewClient(new WebViewClient()
                                   {
                                       public void onPageStarted(WebView view, String url, Bitmap favicon)
                                       {
                                           super.onPageStarted(view, url, favicon);
                                           progressStyle3.setVisibility(View.VISIBLE);
                                           setTitle("Loading...");
                                       }

                                       @Override
                                       public void onPageFinished(WebView view, String url) {
                                           super.onPageFinished(view, url);
                                           progressStyle3.setVisibility(View.GONE);
                                           setTitle(view.getTitle());
                                       }
                                   }
        );
    }
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

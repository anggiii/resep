package android.example.resep;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        datamodel dataModel= (datamodel) bundle.getSerializable("dataModel");
        setTitle(dataModel.getJudul());

        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/"+dataModel.getKonten());
    }
}

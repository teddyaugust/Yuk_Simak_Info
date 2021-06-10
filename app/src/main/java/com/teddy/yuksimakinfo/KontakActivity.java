package com.teddy.yuksimakinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class  KontakActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        //buka webnya
        webView = findViewById(R.id.kontak_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://yuk-simak.info/kontak/");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.supportZoom();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if(url.startsWith("tel:") || url.startsWith("whatsapp:") || url.startsWith("tg:") || url.startsWith("facebook:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        //assign variabelnya
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer (drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close Drawer Layout
        //Check Condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //Jika drawernya masih terbuka
            //maka tutup Drawer-nya
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Redirect activity ke Beranda
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickKesehatan (View view){
        //Redirect activity ke Artikel Kesehatan
        MainActivity.redirectActivity(this,KesehatanActivity.class);
    }

    public void ClickKulit (View view){
        //Redirect activity ke Artikel Perawatan Kulit
        MainActivity.redirectActivity(this,KulitActivity.class);
    }

    public void ClickMotivasi (View view){
        //Redirect activity ke Artikel Motivasi
        MainActivity.redirectActivity(this,MotivasiActivity.class);
    }

    public void ClickBisnis (View view){
        //Redirect activity ke Artikel Bisnis
        MainActivity.redirectActivity(this,BisnisActivity.class);
    }

    public void ClickBerita (View view){
        //Redirect activity ke Artikel Berita
        MainActivity.redirectActivity(this,BeritaActivity.class);
    }

    public void ClickYSI (View view){
        //Redirect activity ke Tentang Yuk Simak Info
        MainActivity.redirectActivity(this,YSIActivity.class);
    }

    public void ClickKontak (View view){
        //Recreate activity
        recreate();
    }

    public void ClickAplikasi (View view){
        //Redirect activity ke Tentang Aplikasi
        MainActivity.redirectActivity(this,AplikasiActivity.class);
    }
    public void ClickLogout (View view){
        //Menutup Aplikasi
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        closeDrawer(drawerLayout);
    }

}
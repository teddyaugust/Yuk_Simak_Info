package com.teddy.yuksimakinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class  MainActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buka webnya
        webView = findViewById(R.id.beranda_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://yuk-simak.info/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

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
        //Recreate activity
        recreate();
    }

    public void ClickKesehatan (View view){
        //Redirect activity ke Artikel Kesehatan
        redirectActivity(this,KesehatanActivity.class);
    }

    public void ClickKulit (View view){
        //Redirect activity ke Artikel Perawatan Kulit
        redirectActivity(this,KulitActivity.class);
    }

    public void ClickMotivasi (View view){
        //Redirect activity ke Artikel Motivasi
        redirectActivity(this,MotivasiActivity.class);
    }

    public void ClickBisnis (View view){
        //Redirect activity ke Artikel Bisnis
        redirectActivity(this,BisnisActivity.class);
    }

    public void ClickBerita (View view){
        //Redirect activity ke Artikel Berita
        redirectActivity(this,BeritaActivity.class);
    }

    public void ClickYSI (View view){
        //Redirect activity ke Tentang Yuk Simak Info
        redirectActivity(this,YSIActivity.class);
    }

    public void ClickKontak (View view){
        //Redirect activity ke Kontak Resmi
        redirectActivity(this,KontakActivity.class);
    }

    public void ClickAplikasi (View view){
        //Redirect activity ke Tentang Aplikasi
        redirectActivity(this,AplikasiActivity.class);
    }
    public void ClickLogout (View view){
        //Menutup Aplikasi
        logout(this);
    }

    public static void logout(Activity activity) {
        //Inisialisasi Kotak Dialog Peringatan
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set Title
        builder.setTitle("Logout");
        //Berikan Pesan
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?");
        //Positif Tombol Yes
        builder.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish Activivy
                activity.finishAffinity();
                //Exit Aplikasi
                System.exit(0);
            }
        });
        //Negative Tombol No
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss Dialog atau batalin aktivitas
                dialog.dismiss();
            }
        });
        //Show Dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Inisialisasi intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start Acitivity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        closeDrawer(drawerLayout);
    }

}
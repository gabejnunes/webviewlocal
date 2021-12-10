package com.teste.webviewlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        // Cria uma instância das configurações do navegador interno
        WebSettings webSettings = webView.getSettings();
        // Ativa o javascript (necessário para qualquer página moderna :p )
        webSettings.setJavaScriptEnabled(true);

        /* Essas funções são extremamente necessárias para que o arquivo html da página
            possa acessar os recursos do site dentro de scripts.
            O acesso é feito por uma string "file:///android_asset/[pasta]/[arquivo.extensão]".

            Essas funções também foram depreciadas na API 30 então não use com sites normais (www).
         */
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);

        // Acessa a página html presente na pasta /src/assets/site
        // A referência "android_asset" equivale ao caminho "/src/assets/"
        /* Para criar uma pasta de assets, no Android Studio:
            Selecione o painel "Project" no lado esquerdo
            Selecione "Android"
            Selecione "app" com o botão direito
            Selecione "New" > "Directory" e digite "src/main/assets"
        */
        webView.loadUrl("file:///android_asset/site/index.html");
    }
}
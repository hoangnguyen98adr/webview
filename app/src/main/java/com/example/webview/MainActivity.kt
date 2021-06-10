package com.example.webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webViewSetup()
    }

    private fun webViewSetup() {
        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }

    /*
    Sử dụng javascript trong webview
    - Nó giúp tương tác với web trên application mà không phải
    mở cửa sổ browser,
    mặc định javascript bị tắt , để bật nó gọi đến method settings.javaScriptEnabled = true
    Ví dụng khách hàng yêu cầu trang web của bạn thực sự là android của bạn, vậy nên sử dụng để thao tác trên chính android
   settings.safeBrowsingEnabled = true, với trình duyệt web an toàn, bạn sẽ nhận cảnh báo về phần mềm độc hại,
   rủi ro, lừa đảo hoặc các trang web trong danh sách của google
    * */
}
package cn.zhaoliang5156.monthmoni.ui.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import cn.zhaoliang5156.monthmoni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    private WebView webView;
    private Button btnCallJS;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        webView = view.findViewById(R.id.webview);
        btnCallJS = view.findViewById(R.id.btn_call_js);


        // 设置Client
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        // 设置支持JS
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 加载html
        webView.loadUrl("file:///android_asset/about.html");

        btnCallJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    webView.evaluateJavascript("callJS()", null);
                }
            }
        });

        return view;
    }

}

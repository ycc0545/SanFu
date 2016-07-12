package com.example.dllo.sanfu.net;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.dllo.sanfu.base.App;

/**
 * Created by dllo on 16/7/6.
 */
public class VolleySingleton {
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private static VolleySingleton volleySingleton = new VolleySingleton();

    public static VolleySingleton getInstance() {
        return volleySingleton;
    }

    private VolleySingleton() {
        requestQueue = Volley.newRequestQueue(App.context);
        imageLoader = new ImageLoader(requestQueue, new MemoryCache());
    }
}

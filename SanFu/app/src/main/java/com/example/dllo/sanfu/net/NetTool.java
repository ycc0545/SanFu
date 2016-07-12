package com.example.dllo.sanfu.net;

import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.example.dllo.sanfu.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/7/6.
 */
public class NetTool {
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;


    public NetTool() {
        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        imageLoader = VolleySingleton.getInstance().getImageLoader();
    }

    public void getAnalysis(String url, final NetListener netListener) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                netListener.onSuccessed(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                netListener.onFailed(error);
            }
        });
        requestQueue.add(request);
    }

    public void getImgAnalysis(String url, final ImageView imageView) {

        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null) {
                    imageView.setImageBitmap(response.getBitmap());
                } else {
                    imageView.setImageResource(R.mipmap.ig_logo_text);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }
}

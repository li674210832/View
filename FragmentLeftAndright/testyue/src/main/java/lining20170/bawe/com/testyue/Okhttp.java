package lining20170.bawe.com.testyue;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 2017/3/29.
 * author ：李宁
 * 类注释：
 */

public class Okhttp {

    public static String httpok(String url) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request bbuild = new Request.Builder().url(url).build();
        Response execute = okHttpClient.newCall(bbuild).execute();

        return  execute.body().string();
    }
}

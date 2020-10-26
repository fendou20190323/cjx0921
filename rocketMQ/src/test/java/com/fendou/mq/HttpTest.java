package com.fendou.mq;

import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cjx
 * @Date: 2020-10-21 09:37
 * @Description;
 */
@Log4j2
public class HttpTest {
    private final String con="wd=张定宇&rsv_spt=1&rsv_iqid=0xbe86725f00026a54&issp=1&f=3&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=ts_1&rsv_sug3=7&rsv_sug1=6&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&prefixsug=%25E5%25BC%25A0&rsp=1&inputT=4335&rsv_sug4=13202";
    public static void main(String[] args) {

        HttpTest httpTest = new HttpTest();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            httpTest.okhttp();
        }
        long mid = System.currentTimeMillis();
        System.err.println("okhttp:"+(mid-start));
        for (int i = 0; i < 100; i++) {
            httpTest.httpUrlCon();
        }
        System.err.println("httpUrlCon:"+(System.currentTimeMillis()-start));
    }
    public void okhttp() {
        byte[] content=con
                .getBytes();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .post(RequestBody.create(MediaType.parse("application/json"), content))
                .build();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(50, 5, TimeUnit.MINUTES))
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                log.info("error:" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                log.info("success:" + response.body().string());
            }
        });
    }

    public void httpUrlCon(){

        try {
            // 1. 获取访问地址URL
            URL url = new URL("https://www.baidu.com/");
            // 2. 创建HttpURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            /* 3. 设置请求参数等 */
            // 请求方式
            connection.setRequestMethod("POST");
            // 超时时间
            connection.setConnectTimeout(3000);
            // 设置是否输出
            connection.setDoOutput(true);
            // 设置是否读入
            connection.setDoInput(true);
            // 设置是否使用缓存
            connection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置使用标准编码格式编码参数的名-值对
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 连接
            connection.connect();
            /* 4. 处理输入输出 */
            // 写入参数到请求中
            String params = con;
            OutputStream out = connection.getOutputStream();
            out.write(params.getBytes());
            out.flush();
            out.close();
            // 从连接中读取响应信息
            String msg = "";
            int code = connection.getResponseCode();
            if (code == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    msg += line + "\n";
                }
                reader.close();
            }
            // 5. 断开连接
            connection.disconnect();

            // 处理结果
//            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void testHttpClient(){
    }
}




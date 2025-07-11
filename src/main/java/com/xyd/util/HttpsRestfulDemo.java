package com.xyd.util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpRequest;

import java.io.IOException;
import java.net.URI;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class HttpsRestfulDemo {
    // 创建 CloseableHttpClient 实例，设置连接超时
    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.custom()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(10_000) // 连接超时 10 秒
                    .setSocketTimeout(5_000)   // 读取超时 5 秒
                    .build())
            .build();
    private static final String BASE_URL = "https://tysl.telecomjs.com:9443/sjzl/rest/ability/";
    private static final String NGINX_PROXY_URL="http://172.19.179.86:8000";

    // 发送 POST 请求，返回 JSONObject
    public static JSONObject sendPostRequest(String endpoint, JSONObject jsonBody) throws Exception {
        // 创建 POST 请求
        HttpPost httpPost = new HttpPost(BASE_URL + endpoint);

        // 设置请求头
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        // 设置请求体
        httpPost.setEntity(new StringEntity(jsonBody.toJSONString(), StandardCharsets.UTF_8));

        // 执行请求
        try (CloseableHttpResponse response = HTTP_CLIENT.execute(httpPost)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

            if (statusCode >= 200 && statusCode < 300) {
                return JSONObject.parseObject(responseBody);
            } else {
                throw new RuntimeException("POST request failed with status code: " + statusCode);
            }
        }
    }
    @SneakyThrows
    public static void main(String[] args) {
        try {
            //查询设备列表-不含通道数据
            JSONObject jsonObject = new JSONObject();
            Long curTime = System.currentTimeMillis();
            String nonce = "aabbccdd";
            String appsecret = "3q66301b7710307yziz1t1x5wbgu4p5j8dtr4mzy";
            jsonObject.put("curTime", curTime);
            String input = nonce + appsecret + curTime;
            String checkNum = DemoUtils.SHA256Encrypt(input);
            jsonObject.put("checkNum", checkNum);
            jsonObject.put("pageNo", 1);
            jsonObject.put("loginName", "184001118362");
            jsonObject.put("appKey", "537556523");
            jsonObject.put("nonce", nonce);
            jsonObject.put("pageSize",50);
            JSONObject postResponse= sendPostRequest("getTerminalListStand", jsonObject);
            System.out.println("jsonObject===:"+jsonObject);
            System.out.println(postResponse);
            JSONArray data = postResponse.getJSONArray("data");
            JSONObject obj = (JSONObject)data.get(0);

            JSONObject jsonObject1 = new JSONObject();
            Long curTime1 = System.currentTimeMillis();
            String nonce1 = "aabbccdd";
            String appsecret1 = "3q66301b7710307yziz1t1x5wbgu4p5j8dtr4mzy";
            jsonObject1.put("curTime", curTime1);
            String input1 = nonce1 + appsecret1 + curTime1;
            String checkNum1 = DemoUtils.SHA256Encrypt(input1);
            jsonObject1.put("checkNum", checkNum1);
//            jsonObject1.put("pageNo", 1);
            jsonObject1.put("loginName", "184001118362");
            jsonObject1.put("appKey", "537556523");
            jsonObject1.put("nonce", nonce1);
//            jsonObject1.put("pageSize",50);
            jsonObject1.put("devID","32070100001327112718");
            jsonObject1.put("channelid","32070100001317112718");
            //获取设备媒体播放地址接口
            JSONObject postResponse1 = sendPostRequest("getMediaPlayUrl", jsonObject1);
            System.out.println("jsonObject1====:"+jsonObject1);
            System.out.println(postResponse1);
            JSONObject data1 = postResponse1.getJSONObject("data");
            String rtspUrl = data1.getString("rtspUrl");
            String flvUrl = data1.getString("flvUrl");
            String hlsUrl = data1.getString("hlsUrl");
            System.out.println("rtspUrl==="+rtspUrl);
            System.out.println("flvUrl==="+flvUrl);

            String newUrl = flvUrl.substring(flvUrl.indexOf("/rtp"));
            System.out.println("flvUrlReplace==="+newUrl);
            System.out.println("hlsUrl==="+NGINX_PROXY_URL+hlsUrl);
            //获取 https 媒体播放地址接口
            JSONObject postResponse3 = sendPostRequest("getEncryptMediaPlayUrl", jsonObject1);
            System.out.println(postResponse3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.xyd.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpsRestfulDemo {
    // 创建 CloseableHttpClient 实例，设置连接超时
    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.custom()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(10000) // 连接超时 10 秒
                    .setSocketTimeout(5000)   // 读取超时 5 秒
                    .build())
            .build();
    private static final String BASE_URL = "https://tysl.telecomjs.com:9443/sjzl/rest/ability/";
    private static final String BASE_URL_NGINX = "http://172.19.172.86:8083/sjzl/rest/ability/";
    private static final String NGINX_PROXY_URL = "https://172.19.172.86:8000";

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
            jsonObject.put("pageSize", 100000);
            JSONObject postResponse = sendPostRequest("getTerminalListStand", jsonObject);
            System.out.println("jsonObject===:" + jsonObject);
            System.out.println(postResponse);
            JSONArray data = postResponse.getJSONArray("data");
            JSONObject obj = (JSONObject) data.get(0);

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
            /**
             * 宇视
             * 海州区大厅东
             * --- devID--32070600001327113339---channelID---32070600001317113339
             *
             * 海州区大厅12
             * --- devID--32070600001327113403---channelID---32070600001317113403
             */
            /**
             * Dahua
             *
             *灌云县基层治理指挥大厅1
             *  "devID": "32070100001327112717", "channelID": "32070100001317112717",
             *
             *灌云县基层治理指挥大厅2（7号位）
             * devID--32070100001327112718---channelID---32070100001317112718
             *
             * 海州湾街道办事处
             * "devID": "32070300001327114534", "channelID": "32070300001317114534",
             *
             * 宿城街道 X
             *  "devID": "32070300001327121419",  "channelID": "32070300001317121419",
             * "宋庄镇基层治理服务中心", X
             *  "devID": "32070700001327118715","channelID": "32070700001317118715",
             *
             * 班庄综治中心信访接待大厅 X
             *  "devID": "32070700001327121074","channelID": "32070700001317121074",
             *
             * 灌南县汤沟镇信访大厅 X
             *  "devID": "32072400001327113578",  "channelID": "32072400001317113578",
             * 灌南县百禄镇信访大厅-
             *   ==devId===32072400001327113769=== channelID=== 32072400001317113769
             */
            /**
             *
             *不能 播放汇总、不稳定
             * 赣榆区青口镇接访大厅（1号位）
             *"devID", "32070700001327113535" ---"channelID": "32070700001317113535",
             *
             */

//* devID--32070100001327112718---channelID---32070100001317112718

            // devID--32072400001327113476---channelID---32072400001317113476
//            jsonObject1.put("pageSize",50);
            jsonObject1.put("devID", "32070600001327113412");
            jsonObject1.put("channelID", "32070600001317113412");
            //获取设备媒体播放地址接口
            JSONObject postResponse1 = sendPostRequest("getMediaPlayUrl", jsonObject1);
            System.out.println("jsonObject1====:" + jsonObject1);
            System.out.println(postResponse1);
            JSONObject data1 = postResponse1.getJSONObject("data");
            String rtspUrl = data1.getString("rtspUrl");
            String flvUrl = data1.getString("flvUrl");
            String hlsUrl = data1.getString("hlsUrl");
            System.out.println("rtspUrl===" + rtspUrl);
            System.out.println("flvUrl===" + flvUrl);
            String testUrl = flvUrl;
            String url = URLParser(NGINX_PROXY_URL, testUrl);
            System.out.println("url===" + url);
            String newUrl = testUrl.substring(testUrl.indexOf("/rtp"));
            System.out.println("flvUrlReplace===" + NGINX_PROXY_URL + newUrl);
            System.out.println("hlsUrl===" + hlsUrl);
            //获取 https 媒体播放地址接口
            JSONObject postResponse3 = sendPostRequest("getEncryptMediaPlayUrl", jsonObject1);
            System.out.println(postResponse3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    public static String URLParser(String nginxProxyUrl, String originalUrl) {
        //http://192.168.1.100/rtp?ip=121.237.36.172&rtp=0C584C9C&token=5703F81AED11EE69FE1F3BD0AAEF485E23FCD2B1D674F43C589201C6562DB624
        String newUrl = "";
        URL url = new URL(originalUrl);
        String ipAddress = url.getHost();
        String path = url.getPath();
        String streamId = path.split("/")[2].split("\\.")[0];
        String token = url.getQuery().split("=")[1];
        newUrl = String.format(nginxProxyUrl + "/rtp?ip=%s&rtp=%s&token=%s",
                ipAddress, streamId, token);
        return newUrl;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//网页爬虫
public class WebCrawler {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        String title = "";
        String content = "";
        try {
            // 获取网页内容
            URLConnection conn = new URL(url).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            // 解析网页内容
            Document doc = Jsoup.parse(sb.toString());
            title = doc.title();
            Elements paragraphs = doc.select("p");
            for (Element p : paragraphs) {
                content += p.text() + "\n";
            }

            // 存储数据
            System.out.println("Title: " + title);
            System.out.println("Content: " + content);

            int count = 0; // 计数器，记录当前已经提交了多少次
            int batch = 1000; // 每隔多少次提交一次
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

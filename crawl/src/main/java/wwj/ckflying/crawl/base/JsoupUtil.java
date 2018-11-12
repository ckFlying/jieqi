package wwj.ckflying.crawl.base;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.task.TaskExecutor;
import wwj.ckflying.crawl.entity.CrawlInfo;

import java.io.IOException;

/**
 * create by wjwang on 2018/11/12
 */
@Log4j2
public class JsoupUtil {
    private static final String UA_PHONE = "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Safari/537.36";
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36";

    private static final int TIME_OUT = 10 * 1000;

    private static final String ERROR_DESC = "网址请求失败：";

    public static Document getDocWithPC(String url) {
        try {
            return Jsoup.connect(url).userAgent(UA_PC).cookie("__cdnuid","3223ec883247dd83dc6fd1f0b59dbc58").ignoreContentType(true).timeout(TIME_OUT).get();
        } catch (IOException e) {
            log.error(ERROR_DESC + url);
            throw new RuntimeException(e);
        }
    }
    public static void saveFileWithDAOGUO(CrawlInfo  crawlInfo){
        Document document = getDocWithPC(crawlInfo.getUrl() );
        Elements eles= document.select(crawlInfo.getSimilarDom()).get(0).children();
        int i=1;
        TaskExecutor threadExecutor=new ThreadExecutor().taskExecutor();
        for(Element ele:eles){
            String eleUrl=ele.select(crawlInfo.getNextDom()).attr("href");
            threadExecutor.execute(new SaveThread(crawlInfo.getUrl()+eleUrl,i,"content",crawlInfo.getOutDir()));
            i++;
            log.debug("in "+i);
        }
    }
    public static void main(String[] args) {
        CrawlInfo crawlInfo=new CrawlInfo();
        crawlInfo.setUrl("https://www.booktxt.net/0_8/");
        crawlInfo.setSimilarDom("#list dl");
        crawlInfo.setNextDom("dd a");
        crawlInfo.setOutDir("E:\\crawlFile");
        saveFileWithDAOGUO(crawlInfo);
    }

}

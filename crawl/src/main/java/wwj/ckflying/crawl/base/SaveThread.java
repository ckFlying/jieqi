package wwj.ckflying.crawl.base;

import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * create by wjwang on 2018/11/12
 */
@Log4j2
public class SaveThread implements Runnable{
    private String url;
    private int page;
    private String id;
    private String outDir;

    public SaveThread(String url, int page, String id,String outDir) {
        this.url = url;
        this.page = page;
        this.id = id;
        this.outDir=outDir;
    }

    @Override
    public void run() {
        log.debug("在存储第"+page+"章");
        Document document =JsoupUtil.getDocWithPC(url);
        Element element= document.getElementById(id);
        FileUtil.saveFileToTxt( element.text(),"第"+page+"章",outDir);
        log.debug("存储"+page+"章结束！！！");
    }
}

package wwj.ckflying.crawl.entity;

import lombok.Data;

/**
 * create by wjwang on 2018/11/12
 */
@Data
public class CrawlInfo {
    private String url;
    private String similarDom;
    private String nextDom;
    private String outDir;
}

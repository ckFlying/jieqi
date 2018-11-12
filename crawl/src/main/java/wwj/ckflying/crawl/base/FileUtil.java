package wwj.ckflying.crawl.base;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * create by wjwang on 2018/11/12
 */
@Log4j2
public class FileUtil {
        public static void saveFileToTxt(String content,String filename,String outDir){
            File file=new File(outDir+"\\"+filename+".txt");
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if(file.exists()){
                file.delete();
            }
            FileOutputStream outputStream=null;
            try {
                file.createNewFile();
                outputStream=new FileOutputStream(file);
                outputStream.write(content.getBytes());
            } catch (FileNotFoundException e) {
                log.error("文件未发现");
            } catch (IOException e) {
                log.error("文件写入失败");
            }finally {
                if(outputStream!=null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        log.error("outstream close error");
                    }
                }
            }
        }
}

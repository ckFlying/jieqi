package jq.server.util;

/**
 * create by wjwang on 2018/11/27
 */
public class IDUtil {
    private long lastTimestamp = -1L;
    private long sequence = 0L;
    private long workerId = 1023L;
    private static IDUtil idUtil;
    private long timeGen() {
        return System.currentTimeMillis();
    }
    public static long getKey(){
        if(idUtil==null){
            idUtil=new IDUtil();
        }
        return idUtil.getId();
    }
    public synchronized long getId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 1023L;
            if (this.sequence == 0L) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }

        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

        this.lastTimestamp = timestamp;
        long nextId = timestamp - 1473383349999L << 20 | this.workerId << 10 | this.sequence;
        return nextId;
    }
    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            ;
        }

        return timestamp;
    }
}

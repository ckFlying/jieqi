package config;

/**
 * create by wjwang on ${date}
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> DS_HOLDER = new ThreadLocal<String>();

    public static void setDS(String dbType) {
        DS_HOLDER.set(dbType);
    }

    public static String getDS() {
        return (DS_HOLDER.get());
    }

    public static void clearDS() {
        DS_HOLDER.remove();
    }
}

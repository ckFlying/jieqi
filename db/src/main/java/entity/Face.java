package entity;

/**
 * create by wjwang on ${date}
 */
public class Face {
    private int faceId;
    private String faceInfo;

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    public String getFaceInfo() {
        return faceInfo;
    }

    public void setFaceInfo(String faceInfo) {
        this.faceInfo = faceInfo;
    }

    @Override
    public String toString() {
        return "Face{" +
                "faceId=" + faceId +
                ", faceInfo='" + faceInfo + '\'' +
                '}';
    }
}

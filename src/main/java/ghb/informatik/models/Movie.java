package ghb.informatik.models;

public class Movie {
    
    String title;
    int fsk;
    int length;
    String desc;
    String imgLink;
    String externalLink;

    public Movie(String title){
        setTitle(title);
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public String getDesc() {
        return desc;
    }
    public String getImgLink() {
        return imgLink;
    }

    public int getFsk() {
        return fsk;
    }
    public int getLength() {
        return length;
    }
    public String getTitle() {
        return title;
    }
    public void setFsk(int fsk) {
        this.fsk = fsk;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

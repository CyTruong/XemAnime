package phanhattruong.com.animeviewer;

/**
 * Created by admin on 20/10/2018.
 */

public class AnimeInfo {
    String Title;
    String Chap;
    String Views;
    String Quality;
    String Source;
    String ImageSource;

    public AnimeInfo(String title, String chap, String source,String imageSource, String views, String quality) {
        Title = title;
        Chap = chap;
        Source = source;
        ImageSource = imageSource;
        Views = views;
        Quality = quality;
    }

    public String getImageSource() {
        return ImageSource;
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }

    public void setChap(String chap) {
        Chap = chap;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public void setViews(String views) {
        Views = views;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getChap() {

        return Chap;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTitle() {
        return Title;
    }

    public String getViews() {
        return Views;
    }

    public String getQuality() {
        return Quality;
    }
}

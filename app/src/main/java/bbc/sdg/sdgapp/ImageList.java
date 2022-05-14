package bbc.sdg.sdgapp;

public class ImageList {

    private int image;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    private String newsTitle;
    private String newsDate;

    public ImageList(int image) {

        this.image = image;
    }
    public ImageList(int image,String newsTitle,String newsDate) {
        this.image = image;
this.newsTitle = newsTitle;
this.newsDate = newsDate;

    }

    public int getImage() {
        return image;
    }
}

package com.example.toshiba.myapplication;

public class Recommendation {
    private double similarity_percentage;
    private String title;
    private String titulo_alicia;
    private String link;

    public double getSimilarity_percentage() {
        return similarity_percentage;
    }

    public void setSimilarity_percentage(double similarity_percentage) {
        this.similarity_percentage = similarity_percentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitulo_alicia() {
        return titulo_alicia;
    }

    public void setTitulo_alicia(String titulo_alicia) {
        this.titulo_alicia = titulo_alicia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

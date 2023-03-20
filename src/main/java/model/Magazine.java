package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Magazine {
  private int magazineId;
  private String title;
  private Date publicationDate;
  private List<Article> articles = new ArrayList<Article>();


  public Magazine(int magazineId, String title, Date data_publicacio) {
    super();
    this.title = title;
    this.publicationDate = data_publicacio;
    this.magazineId = magazineId;
  }

  public Magazine() {
    super();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public int getMagazineId() {
    return magazineId;
  }

  public void setMagazineId(int magazineId) {
    this.magazineId = magazineId;
  }

  public void addArticle(Article article) {
    articles.add(article);
  }

  public Article getArticle(int i) {

    return articles.get(i);

  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }


  @Override
  public String toString() {
    return "Magazine{" +
        "magazineId=" + magazineId +
        ", title='" + title + '\'' +
        ", publicationDate=" + publicationDate +
        ", articles=" + articles +
        '}';
  }

}

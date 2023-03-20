package model;

import java.util.Date;


public class Article {
  private int articleId;
  private String title;
  private Date publicationDate;
  private boolean publishable;
  private Author author;
  //private Revista  publicate;

  public Article(int articleId, String title, Date publicationDate,
                 boolean publishable, Author author) {
    super();
    this.articleId = articleId;
    this.title = title;
    this.publicationDate = publicationDate;
    this.publishable = publishable;
    this.author = author;
  }

  public Article() {
    super();

  }

  public int getArticleId() {
    return articleId;
  }

  public void setArticleId(int articleId) {
    this.articleId = articleId;
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

  public boolean isPublishable() {
    return publishable;
  }

  public void setPublishable(boolean publishable) {
    this.publishable = publishable;
  }

  public Author getAutor() {
    return author;
  }

  public void setAutor(Author author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Article{" +
        "articleId=" + articleId +
        ", title='" + title + '\'' +
        ", publicationDate=" + publicationDate +
        ", publishable=" + publishable +
        ", author=" + author +
        '}';
  }

/**
   public Revista getPublicate() {
   return publicate;
   }
   public void setPublicate(Revista publicate) {
   this.publicate = publicate;
   }
   **/


}

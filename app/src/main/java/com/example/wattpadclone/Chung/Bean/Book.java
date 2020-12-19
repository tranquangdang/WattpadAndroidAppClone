package com.example.wattpadclone.Chung.Bean;

public class Book {
    String BookName, Intro, BookImg, Author, TimeCreate, Status;
    int  BookID,CategoryNo, Chapter, Written, Favorite;

    public Book(int bookID, int categoryNo,String bookName, String intro, String bookImg, String author, String timeCreate, String status, int chapter, int written, int favorite) {
        BookName = bookName;
        Intro = intro;
        BookImg = bookImg;
        Author = author;
        TimeCreate = timeCreate;
        Status = status;
        BookID = bookID;
        CategoryNo = categoryNo;
        Chapter = chapter;
        Written = written;
        Favorite = favorite;
    }

    //    public Book() {
//    }


    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public String getBookImg() {
        return BookImg;
    }

    public void setBookImg(String bookImg) {
        BookImg = bookImg;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTimeCreate() {
        return TimeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        TimeCreate = timeCreate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getCategoryNo() {
        return CategoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        CategoryNo = categoryNo;
    }

    public int getChapter() {
        return Chapter;
    }

    public void setChapter(int chapter) {
        Chapter = chapter;
    }

    public int getWritten() {
        return Written;
    }

    public void setWritten(int written) {
        Written = written;
    }

    public int getFavorite() {
        return Favorite;
    }

    public void setFavorite(int favorite) {
        Favorite = favorite;
    }
}
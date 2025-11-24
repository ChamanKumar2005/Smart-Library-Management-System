package model;

import java.sql.Date;

public class Borrow {

    private String idBook;
    private String idReader;
    private Date lendDate;
    private Date dueDate;
    private String overtime;

    public Borrow() {
    }

    public Borrow(String idBook, String idReader, Date lendDate, Date dueDate, String overtime) {
        this.idBook = idBook;
        this.idReader = idReader;
        this.lendDate = lendDate;
        this.dueDate = dueDate;
        this.overtime = overtime;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }
}

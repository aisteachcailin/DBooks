/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbooks.db;

import com.mycompany.dbooks.db.Orders;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 9977q
 */
@Entity
@Table(name = "books")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByNameBook", query = "SELECT b FROM Books b WHERE b.nameBook = :nameBook"),
    @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NameBook")
    private String nameBook;
    @Basic(optional = false)
    @Column(name = "Author")
    private String author;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booksNameBook")
    private Collection<Orders> ordersCollection;

    public Books() {
    }

    public Books(String nameBook) {
        this.nameBook = nameBook;
    }

    public Books(String nameBook, String author) {
        this.nameBook = nameBook;
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameBook != null ? nameBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.nameBook == null && other.nameBook != null) || (this.nameBook != null && !this.nameBook.equals(other.nameBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameBook;
    }
    
}

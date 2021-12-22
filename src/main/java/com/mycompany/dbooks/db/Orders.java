/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbooks.db;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 9977q
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByIdOrders", query = "SELECT o FROM Orders o WHERE o.idOrders = :idOrders")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "idOrders")
    private String idOrders;
    @JoinColumn(name = "Books_NameBook", referencedColumnName = "NameBook")
    @ManyToOne(optional = false)
    private Books booksNameBook;
    @JoinColumn(name = "Customers_NameCustomer", referencedColumnName = "NameCustomer")
    @ManyToOne(optional = false)
    private Customers customersNameCustomer;

    public Orders() {
    }

    public Orders(String idOrders) {
        this.idOrders = idOrders;
    }

    public String getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(String idOrders) {
        this.idOrders = idOrders;
    }

    public Books getBooksNameBook() {
        return booksNameBook;
    }

    public void setBooksNameBook(Books booksNameBook) {
        this.booksNameBook = booksNameBook;
    }

    public Customers getCustomersNameCustomer() {
        return customersNameCustomer;
    }

    public void setCustomersNameCustomer(Customers customersNameCustomer) {
        this.customersNameCustomer = customersNameCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrders != null ? idOrders.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrders == null && other.idOrders != null) || (this.idOrders != null && !this.idOrders.equals(other.idOrders))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOrders;
    }


    
    
}

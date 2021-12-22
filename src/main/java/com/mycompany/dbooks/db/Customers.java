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
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByNameCustomer", query = "SELECT c FROM Customers c WHERE c.nameCustomer = :nameCustomer"),
    @NamedQuery(name = "Customers.findByAddress", query = "SELECT c FROM Customers c WHERE c.address = :address"),
    @NamedQuery(name = "Customers.findByNumber", query = "SELECT c FROM Customers c WHERE c.number = :number")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NameCustomer")
    private String nameCustomer;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Number")
    private String number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersNameCustomer")
    private Collection<Orders> ordersCollection;

    public Customers() {
    }

    public Customers(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Customers(String nameCustomer, String address, String number) {
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.number = number;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        hash += (nameCustomer != null ? nameCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.nameCustomer == null && other.nameCustomer != null) || (this.nameCustomer != null && !this.nameCustomer.equals(other.nameCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameCustomer;
    }
    
}

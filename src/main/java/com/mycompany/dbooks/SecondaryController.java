package com.mycompany.dbooks;

import java.io.IOException;
import javafx.fxml.FXML;
import com.mycompany.dbooks.db.Customers;
import com.mycompany.dbooks.db.Books;
import com.mycompany.dbooks.db.Orders;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SecondaryController {
    
   public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mydb"); 
   public static EntityManager em = emf.createEntityManager();


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private TableView table;
    
    @FXML
    private TableColumn<Orders, String> columnCustomers;
    
    @FXML
    private TableColumn<Orders, String> columnBooks;
    
    @FXML
    private TableColumn<Orders, String> columnOrders;
    
    @FXML
    private TextField idOrdTextField;
    @FXML
    private TextField nameBTextField;
    @FXML
    private TextField nameCTextField;
    @FXML
    private TextField nameBBTextField;
    @FXML
    private TextField nameCCTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextField numbTextField;
    @FXML
    private TextField addressTextField;
    
            String nameB = nameBTextField.getText();
            String nameC = nameCTextField.getText();
    @FXML
    public void initialize() {
        
        Query q = em.createNamedQuery("Orders.findAll");
        List<Orders> ordersList = q.getResultList();
                        
       columnCustomers.setCellValueFactory((TableColumn.CellDataFeatures<Orders, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getCustomersNameCustomer().toString());
        });  
     
       
       columnBooks.setCellValueFactory((TableColumn.CellDataFeatures<Orders, String> cd) -> {
        return new SimpleStringProperty(cd.getValue().getBooksNameBook().toString());
        });
       
       columnOrders.setCellValueFactory((TableColumn.CellDataFeatures<Orders, String> cd) -> {
         return new SimpleStringProperty(cd.getValue().getIdOrders());
        });
        
        ObservableList<Orders> ord = FXCollections.observableList(ordersList);
        table.setItems(ord);
               
    }
    
    @FXML
    private void addCustomer() throws IOException {
        
      
        String numb = numbTextField.getText();
        String address = addressTextField.getText();
        
        if (nameC.isEmpty() || numb.isEmpty() || address.isEmpty()) {
            System.out.println("Вы ввели не все данные покупателя");
        } else {
            Customers customerIns = new Customers();
            customerIns.setNameCustomer(nameC);
            customerIns.setNumber(numb);
            customerIns.setAddress(address);
            
            em.getTransaction().begin();
            em.persist(customerIns);
            em.getTransaction().commit();

        }
    }
    
        @FXML
    private void addBook() throws IOException {
        

        String author = authorTextField.getText();
        
        if (nameB.isEmpty() || author.isEmpty()) {
            System.out.println("Вы ввели не все данные книги");
        } else {
            Books bookIns = new Books();
            bookIns.setNameBook(nameB);
            bookIns.setAuthor(author);
            
            em.getTransaction().begin();
            em.persist(bookIns);
            em.getTransaction().commit();
            
        }
    }
    
    @FXML
    private void addOrder() throws IOException{
        String idOrd = idOrdTextField.getText();
        if (idOrd.isEmpty() || nameB.isEmpty() || nameC.isEmpty()) {
            System.out.println("Введены не все данные для заказа");
        }else{
            Orders orderIns = new Orders();
            orderIns.setIdOrders(idOrd);
            orderIns.setBooksNameBook(nameB);
            orderIns.setCustomersNameCustomer(nameC);
            

            em.getTransaction().begin();
            
            em.persist(orderIns);
            em.getTransaction().commit();

            initialize();
         
            
        }      
    }

}



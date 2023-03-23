/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;
import books.Book;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import lombok.Builder;


/**
 *
 * @author Xiaomi
 */
@Builder//разобраться как работает
public class User {
    private String fullName;
    private ArrayList<Book> books = new ArrayList<>();
    public User(String fullName, ArrayList<Book> books){
        this.fullName=fullName;
        this.books=books;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public MutableTreeNode getNode(){
        DefaultMutableTreeNode node  = new DefaultMutableTreeNode(getFullName());
        for (Book book : books){
            node.add(new DefaultMutableTreeNode(book.getFullName()));
        }
        return node;
    }
}


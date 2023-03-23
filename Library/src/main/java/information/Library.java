/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package information;
import users.User;
import books.Book;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Library {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<User> students = new ArrayList<>();
    public static ArrayList<User> teachers = new ArrayList<>();
    
    public static MutableTreeNode getSudentNodes(){
        DefaultMutableTreeNode studentnodes = new  DefaultMutableTreeNode("Студенты");
        for (User user: students){
            studentnodes.add(user.getNode());
        }
    return studentnodes;
    }
    public static MutableTreeNode getTeachersNodes(){
        DefaultMutableTreeNode teachernodes = new  DefaultMutableTreeNode("Преподаватели");
        for (User user: teachers){
            teachernodes.add(user.getNode());
        }
    return teachernodes;
    }
}

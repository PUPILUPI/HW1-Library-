package books;

import books.EnglishBookFactory;
import information.Library;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import users.Builder;
import users.Director;
import users.StudentBuilder;
import users.TeacherBuilder;
import users.User;

public class DataManipulation {
    public DataManipulation() {

    }
    public void generateData(){
        Bookfactory factory;
        for (int i=0; i<25; i++){
            factory = new RussianBookFactory();
            Library.books.add(factory.createFiction());
            Library.books.add(factory.createTextbook());
            factory = new EnglishBookFactory();
            Library.books.add(factory.createFiction());
            Library.books.add(factory.createTextbook());
        }
        for (int i=0; i<20; i++){
            Builder builder = new StudentBuilder();
            Director director = new Director(builder);
            User user = director.createUser();
            Library.students.add(user);
        }
        for (int i=0; i<20; i++){
            Builder builder = new TeacherBuilder();
            Director director = new Director(builder);
            User user = director.createUser();
            Library.teachers.add(user);
        }
    }
    public void delete(){
        Library.books= new ArrayList<>();
        Library.teachers = new ArrayList<>();
        Library.students = new ArrayList<>();
    }
    public DefaultMutableTreeNode addInfotoGUI(){
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Пользователи");
        main.add(Library.getSudentNodes());
        main.add(Library.getTeachersNodes());
        return main;
    }

}

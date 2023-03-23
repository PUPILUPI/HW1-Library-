/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import books.Book;
import information.Library;
import java.util.ArrayList;

/**
 *
 * @author Xiaomi
 */
public class StudentBuilder implements Builder{
     private String fullName;
     private ArrayList<Book>books=new ArrayList<>();

    @Override
    public Builder bldFullName() {
        StringBuilder sb =  new StringBuilder();
        int indexOfName=0;
        int indexOfSurname=0;
       Integer randomSex= (int)Math.round(Math.random());
        if (randomSex.equals(0)){
            indexOfName=(int)Math.round(Math.random()*(femaleNames.size()-1));
            indexOfSurname=(int)Math.round(Math.random()*(femaleSurnames.size()-1));
            this.fullName = sb.append(femaleSurnames.get(indexOfSurname))
                              .append(" ")
                              .append(femaleNames.get(indexOfName))
                              .toString();            
        } 
        if (randomSex.equals(1)){
            indexOfName=(int)Math.round(Math.random()*(maleNames.size()-1));
            indexOfSurname=(int)Math.round(Math.random()*(maleSurnames.size()-1));
            this.fullName = sb.append(maleSurnames.get(indexOfSurname))
                              .append(" ")
                              .append(maleNames.get(indexOfName))
                              .toString();
        }
        return this;      
    }

    @Override
    public Builder bldBooks(ArrayList<Book> books) {
        ArrayList<Book> bk = new ArrayList<>(books);
        int quantityOfBooks =(int)Math.round(Math.random()*(10-3)+3);
        for (int i = 1; i<=quantityOfBooks; i++){
            int numberOfBook =(int)Math.round(Math.random()*(bk.size()-1));
            this.books.add(bk.get(numberOfBook));
            bk.remove(numberOfBook);
        }
        
        return this;
        
    }

    @Override
    public User bldUser() {
        User user = new User(fullName, books);
        return user;
    }
}

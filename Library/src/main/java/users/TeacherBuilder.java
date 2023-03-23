/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import books.Book;
import java.util.ArrayList;

/**
 *
 * @author Xiaomi
 */
public class TeacherBuilder implements Builder{
    private String fullName;
    private ArrayList<Book>books=new ArrayList<>();

    @Override
    public Builder bldFullName() {
        String ending=null;
        int indexOfName=0;
        int indexOfSurname=0;
        int indexOfSecondName=(int)Math.round(Math.random()*(secondNames.size()-1));
        Integer randomSex= (int)Math.round(Math.random());
        if (randomSex.equals(0)){
            indexOfName=(int)Math.round(Math.random()*(femaleNames.size()-1));
            indexOfSurname=(int)Math.round(Math.random()*(femaleTSurnames.size()-1));
            ending="на";
            this.fullName = fullNameByGender(indexOfName, indexOfSurname, indexOfSecondName, femaleNames, femaleTSurnames, secondNames, ending);
        } 
        if (randomSex.equals(1)){
            indexOfName=(int)Math.round(Math.random()*(maleNames.size()-1));
            indexOfSurname=(int)Math.round(Math.random()*(maleTSurnames.size()-1));
            ending="ич";
            this.fullName = fullNameByGender(indexOfName, indexOfSurname, indexOfSecondName, maleNames, maleTSurnames, secondNames, ending);
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
    public String fullNameByGender(int indexOfName, int indexOfSurname, int indexOfSecondName,  ArrayList<String> names, ArrayList<String> surnames,
    ArrayList<String> secondnames, String ending){
        StringBuilder sb =  new StringBuilder();
        return sb.append(surnames.get(indexOfSurname))
                           .append(" ")
                           .append(names.get(indexOfName))
                           .append(" ")
                           .append(secondnames.get(indexOfSecondName))
                           .append(ending)
                           .toString();
    }
    
}

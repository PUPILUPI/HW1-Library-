
package users;

import information.Library;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder=builder;
    }
    public User createUser(){
        return builder.bldFullName().bldBooks(Library.books).bldUser();
    }
    
}

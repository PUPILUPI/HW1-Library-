package books;

public class EnglishFiction extends Book {
    private String name;
    @Override
    public String getFullName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public EnglishFiction(String name ){
        this.name = name;
    }
    
}

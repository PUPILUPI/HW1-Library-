package books;

public class RussianTextbook extends Book{
    private String name;

    public String getFullName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public RussianTextbook(String name){
        this.name=name;
    }
}

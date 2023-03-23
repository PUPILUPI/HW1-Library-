package users;
import books.Book;
import java.util.ArrayList;

public interface Builder {
    public static ArrayList<String> femaleNames = new ArrayList<>();
    public static ArrayList<String> maleNames = new ArrayList<>();
    public static ArrayList<String> maleSurnames = new ArrayList<>();
    public static ArrayList<String> femaleSurnames = new ArrayList<>();
    public static ArrayList<String> femaleTSurnames = new ArrayList<>();
    public static ArrayList<String> maleTSurnames = new ArrayList<>();
    public static ArrayList<String> secondNames = new ArrayList<>();

    abstract Builder bldFullName();
    abstract Builder bldBooks(ArrayList<Book> books);
    abstract User bldUser();
    
}

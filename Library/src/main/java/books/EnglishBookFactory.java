package books;

import com.github.javafaker.Faker;
import java.util.ArrayList;

public class EnglishBookFactory extends Bookfactory{
        public static ArrayList<String> name = new ArrayList<>();
        public static ArrayList<String> university = new ArrayList<>();
        public static ArrayList<String> author = new ArrayList<>();
        public static Faker faker = new Faker();
    @Override
    public Book createTextbook() {
        int indexOfName=(int)Math.round(Math.random()*(name.size()-1));
        int indexOfUniversity=(int)Math.round(Math.random()*(university.size()-1));
        int indexOfAuthor=(int)Math.round(Math.random()*(author.size()-1));
        String level = null;
        int i = (int)Math.round(Math.random());
        if (i==0) level = "для бакалавриата";
        if (i==1) level = "для магистратуры";
        
        return new EnglishTextbook(name.get(indexOfName), university.get(indexOfUniversity),
                author.get(indexOfAuthor), level);
    }

    @Override
    public Book createFiction() {
        return new EnglishFiction(faker.book().title());
    }
}

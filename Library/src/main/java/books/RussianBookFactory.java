package books;

import java.util.ArrayList;
import com.github.javafaker.Faker;
import java.util.Locale;
public class RussianBookFactory extends Bookfactory{
    //для них будет использоваться предлог по (учебная литература
    public static ArrayList<String> type=new ArrayList<String>();
    public static ArrayList<String> name=new ArrayList<String>();
    //для них ничего не надо, просто слепить 
    public static ArrayList<String> adj= new ArrayList<>();
    public static ArrayList<String> noun= new ArrayList<>();
    public static ArrayList<String> whom= new ArrayList<>();
    public static String[] wordlist  = {"Груша","Пиво","чипсы","город","поле","закат","Зевс","Драка","Деньги","Любовь","Жаба","Краб","Учеба","Чайник","Ночь","Погибель","Труд","Каща"};
    
    @Override
    public Book createTextbook() {
        StringBuilder sb = new StringBuilder();
        String name = null;
        int indexOftype=(int)Math.round(Math.random()*((type.size()-1)));
        int indexOfname=(int)Math.round(Math.random()*(noun.size()-1));
        name = sb.append(type.get(indexOftype))
                 .append(" по ")
                 .append(RussianBookFactory.name.get(indexOfname))
                 .toString();
        return new RussianTextbook(name);
    }

    @Override
    public Book createFiction() {
        StringBuilder sb = new StringBuilder();
        int indexOfadj=(int)Math.round(Math.random()*(adj.size()-1));
        int indexOfnoun=(int)Math.round(Math.random()*(noun.size()-1));
        int indexOfwhom=(int)Math.round(Math.random()*(whom.size()-1));
       String name = null;
       int i = (int)Math.round(Math.random());
       if (i==0) name = wordlist[(int)Math.round(Math.random()*(wordlist.length-1))] + " и " + wordlist[(int)Math.round(Math.random()*(wordlist.length-1))];
       else name = sb.append(adj.get(indexOfadj))
                     .append(" ")
                     .append(noun.get(indexOfnoun))
                     .append(" ")
                     .append(whom.get(indexOfwhom))
                     .toString();
        return new RussianFiction(name);
    }
}

package books;

public class EnglishTextbook extends Book{
    public String name;
    private String university;
    private String author;
    private String level;
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    @Override
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public EnglishTextbook(String name,String university, String author, String level){
        this.name = name;
        this.author=author;
        this.university=university;
        this.level=level;
        StringBuilder sb = new StringBuilder();
        this.fullName=sb.append(name)
                        .append(", ")
                        .append(author)
                        .append(", ")
                        .append(university)
                        .append(", ")
                        .append(level)
                        .toString();
                        
    }
}

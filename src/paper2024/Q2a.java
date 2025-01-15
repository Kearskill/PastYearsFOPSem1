package paper2024;

public class Q2a {
    public static void main(String[] args) {
        Book a = new Book("Nihon 2025", "Galland", 2025);
        System.out.println(a.getAuthor());
        System.out.println(a.getTitle());
        System.out.println(a.getYearPublished());
        System.out.println();

        System.out.println("Display method:");
        a.display();
    }
}
// Write a Java Program that defines a class Book
// The book class should have three private attributes: titles (String) author(String) and
// yearPublished (int). Include a constructor to initiate these attributes and corresponding
// getting method for each. In your main method create an instance of book and display its
// details

class Book{
    private final String title;
    private final String author;
    private final int yearPublished;
    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYearPublished(){
        return yearPublished;
    }

    public void display(){
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Year published : " + yearPublished);
    }
}
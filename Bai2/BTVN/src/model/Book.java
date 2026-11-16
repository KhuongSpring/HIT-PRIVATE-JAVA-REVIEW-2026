package model;

public class Book extends Product{
    private String author;

    public Book(String id, String name, double price, int stock, String author){
        super(id,name,price,stock);
        if(author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Ten tac gia khong de trong !");
        }
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return getName() + " - tac gia : " + author;
    }
}
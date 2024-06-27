package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Hello world", 100);
        Book second = new Book("1984 Book", 255);
        Book third = new Book("Eugene Onegin", 249);
        Book four =  new Book("Clean code", 500);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = four;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        System.out.println(System.lineSeparator());
        books[0] = four;
        books[3] = first;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        System.out.println(System.lineSeparator());
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals(books[0].getName())) {
                System.out.println(books[index].getName() + " - " + books[index].getPageCount());
            }
        }
    }
}

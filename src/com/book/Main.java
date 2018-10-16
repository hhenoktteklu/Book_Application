package com.book;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here
        ArrayList<Author> authors = new ArrayList<Author>();
        ArrayList<Book> books = new ArrayList<Book>();

        Scanner keyboard = new Scanner(System.in);
        int choice = 0;


      do {
            System.out.println("Select an option number to continue:\n  1.Create Book\n  2.Creat Author\n  3.List of Author\n");
            int input = keyboard.nextInt();
            if (input == 1) {
                keyboard.nextLine();
                String title;
                String isbn;

                System.out.println("Enter title: ");
                title = keyboard.nextLine();
                System.out.println("Enter ISBN: ");
                isbn = keyboard.nextLine();
                System.out.println("AUTHORS: ");
                for (Author eachAuthor: authors) {
                    System.out.print("AUTHOR: ");
                    System.out.println(eachAuthor.getFirstName()+" "+eachAuthor.getLastName()+" "+eachAuthor.getEmailAddress()+" "+eachAuthor.getPhoneNumber()+"\n");
                }
                System.out.println("ADD AUTHOR: \ntype here first name and last name: ");
                System.out.print("First name: ");
                String authorFirstName = keyboard.nextLine();
                System.out.print("Last name: ");
                String authorLastName = keyboard.nextLine();

                Author foundAuthor = findAuthor(authorFirstName,authorLastName,authors);
                if(foundAuthor==null){
                    String email = "";
                    long phoneNumber = 0;

                    System.out.print("email: ");
                    email = keyboard.nextLine();
                    System.out.print("Phone number: ");
                    phoneNumber = keyboard.nextInt();

                    Author newAuthor = new Author(authorFirstName,authorLastName,email,phoneNumber);

                    Book book = new Book(title,isbn,newAuthor);
                    System.out.println(book);


                } else {

                    Book book = new Book(title, isbn, foundAuthor);
                    System.out.println("-->" + book);
                }
            }else if(input==2){
                keyboard.nextLine();
                String firstName = "";
                String lastName = "";
                String email = "";
                long phoneNumber =0;

                System.out.println("////Creating Author////");
                System.out.print("Enter first name: ");
                firstName = keyboard.nextLine();
                System.out.print("Enter last name: ");
                lastName = keyboard.nextLine();
                System.out.print("Enter email: ");
                email = keyboard.nextLine();
                System.out.print("Enter phone number: ");
                phoneNumber = keyboard.nextInt();
                keyboard.nextLine();

                String title = "";
                String isbn = "";

                System.out.println("        ADD BOOK ");
                System.out.print("               Title: ");
                title = keyboard.nextLine();
                System.out.print("                ISBN: ");
                isbn = keyboard.nextLine();

                books.add(new Book(title,isbn));

                boolean moreBook = true;
                do{
                    System.out.println("Do you want to add more books? (y/n)");
                    if(keyboard.nextLine().equalsIgnoreCase("y")){
                        System.out.println("        ADD BOOK ");
                        System.out.print("               Title: ");
                        title = keyboard.nextLine();
                        System.out.print("                ISBN: ");
                        isbn = keyboard.nextLine();

                        books.add(new Book(title,isbn));
                    } else {
                        moreBook = false;
                        break;
                    }
                }while(moreBook);

                authors.add(new Author(firstName,lastName,email,phoneNumber,books));

                books.clear();
            }
            else if (input==3){
                System.out.println("List of Authors:");
                for (Author author:authors) {
                    System.out.println("First name: "+author.getFirstName());
                    System.out.println("Last name: "+author.getLastName());
                    System.out.println("Email: "+author.getEmailAddress());
                    System.out.println("Phone number: "+author.getPhoneNumber());

                    for (Book book: author.getBook()) {
                        System.out.print("Book wrote: ");
                        System.out.print("-->"+book.getTitle()+" ");
                        System.out.print("-->"+book.getIsbn()+" ");
                    }
                    System.out.println();
                }

            }
        } while (choice != 4);
    }

    public static Author findAuthor(String firstName, String lastName, ArrayList<Author> authors) {

        Author returnAuthor = null;

        for (Author author : authors) {
            if (firstName.equalsIgnoreCase(author.getFirstName()) && lastName.equalsIgnoreCase(author.getLastName())) {
                returnAuthor = author;
            }
        }
        return returnAuthor;
    }


}

package com.techelevator.view;

import com.techelevator.model.Cat;
import com.techelevator.services.CatService;

import java.util.Scanner;

public class CatCardCLI {

    private final CatService catService = new CatService();

    public static void main(String[] args) {

        CatCardCLI app = new CatCardCLI();

        app.run();

    }

    public void run() {

        System.out.println("Welcome to your Cat Card app!" + "\n" );

        //prompt user for numeric selection of desired action
        //action will depend on numeric selection by the user
        System.out.println("Make a selection: (Enter a number 1-5) ");
        System.out.println("1. Add a Cat Card");
        System.out.println("2. Update Cat Card By ID");
        System.out.println("3. Delete Cat Card by ID");
        System.out.println("4. Display Cat Card Collection");
        System.out.println("5. End Program");

        //user input is read as a string so must parse into an integer
        Scanner selectionInput = new Scanner(System.in);
        String selection = selectionInput.nextLine();
        int numSelection = Integer.parseInt(selection);

        //if user enters 1, then prompt them for cat card data to add
        if (numSelection == 1) {

            System.out.println("Add a new cat card!");

            //call a new scanner to read user input specifically for adding new card data
            Scanner toAddInput = new Scanner(System.in);

            System.out.println("Enter name: ");
            String name = toAddInput.nextLine();

//            System.out.println("Enter fact: ");
//            String catFact = toAddInput.nextLine();

//            System.out.println("Enter image URL: ");
//            String imgUrl = toAddInput.nextLine();

            System.out.println("Enter caption: ");
            String caption = toAddInput.nextLine();

            //call a new cat object to be used as an argument for .addCat method
            Cat newCat = new Cat();

            //set new cat card data based on user input
            //cat fact and image data will be automatically generated each time a new card is added
            newCat.setName(name);
            newCat.setCatFact(catService.getFactRandomly().getText()); //generated automatically via api call
            newCat.setImgUrl(catService.getPicRandomly().getFile()); //generated automatically via api call
            newCat.setCaption(caption);

            catService.addCat(newCat);
            System.out.println("New cat card added!");

        }

        //if user enters 2, then prompt them for id to update, item to update, and text to replace current data
        if (numSelection == 2) {

            System.out.println("Which cat card would you like to update? Enter the ID number: ");

            Scanner toUpdateInput = new Scanner(System.in);
            String idToUpdate = toUpdateInput.next();
            long idNum = Long.parseLong(idToUpdate);

            if (idNum > 0) {

                Cat existingCat = catService.getCat(idNum);

                System.out.println(existingCat.getCatCardId() + ": " + existingCat.getName() + "\n" + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: " + existingCat.getCaption() + "\n");

                System.out.println("What card item would you like to update?");
                System.out.println("1. Name");
                System.out.println("2. Fact");
                System.out.println("3. Image");
                System.out.println("4. Caption");

                Scanner cardItemInput = new Scanner(System.in);
                String cardItemToUpdate = cardItemInput.nextLine();
                int updateNum = Integer.parseInt(cardItemToUpdate);

                if (updateNum == 1) {

                    Scanner nameInput = new Scanner(System.in);
                    System.out.println("Enter New Name: ");
                    String newName = nameInput.nextLine();

                    existingCat.setName(newName);
                    catService.update(existingCat);
                    System.out.println(existingCat.getCatCardId() + ": " + existingCat.getName() + "\n" + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: " + existingCat.getCaption() + "\n");
                    System.out.println("This cat card is now updated!");

                }

                if (updateNum == 2) {

                    Scanner factInput = new Scanner(System.in);
                    System.out.println("Enter New Fact: ");
                    String newFact = factInput.nextLine();

                    existingCat.setCatFact(newFact);
                    catService.update(existingCat);
                    System.out.println(existingCat.getCatCardId() + ": " + existingCat.getName() + "\n" + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: " + existingCat.getCaption() + "\n");
                    System.out.println("This cat card is now updated!");

                }

                if (updateNum == 3) {

                    Scanner imageInput = new Scanner(System.in);
                    System.out.println("Enter New Image URL: ");
                    String newImage = imageInput.nextLine();

                    existingCat.setImgUrl(newImage);
                    catService.update(existingCat);
                    System.out.println(existingCat.getCatCardId() + ": " + existingCat.getName() + "\n" + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: " + existingCat.getCaption() + "\n");
                    System.out.println("This cat card is now updated!");

                }

                if (updateNum == 4) {

                    Scanner captionInput = new Scanner(System.in);
                    System.out.println("Enter New Caption: ");
                    String newCaption = captionInput.nextLine();

                    existingCat.setCaption(newCaption);
                    catService.update(existingCat);
                    System.out.println(existingCat.getCatCardId() + ": " + existingCat.getName() + "\n" + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: " + existingCat.getCaption() + "\n");
                    System.out.println("This cat card is now updated!");

                }

                else {

                    System.out.println("Entered card item does not exist.");

                }

            }

            else {

                System.out.println("Entered ID does not exist.");

            }

        }

        //if user enters 3, then prompt them for id to delete, pass it as an argument to delete, then display remaining cards
        if (numSelection == 3) {

            System.out.println("Which cat card would you like to delete? Enter the ID number: ");

            Scanner idInput = new Scanner(System.in);
            String idToDelete = idInput.next();
            long idNum = Long.parseLong(idToDelete);

            if (idNum > 0) {

                Cat catToDelete = catService.getCat(idNum);

                catService.delete(catToDelete);
                System.out.println("Success! This cat card is now deleted!");

                System.out.println("Here are your remaining cat cards: ");

                Cat[] cats = catService.getAllCats();

                for (Cat cat: cats) {
                    System.out.println(cat.getCatCardId() + ": " + cat.getName() + "\n" + "Fun Fact: " + cat.getCatFact() + "\n" + "Image URL: " + cat.getImgUrl() + "\n" + "Caption: " + cat.getCaption() + "\n" );
                }

            }

            else {

                System.out.println("Entered ID does not exist.");

            }

        }

        //if user enters 4, display all cards in the system
        if (numSelection == 4) {

            System.out.println("Here is our cat card collection: " + "\n" );

            Cat[] cats = catService.getAllCats();

            for (Cat cat: cats) {
                System.out.println(cat.getCatCardId() + ": " + cat.getName() + "\n" + "Fun Fact: " + cat.getCatFact() + "\n" + "Image URL: " + cat.getImgUrl() + "\n" + "Caption: " + cat.getCaption() + "\n" );
            }

        }

        //if user enters 5, end the program
        if (numSelection == 5) {

            System.out.println("Program ended!");
            System.exit(0);

        }

    }

}

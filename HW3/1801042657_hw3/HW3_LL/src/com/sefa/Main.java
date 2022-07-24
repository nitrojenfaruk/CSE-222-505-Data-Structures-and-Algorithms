package com.sefa;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Class
 * 
 * @author Sefa Cicek
 */

public class Main{

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            int choice;

            System.out.println("Welcome!");
            System.out.println("1- User Mode");
            System.out.println("2- Driver Mode");
            System.out.println("0- Exit");
            System.out.println("\nChoose the mode: ");

            choice = Integer.parseInt(scan.nextLine());

            if (choice == 1) {
                userMode();
            } else if (choice == 2) {
                double startTime = System.nanoTime();
                driverMode();
                double endTime = System.nanoTime();
                double totalTime = endTime - startTime;
                System.out.println("************");
                System.out.println("--LinkedList");
                System.out.println("Running time: " + (totalTime / 1000000000));
                System.out.println("************");
            } else if (choice == 0) {
                scan.close();
                return;
            } else
                System.out.println("--Invalid choice!");

            scan.close();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    /**
     * Interactive mode. User can add building, delete building etc.
     */
    public static void userMode() {

        Scanner scan = new Scanner(System.in);
        try {
            int sideChoice, position, length, height, numberOfRooms, openingTime, closingTime, choice;
            String color, owner, jobType;
            StreetLL myStreet;

            System.out.print("Enter length of the street: ");
            myStreet = new StreetLL();

            try {
                myStreet.setLength(scan.nextInt());
            } catch (InputMismatchException e) {
                e.printStackTrace();
                scan.close();
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                scan.close();
                return;
            } catch (NegativeArraySizeException e) {
                e.printStackTrace();
                scan.close();
                return;
            }

            System.out.println();
            while (true) {
                System.out.println("1- Editing Mode");
                System.out.println("2- Viewing Mode");
                System.out.println("3- Focus a Building");
                System.out.println("0- Exit");

                switch (scan.nextInt()) {

                    case 1:
                        System.out.println("\n1- Add a Building");
                        System.out.println("2- Delete a Building");
                        myStreet.displayBuildings();
                        choice = scan.nextInt();
                        if (choice == 1) {
                            System.out.print("Choose side of the street (1- Front, 2- Back): ");
                            sideChoice = scan.nextInt();
                            if (sideChoice != 1 && sideChoice != 2) {
                                System.err.println("--Invalid choice!\n");
                                break;
                            }
                            System.out.print(
                                    "Choose building type or playground (1- House, 2- Office, 3- Market, 4- Playground): ");
                            switch (scan.nextInt()) {
                                case 1:
                                    System.out.print("Enter position: ");
                                    position = scan.nextInt();
                                    System.out.print("Enter length: ");
                                    length = scan.nextInt();
                                    System.out.print("Enter height: ");
                                    height = scan.nextInt();
                                    System.out.print("Enter number of rooms: ");
                                    numberOfRooms = scan.nextInt();
                                    System.out.print("Enter color: ");
                                    color = scan.next();
                                    System.out.print("Enter owner: ");
                                    owner = scan.next();
                                    Building house = new House(position, length, height, numberOfRooms, color, owner);
                                    myStreet.addBuilding(sideChoice, house);
                                    break;
                                case 2:
                                    System.out.print("Enter position: ");
                                    position = scan.nextInt();
                                    System.out.print("Enter length: ");
                                    length = scan.nextInt();
                                    System.out.print("Enter height: ");
                                    height = scan.nextInt();
                                    System.out.print("Enter job type: ");
                                    jobType = scan.next();
                                    System.out.print("Enter owner: ");
                                    owner = scan.next();
                                    Building office = new Office(position, length, height, jobType, owner);
                                    myStreet.addBuilding(sideChoice, office);
                                    break;
                                case 3:
                                    System.out.print("Enter position: ");
                                    position = scan.nextInt();
                                    System.out.print("Enter length: ");
                                    length = scan.nextInt();
                                    System.out.print("Enter height: ");
                                    height = scan.nextInt();
                                    System.out.print("Enter owner: ");
                                    owner = scan.next();
                                    System.out.print("Enter opening time: ");
                                    openingTime = scan.nextInt();
                                    System.out.print("Enter closing time: ");
                                    closingTime = scan.nextInt();
                                    Building market = new Market(position, length, height, owner, openingTime,
                                            closingTime);
                                    myStreet.addBuilding(sideChoice, market);
                                    break;
                                case 4:
                                    System.out.print("Enter position: ");
                                    position = scan.nextInt();
                                    System.out.print("Enter length: ");
                                    length = scan.nextInt();
                                    Playground playground = new Playground(position, length);
                                    myStreet.addBuilding(sideChoice, playground);
                                    break;
                                default:
                                    System.err.println("\n--Invalid choice!\n");
                                    break;
                            }

                        } else if (choice == 2) {
                            if (myStreet.displayBuildings()) {
                                System.out.print("Choose side of the street (1- Front, 2- Back): ");
                                sideChoice = scan.nextInt();
                                System.out.print("Enter position of a building or playground to delete: ");
                                position = scan.nextInt();
                                myStreet.deleteBuilding(sideChoice, position);
                            } else
                                System.out.println("--There is no building!");
                        }
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("1- Display the total remaining length of lands");
                        System.out.println("2- Display the list of buildings");
                        System.out.println("3- Display the number and ratio of length of playgrounds");
                        System.out.println(
                                "4- Calculate the total length of street occupied by the markets, houses or offices");
                        System.out.println("5- Display the skyline silhouette of the street");
                        switch (scan.nextInt()) {
                            case 1:
                                System.out.println("\n--Total remaining length: " + myStreet.remainingLength() + "\n");
                                break;
                            case 2:
                                myStreet.displayBuildings();
                                break;
                            case 3:
                                System.out.println("\n--Number: " + myStreet.playgroundNumber());
                                System.out.println("\n--Ratio: " + myStreet.playgroundRatio() + "\n");
                                break;
                            case 4:
                                System.out.println(
                                        "\n--Total length of buildings: " + myStreet.totalBuildingLength() + "\n");
                                break;
                            case 5:
                                System.out.println();
                                myStreet.displaySilhouette();
                                System.out.println();
                                break;
                            default:
                                System.out.println("\n--Invalid choice!\n");
                                break;
                        }

                        break;

                    case 3:
                        if (myStreet.displayBuildings()) {
                            System.out.print("Choose side of the street (1- Front, 2- Back): ");
                            sideChoice = scan.nextInt();
                            System.out.print("Enter position of a building to focus: ");
                            position = scan.nextInt();
                            myStreet.focuseOnBuilding(sideChoice, position);
                        } else
                            System.out.println("--There is no building for focusing!\n");

                        break;

                    case 0:
                        return;

                    default:
                        System.err.println("\n--Invalid choice!\n");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        scan.close();

    }

    /**
     * It demonstrates all possible actions.
     */
    public static void driverMode() {

         /* Creating buildings and playgrounds */
        Building build1 = new House(0, 7, 14, 3, "ocean blue", "sefa"); // front
        Building build2 = new Office(5, 7, 4, "lawyer", "robby"); // back
        Building build3 = new Market(10, 12, 14, "bim", 8, 22); // front
        Building build4 = new House(19, 11, 25, 4, "red", "cicek"); // back

        StreetLL myStreet = new StreetLL();

        /* Set street length */
        try {
            System.out.println("Setting street length -> -20");
            myStreet.setLength(-20);
        } catch (NegativeArraySizeException e) {
            System.out.println("--Invalid street length!");
            e.printStackTrace();
        }

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("Setting street length -> 100");
        myStreet.setLength(100);
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println();

        /* EMPTY STREET PART */
        System.out.println("-----------------------------");
        System.out.println("EMPTY STREET");
        System.out.println("-----------------------------");

        /* Deleting from empty street */
        try {
            System.out.println("Deleting from empty street");
            myStreet.deleteBuilding(1, 5); // sideChoice, position
        } catch (NullPointerException e) {
            System.out.println("Side choice = 1 (front)");
            System.out.println("position = 5");
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display total remaining length */
        System.out.println("Displaying the total remaining length of lands on the street");
        System.out.println("\n--Total remaining length: " + myStreet.remainingLength() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display builldings */
        System.out.println("Displaying the list of buildings on the street");
        if (!myStreet.displayBuildings())
            System.out.println("--There is no building for display!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display the number and ratio of length of playgrounds */
        System.out.println("Display the number and ratio of length of playgrounds");
        System.out.println("\n--Number: " + myStreet.playgroundNumber());
        System.out.println("\n--Ratio: " + myStreet.playgroundRatio() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Total length of street occupied by the markets, houses or offices */
        System.out.println("Display the total length of street occupied by the markets, houses or offices");
        System.out.println("\n--Total length of buildings: " + myStreet.totalBuildingLength() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Focusing on a building */
        System.out.println("Focusing on a building");
        if (myStreet.displayBuildings()) {
            System.out.println("Side of the street (1 -- front)");
            System.out.print("Position of building to focus (3)");
            myStreet.focuseOnBuilding(1, 3);
        } else
            System.out.println("--There is no building for focusing!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Focusing on a playground */
        System.out.println("Focusing on a playground");
        if (myStreet.displayBuildings()) {
            System.out.println("Side of the street (2 -- back)");
            System.out.print("Position of playground to focus (35)");
            myStreet.focuseOnBuilding(2, 35); // sideChoice, position
        } else
            System.out.println("--There is no playground for focusing!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display the skyline silhouette of the street */
        System.out.println("Displaying the skyline silhouette of the street");
        System.out.println();
        myStreet.displaySilhouette();
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("END OF THE EMPTY STREET PART");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println();

        /* Adding buildings and playgrounds */
        System.out.println("Adding buildings to the front of street");
        myStreet.addBuilding(1, build1); // sideChoice, building
        myStreet.addBuilding(1, build3);
        System.out.println("Adding playground to the front of street");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Adding buildings or playground */
        System.out.println("Adding buildings to the back of street");
        myStreet.addBuilding(2, build2); // sideChoice, building
        myStreet.addBuilding(2, build4);
        System.out.println("Adding playground to the back of street");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Adding building or playground to wrong position */
        System.out.println("Adding building or playground to the filled area of street");
        myStreet.addBuilding(1, build1); // sideChoice, building
        myStreet.addBuilding(2, build2);
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        try {
            /* Adding building or playground to outside of street */
            System.out.println("Adding building or playground to the outside of street");
            System.out.println(build3);
            System.out.println(build4);
            myStreet.addBuilding(1, build3); // sideChoice, building
            myStreet.addBuilding(2, build4);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Deleting from empty position of the street */
        try {
            System.out.println("Deleting from empty position of the street");
            System.out.println("position = 25");
            myStreet.deleteBuilding(1, 25); // sideChoice, position
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Deleting from outside of the street */
        try {
            System.out.println("Deleting from outside of the street");
            System.out.println("position = 150 (street length = 100)");
            myStreet.deleteBuilding(1, 150); // sideChoice, position
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Deleting from street */
        System.out.println("Deleting from the street (correct input - position = 70)");
        myStreet.deleteBuilding(2, 20); // sideChoice, position
        //myStreet.deleteBuilding(2, 70); // sideChoice, position
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        System.out.println("Adding last deleted building to the street");
        myStreet.addBuilding(2, build4); // sideChoice, position
        //myStreet.addBuilding(2, build10); // sideChoice, position
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display total remaining length */
        System.out.println("Displaying the total remaining length of lands on the street");
        System.out.println("\n--Total remaining length: " + myStreet.remainingLength() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display builldings */
        System.out.println("Displaying the list of buildings on the street");
        if (!myStreet.displayBuildings())
            System.out.println("--There is no building for display!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display the number and ratio of length of playgrounds */
        System.out.println("Display the number and ratio of length of playgrounds");
        System.out.println("\n--Number: " + myStreet.playgroundNumber());
        System.out.println("\n--Ratio: " + myStreet.playgroundRatio() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Total length of street occupied by the markets, houses or offices */
        System.out.println("Display the total length of street occupied by the markets, houses or offices");
        System.out.println("\n--Total length of buildings: " + myStreet.totalBuildingLength() + "\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Focusing on a building */
        System.out.println("Focusing on a building");
        if (myStreet.displayBuildings()) {
            System.out.println("Side of the street (1 -- front)");
            System.out.print("Position of building to focus (3)");
            myStreet.focuseOnBuilding(1, 3);
        } else
            System.out.println("--There is no building for focusing!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Focusing on a playground */
        System.out.println("Focusing on a playground");
        if (myStreet.displayBuildings()) {
            System.out.println("Side of the street (2 -- back)");
            System.out.print("Position of playground to focus (35)");
            myStreet.focuseOnBuilding(2, 35); // sideChoice, position
        } else
            System.out.println("--There is no playground for focusing!\n");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        /* Display the skyline silhouette of the street */
        System.out.println("Displaying the skyline silhouette of the street");
        System.out.println();
        myStreet.displaySilhouette();
        System.out.println();
    }

}
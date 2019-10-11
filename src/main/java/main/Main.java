package main;

import commands.CheckCommand;
import commands.DisplayCommand;
import commands.RemoveCommand;
import commands.UpdateCommand;
import entity.Guest;
import entity.GuestList;

import java.util.Scanner;

public class Main {
    private static CheckCommand checkCommand = new CheckCommand();
    private static commands.commands.AddCommand addCommand = new commands.commands.AddCommand();
    private static RemoveCommand removeCommand = new RemoveCommand();
    private static UpdateCommand updateCommand = new UpdateCommand();
    private static commands.commands.SearchCommand searchCommand = new commands.commands.SearchCommand();
    private static DisplayCommand displayCommand = new DisplayCommand();

    public static GuestList gL = new GuestList(1, 5);

    public static void help() {
        System.out.println("help - Show the commands available\n" +
                "add - Add a new guest)\n" +
                "check - Check if a person is registered for the event\n" +
                "remove - Remove a person\n" +
                "update - Update the details of a guest\n" +
                "guests - The list of people that are registered for the event\n" +
                "waitlist - The list of guests on the waiting list\n" +
                "available - The number of spots available\n" +
                "guests_no - The number of guests that participate at the event\n" +
                "waitlist_no - The number of guests on the waiting list\n" +
                "subscribe_no - The total number of guests signed up\n" +
                "search - Look for all the guests according to the substring\n" +
                "quit - Close the application ");
        System.out.println();
    }



    public static void main(String[] args) {
        initDemoData(gL);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to DevMind event!");
        System.out.println("Waiting for the command: (help - show the commands available)");

        while (true) {
            String option = "";
            option = scanner.nextLine();
            switch (option) {
                case "help":
                    help();
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "add":
                    addCommand.add(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "check":
                    checkCommand.check(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "remove":
                    removeCommand.remove(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "update":
                    updateCommand.update(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "guests":
                    displayCommand.displayGuestsList(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "waitlist":
                    displayCommand.displayWaitList(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "available":
                    displayCommand.displayAvailable(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "guests_no":
                    displayCommand.displayNoGuests(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "waitlist_no":
                    displayCommand.displayWaitListNo(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "subscribe_no":
                    displayCommand.displayTotal(gL);
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "search":
                   searchCommand.search(gL);
                   gL.getNewList().clear();
                    System.out.println("Waiting for the command: (help - show the comands available");
                    break;
                case "quit":
                    System.out.println("The app is closing...");
                    System.exit(0);
            }

        }
    }


    static void initDemoData(GuestList guestList) {
        Guest guest = new Guest("last", "firstName", "email", "123");
        gL.getGuestList().add(guest);
        guest = new Guest("last", "f", "e", "1");
        gL.getGuestList().add(guest);
        guest = new Guest("Ionescu", "Mircea", "kkk", "0722222222");
        gL.getGuestList().add(guest);

    }
}






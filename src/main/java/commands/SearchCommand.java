package commands.commands;

import entity.GuestList;
import find.FindService;
import read.InputService;

import java.util.Scanner;

public class SearchCommand {
    private InputService inputService = new InputService();
    private FindService findService = new FindService();


    public void search(GuestList guestList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the list of characters: ");
        String substring = scanner.nextLine();
        substring = substring.toLowerCase();

        findService.addBySubstring(guestList, substring);
        showParticipants(guestList);


    }


    void showParticipants(GuestList guestList) {
        for (int i = 0; i < guestList.getNewList().size(); i++) {
            System.out.println("Last name: " + guestList.getNewList().get(i).getLastName()
                    + "\nFirst name: " + guestList.getNewList().get(i).getFirstName()
                    + "\nE-mail address: " + guestList.getNewList().get(i).getEmail()
                    + "\nPhone number: " + guestList.getNewList().get(i).getPhoneNumber());
            System.out.println();
        }
    }
}

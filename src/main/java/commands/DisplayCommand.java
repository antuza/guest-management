package commands;

import entity.GuestList;

public class DisplayCommand {
    public void displayGuestsList(GuestList guestList) {
        if(guestList.getGuestList().size() == 0) {
            System.out.println("The guests list is empty!");
            return;
        }
        for (int i = 0; i < guestList.getGuestList().size(); i++) {
            System.out.println("Last name: " + guestList.getGuestList().get(i).getLastName()
                    + "\nFirst name: " + guestList.getGuestList().get(i).getFirstName()
                    + "\nE-mail address: " + guestList.getGuestList().get(i).getEmail()
                    + "\nPhone number: " + guestList.getGuestList().get(i).getPhoneNumber());
            System.out.println();
        }
    }

    public void displayWaitList(GuestList guestList) {
        if (guestList.getWaitingList().size() == 0) {
            System.out.println("The wait list is empty!");
            return;
        }
        for (int i = 0; i < guestList.getWaitingList().size(); i++) {
            System.out.println("Last name: " + guestList.getWaitingList().get(i).getLastName()
                    + "\nFirst name: " + guestList.getWaitingList().get(i).getFirstName()
                    + "\nE-mail address: " + guestList.getWaitingList().get(i).getEmail()
                    + "\nPhone number: " + guestList.getWaitingList().get(i).getPhoneNumber());
            System.out.println();
        }
    }

    public void displayAvailable(GuestList guestList) {
        System.out.print("The number of available spots is: ");
        System.out.println(guestList.getNoSpots() - guestList.getGuestList().size());
    }

    public void displayNoGuests(GuestList guestList) {
        System.out.print("The number of guests is: ");
        System.out.println(guestList.getGuestList().size());
    }

    public void displayWaitListNo(GuestList guestList) {
        System.out.print("The number of people that are on the waiting list is: ");
        System.out.println(guestList.getWaitingList().size());
    }

    public void displayTotal (GuestList guestList) {
        System.out.print("The total number in the lists is: ");
        System.out.println(guestList.getGuestList().size() + guestList.getWaitingList().size());
    }
}

package commands.commands;

import entity.Guest;
import entity.GuestList;
import find.FindService;
import read.InputService;

public class AddCommand {
    private InputService inputService = new InputService();
    private FindService findService = new FindService();

    public int add(GuestList guestList) {
        Guest guest = inputService.readGuest();

        if (findService.isGuestRegisteredInGuestList(guestList, guest)) {
            System.out.println("The person is already registered!");
            return -1;
        }
        if (guestList.getNoSpots() > 0) {
            guestList.getGuestList().add(guest);
            guestList.setNoSpots(guestList.getNoSpots() - 1);
            System.out.println("Congratulations! Your place at the event is reserved! Can't wait to meet you!");
            return 0;
        } else {
            guestList.setNoSpots(guestList.getNoSpots() - 1);
            System.out.println("You have successfully registered on the waiting list and received the " +
                    guestList.getWaitingList().size() +
                    " order number. We will notify you if a seat becomes available.");
            return guestList.getWaitingList().size();
        }
    }
}

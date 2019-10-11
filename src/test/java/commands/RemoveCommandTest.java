package commands;

import entity.Guest;
import entity.GuestList;
import read.InputService;
import read.Operation;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class RemoveCommandTest {

    @org.junit.Test
    public void remove() {
        RemoveCommand removeCommand = new RemoveCommand();
        GuestList guestList = new GuestList(3, 2);
        Guest guest1 = new Guest("l", "f", "e", "p");
        Guest guest2 = new Guest("l2", "f2", "e2", "p2");
        Guest guest3 = new Guest("l3", "f3", "e3", "p3");
        guestList.getGuestList().add(guest1);
        guestList.getGuestList().add(guest2);
        guestList.getGuestList().add(guest3);

        removeCommand.removeInternal(guestList, new Operation(InputService.EMAIL_OPERATION, Arrays.asList("e2")));


        assert guestList.getGuestList().size() == 2;
        assert guestList.getGuestList().get(0).getFirstName().equals("f");
        assert guestList.getGuestList().get(1).getFirstName().equals("f3");
    }

    @org.junit.Test
    public void removeWithShift() {
        String input = "1 \nf";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RemoveCommand removeCommand = new RemoveCommand();

        GuestList guestList = new GuestList(3, 2);
        Guest guest1 = new Guest("l", "f", "e", "p");
        Guest guest2 = new Guest("l2", "f2", "e2", "p2");
        Guest guest3 = new Guest("l3", "f3", "e3", "p3");
        Guest guest4 = new Guest("l4", "f4", "e4", "p4");
        guestList.getGuestList().add(guest1);
        guestList.getGuestList().add(guest2);
        guestList.getGuestList().add(guest3);
        guestList.getWaitingList().add(guest4);

        removeCommand.removeInternal(guestList, new Operation(InputService.EMAIL_OPERATION, Arrays.asList("e2")));

        assert guestList.getGuestList().size() == 3;
        assert guestList.getGuestList().get(0).getFirstName().equals("f");
        assert guestList.getGuestList().get(1).getFirstName().equals("f3");
        assert guestList.getGuestList().get(2).getFirstName().equals("f4");
        assert guestList.getWaitingList().size() == 0;
    }
}
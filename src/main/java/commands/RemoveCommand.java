package commands;


import entity.Guest;
import entity.GuestList;
import find.FindService;
import find.SearchResult;
import read.InputService;
import read.Operation;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand {
    InputService inputService = new InputService();
    private FindService findService = new FindService();

    public void remove(GuestList guestList) {
        System.out.println("Please choose the log-in type!");

        Operation operation = inputService.readOperation();

        removeInternal(guestList, operation);
    }

    void removeInternal(GuestList guestList, Operation operation) {
        switch (operation.getType()) {
            case InputService.NAME_OPERATION:
                String lastName = operation.getParameters().get(0);
                String firstName = operation.getParameters().get(1);
                SearchResult byName = findService.findByName(guestList, lastName, firstName);
                handleSearchResult(byName, guestList);
                break;
            case InputService.EMAIL_OPERATION:
                String email = operation.getParameters().get(0);
                SearchResult byEmail = findService.findByEmail(guestList, email);
                handleSearchResult(byEmail, guestList);
                break;
            case InputService.PHONE_OPERATION:
                String phone = operation.getParameters().get(0);
                SearchResult byPhoneNumber = findService.findByPhoneNumber(guestList, phone);
                handleSearchResult(byPhoneNumber, guestList);
                break;
            case InputService.UNKNOWN_OPERATION:
                System.out.println("Unknown command!");
                break;
        }
    }

    private void handleSearchResult(SearchResult searchResult, GuestList guestList) {
        if (searchResult.getGuestListIndex() != FindService.NOT_FOUND) {
            removeFromGuestList(searchResult, guestList);
        } else if (searchResult.getWaitingListIndex() != FindService.NOT_FOUND) {
            guestList.getWaitingList().remove(searchResult.getWaitingListIndex());
            System.out.println("The person was removed from the wait list!");
        } else {
            System.out.println("Person was not found!");
        }
    }

    private void removeFromGuestList(SearchResult searchResult, GuestList guestList) {

        if (guestList.getWaitingList().size() > 0) {
            guestList.getGuestList().remove(searchResult.getGuestListIndex());
            guestList.getGuestList().add(guestList.getWaitingList().get(0));
            List<Guest> newList = new ArrayList<>();
            guestList.getWaitingList().remove(0);
            newList.addAll(guestList.getWaitingList());
            guestList.setWaitingList(newList);
            System.out.println("The first person in the wait list was added to the guests list.");
        } else {
            guestList.getGuestList().remove(searchResult.getGuestListIndex());
        }
        System.out.println("The person was removed from the guests list!");
    }
}

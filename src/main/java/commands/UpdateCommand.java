package commands;

import entity.Guest;
import entity.GuestList;
import find.FindService;
import find.SearchResult;
import read.InputService;
import read.Operation;

public class UpdateCommand {
    private FindService findService = new FindService();
    private InputService inputService = new InputService();

    public void update(GuestList guestList) {
        System.out.println("Please choose the log-in type!");

        Operation findOperation = inputService.readOperation();
        Operation updateOperation = inputService.readOperationWithSplitName();
        checkToUpdate(guestList, findOperation, updateOperation);

    }

    void checkToUpdate(GuestList guestList, Operation operation, Operation updateOperation) {
        switch (operation.getType()) {
            case InputService.NAME_OPERATION:
                String lastName = operation.getParameters().get(0);
                String firstName = operation.getParameters().get(1);
                SearchResult byName = findService.findByName(guestList, lastName, firstName);
                handleSearchResult(byName, guestList, updateOperation);
                break;
            case InputService.EMAIL_OPERATION:
                String email = operation.getParameters().get(0);
                SearchResult byEmail = findService.findByEmail(guestList, email);
                handleSearchResult(byEmail, guestList, updateOperation);
                break;
            case InputService.PHONE_OPERATION:
                String phone = operation.getParameters().get(0);
                SearchResult byPhoneNumber = findService.findByPhoneNumber(guestList, phone);
                handleSearchResult(byPhoneNumber, guestList, updateOperation);
                break;
            case InputService.UNKNOWN_OPERATION:
                System.out.println("Unknown command!");
                break;
        }
    }

    void checkByUser(Guest guest, Operation updateOperation) {
        switch (updateOperation.getType()) {
            case InputService.LAST_NAME_OPERATION:
                String lastName = updateOperation.getParameters().get(0);
                guest.setLastName(lastName);
                break;
            case InputService.FIRST_NAME_OPERATION:
                String firstName = updateOperation.getParameters().get(0);
                guest.setFirstName(firstName);
                break;
            case InputService.EMAIL_OPERATION:
                String email = updateOperation.getParameters().get(0);
                guest.setEmail(email);
                break;
            case InputService.PHONE_OPERATION:
                String phoneNumber = updateOperation.getParameters().get(0);
                guest.setPhoneNumber(phoneNumber);
                break;
            case InputService.UNKNOWN_OPERATION:
                System.out.println("Unknown command!");
                break;
        }

    }

    void handleSearchResult(SearchResult searchResult, GuestList guestList, Operation updateOperation) {
        if (searchResult.getGuestListIndex() != FindService.NOT_FOUND) {
            checkByUser(guestList.getGuestList().get(searchResult.getGuestListIndex()), updateOperation);
        } else if (searchResult.getWaitingListIndex() != FindService.NOT_FOUND) {
            checkByUser(guestList.getWaitingList().get(searchResult.getWaitingListIndex()), updateOperation);
        } else if (searchResult.getGuestListIndex() == -1 && searchResult.getGuestListIndex() == -1) {
            System.out.println("Person is not registered!");
        }
    }
}






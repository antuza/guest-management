package commands;

import entity.GuestList;
import find.FindService;
import find.SearchResult;
import read.InputService;
import read.Operation;

public class CheckCommand {
    private FindService findService = new FindService();
    private InputService inputService = new InputService();

    public void check(GuestList guestList) {
        System.out.println("How do you want to search for our guest? " +
                "Please choose between last name and first name, phone number or e-mail address");

        Operation operation = inputService.readOperation();

        switch (operation.getType()) {
            case InputService.NAME_OPERATION:
                String lastName = operation.getParameters().get(0);
                String firstName = operation.getParameters().get(1);
                SearchResult byName = findService.findByName(guestList,
                        lastName,
                        firstName);
                handleSearchResult(byName);
                break;
            case InputService.EMAIL_OPERATION:
                String email = operation.getParameters().get(0);
                SearchResult byEmail = findService.findByEmail(guestList, email);
                handleSearchResult(byEmail);
                break;
            case InputService.PHONE_OPERATION:
                String phoneNumber = operation.getParameters().get(0);
                SearchResult byPhoneNumber = findService.findByPhoneNumber(guestList, phoneNumber);
                handleSearchResult(byPhoneNumber);
                break;
            case InputService.UNKNOWN_OPERATION:
                System.out.println("Unknown command!");
                break;
        }
    }

    private void handleSearchResult(SearchResult searchResult) {
        if (searchResult.getGuestListIndex() != FindService.NOT_FOUND
                || searchResult.getWaitingListIndex() != FindService.NOT_FOUND) {
            System.out.println("Person is registered!");
        } else {
            System.out.println("Person is not registered!");
        }
    }
}

package find;

import entity.Guest;
import entity.GuestList;
import read.Operation;

import java.util.List;

import static read.InputService.*;

public class FindService {
    public static final int NOT_FOUND = -1;

    public SearchResult findByOperation(GuestList guestList, Operation operation) {
        switch (operation.getType()) {
            case NAME_OPERATION:
                return findByName(guestList, operation.getParameters().get(0), operation.getParameters().get(1));
            case EMAIL_OPERATION:
                return findByEmail(guestList, operation.getParameters().get(0));
            case PHONE_OPERATION:
                return findByPhoneNumber(guestList, operation.getParameters().get(0));
            default:
                return new SearchResult(NOT_FOUND, NOT_FOUND);

        }
    }

    public SearchResult findByName(GuestList guestList, String lastName, String firstName) {
        int guestListIndex = findByNameInList(lastName, firstName, guestList.getGuestList());
        int waitingListIndex = findByNameInList(lastName, firstName, guestList.getWaitingList());
        return new SearchResult(
                guestListIndex,
                waitingListIndex
        );
    }

    public SearchResult findByEmail(GuestList guestList, String email) {
        int guestListIndex = findByEmailInList(email, guestList.getGuestList());
        int waitingListIndex = findByEmailInList(email, guestList.getWaitingList());
        return new SearchResult(
                guestListIndex,
                waitingListIndex
        );
    }

    public SearchResult findByPhoneNumber(GuestList guestList, String phoneNumber) {
        int guestListIndex = findByPhoneInList(phoneNumber, guestList.getGuestList());
        int waitingListIndex = findByPhoneInList(phoneNumber, guestList.getWaitingList());
        return new SearchResult(
                guestListIndex,
                waitingListIndex
        );
    }

    public void addBySubstring(GuestList guestList, String subString) {
       findBySubstringInList(subString, guestList.getGuestList(),guestList);
       findBySubstringInList(subString, guestList.getWaitingList(), guestList);
    }


    public boolean isGuestRegisteredInGuestList(GuestList guestList, Guest guest) {
        SearchResult byName = findByName(guestList, guest.getLastName(), guest.getFirstName());
        SearchResult byPhoneNumber = findByPhoneNumber(guestList, guest.getPhoneNumber());
        SearchResult byEmail = findByEmail(guestList, guest.getEmail());

        if (byName.getGuestListIndex() != FindService.NOT_FOUND
                || byName.getWaitingListIndex() != FindService.NOT_FOUND) {
            return true;
        } else if (byPhoneNumber.getGuestListIndex() != FindService.NOT_FOUND
                || byPhoneNumber.getWaitingListIndex() != FindService.NOT_FOUND) {
            return true;
        } else return byEmail.getGuestListIndex() != -1
                || byEmail.getWaitingListIndex() != -1;
    }

    private int findBySubstringInList(String subString, List<Guest> listToSearchIn, GuestList guestlist) {
        for(int i = 0; i < listToSearchIn.size(); i++) {
            Guest guest = listToSearchIn.get(i);
            if(guest.getLastName().toLowerCase().contains(subString) || guest.getFirstName().toLowerCase().contains(subString) ||
            guest.getEmail().toLowerCase().contains(subString) || guest.getPhoneNumber().toLowerCase().contains(subString)) {
                guestlist.getNewList().add(guest);
            }
        }
        return NOT_FOUND;
    }


    private int findByNameInList(String lastName, String firstName, List<Guest> listToSearchIn) {
        for (int i = 0; i < listToSearchIn.size(); i++) {
            Guest guest = listToSearchIn.get(i);
            if (guest.getLastName().equals(lastName) && guest.getFirstName().equals(firstName)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int findByEmailInList(String email, List<Guest> listToSearchIn) {
        for (int i = 0; i < listToSearchIn.size(); i++) {
            Guest guest = listToSearchIn.get(i);
            if (guest.getEmail().equals(email)) {
                return i;
            }
        }
        return NOT_FOUND;
    }


    private int findByPhoneInList(String phone, List<Guest> listToSearchIn) {
        for (int i = 0; i < listToSearchIn.size(); i++) {
            Guest guest = listToSearchIn.get(i);
            if (guest.getPhoneNumber().equals(phone)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

}

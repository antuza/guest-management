package entity;

import java.util.ArrayList;
import java.util.List;

public class GuestList {
    int noSpots;
    int noSpotsWaiting;
    public List<Guest> guestList;
    public List<Guest> waitingList;

    public List<Guest> newList = new ArrayList<>();

    public void setNoSpots(int noSpots) {
        this.noSpots = noSpots;
    }

    public void setNoSpotsWaiting(int noSpotsWaiting) {
        this.noSpotsWaiting = noSpotsWaiting;
    }


    public void setWaitingList(List<Guest> waitingList) {
        this.waitingList = waitingList;
    }

    public GuestList(int noSpots, int noSpotsWaiting) {
        super();
        this.noSpots = noSpots;
        this.noSpotsWaiting = noSpotsWaiting;
        guestList = new ArrayList<Guest>(this.noSpots);
        waitingList = new ArrayList<Guest>(this.noSpotsWaiting);
    }

    public int getNoSpots() {
        return noSpots;
    }

    public int getNoSpotsWaiting() {
        return noSpotsWaiting;
    }


    public List<Guest> getGuestList() {
        return guestList;
    }

    public List<Guest> getWaitingList() {
        return waitingList;
    }

    public List<Guest> getNewList() {
        return newList;
    }

    public int size() {
        return guestList.size();
    }

    public int sizeWaiting() {
        return waitingList.size();
    }


}

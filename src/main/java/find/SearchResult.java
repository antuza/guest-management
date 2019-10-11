package find;

public class SearchResult {
    private int guestListIndex;
    private int waitingListIndex;

    public SearchResult(int guestListIndex, int waitingListIndex) {
        this.guestListIndex = guestListIndex;
        this.waitingListIndex = waitingListIndex;
    }

    public int getWaitingListIndex() {
        return waitingListIndex;
    }

    public int getGuestListIndex() {
        return guestListIndex;
    }
}

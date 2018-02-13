public class Teller extends Event{

    private int workingDuration;
    private boolean isFree;
    private final int SSN;
    private int freeTime;

    public Teller(int SSN){
        workingDuration = 0;
        isFree = true;
        this.SSN = SSN;
        freeTime = 0;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getWorkingDuration() {
        return workingDuration;
    }

    public int getSSN() {
        return SSN;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void addWorkingDuration(int duration){
        workingDuration += duration;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    @Override
    public String toString() {
        return "Teller " + SSN + " has worked for " + Timer.numToTime(workingDuration);
    }
}
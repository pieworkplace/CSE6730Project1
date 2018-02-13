import java.util.ArrayList;
import java.util.List;

public class TellerWindows {

    private List<Teller> windows;

    public TellerWindows(int windowNum){
        windows = new ArrayList<>();
        for(int i = 0; i < windowNum; i++){
            windows.add(new Teller(i));
        }
    }

    public Teller checkFreeTeller(){
        for (Teller teller : windows) {
            if (teller.isFree()) {
                return teller;
            }
        }
        return null;
    }

    public int checkFreeTellerNum(){
        int num = 0;
        for (Teller teller : windows){
            if (teller.isFree()){
                num++;
            }
        }
        return num;
    }

    public int averageServiceTime(){
        int averageServiceTime = 0;
        for (Teller teller : windows){
            averageServiceTime += teller.getWorkingDuration();
        }
        return averageServiceTime / windows.size();
    }
}

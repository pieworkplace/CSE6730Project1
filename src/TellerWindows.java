import java.util.ArrayList;
import java.util.List;

public class TellerWindows {

    private int windowNum;
    private List<Teller> windows;

    public TellerWindows(int windowNum){
        this.windowNum = windowNum;
        windows = new ArrayList<>();
        for(int i = 0; i < windowNum; i++){
            windows.add(new Teller());
        }
    }

}

package sample;

public class testTime {

	public static void main(String[] args) {
		int seconds = 0;
        seconds++;

        int minutes = seconds / 60;

        seconds = seconds % 60;

        for(;minutes>=1;seconds++) {
        	
        }
        System.out.println(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

        if (minutes >= 1) {
            responseDelegate.stopTimer();
            responseDelegate.setTimeProgress(60);
            return;
        }

        if (seconds == 0) {
            seconds = 1;
        }
        
	}

}

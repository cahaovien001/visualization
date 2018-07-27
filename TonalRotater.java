public class TonalRotater {
    public static void main(String... args) {
	String MAJOR = "TWWHWWWH";

	for (int i=0; i<8; i++) {
	    mutateAndPrintTones(MAJOR, i);
	}	
    }
    
    public static void mutateAndPrintTones(String tones, int timesRotate) {
	mutateTones(tones, timesRotate);
    }

    public static void printTones(String tones) {
	System.out.print("Tones: ");
	System.out.print(tones);
	System.out.println();
    }

    public static void mutateTones(String tones, int timesRotate) {
	StringBuilder sb = new StringBuilder();

	while (timesRotate-- > 0)
	    tones = tones.charAt(0)
		+ rotateLeftString(tones.substring(1, tones.length()));

	sb.append(tones);

	printTones(sb.toString());
    }

    public static String rotateLeftString(String stringToBeRotated) {
	StringBuilder sb = new StringBuilder();

	for(int i=1; i<stringToBeRotated.length(); i++) 
	    sb.append(stringToBeRotated.charAt(i));

	sb.append(stringToBeRotated.charAt(0));

	return sb.toString();
    }

}
    
	

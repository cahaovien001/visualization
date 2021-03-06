public class FullTonalCombinator {
    public static void main(String... args) {
	String MAJOR = "TWWHWWWH";
	StringBuilder sb = new StringBuilder();
	
	for (int i=1; i<8; i++) {
	    for (int j=1; j<8; j++) {
		for (int k=1; k<8; k++) {
		    for (int l=1; l<8; l++) {
			for (int m=1; m<8; m++) {
			    for (int n=1; n<8; n++) {
				for (int o=1; o<8; o++) {
				    if (i != j &&
					i != k &&
					i != l &&
					i != m &&
					i != n &&
					i != o &&
					j != k &&
					j != l &&
					j != m &&
					j != n &&
					j != o &&
					k != l &&
					k != m &&
					k != n &&
					k != o &&
					l != m &&
					l != n &&
					l != o &&
					m != n &&
					m != o &&
					n != o ) {
					// debug: System.out.println(i + " " +
					//		   j + " " +
					//		   k + " " +
					//		   l + " " +
					//		   m + " " +
					//		   n + " " +
					//		   o);
					sb.append(MAJOR.charAt(0));
					sb.append(MAJOR.charAt(i));
					sb.append(MAJOR.charAt(j));
					sb.append(MAJOR.charAt(k));
					sb.append(MAJOR.charAt(l));
					sb.append(MAJOR.charAt(m));
					sb.append(MAJOR.charAt(n));
					sb.append(MAJOR.charAt(o));
					printTones(sb.toString());
					sb = new StringBuilder();
				    }
				}
			    }
			}
		    }
		}
	    }
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
    
	

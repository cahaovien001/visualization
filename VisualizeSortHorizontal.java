public class VisualizeSortHorizontal {
    public static void selection_sort(int[] A) {
	int key;
	int index;
	int i, j;

	key   = Integer.MAX_VALUE;
	index = Integer.MAX_VALUE;
	for(i = 0; i < A.length; i++) {
	    for(j = i; j < A.length; j++) {
		if ( A[j] < key ) { // min function
		    key   = A[j];
		    index = j;
		} else {
		    continue;
		}
	    }
	    A[index] = A[i];
	    A[i]     = key;
	    printChessVisualization(A);
	    key      = Integer.MAX_VALUE;
	    index    = Integer.MAX_VALUE;
	}
    }

    
    public static void sort(int[] A) {
	int key;
	int i, j;
	for(j = 1; j < A.length; j++) {
	    key = A[j];
	    i = j - 1;
	    while( i >= 0 && A[i] > key ) {
		A[i+1] = A[i];
		i = i-1;
		printVisualization(A);
	    }
	    A[i+1] = key;
	}
    }
    
    public static void merge_sort(int[] A, int p, int r) {
	int q;
	
	if (p < r) {
	    q = (int) Math.floor((p+r)/2);
	    merge_sort(A, p, q);
	    merge_sort(A, q+1, r);
	    merge(A, p, q, r);
	}
    }
    
    public static void merge(int[] A, int p, int q, int r) {
	int n1 = q - p + 2;
	int n2 = r - q + 1;

	int L[] = new int[n1+1];
	int R[] = new int[n2+1];
	
	// Copy
	for (int i=1; i<n1; i++)
	    L[i] = A[p+i-1];
	for (int j=1; j<n2; j++)
	    R[j] = A[q+j];

	L[n1] = Integer.MAX_VALUE;
	R[n2] = Integer.MAX_VALUE;
	int i = 1;
	int j = 1;
	for (int k = p; k <= r; k++) {
	    if (L[i] < R[j])  {
		A[k] = L[i];
		i = i+1;
		printChessVisualization(A);
	    } else {
		A[k] = R[j];
		j = j+1;
		printChessVisualization(A);
	    }
	}
    }

    public static void deleteBoxes(int max) {
	for (int i = 0; i<max; i++) {
	    System.out.print(String.format("\033[%dA", 1));
	    System.out.print("\033[2K");
	}
    }

    public static void printNumbersRow(int[] A) {
	final String ONE_BAGUA     = "☰";
	final String TWO_BAGUA     = "☱";
	final String THREE_BAGUA   = "☲";
	final String FOUR_BAGUA    = "☳";
	final String FIVE_BAGUA    = "☴";
	final String SIX_BAGUA     = "☵";
	final String SEVEN_BAGUA   = "☶";
	final String EIGHT_BAGUA   = "☷";
	final String WHITE_ONE     = "➀";
	final String WHITE_TWO     = "➁";
	final String WHITE_THREE   = "➂";
	final String WHITE_FOUR    = "➃";
	final String WHITE_FIVE    = "➄";
	final String WHITE_SIX     = "➅";
	final String WHITE_SEVEN   = "➆";
	final String WHITE_EIGHT   = "➇";
	final String WHITE_NINE    = "➈";
	final String WHITE_TEN     = "➉";
	final String BLACK_SIX     = "➏";
	
        for (int i=0; i<A.length; i++) {
	    switch(A[i]%11) {
	    case 1: System.out.print(WHITE_ONE);
		break;
	    case 2: System.out.print(WHITE_TWO);
		break;
	    case 3: System.out.print(WHITE_THREE);
		break;
	    case 4: System.out.print(WHITE_FOUR);
		break;
	    case 5: System.out.print(WHITE_FIVE);
		break;
	    case 6: System.out.print(WHITE_SIX);
		break;
	    case 7: System.out.print(WHITE_SEVEN);
		break;
	    case 8: System.out.print(WHITE_EIGHT);
		break;
	    case 9: System.out.print(WHITE_NINE);
		break;
	    case 10: System.out.print(WHITE_TEN);
		break;
	    default:
		System.out.print(BLACK_SIX);
		break;
	    }
	}
	System.out.println();
    }

    public static void printChessPiecesRow(int[] A) {
	final String CHESS_ONE           = "♖";
	final String CHESS_TWO           = "♘";
	final String CHESS_THREE         = "♗";
	final String CHESS_FOUR          = "♕";
	final String CHESS_FIVE          = "♔";
	final String CHESS_SIX           = "♗";
	final String CHESS_SEVEN         = "♘";
	final String CHESS_EIGHT         = "♖";
	final String CHESS_NINE          = "♙";
	final String CHESS_TEN           = "♙";
	final String CHESS_ELEVEN        = "♙";
	final String CHESS_TWELVE        = "♙";
	final String CHESS_THIRTEEN      = "♙";
	final String CHESS_FOURTEEN      = "♙";
	final String CHESS_FIFTEEN       = "♙";
	final String CHESS_SIXTEEN       = "♙";
	final String CHESS_SEVENTEEN     = "♜";
	final String CHESS_EIGHTEEN      = "♞";
	final String CHESS_NINETEEN      = "♝";
	final String CHESS_TWENTY        = "♚";
	final String CHESS_TWENTYONE     = "♛";
	final String CHESS_TWENTYTWO     = "♝";
	final String CHESS_TWENTYTHREE   = "♞";
	final String CHESS_TWENTYFOUR    = "♜";
	final String CHESS_TWENTYFIVE    = "♟";
	final String CHESS_TWENTYSIX     = "♟";
	final String CHESS_TWENTYSEVEN   = "♟";
	final String CHESS_TWENTYEIGHT   = "♟";
	final String CHESS_TWENTYNINE    = "♟";
	final String CHESS_THIRTY        = "♟";
	final String CHESS_THIRTYONE     = "♟";
	final String CHESS_THIRTYTWO     = "♟";
		
        for (int i=0; i<A.length; i++) {
	    switch(A[i]%32) {
	    case 0: System.out.print(CHESS_ONE);
		break;
	    case 1: System.out.print(CHESS_THREE);
		break;
	    case 2: System.out.print(CHESS_THREE);
		break;
	    case 3: System.out.print(CHESS_FOUR);
		break;
	    case 4: System.out.print(CHESS_FIVE);
		break;
	    case 5: System.out.print(CHESS_SIX);
		break;
	    case 6: System.out.print(CHESS_SEVEN);
		break;
	    case 7: System.out.print(CHESS_EIGHT);
		break;
	    case 8: System.out.print(CHESS_NINE);
		break;
	    case 9: System.out.print(CHESS_TEN);
		break;
	    case 10: System.out.print(CHESS_ELEVEN);
		break;
	    case 11: System.out.print(CHESS_TWELVE);
		break;
	    case 12: System.out.print(CHESS_THIRTEEN);
		break;
	    case 13: System.out.print(CHESS_FOURTEEN);
		break;
	    case 14: System.out.print(CHESS_FIFTEEN);
		break;
	    case 15: System.out.print(CHESS_SIXTEEN);
		break;
	    case 16: System.out.print(CHESS_SEVENTEEN);
		break;
	    case 17: System.out.print(CHESS_EIGHTEEN);
		break;
	    case 18: System.out.print(CHESS_NINETEEN);
		break;
	    case 19: System.out.print(CHESS_TWENTY);
		break;
	    case 20: System.out.print(CHESS_TWENTYONE);
		break;
	    case 21: System.out.print(CHESS_TWENTYTWO);
		break;
	    case 22: System.out.print(CHESS_TWENTYTHREE);
		break;
	    case 23: System.out.print(CHESS_TWENTYFOUR);
		break;
	    case 24: System.out.print(CHESS_TWENTYFIVE);
		break;
	    case 25: System.out.print(CHESS_TWENTYSIX);
		break;
	    case 26: System.out.print(CHESS_TWENTYSEVEN);
		break;
	    case 27: System.out.print(CHESS_TWENTYEIGHT);
		break;
	    case 28: System.out.print(CHESS_TWENTYNINE);
		break;
	    case 29: System.out.print(CHESS_THIRTY);
		break;
	    case 30: System.out.print(CHESS_THIRTYONE);
		break;
	    case 31: System.out.print(CHESS_THIRTYTWO);
		break;
	    default: System.out.print(CHESS_ONE);
		break;
	    }
	}
	System.out.println();
    }

    public static void printBaguaNumbersRow(int[] A) {
	final String ONE_BAGUA     = "☰";
	final String TWO_BAGUA     = "☱";
	final String THREE_BAGUA   = "☲";
	final String FOUR_BAGUA    = "☳";
	final String FIVE_BAGUA    = "☴";
	final String SIX_BAGUA     = "☵";
	final String SEVEN_BAGUA   = "☶";
	final String EIGHT_BAGUA   = "☷";
		
        for (int i=0; i<A.length; i++) {
	    switch(A[i]%8) {
	    case 0: System.out.print(ONE_BAGUA);
		break;
	    case 1: System.out.print(TWO_BAGUA);
		break;
	    case 2: System.out.print(THREE_BAGUA);
		break;
	    case 3: System.out.print(FOUR_BAGUA);
		break;
	    case 4: System.out.print(FIVE_BAGUA);
		break;
	    case 5: System.out.print(SIX_BAGUA);
		break;
	    case 6: System.out.print(SEVEN_BAGUA);
		break;
	    case 7: System.out.print(EIGHT_BAGUA);
		break;
	    default:
		System.out.print(ONE_BAGUA);
		break;
	    }
	}
	System.out.println();
    }
    
    public static void printBoxes(int n, int max) {
	// will only work for 79/3 - 3 boxes
	final String BOX        = "🌕";
	final String BOXCROSS   = "🌑";
	final String STARDOT    = "★";
	final String STARHOLE   = "☆";
	final String OPENBOX    = "☐";
	final String CROSSBOX   = "☒";
	final String BLACKHEART = "♥";
	final String WHITEHEART = "♡";
	final String BLACKHEX   = " ⬣";
	final String WHITEHEX   = " ⎔";
	
	for (int i = 0; i < max; i++) {
	    if (i+1 != n) 
		System.out.print(WHITEHEX);
	    else
		System.out.print(BLACKHEX);
	}

	System.out.println();
    }

    public static void printNumbersVisualization(int[] A) {
	try {
	    System.out.println("Visualization: ");
	    printNumbersRow(A);
	    Thread.sleep(377);
	    deleteBoxes(1+1);
	} catch(Exception e) {
	    ;
	}
    }

    public static void printBaguaVisualization(int[] A) {
	try {
	    System.out.println("Visualization: ");
	    printBaguaNumbersRow(A);
	    Thread.sleep(377);
	    deleteBoxes(1+1);
	} catch(Exception e) {
	    ;
	}
    }

    public static void printChessVisualization(int[] A) {
	try {
	    System.out.println("Visualization: ");
	    printChessPiecesRow(A);
	    Thread.sleep(377);
	    deleteBoxes(1+1);
	} catch(Exception e) {
	    ;
	}
    }
   
    public static void printVisualization(int[] A) {
	try {
	    System.out.println("Visualization: ");
	    for(int i = 0; i<A.length; i++) {
		printBoxes(A[i], A.length);
	    }
	    Thread.sleep(377);
	    deleteBoxes(A.length+1);
	} catch(Exception e) {
	    ;
	}
    }
    
    public static void printArray(int[] A) {
	int i;
	    
	System.out.print("Sequence: {");
	for(i = 0; i<A.length; i++) {
	    if (i >= A.length-1) {
		System.out.print(A[i]);
		System.out.print("} ");
	    } else {
		System.out.print(A[i]);
		System.out.print(", ");
	    }
	}
	System.out.println();
    }

    public static void main(String... args) {
	int [] CORMEN_ARR_PP_32 = { 2, 4, 5, 7, 1, 3, 6, 10, 9, 21,
	                            8, 13, 15, 12, 17, 16, 11, 14,
	                            18, 20, 19};
	int [] arr = CORMEN_ARR_PP_32;

	merge_sort(arr, 0, arr.length-1);
	//selection_sort(arr);
    }
}

    

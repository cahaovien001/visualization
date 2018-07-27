public class VisualizeInsertionSort {
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
		printVisualization(A);
	    } else {
		A[k] = R[j];
		j = j+1;
		printVisualization(A);
	    }
	}
    }

    public static void deleteBoxes(int max) {
	for (int i = 0; i<max; i++) {
	    System.out.print(String.format("\033[%dA", 1));
	    System.out.print("\033[2K");
	}
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

	//merge_sort(arr, 0, arr.length-1);
	sort(arr);
    }
}

    

import javax.tools.StandardLocation;

public class Example {


    //Spajamo 2 podniza od niza arr[]
    //Prvi podniz je arr[l...m]
    //Drugi podniz je arr[m+1...r]


    private static void merge(int arr[], int l, int m, int r) {

        //Nadjimo duzinu 2 podniza koji trebaju da se spajaju
        int n1 = m - l + 1;
        int n2 = r - m;

        //Pravimo dva privremena niza
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Kopiramo podatke u privremene nizove
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        //Spajamo privremene nizove

        //Početni indexi prvog i drugog podniza
        int i = 0;
        int j = 0;

        //Pocetni index spojenog niza podnizova

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Kopiramo presotajuce elemente L[] if any niza

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //Kopiramo preostajuce elemente R[] if any

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }


    }
    //Glavna funkcija koja sortira arr[l..r] koristi
    //merge()

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            //Nadjimo srednju tacku
            int m = l + (r - l) / 2;
            //Sortirajmo prvi i drugu poloinu
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            //Spojimo dvije sortirane polovine
            merge(arr, l, m, r);

        }

    }


    public static void main(String[] args) {

        int arr[] = {38, 27, 43, 10};
        int n = arr.length;
        // sortiramo niz
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }

    }
}

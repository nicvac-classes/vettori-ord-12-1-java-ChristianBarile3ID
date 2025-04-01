//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static void visualizzaVettore(int V[]) {
        int i;
        for (i=0; i<V.length; ++i) {
            System.out.println(V[i]);
        }
    }

    public static void copiaVettore(int V1[], int V2[]) {
        int i;
        for (i=0; i<V1.length; ++i) {
            V2[i] = V1[i];
        }
    }

    public static int bubbleSortStandard(int V[]) {
        int cont, i, j, temp;
        cont = 0;
        for (i=0; i<V.length; ++i) {
            for (j=0; j<V.length-1; ++j) {
                if (V[j]>V[j+1]) {
                    temp = V[j];
                    V[j] = V[j+1];
                    V[j+1] = temp;
                }
                ++cont;
            }
        }
        return cont;
    }

    public static int bubbleSortOttimizzazione1(int V[]) {
        int cont, i, j, temp;
        cont = 0;
        for (i=0; i<V.length; ++i) {
            for (j=0; j<(V.length-1)-i; ++j) {
                if (V[j]>V[j+1]) {
                    temp = V[j];
                    V[j] = V[j+1];
                    V[j+1] = temp;
                }
                ++cont;
            }
        }
        return cont;
    }

    public static int bubbleSortOttimizzazione2(int V[]) {
        int cont, i, j, temp;
        boolean scambio;
        cont = 0;
        i = 0;
        scambio = true;
        while (i<V.length && scambio) {
            j = 0;
            scambio = false;
            while (j<(V.length-1)-i) {
                if (V[j]>V[j+1]) {
                    temp = V[j];
                    V[j] = V[j+1];
                    V[j+1] = temp;
                    scambio = true;
                } 
                ++cont;
                ++j;
            }
            ++i;
        }
        return cont;
    }


    public static void main(String args[]) {

        Scanner in = new Scanner( System.in );
        int N, i, contStandard, contOttimizzazione1, contOttimizzazione2;
        System.out.println("Inserire grandezza del vettore: ");
        N = Integer.parseInt(in.nextLine());
        int[] V = new int[N];
        int[] W = new int[N];
        Random random = new Random();
        for (i=0; i<N; ++i) {
            V[i] = random.nextInt(N*10);
        }
        System.out.println("------ VETTORE NON ORDINATO ------");
        visualizzaVettore(V);
        copiaVettore(V, W);
        contStandard = bubbleSortStandard(V);
        System.out.println("------ VETTORE ORDINATO CON METODO STANDARD ------");
        visualizzaVettore(V);
        copiaVettore(W, V);
        contOttimizzazione1 = bubbleSortOttimizzazione1(V);
        System.out.println("------ VETTORE ORDINATO CON METODO OTTIMIZZATO BASE ------");
        visualizzaVettore(V);
        copiaVettore(W, V);
        contOttimizzazione2 = bubbleSortOttimizzazione2(V);
        System.out.println("------ VETTORE ORDINATO CON METODO OTTIMIZZATO AVANZATO ------");
        visualizzaVettore(V);
        System.out.println("Confronti Metodo Standard: " + contStandard);
        System.out.println("Confronti Metodo Ottimizzato Base: " + contOttimizzazione1);
        System.out.println("Confronti Metodo Ottimizzato Avanzato: " + contOttimizzazione2);
        if ((contOttimizzazione2<contOttimizzazione1 && contOttimizzazione2<contStandard) && (contOttimizzazione1<contStandard && contOttimizzazione1>contOttimizzazione2) && (contStandard>contOttimizzazione1) && (contStandard>contOttimizzazione2)) {
            System.out.println("Il numero di confronti diminuisce passando dal metodo meno ottimizzato a quello più ottimizzato");
        }
        in.close();
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md
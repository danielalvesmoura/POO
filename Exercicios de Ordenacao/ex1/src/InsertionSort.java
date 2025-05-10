public class InsertionSort {


    public static void main(String[] args) {


        int[] vetor = {5,4,3,2,1};


        for (int cont = 0; cont < vetor.length; cont++) {
            System.out.print(vetor[cont] + " ");
        }
        System.out.println();


        insertionSort(vetor);


    }


    public static void insertionSort(int[] vetor) {


        for (int i = 1; i < vetor.length; i++) {


            int chave = vetor[i];
            int j = i - 1;


            while(j>=0 && vetor[j]>chave) {
                vetor[j+1] = vetor[j];
                j--;
            }


            vetor[j+1] = chave;


            for (int cont = 0; cont < vetor.length; cont++) {
                System.out.print(vetor[cont] + " ");
            }
            System.out.println();


        }
    }
}

public class MergeSort {

    static Impressao impressao = new Impressao();
    static int[] vetor = {5,7,4,6,3,4,67,65,3,23,4,634,7,3,34,3};


    public static void main(String[] args) {




        impressao.imprimirVetor(vetor);
        System.out.println();


        mergeSort(vetor);


        impressao.imprimirVetor(vetor);


    }


    public static void mergeSort(int[] vetor) {


        int tamanho = vetor.length;
        if (tamanho <= 1) return;


        int indiceMeio = tamanho/2;


        int[] vetorEsquerdo = new int[indiceMeio];
        int[] vetorDireito = new int[tamanho-indiceMeio];


        int iTotal = 0;
        int iDireito = 0;


        for (; iTotal < tamanho; iTotal++) {


            if (iTotal < indiceMeio) {
                vetorEsquerdo[iTotal] = vetor[iTotal];
            } else {
                vetorDireito[iDireito] = vetor[iTotal];
                iDireito++;
            }
        }


        mergeSort(vetorEsquerdo);
        mergeSort(vetorDireito);
        merge(vetorEsquerdo,vetorDireito,vetor);


    }


    private static void merge(int[] vetorEsquerdo, int[] vetorDireito, int[] vetor) {


        int tamanho = vetor.length;


        int tamanhoEsquerdo = tamanho/2;
        int tamanhoDireito = tamanho - tamanhoEsquerdo;
        int iTotal = 0, iEsquerda = 0, iDireito = 0;


        while (iEsquerda < tamanhoEsquerdo && iDireito < tamanhoDireito) {
            if(vetorEsquerdo[iEsquerda] < vetorDireito[iDireito]) {
                vetor[iTotal] = vetorEsquerdo[iEsquerda];
                iTotal++;
                iEsquerda++;
            } else {
                vetor[iTotal] = vetorDireito[iDireito];
                iTotal++;
                iDireito++;
            }
            impressao.imprimirVetor(vetor);
            System.out.println();
        }


        while(iEsquerda < tamanhoEsquerdo) {
            vetor[iTotal] = vetorEsquerdo[iEsquerda];
            iTotal++;
            iEsquerda++;
        }


        while(iDireito < tamanhoDireito) {
            vetor[iTotal] = vetorDireito[iDireito];
            iTotal++;
            iDireito++;
        }


    }


}


public class Grafo {

    int[][] matrizPesos;
    String[] vertices;
    int[] distancias;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];
        this.distancias = new int[vertices.length];
    }

    public Grafos(String[] vertices, int[][] pesos) {
        this.vertices = vertices;
        matrizPesos = pesos;
        this.distancias = new int[vertices.length];
    }

    public void conectar(String v1, String v2, int peso) {

        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = peso;
            matrizPesos[index2][index1] = peso;
        }
    }

    public void imprimir() {
        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    public void calcularDijkstra(){
        int flag[] = new int[vertices.length];
         int i,minpos=1,k,c,minimo;

        //lo llenamos al vector distancia con la primer fila de la matriz
        //entonces esto indica que estoy parada en el estado inicial y tengo todas las distancias desde ese punto

         for(i=0 ;i<vertices.length;i++){  
            flag[i]=0; 
            this.distancias[i]=this.matrizPesos[0][i]; // tomando como el estado inicial al nodo ubicado el 0 
        } //a esta altura i tiene 4

        c=2;
          
        while(c<=vertices.length){

           minimo=99; // hv
           //se aranca en 1 suponiendo que el 0es el estado inicial
           for(k=1;k<vertices.length;k++){ 

                if(this.distancias[k]<minimo && flag[k]!=1) {
                    minimo=this.distancias[k];
                    //guardamos donde esta la posicion del menor
                    minpos=k;
                }
           } 

           flag[minpos]=1;
           c++;
           for(k=1;k<vertices.length;k++){
                 if(this.distancias[minpos]+this.matrizPesos[minpos][k] <  this.distancias[k] && flag[k]!=1 )
                 this.distancias[k]=this.distancias[minpos]+this.matrizPesos[minpos][k];
           }  

         } 
        
        for (i=0;i<distancias.length;i++){
            System.out.print(distancias[i]+" ");
        }
         
        
         return;


         
    }
}



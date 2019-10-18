public class Dijkstra {
    
    public static String vertices[]={"a","b","c","d","e","f"};
    public static int[][] pesos= {
        {0,4,2,999,999,999},
        {4,0,1,5,999,999},
        {2,1,0,8,10,999},
        {999,5,8,0,2,6},
        {999,999,10,2,0,2},
        {999,999,999,6,2,0}};
    
    public static void main(String[] args){
        Grafos grafo = new Grafos(vertices, pesos);
        
        grafo.imprimir();
        
        grafo.calcularDijkstra();
    }
    
}
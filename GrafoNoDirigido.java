package GRAFOS;
public class GrafoNoDirigido<T>extends GrafoDirigido<T>{
	@Override
	public void agregarArco(int vertice1,int vertice2,T etiqueta){
		//O(1)
		super.agregarArco(vertice1,vertice2,etiqueta);
		super.agregarArco(vertice2,vertice1,etiqueta);
	}
	@Override
	public void borrarArco(int vertice1,int vertice2){
		//O(A)
		super.borrarArco(vertice1,vertice2);
		super.borrarArco(vertice2,vertice1);
	}
}
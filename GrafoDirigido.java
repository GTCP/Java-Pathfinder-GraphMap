package GRAFOS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class GrafoDirigido<T> implements Grafo<T>{
	private HashMap<Integer,ArrayList<Arco<T>>>vertices;
	private int cantidadArcos;
	public GrafoDirigido(){
		//O(1)
		this.vertices=new HashMap<Integer,ArrayList<Arco<T>>>();
	}
	@Override
	public void agregarVertice(int verticeId){	
		//O(1)
		if(!vertices.containsKey(verticeId)) {
			vertices.put(verticeId,new ArrayList<Arco<T>>());
		}
		else {
			System.out.println("No agrego por que sino quedaria repetido");
		}
	}
	@Override
	public void borrarVertice(int vertice) {
		//O(V*A)  la V representaria los vertices y A las aristas a recorrer.
		if(vertices.containsKey(vertice)) {
			Iterator<Integer>temp=this.obtenerAdyacentes(vertice);
			if(temp!=null) {
				vertices.remove(vertice);
				while(temp.hasNext()){
					 Integer aux=temp.next();
					 Iterator<Arco<T>> arcos=this.vertices.get(aux).iterator();
					 while(arcos.hasNext()) {
						 Arco<T> arquito=arcos.next();
						 if(arquito.getVerticeDestino()==vertice) {
							 arcos.remove();
							 cantidadArcos--;
							 break;
						 }
					 }
					 cantidadArcos--;
				} 
			}
		}
		else {
			System.out.println("No existe el vertice a borrar");
		}
	}			
	@Override
	public void agregarArco(int vertice1,int vertice2,T etiqueta){
		//O(1) 
		if((vertices.containsKey(vertice1))&&(vertices.containsKey(vertice2))&&(!this.existeArco(vertice1, vertice2))) {
			vertices.get(vertice1).add(new Arco<T>(vertice1,vertice2,etiqueta));
			cantidadArcos++;
		}
		else {
			System.out.println("No agrego arco");
		}
	}
	@Override
	public void borrarArco(int vertice1,int vertice2){
		//O(A), donde A representa los la cantidad de arcos de un vertice
		if(vertices.containsKey(vertice1)&&vertices.containsKey(vertice2)) {
			int contador=0;
			Iterator<Arco<T>>aux=vertices.get(vertice1).iterator();
			while(aux.hasNext()){
				if(aux.next().getVerticeDestino()==vertice2){
					vertices.get(vertice1).remove(contador);
					cantidadArcos--;
					return;
				}
				contador++;
			}
		}else {
			System.out.println("No borro el arco por que uno de los 2 vertices no existe");
		}
	 }
	@Override
	public boolean contieneVertice(int verticeId){
		//O(1) es constante
		return vertices.containsKey(verticeId);
	}
	@Override
	public boolean existeArco(int vertice1,int vertice2){
		//O(V) dodne v son los vertices a recorrer.	
		if((vertices.containsKey(vertice1))&&(vertices.containsKey(vertice2))) {
			return this.obtenerArco(vertice1,vertice2)!=null;
		}
	    return false;
	}
	public Arco<T>obtenerArco(int vertice1,int vertice2){
		//O(V), v los vertices a recorrer.	   	
		if((vertices.containsKey(vertice1))&&(vertices.containsKey(vertice2))) {
			Iterator<Integer>aux2=obtenerAdyacentes(vertice1);			
			if(aux2!=null) {	
				int contador=0;
				while(aux2.hasNext()) {
					aux2.next();
					if(vertices.get(vertice1).get(contador).getVerticeDestino()==vertice2) {
						return vertices.get(vertice1).get(contador);
					}	
					contador++;
				}
			}
		}
	    return null;
	}
	@Override
	public int cantidadVertices(){
		//O(1) 
		return this.vertices.size();
	}
	@Override
	public int cantidadArcos(){
		//O(1)
		return this.cantidadArcos;	
	}
	@Override
	public Iterator<Integer>obtenerVertices(){
		//O(1)
		return vertices.keySet().iterator();
	}
	@Override
	public Iterator<Integer>obtenerAdyacentes(int vertice){
		//O(1)
		//obtiene todos los adyacentes de un vertice por medio de sus arcos
		if(vertices.containsKey(vertice)) {
			 Iterator<Arco<T>>auxArco=vertices.get(vertice).iterator();
			    return new ArcoIterator<T>(auxArco);
		}
		return null;
	}
	@Override	
	public Iterator<Arco<T>>obtenerArcos(){
		//O(V*A), la V representaria los vertices y A los vertices a recorrer.
		//obtiene los vertices e itera sobre ellos obteniendo los arcos, ahi mismo itera sobre cada arco de cada vertice hasta recorrer a todos y obtener asi todos los arcos del grafo.
		ArrayList<Arco<T>>auxArcos=new ArrayList<Arco<T>>();
		Iterator<Arco<T>>aux=null;
		Iterator<Integer>iterator=this.obtenerVertices();
		while(iterator.hasNext()){
		    aux=this.obtenerArcos(iterator.next());
		    if(aux!=null) {
			    while(aux.hasNext()){
				   	auxArcos.add(aux.next());
			    }
		    }
		}
		aux=auxArcos.iterator();
		return aux;
	}
	@Override
	public Iterator<Arco<T>>obtenerArcos(int vertice){
		//O(1)
		//obtiene los arcos de un vertice y lo devuelve como un iterador
		if(vertices.containsKey(vertice)) {
			return vertices.get(vertice).iterator();
		}
		return null;
	}
}
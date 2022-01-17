package GRAFOS;
import java.util.Iterator;
public class ArcoIterator <T>implements Iterator<Integer>{
	private Iterator<Arco<T>>IteradorArco;
	public ArcoIterator(Iterator<Arco<T>>iterador){
		this.IteradorArco= iterador;
	}
	@Override
	public boolean hasNext(){
	//O(1), pregunta si hay un siguiente
		return IteradorArco.hasNext();
	}
	@Override
	public Integer next(){
	//O(1), cambia al siguiente y devuelve el destino del arco
		return IteradorArco.next().getVerticeDestino();
	}
}
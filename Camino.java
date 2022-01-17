package GRAFOS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class Camino {
	private ArrayList<Ciudad>caminoRecorrido;
	private Integer km;
	public Camino(){
		this.caminoRecorrido=new ArrayList<>();
		this.km=0;
	}
	public void setCamino(ArrayList<Ciudad>camino){
		//O(1)	
		this.caminoRecorrido=camino;
	}
	public void addCamino(Ciudad camino) {
		//O(1)
		this.caminoRecorrido.add(camino);
	}
	public ArrayList<Ciudad>getCaminoRecorrido(){
		//O(1)
		return new ArrayList<>(this.caminoRecorrido);
		//return (ArrayList<Ciudad>) this.camino.clone();
	}
	public void addCaminoIndex(Ciudad camino,Integer index){
		//O(c),donde n es la cantidad de ciudades a recorrer hasta insertar
		this.caminoRecorrido.add(index, camino);
	}
	public void setKm(Integer km){
		//O(1)
		this.km=km;
	}
	public Integer getKm(){
		//O(1)
		return this.km;
	}
	public void limpiarCamino(){
		//O(1)
		this.caminoRecorrido.clear();
	}
	public String toString(){
		//O(c),donde c es la cantidad de ciudades a recorrer
		LinkedHashSet<Ciudad>caminos=new LinkedHashSet<>(caminoRecorrido);
		String caminosString="";
		Iterator<Ciudad>ite=caminos.iterator();
		while(ite.hasNext()) {
		    caminosString+="->["+(ite.next().getNombre()+"]");
		}
		if(km==0) {
			return "->No se encontro camino posible";			
		}
		else {
			return caminosString+"[KM totales:"+this.km+"]";
		}
	}
}
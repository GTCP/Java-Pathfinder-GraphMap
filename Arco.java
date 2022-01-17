package GRAFOS;
public class Arco<T>{
	private Integer verticeOrigen;
	private Integer verticeDestino;
	private T etiqueta;
	public Arco(Integer verticeOrigen,Integer verticeDestino,T etiqueta){
		this.verticeOrigen=verticeOrigen;
		this.verticeDestino=verticeDestino;
		this.etiqueta=etiqueta;
	}
	public Integer getVerticeOrigen(){
		//O(1)
		return verticeOrigen;
	}
	public Integer getVerticeDestino(){
		//O(1)
		return verticeDestino;
	}
	public T getEtiqueta(){
		//O(1)
		return etiqueta;
	}
}
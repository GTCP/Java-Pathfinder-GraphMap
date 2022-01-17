package GRAFOS;
import java.util.HashMap;
import java.util.Iterator;
public class Mapa{
	private Grafo<Integer>grafo;
	private HashMap<Integer,String>colores;
	private HashMap<Integer,Ciudad>ciudades;
	public Mapa(Grafo<Integer>grafo){
		//O(1)
		this.ciudades=new HashMap<>();
		this.grafo=grafo;
		this.colores=new HashMap<>();
	}
	public void addCiudad(Ciudad ciudad){
		//O(1)
		//agrega una ciudad una ciudad al hashmap y un vertice en el grafo
		this.ciudades.put(ciudad.getId(),ciudad);
		this.grafo.agregarVertice(ciudad.getId());
	}
	public void agregarCamino(Ciudad ciudadOri,Ciudad ciudadDes,int km){
		//O(1)
		//agrega un arco entre 2 ciudades y su respectivo km entre ellas(etiqueta)
		grafo.agregarArco(ciudadOri.getId(),ciudadDes.getId(),km);
	}
	public void deleteCiudad(Ciudad ciudad){
		//O(A)
		//borra una ciudad= un vertice del grafo
		grafo.borrarVertice(ciudad.getId());
	}
	public void deleteCamino(Ciudad vertice1,Ciudad vertice2){
		//O(A)
		//borra un camino entre 2 ciudades
		grafo.borrarArco(vertice1.getId(),vertice2.getId());
	}
	public String getNombreCiudad(int ciudad){
		//O(1)
		//verifica si lo tiene y si es asi devuelve su nombre
		if(this.ciudades.containsKey(ciudad)){
			return this.ciudades.get(ciudad).getNombre();
		}
		else {
			return null;
		}	
	}
	public Camino DFS(Ciudad ciudadOri,Ciudad ciudadDes){
		//recorro todas las ciudades y las pinto de blanco
		//llamo al visit y le paso ciudad ori,ciudaddestino,las 2 clases de caminos,y la balanza
		//ese camino lo tengo en la clase atributo arraylist caminomascorto,si en caminomascorto km  cambio del valor con el que si inicializo
		//agrego ciudad origen en la primera posicion sino devuelvo 0 ya sea por que no encontro por balanzas.
		//y luego devuelvo la clase caminomascorto donde en sus atributos esta el caminomascorto y el km correspondiente.	
		Camino caminoMasCorto= new Camino();
		if((this.grafo.contieneVertice(ciudadOri.getId()))&&(this.grafo.contieneVertice(ciudadDes.getId()))) {
			int kmFull=9999999;
			caminoMasCorto.setKm(kmFull);
			Camino caminoActual= new Camino();
			caminoActual.setKm(0);
			int balanza=0;	
			Iterator<Integer>iteradorCiudad=ciudades.keySet().iterator();
			if(iteradorCiudad!=null) {
				while (iteradorCiudad.hasNext()){
					Integer iterador=iteradorCiudad.next();
					colores.put(iterador,"blanco");
				}	
				DFS_VISIT(ciudadOri,ciudadDes,caminoMasCorto,caminoActual,balanza);
				if(caminoMasCorto.getKm()!=kmFull){
					caminoMasCorto.addCaminoIndex(ciudadOri,0);
				}
				else {
					caminoMasCorto.setKm(0);
				}
			}
			return caminoMasCorto;	
		}
		System.out.println("No existe/n la/s ciudad/es seleccionada/s");
		return caminoMasCorto;	
	}
	public void DFS_VISIT(Ciudad ciudadOri,Ciudad ciudadDes,Camino caminoMasCorto,Camino caminoActual,int balanza){
		//si soy el valor, me agrego a caminoactual atributo arraylist camino  y si el valor que acumule del camino es menor al minimo(atributo km clase caminomascorto)
		//el array camino de clase caminomascorto se borra y se agrega el atributo camino de la clase caminoactual, atributo km clase caminomascorto pasa a ser el atributo de la clase caminoactual km.
		//si no soy el valor me pinto de amarillo,traigo mis adyacentes e itero en cada adyacente, 
		//si soy blanco,y poseo balanza aumenta balanza, si balanza es menor a 2, agrego ciudad origen al atributo camino de la clase caminoactual,
		//atributo km de clase caminoactual se vuelve su valor mas la distancia entre origen y la posicion de iteracion de los adyacentes,
		//el atributo camino de la clase caminoactual se limpia y el atributo km de la clase caminoactual se vuelve a restar
		//lo mismo que se habia sumado antes. si la pos de mi iteracion de mi adyacente tiene balanza balanza se resta 1.
		//al salir del while ciudadorigen se vuelve blanco.	
		if(ciudadOri.equals(ciudadDes)){
			caminoActual.addCamino(ciudadOri);
			if(caminoActual.getKm()<caminoMasCorto.getKm()){	
				caminoMasCorto.limpiarCamino();
				caminoMasCorto.setCamino(caminoActual.getCaminoRecorrido());
				caminoMasCorto.setKm(caminoActual.getKm());
			}
		}
		else {
			colores.put(ciudadOri.getId(),"amarillo");	
			Iterator<Integer>ite=grafo.obtenerAdyacentes(ciudadOri.getId());
			if(ite!=null) {
				while(ite.hasNext()){
					Integer ite2=ite.next();
					if(colores.get(ite2).equals("blanco")){
						if(ciudades.get(ite2).isBalanza()){
							balanza++;
						}
						if(balanza<2){
							caminoActual.addCamino(ciudadOri);
							caminoActual.setKm(caminoActual.getKm()+obtenerKilometrosEntreCiudades(ciudadOri.getId(),ite2));
							DFS_VISIT(ciudades.get(ite2),ciudadDes,caminoMasCorto,caminoActual,balanza);
							caminoActual.limpiarCamino();
							caminoActual.setKm(caminoActual.getKm()-obtenerKilometrosEntreCiudades(ciudadOri.getId(),ite2));	
						}
						if(ciudades.get(ite2).isBalanza()){
							balanza--;
						}
					}
				}
			}
		}
		colores.put(ciudadOri.getId(),"blanco");
	}
	private Integer obtenerKilometrosEntreCiudades(Integer ciudadOri,Integer ciudadDes){
		//O(A)
		//obtiene la distancia entre 2 ciudades
		return grafo.obtenerArco(ciudadOri,ciudadDes).getEtiqueta();
	}
}
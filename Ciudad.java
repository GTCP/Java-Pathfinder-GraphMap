package GRAFOS;
public class Ciudad {
	private	int id;
	private String nombre;
	private boolean balanza;
	private	int estacionesDeservicio; 
	private boolean radar;
	private	int mecanicos;
	public Ciudad(int id,String nombre){
		//O(1)
		this.id=id;
		this.nombre=nombre;
		this.balanza=false;
		this.estacionesDeservicio=0;
		this.radar=false;
		this.mecanicos=0;
	}
	public int getMecanicos(){
		//O(1)
		return this.mecanicos;
	}
	public void setMecanicos(int mecanicos){
		//O(1)
		this.mecanicos=mecanicos;
	}
	public boolean isRadar(){
		//O(1)
		return this.radar;
	}
	public void setRadar(boolean radar){
		//O(1)
		this.radar=radar;
	}
	public int getEstacionesDeServicio(){
		//O(1)
		return this.estacionesDeservicio;
	}
	public void setEstacionesDeServicio(int estacionesDeServicio){
		//O(1)
		this.estacionesDeservicio=estacionesDeServicio;
	}
	public int getId(){
		//O(1)
		return this.id;
	}
	public boolean isBalanza(){
		//O(1)
		return this.balanza;
	}
	public void setIsBalanza(boolean balanza){
		//O(1)
		this.balanza=balanza;
	}
	public String getNombre(){
		//O(1)
		return this.nombre;
	}
	public void setNombre(String nombre){
		//O(1)
		this.nombre=nombre;
	}	
	public boolean equals(Object o) {
		try {
			Ciudad ciudad=(Ciudad)o;
			if(this.getNombre().equals(ciudad.getNombre())) {
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}	
		return false;
	}
}
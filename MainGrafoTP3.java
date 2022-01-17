package GRAFOS;
public class MainGrafoTP3 {
	public static void main(String[] args){	
		GrafoNoDirigido<Integer>grafo=new GrafoNoDirigido<>();	
				
		Mapa MapaCiudades=new Mapa(grafo);
		Ciudad pehuajo=new Ciudad(1,"pehuajo");
		Ciudad bolivar=new Ciudad(2,"bolivar");
		Ciudad azul=new Ciudad(3,"azul");
		Ciudad ayacucho=new Ciudad(4,"ayacucho");
		Ciudad tandil=new Ciudad(5,"tandil");
		Ciudad rauch=new Ciudad(6,"rauch");
		Ciudad mardelplata=new Ciudad(7,"mardelplata");
		Ciudad olavarria=new Ciudad(8,"olavarria");
		
		pehuajo.setIsBalanza(true);
		tandil.setIsBalanza(true);
		mardelplata.setIsBalanza(true);
		olavarria.setIsBalanza(true);
			
		MapaCiudades.addCiudad(pehuajo);
		MapaCiudades.addCiudad(bolivar);
		MapaCiudades.addCiudad(azul);
		MapaCiudades.addCiudad(ayacucho);
		MapaCiudades.addCiudad(tandil);		
		MapaCiudades.addCiudad(rauch);
		MapaCiudades.addCiudad(mardelplata);
		MapaCiudades.addCiudad(olavarria);
			
		MapaCiudades.agregarCamino(pehuajo,bolivar,70);
		MapaCiudades.agregarCamino(bolivar,azul,100);
		MapaCiudades.agregarCamino(pehuajo,ayacucho,540);
		MapaCiudades.agregarCamino(ayacucho,tandil,70);
		MapaCiudades.agregarCamino(ayacucho,rauch,50);
		MapaCiudades.agregarCamino(tandil,olavarria,130);
		MapaCiudades.agregarCamino(tandil,mardelplata,200);
		MapaCiudades.agregarCamino(rauch,tandil,60);	
		MapaCiudades.agregarCamino(rauch,olavarria,210);
		MapaCiudades.agregarCamino(olavarria,bolivar,140);	
		
		System.out.println("----------=Inicio=----------");

		Camino camino=new Camino();
		System.out.println("Origen Azul -> Destino Ayacucho");	
		camino=MapaCiudades.DFS(azul,ayacucho);
		System.out.println(camino);
		
		System.out.println("-------------------------------------------");	
		
		camino=MapaCiudades.DFS(rauch,mardelplata);
		System.out.println("Origen Rauch -> Destino Mardelplata");
		System.out.println(camino);
		
		System.out.println("-------------------------------------------");	
			
		camino=MapaCiudades.DFS(mardelplata,pehuajo);
		System.out.println("Origen Mardelplata -> Destino Pehuajo");	
		System.out.println(camino);
		
		System.out.println("-------------------------------------------");	
			
		MapaCiudades.deleteCiudad(ayacucho);
		System.out.println("Se elimino ayacucho");	
			
		System.out.println("-------------------------------------------");	
			
		MapaCiudades.deleteCamino(tandil,rauch);
		System.out.println("Se elimino el camino de Tandil a Rauch");	
			
		System.out.println("-------------------------------------------");	
		
		camino=MapaCiudades.DFS(mardelplata,pehuajo);
		System.out.println("Origen Mardelplata -> Destino Pehuajo");	
		System.out.println(camino);
		
		System.out.println("-------------------------------------------");
		System.out.println("Aclaracion:");
		System.out.println("NO se toma en cuenta la balanza de la ciudad origen,solo la balanza de pasada y de llegada.");
		
		System.out.println("----------=Final=----------");
	}
}
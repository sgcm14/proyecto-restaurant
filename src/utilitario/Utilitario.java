package utilitario;

import java.util.List;

import clases.Orden;
import clases.Producto;


public class Utilitario {
	
	
	public static void listaMenu(List<Producto> productos) {
		
		System.out.println("\n");
		System.out.println("LISTA DE PRODUCTOS");
		System.out.println("===================\n");
		System.out.println("ID\t\tNOMBRE\t\t\t\t         PRECIO");
		System.out.println("===============================================================");
		
		for (Producto p : productos) {
			System.out.println(p.getId()+"\t"+p.getNombre()+"\t\t\t\t"+p.getPrecio());
		}
	}

	
	public static void listaPedido(List<Orden> pedido) {
		
		System.out.println("\n");
		System.out.println("LISTA DE PEDIDOS");
		System.out.println("================\n");
		System.out.println("CLIENTE\t\tPRODUCTO\t\t\tCANTIDAD");
		System.out.println("=========================================================");
		for (Orden ped : pedido) {
			System.out.println(ped.getCliente().getNombre()+"\t"+ped.getProducto().getNombre()+"\t\t"+ped.getCantidad());
			
		}
	}
	
	
}

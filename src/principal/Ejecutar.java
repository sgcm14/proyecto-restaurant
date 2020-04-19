package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import clases.Cliente;
import clases.Producto;
import clases.Orden;

import utilitario.Utilitario;

public class Ejecutar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Producto producto1 = new Producto(1,"Puré con pollo broaster y rocoto",5.00);
		Producto producto2 = new Producto(2,"Papa a la huancaina",3.00);
		Producto producto3 = new Producto(3,"Jarra de Chicha\t",3.00);

		
		ArrayList<Producto> productos = new ArrayList<Producto>();	
		
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		
		//--------------------------------------------------------------
		
		Cliente cliente1 = new Cliente(1,"Carlos Alaba","56239812");
		Cliente cliente2 = new Cliente(2,"Lily Mendez","94638120");
		Cliente cliente3 = new Cliente(3,"Louis Cartagena","64931678");

		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();	
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		
		//--------------------------------------------------------------

		ArrayList<Orden> pedido = new ArrayList<Orden>();
		
		System.out.println("Restaurant La Divina Comedia");
		System.out.println("============================");
		
		int opcion = 0;
		int idOrden = 0;
		Cliente clienteElegido=null;
		
		
		do {
			Scanner sc = new Scanner(System.in);
			if(opcion == 0) {
				System.out.println("MENÚ PRINCIPAL");
				System.out.println("--------------");
				
				System.out.println("(1) Lista de Productos");
				System.out.println("(2) Pedidos"); 
				System.out.println("(3) Pago");
				System.out.println("(99) Salir");
				System.out.print("Ingrese opción: ");
				opcion = sc.nextInt();

			}		
						
			
			switch (opcion) {
			case 1:
				
				Utilitario.listaMenu(productos);
				
				System.out.println("\nOpciones: ");
				System.out.println("(6) Agregar Producto");
				System.out.println("(0) Menú principal");
				
				System.out.print("Ingrese opción: ");
				opcion = sc.nextInt();
				System.out.println("\n");
				
				if(opcion == 6) {
					
					Producto ProductoNew = new Producto();
					
					System.out.print("Ingrese el ID:");
					ProductoNew.setId(sc.nextInt());
					System.out.print("Ingrese nombre: ");
					ProductoNew.setNombre(sc.next()+"\t\t");
					System.out.print("Ingrese precio: ");
					ProductoNew.setPrecio(sc.nextDouble());
					
					productos.add(ProductoNew);
					
					opcion = 1;
				}
				
				
				break;
			
			case 2:
				
				Utilitario.listaPedido(pedido);
				
				System.out.println("\nOpciones: ");
				System.out.println("(7) Realizar Pedido");//listado de pedidos (cliente-producto-cantidad), realizar pedido
				System.out.println("(0) Menú principal");
				
				System.out.print("Ingrese opción: ");
				opcion = sc.nextInt();
				System.out.println("\n");
				
				if(opcion == 7) {
					Utilitario.listaMenu(productos);
					System.out.println("");
					System.out.print("Ingrese ID del Producto: ");
					int idProducto = sc.nextInt();
					
					Producto productobuy = new Producto();
					for (Producto p : productos) {
						if(p.getId() == idProducto) {
							productobuy = p;
							idOrden++;
							break;
						}
					}
					
					System.out.print("Ingrese la cantidad: ");
					int cantidad = sc.nextInt();
					
					System.out.print("Ingrese ID del Cliente: ");
					int idCliente = sc.nextInt();
					
					Cliente clientebuy = new Cliente();
					for (Cliente c : clientes) {
						if(c.getId() == idCliente) {
							clientebuy = c;
							break;
						}
					}
					
					//10 elem
					boolean yaExiste = false;
					
					for (Orden ord : pedido) {
						
						if(ord.getProducto().getId() == productobuy.getId() && 
								ord.getCliente().getId() == clientebuy.getId()) {
							//ya existe, actualiza datos
							int nuevaCantidad = ord.getCantidad() + cantidad;
							ord.setCantidad(nuevaCantidad);
							yaExiste = true;
							//salir del for
							break;
							
						}
						
					}
					
					//si yaExiste = false // si no existe
					if(!yaExiste) {
						Orden ordenNew = new Orden(idOrden, new Date(), clientebuy, productobuy, cantidad, productobuy.getPrecio());
						pedido.add(ordenNew);
					}
					
					
					System.out.println("Se agregó el producto a su pedido!");
										
					opcion = 2;					
				}
				
				
				
				break;
			case 3:
				double sumatotal=0,subtotal=0;
				//ingresar el id cliente y muestra cabecera:nombre del cliente, tabla: producto-cant-precio==>total a pagar
				
				System.out.print("Ingrese ID del Cliente: ");
				int idCliente= sc.nextInt();
				System.out.println("\n");
				
				for (Cliente c : clientes) {
					if(c.getId() == idCliente) {
						clienteElegido = c;
						break;
					}
				}
				
				
				System.out.println("\n");
				System.out.println("BOLETA DE VENTA");
				System.out.println("=======================\n");
				System.out.println("\nCLIENTE: "+clienteElegido.getNombre().toUpperCase());
				System.out.println("PRODUCTO\t\t\tCANTIDAD\t\t\tPRECIO");
				System.out.println("=======================================================================");
				for (Orden ped : pedido) {
					if(ped.getCliente().getId()==clienteElegido.getId()) {
					subtotal=ped.getProducto().getPrecio()*ped.getCantidad();
					sumatotal+=subtotal;
					System.out.println(ped.getProducto().getNombre()+"\t\t\t"+ped.getCantidad()+"\t\t\t"+ped.getProducto().getPrecio());
					}
				}
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t\t\tTOTAL S/. "+sumatotal);
				
				
				System.out.println();
				System.out.println("(0) Menú principal");
				
				System.out.print("Ingrese opción: ");
				opcion = sc.nextInt();
				System.out.println("\n");
				
				break;
			}
			
		}while(opcion != 99);
		
			

	}

}

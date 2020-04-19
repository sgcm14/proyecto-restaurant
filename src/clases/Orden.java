package clases;

import java.util.Date;

public class Orden {
	private int id;
	private Date fecha;
	private Cliente cliente;
	private Producto producto;
	private int cantidad;
	private double total;
	public Orden(int id, Date fecha, Cliente cliente, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	public Orden() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		total=producto.getPrecio()*cantidad;
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
		
	
	
}

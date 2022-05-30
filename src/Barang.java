

public class Barang {
	protected String id;
	protected double harga;
	protected String nama;
	protected int stok;
	
	public Barang() {}
	public Barang(String id, String nama, double harga) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public int getStok() {
		return stok;
	}
	
	public void minusStok(int jml) {
		this.stok -= jml;
	}
	
}

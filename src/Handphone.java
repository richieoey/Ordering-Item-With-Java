

public class Handphone extends Barang {
	private String warna;
	public static int total;
	
	public Handphone() {}
	public Handphone(String id, String nama, double harga, int stok, String warna) {
		super(id,nama,harga);
		this.stok = stok;
		this.warna = warna;
	}
	
	public String getWarna() {
		return warna;
	}
	
}

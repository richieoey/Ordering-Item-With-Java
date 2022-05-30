

public class Voucher extends Barang{
	private double pajak;
	public static int total;
	
	public Voucher() {}
	public Voucher(String id, String nama, double harga,int stok,double pajak) {
		super(id,nama,harga);
		this.stok = stok;
		this.pajak = pajak;
	}
	
	public double getPajak() {
		return pajak;
	}
	
	public double gethargaJual() {
		return pajak+harga;
	}
}

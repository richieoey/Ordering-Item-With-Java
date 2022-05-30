

public class Order {
	private String id;
	private Voucher voucher;
	private Handphone handphone;
	private int jumlah;
	public static int total;
	
	public Order() {}
	public Order(String id, Voucher voucher, int jumlah) {
		this.id = id;
		this.voucher = voucher;
		this.jumlah = jumlah;
	}
	public Order(String id, Handphone handphone,int jumlah) {
		this.id = id;
		this.handphone = handphone;
		this.jumlah = jumlah;
	}
	
	public String getId() {
		return id;
	}
	
	public Voucher getVoucher() {
		return voucher;
	}
	
	public Handphone getHandphone() {
		return handphone;
	}
	
	public int getJumlah() {
		return jumlah;
	}
	
	public int getTotalHP() {
		return (int) (jumlah * handphone.getHarga());
	}
	
	public int getTotalVoucher() {
		return (int) (jumlah * voucher.getHarga());
	}
}

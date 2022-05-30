
import java.util.Scanner;


import java.util.ArrayList;

public class Main {
	static ArrayList<Barang> barang = new ArrayList<Barang>();
	static ArrayList<Order> ordersHP = new ArrayList<Order>();
	static ArrayList<Order> ordersVcr = new ArrayList<Order>();
	static int str = 0;
	static int ctr = 0;
	
	public static void dataBarang() {
		//upcast
		Barang hp = new Handphone("HO1","Samsung Galaxy S21 Ultra",10990000,10,"Hitam");
        barang.add(hp);
        str++;
        Barang hp1 = new Handphone("HO2","Iphone 12 Pro Max",18990000,5,"Putih");
        barang.add(hp1);
        str++;
        
        Barang vcr = new Voucher("VO1","Welkin Resin",75000,5,7500);
        barang.add(vcr);
        ctr++;
        
        Barang vcr1 = new Voucher("VO2","Google Play",100000,100,10000);
        barang.add(vcr1);
        ctr++;
        
	}
	
	public static void seeBarang() {

		for(Barang brg : barang) {
			//downcast
			if(brg.getId().contains("H")) {
				Handphone hp = (Handphone) brg;
				System.out.println("ID      : " + hp.getId());
				System.out.println("Nama    : " + hp.getNama() + " " + hp.getWarna());
				System.out.println("Stock   : " + hp.getStok());
				System.out.println("Harga   : " + (int) hp.getHarga());
				System.out.println("----------------------------------------");
			}else {
				Voucher vcr = (Voucher) brg;
				System.out.println("ID      : " + vcr.getId());
				System.out.println("Nama    : " + vcr.getNama());
				System.out.println("Nominal : " + (int) vcr.getHarga());
				System.out.println("Stock   : " + vcr.getStok());
				System.out.println("Harga   : " + (int) vcr.gethargaJual());
				System.out.println("----------------------------------------");
			}
			
		}
	}
	
	
	public static void seeOrderHP() {
		boolean flag = false;
		for(Order ord : ordersHP) {
			System.out.println("ID     : " + ord.getId());
			System.out.println("Nama   : " + ord.getHandphone().getNama());
			System.out.println("Jumlah : " + ord.getJumlah());
			System.out.println("Harga  : " + ord.getTotalHP());
			System.out.println("----------------------------------------");
			flag = true;
		}
		if(!flag) {
			System.out.println("No HP Order Found..");
		}
		
	}
	
	public static void seeOrderVcr() {
		boolean flag = false;
		for(Order ord : ordersVcr) {
			System.out.println("ID     : " + ord.getId());
			System.out.println("Nama   : " + ord.getVoucher().getNama());
			System.out.println("Jumlah : " + ord.getJumlah());
			System.out.println("Harga  : " + ord.getTotalVoucher());
			System.out.println("----------------------------------------");
			flag = true;
		}
		if(!flag) {
			System.out.println("No Voucher Order Found..");
		}
	}
	
	public static void newBarang() {
		Scanner scans = new Scanner(System.in);
		Scanner scansdata = new Scanner(System.in);
		System.out.print("Voucher / Handphone (V / H) : "); String tipe = scansdata.nextLine();
			if(tipe.equals("V")|| tipe.equals("v")) {
				System.out.print("Nama     : "); String nama = scansdata.nextLine();
				System.out.print("Harga    : "); double harga = scans.nextDouble();
				System.out.print("Stok     : "); int stok = scans.nextInt();
				System.out.print("PPN      : "); double ppn = scans.nextDouble();
				double pajak = harga * ppn;
				//upcast
				Barang vcr = new Voucher("VO"+(ctr+1),nama,harga,stok,pajak);
				barang.add(vcr);
				str++;
				System.out.println("Voucher telah berhasil dibuat");
			}else if(tipe.equals("H") || tipe.equals("h")){
				System.out.print("Nama     : "); String nama = scansdata.nextLine();
				System.out.print("Harga    : "); double harga = scans.nextDouble();
				System.out.print("Stok     : "); int stok = scans.nextInt();
				System.out.print("Warna    : "); String warna = scansdata.nextLine();
				//upcast
				Barang hp = new Handphone("HO"+(str+1),nama,harga,stok,warna);
		        barang.add(hp);
				ctr++;
				System.out.println("Handphone telah berhasil dibuat");
			}
	}
	
	public static void pesanBarang() {
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Daftar Barang Toko Voucher & HP");
		seeBarang();
		System.out.println("Ketik 0 untuk batal");
		System.out.print("Pesan Barang (ID) : ");
		String id = scan1.nextLine();
		for(Barang brg : barang){
			if(brg.getId().equals(id)){
				if(brg.getId().contains("H")) {
					//downcast
					Handphone hp = (Handphone) brg;
					System.out.print("Masukkan jumlah : ");
					int jumlah = scan1.nextInt();
						if(hp.getStok() < jumlah ) {
							System.out.println("Stok tidak mencukupi");
							break;
						}
						int total =  (int) (hp.getHarga()*jumlah);
						System.out.println(jumlah +  " @ " + hp.getNama() + " dengan total harga " + total);
						System.out.print("Masukkan jumlah uang : ");
						int jml_uang = scan1.nextInt();
						if(jml_uang >= total) {
							ordersHP.add(new Order("O"+hp.getId() +"-"+ ordersHP.size(),hp,jumlah));
							hp.minusStok(jumlah);
							System.out.println("Berhasil dipesan");
							break;
						} else {
							System.out.println("Jumlah uang tidak mencukupi.. silahkan coba lagi");
							break;
						}
					} else if(brg.getId().contains("V")) {
						//downcast
						Voucher vcr = (Voucher) brg;
						if(vcr.getId().equals(id)) {
							System.out.print("Masukkan jumlah : ");
							int jumlah_vcr = scan1.nextInt();
							if(vcr.getStok() < jumlah_vcr ) {
								System.out.println("Stok tidak mencukupi");
								break;
							}
							int total_vcr =  (int) (vcr.gethargaJual()*jumlah_vcr);
							System.out.println(jumlah_vcr +  " @ " + vcr.getNama() + " dengan total harga " + total_vcr);
							System.out.print("Masukkan jumlah uang : ");
							int jml_uang2 = scan1.nextInt();
							if(jml_uang2 >= total_vcr) {
								ordersVcr.add(new Order("O"+vcr.getId()+"-"+ordersVcr.size(),vcr,jumlah_vcr));
								vcr.minusStok(jumlah_vcr);
								System.out.println("Berhasil dipesan");
							
								break;
							} else {
								System.out.println("Jumlah uang tidak mencukupi.. silahkan coba lagi");
								break;
							}
						}
					}
			} else if(id == "0") {
				break;
			} 
		}
	}
		
		
	
	public static void main(String[] args) {
		dataBarang();
		Scanner scan = new Scanner(System.in);
		for(;;) {
		System.out.println("---------Menu Toko Voucher & HP---------");
		System.out.print("1. Pesan Barang\n2. Lihat Pesanan\n3. Barang Baru\n4. Exit\n");
		System.out.print("Pilihan : ");
		int input = scan.nextInt();
		switch(input) {
		case 1 :
			pesanBarang();
			break;
		case 2 :
			seeOrderHP();
			seeOrderVcr();
			System.out.println("\n\n\n");
			break;
		case 3 :
			newBarang();
			break;
		case 4 :
			System.exit(0);
			break;
		default :
			break;
		}
		}
	}
}

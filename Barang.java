import java.util.Scanner;

// Superclass untuk barang
class Barang {
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void displayInfo() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: Rp " + hargaBarang);
    }
}

// Subclass yang mengatur pembelian barang (inheritance)
class Pembelian extends Barang {
    private int jumlahBeli;

    public Pembelian(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil constructor superclass
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotal() {
        return jumlahBeli * hargaBarang; // Menghitung total harga
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method displayInfo dari superclass
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Harga: Rp " + hitungTotal());
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //exception 
        try {
            // Input data transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();

            // Validasi input
            if (hargaBarang < 0 || jumlahBeli < 0) {
                throw new IllegalArgumentException("Harga barang atau jumlah beli tidak boleh negatif.");
            }

            // Membuat objek pembelian
            Pembelian pembelian = new Pembelian(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan informasi barang
            System.out.println("\n=== Detail Transaksi ===");
            System.out.println("No Faktur: " + noFaktur);
            pembelian.displayInfo();

        } catch (IllegalArgumentException e) {
            // Menangkap kesalahan input
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Menangkap kesalahan umum lainnya
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
            System.out.println("Transaksi selesai.");
        }
    }
}
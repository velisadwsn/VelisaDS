import java.text.SimpleDateFormat;
import java.util.Date;
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

//main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login section
        System.out.println("+-----------------------------------------------------+");
        System.out.println("                     Log in");
        System.out.println("+-----------------------------------------------------+");

        String storedUsername = "rae";
        String storedPassword = "1006";
        String storedCaptcha = "12345";

        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            try {
                System.out.print("Username : ");
                String username = scanner.nextLine().trim(); // Menggunakan trim() untuk menghapus spasi tambahan

                System.out.print("Password  : ");
                String password = scanner.nextLine();

                System.out.print("Captcha    : ");
                String captcha = scanner.nextLine();

                // Validasi login (menggunakan String method equalsIgnoreCase untuk captcha)
                if (username.equals(storedUsername) && password.equals(storedPassword) && captcha.equalsIgnoreCase(storedCaptcha)) {
                    loginSuccessful = true;
                    System.out.println("Login berhasil!");
                } else {
                    throw new IllegalArgumentException("Login gagal, silakan coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
                System.out.println("+-----------------------------------------------------+\n");
        }



        try {
            // Input transaksi
            System.out.print("No. Faktur      : ");
            String noFaktur = scanner.nextLine();

            System.out.print("Kode Barang  : ");
            String kodeBarang = scanner.nextLine().toUpperCase(); // Menggunakan toUpperCase() untuk konsistensi kode barang

            System.out.print("Nama Barang : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Harga Barang : ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Jumlah Beli     : ");
            int jumlahBeli = scanner.nextInt();

            // Validasi input transaksi
            if (hargaBarang < 0 || jumlahBeli <= 0) {
                throw new IllegalArgumentException("Harga barang atau jumlah beli tidak boleh negatif atau nol.");
            }

            // Membuat objek Pembelian
            Pembelian pembelian = new Pembelian(kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            
            // Input kasir
            scanner.nextLine(); // Membersihkan buffer scanner
            System.out.print("Kasir : ");
            String namaKasir = scanner.nextLine();

            System.out.println("\n+-----------------------------------------------------+");
            System.out.println("  Selamat Datang di Supermarket Brorow!");

            // Menampilkan tanggal dan waktu saat login menggunakan Date dan SimpleDateFormat
            Date now = new Date(); // Membuat objek Date untuk mengambil waktu sekarang
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Format tanggal dan waktu
            System.out.println("  Tanggal dan Waktu : " + dateFormat.format(now)); // Menampilkan waktu dalam format yang ditentukan
            System.out.println("+-----------------------------------------------------+");

            // Menampilkan detail transaksi
            System.out.println("No. Faktur      : " + noFaktur);
            pembelian.displayInfo();

        

            System.out.println("+-----------------------------------------------------+");
            // Menggunakan toUpperCase() untuk menampilkan nama kasir dengan huruf besar
            System.out.println("Kasir : " + namaKasir.toUpperCase());
            System.out.println("+-----------------------------------------------------+");
            

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close(); // Menutup Scanner
        }
    }
}

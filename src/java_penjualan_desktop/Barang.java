package java_penjualan_desktop;

public class Barang {
    String id, nama;
    int h_beli, h_jual, stok;

    public Barang(String id, String nama, int h_beli, int h_jual, int stok) {
        this.id = id;
        this.nama = nama;
        this.h_beli = h_beli;
        this.h_jual = h_jual;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getH_beli() {
        return h_beli;
    }

    public int getH_jual() {
        return h_jual;
    }

    public int getStok() {
        return stok;
    }
    
}
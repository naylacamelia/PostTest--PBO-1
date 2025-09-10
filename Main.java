/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tes;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> namaKegiatan = new ArrayList<>();
        ArrayList<LocalDate> tenggat = new ArrayList<>(); 
        ArrayList<String> status = new ArrayList<>();

        // Contoh data awal
        namaKegiatan.add("Mengerjakan Tugas PBO");
        tenggat.add(LocalDate.of(2025, 9, 15));
        status.add("Belum selesai");
        
        namaKegiatan.add("Mencuci baju");
        tenggat.add(LocalDate.of(2025, 9, 16));
        status.add("Belum selesai");

        while (true) {
            System.out.println("\n=== ACTIVITY LOG ===");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Tampilkan Daftar Kegiatan");
            System.out.println("3. Tandai Selesai");
            System.out.println("4. Update Tenggat Kegiatan");
            System.out.println("5. Hapus Kegiatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            input.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("Masukkan kegiatan kamu: ");
                    String nama = input.nextLine();
                    namaKegiatan.add(nama);

                    System.out.print("Masukkan tenggat (format: yyyy-mm-dd): ");
                    String tglStr = input.nextLine();
                    LocalDate tgl = LocalDate.parse(tglStr); 
                    tenggat.add(tgl);

                    status.add("Belum selesai");
                    System.out.println("Kegiatan berhasil ditambahkan!");
                    break;

                case 2:
                    if (namaKegiatan.isEmpty()) {
                        System.out.println("Kegiatan kamu kosong.");
                    } else {
                        System.out.println("\n=== DAFTAR KEGIATAN ===");
                        for (int i = 0; i < namaKegiatan.size(); i++) {
                            System.out.println("-------------------------------");
                            System.out.println("No     : " + (i + 1));
                            System.out.println("Nama   : " + namaKegiatan.get(i));
                            System.out.println("Tenggat: " + tenggat.get(i)); 
                            System.out.println("Status : " + status.get(i));
                        }
                        System.out.println("-------------------------------");
                    }
                    break;

                case 3:
                    if (namaKegiatan.isEmpty()) {
                        System.out.println("Belum ada kegiatan.");
                    } else {
                        System.out.println("\n=== DAFTAR KEGIATAN ===");
                        for (int i = 0; i < namaKegiatan.size(); i++) {
                            System.out.println((i + 1) + ". " + namaKegiatan.get(i)
                                    + " | Status: " + status.get(i));
                        }
                        System.out.println("-------------------------------------------------------");
                        System.out.print("\nMasukkan nomor kegiatan yang telah diselesaikan: ");
                        int idx = input.nextInt();
                        input.nextLine();
                        if (idx > 0 && idx <= status.size()) {
                            String kegiatanSelesai = namaKegiatan.get(idx - 1);
                            status.set(idx - 1, "Selesai");
                            System.out.println("\nKegiatan " + kegiatanSelesai + " berhasil diselesaikan! ('ᴗ')");
                            System.out.println("-------------------------------------------------------");
                        } else {
                            System.out.println("Nomor tidak valid.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== DAFTAR KEGIATAN ===");
                    for (int i = 0; i < namaKegiatan.size(); i++) {
                        System.out.println((i + 1) + ". " + namaKegiatan.get(i)
                                + " | Tenggat: " + tenggat.get(i));
                    }
                    System.out.println("-------------------------------------------------------");
                    System.out.print("\nMasukkan nomor kegiatan yang ingin diperbarui: ");
                    int updateIdx = input.nextInt();
                    input.nextLine();
                    if (updateIdx > 0 && updateIdx <= tenggat.size()) {
                        String updateKegiatan = namaKegiatan.get(updateIdx - 1);

                        System.out.print("Masukkan tenggat baru (format: yyyy-mm-dd): ");
                        LocalDate tglBaru = LocalDate.parse(input.nextLine());
                        tenggat.set(updateIdx - 1, tglBaru);
                        System.out.println("\nTenggat " + updateKegiatan + " berhasil diperbarui! ('ᴗ')");
                        System.out.println("-------------------------------------------------------");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== DAFTAR KEGIATAN ===");
                    for (int i = 0; i < namaKegiatan.size(); i++) {
                        System.out.println((i + 1) + ". " + namaKegiatan.get(i)
                                + " | Status: " + status.get(i));
                    }
                    System.out.println("-------------------------------------------------------");
                    System.out.print("\nMasukkan nomor kegiatan yang ingin dihapus: ");
                    int hapusIdx = input.nextInt();
                    input.nextLine();
                    if (hapusIdx > 0 && hapusIdx <= namaKegiatan.size()) {
                        String hapusKegiatan = namaKegiatan.get(hapusIdx - 1);
                        namaKegiatan.remove(hapusIdx - 1);
                        tenggat.remove(hapusIdx - 1);
                        status.remove(hapusIdx - 1);
                        System.out.println("Kegiatan " + hapusKegiatan + " berhasil dihapus! ('ᴗ')");
                        System.out.println("-------------------------------------------------------");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;

                case 6:
                    System.out.println("\n+--------------------------------------------------+");
                    System.out.println("| Terimakasih telah menggunakan program ini~       |");
                    System.out.println("| SEE YOU! (^_^)                                   |");
                    System.out.println("+--------------------------------------------------+\n");
                    input.close();
                    return;

                default:
                    System.out.println("Input tidak valid.");
            }
        }
    }
}

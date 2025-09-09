/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<String> namaKegiatan = new ArrayList<>();
    ArrayList<String> tenggat = new ArrayList<>();
    ArrayList<String> status = new ArrayList<>();

    while (true) {
        System.out.println("\n=== ACTIVITY LOG ===");
        System.out.println("1. Tambah Kegiatan");
        System.out.println("2. Tampilkan Daftar Kegiatan");
        System.out.println("3. Tandai Selesai");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
        int menu = input.nextInt();
        input.nextLine(); 

             switch (menu) {
                case 1: 
                    System.out.print("Masukkan kegiatan kamu: ");
                    String nama = input.nextLine();
                    namaKegiatan.add(nama);

                    System.out.print("tenggat kegiatan (contoh: Senin): ");
                    String hari = input.nextLine();
                    tenggat.add(hari);

                    status.add("Belum selesai"); 
                    System.out.println("Kegiatan berhasil ditambahkan!");
                    break;

                case 2: 
                    if (namaKegiatan.isEmpty()) {
                        System.out.println("Kegiatan kamu kosong.");
                    } else {
                        System.out.println("\n=== DAFTAR KEGIATAN ===");
                        for (int i = 0; i < namaKegiatan.size(); i++) {
                            System.out.println((i + 1) + ". " + namaKegiatan.get(i)
                                    + " | Tenggat: " + tenggat.get(i)
                                    + " | Status: " + status.get(i));
                        }
                    }
                    break;

                case 3:
                    if (namaKegiatan.isEmpty()) {
                        System.out.println("Belum ada kegiatan.");
                    } else {
                        System.out.println("\nMasukkan nomor kegiatan yang telah diselesaikan:");
                        for (int i = 0; i < namaKegiatan.size(); i++) {
                            System.out.println((i + 1) + ". " + namaKegiatan.get(i)
                                    + " | Status: " + status.get(i));
                        }
                        int idx = input.nextInt();
                        input.nextLine();
                        if (idx > 0 && idx <= status.size()) {
                            status.set(idx - 1, "Selesai");
                            System.out.println("Kegiatan nomor " + idx + " telah selesai!");
                        } else {
                            System.out.println("Nomor tidak valid.");
                        }
                    }
                    break;

                case 4: 
                    System.out.println("Terima kasih telah menggunakan program ini!.");
                    input.close();
                    return;

                default:
                    System.out.println("input tidak valid.");
            }
        }
    }
}
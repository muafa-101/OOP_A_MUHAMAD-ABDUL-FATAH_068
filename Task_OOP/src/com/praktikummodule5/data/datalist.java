package com.praktikummodule5.data;

import com.praktikummodule5.users.admin_module_5;
import com.praktikummodule5.users.mahasiswa_module_5;
import com.praktikummodule5.users.user_module_5;
import com.praktikummodule5.data.item_module_5; // Pastikan ini import class Item

import java.util.ArrayList;

public class datalist {

    // Penyimpanan global
    public static ArrayList<user_module_5> userlist = new ArrayList<>();
    public static ArrayList<item_module_5> itemlist = new ArrayList<>();

    // Blok static untuk inisialisasi data awal
    static {
        // Tambahkan Admin dan Mahasiswa default
        userlist.add(new admin_module_5("admintampan", "admintampan"));
        userlist.add(new mahasiswa_module_5("202410370110393", "fatah"));
        // Tambahkan lebih banyak jika perlu
    }
}

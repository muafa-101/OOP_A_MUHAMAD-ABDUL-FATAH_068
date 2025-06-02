package com.praktikummodule6.data;

import com.praktikummodule6.item.item;
import com.praktikummodule6.users.admin;
import com.praktikummodule6.users.mahasiswa;
import com.praktikummodule6.users.user;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<user> users = new ArrayList<>();
    public static List<item> items = new ArrayList<>();

    static {
        users.add(new admin("admin", "123"));
        users.add(new mahasiswa("mahasiswa", "123"));
    }
}


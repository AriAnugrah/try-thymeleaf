package com.enigma.ari.tryThymeleaf;

public class Employeess {
    private int id;
    private String name;
    private String jabatan;
    private int golongan;
    private float gaji;

    public Employeess() {
    }

    public Employeess(int id, String name, String jabatan, int golongan, float gaji) {
        this.id = id;
        this.name = name;
        this.jabatan = jabatan;
        this.golongan = golongan;
        this.gaji = gaji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }

    public float getGaji() {
        return gaji;
    }

    public void setGaji(float gaji) {
        this.gaji = gaji;
    }

    @Override
    public String toString() {
        return "Employeess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", golongan=" + golongan +
                ", gaji=" + gaji +
                '}';
    }
}

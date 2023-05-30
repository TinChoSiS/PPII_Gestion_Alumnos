package models;

public class Usuario {
    private int id;
    private String name;
    private String username;
    private String grupo;
    private int calificacion;
    private boolean is_staff;

    public Usuario() {
    }

    public Usuario(int id, String name, String username, boolean is_staff, String grupo, int calificacion) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.is_staff = is_staff;
        this.grupo = grupo;
        this.calificacion = calificacion;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isStaff() {
        return this.is_staff;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public void setIsStaff(boolean is_staff) {
        this.is_staff = is_staff;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }



}

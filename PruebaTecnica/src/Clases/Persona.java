package Clases;



public class Persona {
    // Lista de nombres para generar espectadores
    public static String[] listaNombre = { "Veronica", "Carlos", "Michel", "Eduardo", "Walter", "Gabriela",
            "Jeferson" };

    // Lista de apellidos para generar espectadores
    public static String[] listaApellido = { "Gonzales", "Avila", "Silva", "Herrera", "Ordoñes", "Gomez", "Lopez" };

    protected String nombre;
    protected String apellido;
    protected int edad;

    public Persona() {
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    

}

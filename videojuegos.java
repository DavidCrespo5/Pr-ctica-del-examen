import java.util.Scanner;

public class Videojuegos {
    private String nombre;
    private String consola;
    private String fecha;

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // constructor
    public Videojuegos(String nombre, String consola, String fecha) {
        this.nombre = nombre;
        this.consola = consola;
        this.fecha = fecha;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Consola: " + consola);
        System.out.println("Fecha: " + fecha);
    }

    // clase anidada TipoVideojuego
    public class TipoVideojuego {
        public String genero;

        public TipoVideojuego(String genero) {
            this.genero = genero;
        }

        public void mostrar() {
            Videojuegos.this.mostrar();
            System.out.println("Genero: " + genero);
        }
    }

    // subclase Terror
    public class Terror extends TipoVideojuego {
        public String monstruo;

        public Terror(String nombre, String consola, String fecha, String genero, String monstruo) {
            super(genero);
            Videojuegos.this.setNombre(nombre);
            Videojuegos.this.setConsola(consola);
            Videojuegos.this.setFecha(fecha);
            this.monstruo = monstruo;
        }

        public void mostrarTerror() {
            super.mostrar();
            System.out.println("Monstruo: " + monstruo);
        }
    }

    // subclase Aventura
    public class Aventura extends TipoVideojuego {
        public String recompensa;
        public String heroe;

        public Aventura(String nombre, String consola, String fecha, String genero, String recompensa, String heroe) {
            super(genero);
            Videojuegos.this.setNombre(nombre);
            Videojuegos.this.setConsola(consola);
            Videojuegos.this.setFecha(fecha);
            this.recompensa = recompensa;
            this.heroe = heroe;
        }

        public void mostrarAventura() {
            super.mostrar();
            System.out.println("Recompensa: " + recompensa);
            System.out.println("Héroe: " + heroe);
        }
    }

    // subclase Rol
    public class Rol extends TipoVideojuego {
        public int turnos;
        public String personaje;

        public Rol(String nombre, String consola, String fecha, String genero, int turnos, String personaje) {
            super(genero);
            Videojuegos.this.setNombre(nombre);
            Videojuegos.this.setConsola(consola);
            Videojuegos.this.setFecha(fecha);
            this.turnos = turnos;
            this.personaje = personaje;
        }

        public void mostrarRol() {
            super.mostrar();
            System.out.println("Turnos: " + turnos);
            System.out.println("Personaje: " + personaje);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de juegos:");
        int numJuegos = sc.nextInt();
        sc.nextLine();

        Videojuegos[] juegos = new Videojuegos[numJuegos];

        for (int i = 0; i < numJuegos; i++) {
            System.out.println("\t\t\t JUEGO " + (i + 1));
            System.out.println("Ingrese el nombre del videojuego:");
            String nombre = sc.nextLine();

            System.out.println("Ingrese la consola del juego: ");
            String consola = sc.nextLine();

            System.out.println("Ingrese la fecha de lanzamiento: ");
            String fecha = sc.nextLine();
            System.out.println("Ingrese el tipo de videojuego (aventura/rol/terror):");
            String tipoJuego = sc.nextLine().toLowerCase();

            if (tipoJuego.equals("aventura")) {
                System.out.println("Ingrese la recompensa:");
                String recompensa = sc.nextLine();
                System.out.println("Ingrese el héroe:");
                String heroe = sc.nextLine();


            } else if (tipoJuego.equals("rol")) {
                System.out.println("Ingrese el número de turnos:");
                int turnos = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el personaje:");
                String personaje = sc.nextLine();


            } else if (tipoJuego.equals("terror")) {
                System.out.println("Ingrese el monstruo:");
                String monstruo = sc.nextLine();

            } else {
                System.out.println("Tipo de videojuego no válido. Se asignará como un videojuego genérico.");

            }
        }

        // Mostrar la información de los juegos
        for (int i = 0; i < numJuegos; i++) {
            System.out.println("\nInformación del Juego " + (i + 1) + ":");
            if (juegos[i] != null) {
                juegos[i].mostrar();
            } else {
                System.out.println("No se ingresó información para este juego.");
            }
        }
    }
}

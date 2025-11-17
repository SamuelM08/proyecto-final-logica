public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private String entrenador;

    public Pokemon(int id, String nombre, String tipo, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.entrenador = entrenador;

        // ataque y defensa aleatorios
        this.ataque = (int)(Math.random() * 100) + 1;
        this.defensa = (int)(Math.random() * 100) + 1;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public String getEntrenador() { return entrenador; }

    @Override
    public String toString() {
        return String.format(
            "ID:%d | %s | Tipo:%s | ATK:%d | DEF:%d | Entrenador:%s",
            id, nombre, tipo, ataque, defensa, entrenador
        );
    }
}

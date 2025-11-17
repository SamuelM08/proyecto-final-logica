public class Entrenador {
    private String nombre;
    private int id;
    private int[] equipo = new int[6]; // almacena IDs de Pokémon
    private int count = 0;

    public int PJ = 0, PG = 0, PP = 0;

    public Entrenador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void agregarPokemon(int pokeId) {
        if (count < 6) {
            equipo[count++] = pokeId;
        }
    }

    public int[] getEquipo() {
        return equipo;
    }

    public String getNombre() { return nombre; }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pokemon[] pokedex = new Pokemon[40];
        int pokeCount = 0;

        System.out.print("¿Cuántos Pokemon desea registrar? (max 40): ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Registrar Pokémon #" + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt(); sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Tipo (Agua/Fuego/Planta/Eléctrico): ");
            String tipo = sc.nextLine();

            System.out.print("Entrenador: ");
            String entrenador = sc.nextLine();

            pokedex[pokeCount++] = new Pokemon(id, nombre, tipo, entrenador);
        }

        System.out.println("\nPokémon registrados:");
        for (int i = 0; i < pokeCount; i++) {
            System.out.println(pokedex[i]);
        }

        // ORDENAR POR ATAQUE
        UtilOrdenamiento.seleccionPorAtaque(pokedex, pokeCount);
        System.out.println("\n--- Ordenado por ATAQUE (Selección) ---");
        for (int i = 0; i < pokeCount; i++) System.out.println(pokedex[i]);

        // ORDENAR POR DEFENSA
        UtilOrdenamiento.insercionPorDefensa(pokedex, pokeCount);
        System.out.println("\n--- Ordenado por DEFENSA (Inserción) ---");
        for (int i = 0; i < pokeCount; i++) System.out.println(pokedex[i]);

        // BÚSQUEDA
        System.out.print("\nBuscar Pokémon por nombre: ");
        String bn = sc.nextLine();
        int pos = UtilBusqueda.busquedaLinealPorNombre(pokedex, pokeCount, bn);

        if (pos >= 0) System.out.println("Encontrado: " + pokedex[pos]);
        else System.out.println("No encontrado.");

        // CAMPEONATO
        Entrenador[] entrenadores = {
            new Entrenador(1, "Ash"),
            new Entrenador(2, "Gary"),
            new Entrenador(3, "Misty")
        };

        entrenadores[0].agregarPokemon(pokedex[0].getId());
        entrenadores[1].agregarPokemon(pokedex[1].getId());
        entrenadores[2].agregarPokemon(pokedex[2].getId());

        Campeonato.jugar(entrenadores, 3, pokedex, pokeCount);

        sc.close();

        System.out.println("\nProfe, este ejercicio tomó su tiempo… sería más fácil si en clase todo fuera menos confuso, pero bueno, se entregó.");
    }
}

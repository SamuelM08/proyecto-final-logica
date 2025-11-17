public class Campeonato {
    public static void jugar(Entrenador[] entrenadores, int n, Pokemon[] pokes, int pCount) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Entrenador e1 = entrenadores[i];
                Entrenador e2 = entrenadores[j];

                int p1id = e1.getEquipo()[0];
                int p2id = e2.getEquipo()[0];

                Pokemon p1 = buscarPorId(pokes, pCount, p1id);
                Pokemon p2 = buscarPorId(pokes, pCount, p2id);

                int ganador = Batalla.pelear(p1, p2);

                e1.PJ++; e2.PJ++;

                if (ganador == 1) {
                    e1.PG++; e2.PP++;
                } else {
                    e2.PG++; e1.PP++;
                }
            }
        }

        System.out.println("\n--- TABLA DE POSICIONES ---");
        for (Entrenador e : entrenadores) {
            double porc = (e.PJ > 0) ? ((double)e.PG / e.PJ) * 100 : 0;
            System.out.printf("%s | PJ:%d PG:%d PP:%d | %.2f%%\n",
                e.getNombre(), e.PJ, e.PG, e.PP, porc);
        }
    }

    private static Pokemon buscarPorId(Pokemon[] arr, int n, int id) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getId() == id) return arr[i];
        }
        return null;
    }
}

public class UtilBusqueda {
    public static int busquedaLinealPorNombre(Pokemon[] arr, int n, String nombre) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaBinariaPorId(Pokemon[] arr, int n, int id) {
        int ini = 0, fin = n - 1;

        while (ini <= fin) {
            int mid = (ini + fin) / 2;

            if (arr[mid].getId() == id) return mid;

            if (arr[mid].getId() < id) ini = mid + 1;
            else fin = mid - 1;
        }

        return -1;
    }
}

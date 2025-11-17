public class UtilOrdenamiento {

    public static void seleccionPorAtaque(Pokemon[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getAtaque() < arr[minIdx].getAtaque()) {
                    minIdx = j;
                }
            }
            Pokemon temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void insercionPorDefensa(Pokemon[] arr, int n) {
        for (int i = 1; i < n; i++) {
            Pokemon key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].getDefensa() > key.getDefensa()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

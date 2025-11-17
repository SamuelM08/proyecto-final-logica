public class Batalla {

    private static double efectividad(String t1, String t2) {
        if (t1.equalsIgnoreCase("Agua") && t2.equalsIgnoreCase("Fuego")) return 2;
        if (t1.equalsIgnoreCase("Agua") && t2.equalsIgnoreCase("Planta")) return 0.5;
        if (t1.equalsIgnoreCase("Fuego") && t2.equalsIgnoreCase("Planta")) return 2;
        if (t1.equalsIgnoreCase("Fuego") && t2.equalsIgnoreCase("Agua")) return 0.5;
        if (t1.equalsIgnoreCase("Planta") && t2.equalsIgnoreCase("Agua")) return 2;
        if (t1.equalsIgnoreCase("Planta") && t2.equalsIgnoreCase("Fuego")) return 0.5;
        if (t1.equalsIgnoreCase("Eléctrico") && t2.equalsIgnoreCase("Agua")) return 2;
        return 1;
    }

    public static int pelear(Pokemon p1, Pokemon p2) {
        int hp1 = 100, hp2 = 100;
        boolean turnoP1 = true;

        System.out.println("\n--- BATALLA ---");
        System.out.println(p1.getNombre() + " VS " + p2.getNombre());
        System.out.println("-------------------");

        while (hp1 > 0 && hp2 > 0) {
            Pokemon atk = turnoP1 ? p1 : p2;
            Pokemon def = turnoP1 ? p2 : p1;

            double eff = efectividad(atk.getTipo(), def.getTipo());
            int dmg = (int)Math.round(50 * ((double)atk.getAtaque() / def.getDefensa()) * eff);
            if (dmg < 1) dmg = 1;

            if (turnoP1) hp2 -= dmg;
            else hp1 -= dmg;

            System.out.println(atk.getNombre() + " golpea por " + dmg +
                " | HP " + p1.getNombre() + "=" + hp1 +
                " HP " + p2.getNombre() + "=" + hp2);

            turnoP1 = !turnoP1;
        }

        return hp1 > 0 ? 1 : 2;  
    }
}

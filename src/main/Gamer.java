package main;

import java.util.*;

/**
 * Solution for Codeforces - Gamer Hemose - 1592A
 */
public class Gamer {
    public static Scanner lec = new Scanner(System.in);

    public static void main(String[] args) {
        int x = lec.nextInt();
        int datoGuardado = 0;
        for (int i = 0; i < x; i++) {
            int y = lec.nextInt();
            int vida = lec.nextInt();
            ArrayList<Integer> dama = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                int um = lec.nextInt();
                dama.add(um);

            }

            Collections.sort(dama);
            int ta = dama.size() - 1;
            int numMayor = dama.get(ta);
            int numMayor2 = dama.get(ta-1);
            datoGuardado = 0;
            while(vida>0){
                int posNumMayor = binarySearch(0, ta, dama, numMayor);
                vida-=dama.get(posNumMayor);
                datoGuardado++;
                if (vida>0){
                    posNumMayor = binarySearch(0, ta, dama, numMayor2);
                    vida-=dama.get(posNumMayor);
                    datoGuardado++;
                }
            }
            System.out.println(datoGuardado);
        }
    }

    public static int binarySearch(int inicio, int fin, ArrayList<Integer> arreglo, int buscar) {
		int x = (inicio+fin)/2;
		if(!(inicio<=fin)) {
			return -1;
		}
		if (arreglo.get(x)<buscar) {
			return binarySearch(x+1, fin, arreglo, buscar);
		} else if (arreglo.get(x)>buscar){
			return binarySearch(inicio, x-1, arreglo, buscar);
		}
		return x;
	}

    /**
     * Solucion O(1) sin busqueda binaria
     * if (dama != inf) {
                inf = dama;
                int sum = dama.get(ta) + dama.get(ta - 1);
                int total = 2 * (vida / sum);
                if (vida % sum != 0) {
                    if ((sum * (vida / sum)) + dama.get(ta) >= vida) {
                        total++;
                    } else {
                        total += 2;
                    }
                }
                System.out.println(total);
                datoGuardado = total;
            } else {
                System.out.println(datoGuardado);
            }
     */
}

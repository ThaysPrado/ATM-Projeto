package negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;

import idioma.Idioma;

public class Dispenser {
	private int vet[];

	// Metodo contrutor apartir da quantidade de notas no txt
	public Dispenser() {
		File arquivo = new File(System.getProperty("user.dir") + "\\src\\negocio\\dispenser.txt");
		vet = new int[3];
		int i = 0;
		try (FileReader fr = new FileReader(arquivo); BufferedReader br = new BufferedReader(fr);) {
			while (br.ready()) {
				vet[i++] = Integer.parseInt(br.readLine());
			}
		} catch (Exception e) {
		}
	}

	// Metodos auxiliares
	private boolean n10() {
		return vet[0] == 0;
	}

	private boolean n20() {
		return vet[1] == 0;
	}

	private boolean n50() {
		return vet[2] == 0;
	}

	// Metodo que mostra quais notas estao disponiveis
	public String status() {
		if (!n10() && !n20() && !n50()) {
			return Idioma.getRb().getString("dispenser1");
		} else if (!n10() && !n20() && n50()) {
			return Idioma.getRb().getString("dispenser2");
		} else if (!n10() && n20() && !n50()) {
			return Idioma.getRb().getString("dispenser3");
		} else if (n10() && !n20() && !n50()) {
			return Idioma.getRb().getString("dispenser4");
		} else if (!n10() && n20() && n50()) {
			return Idioma.getRb().getString("dispenser5");
		} else if (n10() && !n20() && n50()) {
			return Idioma.getRb().getString("dispenser6");
		} else if (n10() && n20() && !n50()) {
			return Idioma.getRb().getString("dispenser7");
		} else {
			return Idioma.getRb().getString("dispenser8");
		}
	}

	// Metodo que faz a melhor contagem de notas (Resquisito)
	public String contar(int x) {
		int y = x;
		int a, b, c;
		a = b = c = 0;
		while (x - 50 >= 0 && vet[0] - c > 0) {
			x -= 50;
			c++;
		}

		while (x - 20 >= 0 && vet[1] - b > 0) {
			x -= 20;
			b++;
		}

		while (x - 10 >= 0 && vet[2] - a > 0) {
			x -= 10;
			a++;
		}
		if (x == 0) {
			vet[0] -= a;
			vet[1] -= b;
			vet[2] -= c;
			System.out.println("R$" + y + ",00\n");
			System.out.println("R$50,00   R$20,00   R$10,00");
			System.out.println(n(a + "") + a + "x   " + n(b + "") + b + "x   " + n(c + "") + c + "x\n");
			try (Formatter saida = new Formatter(System.getProperty("user.dir") + "\\src\\negocio\\dispenser.txt");) {
				String quebraDeLinha = System.getProperty("line.separator");
				for (int i = 0; i < vet.length; i++) {
					saida.format(vet[i] + quebraDeLinha);
				}
			} catch (Exception e) {
			}
			return Idioma.getRb().getString("dispenserAviso1");
		} else {
			return Idioma.getRb().getString("dispenserAviso2");
		}
	}

	private static String n(String x) {
		String resp = "";
		int y = 6 - x.length();
		for (int i = 0; i < y; i++) {
			resp += " ";
		}
		return resp;
	}

}
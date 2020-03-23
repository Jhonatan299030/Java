import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException{

        List<String> strings = new ArrayList<>();
        List<String> stringsReorder = new ArrayList<>();
        List<Character> slice = new ArrayList<>();

        strings.add("pipoca");
        strings.add("pirocafasd");
        strings.add("motocatetr");
        strings.add("tiroca");

        strings.sort((a,b) -> a.compareTo(b));

		strings.forEach(System.out::println);

        strings.forEach(string -> {
        	slice.clear();
			for (int i = 0; i < string.length(); i++) {
				slice.add(string.charAt(i));
			}

			slice.sort((a,b) -> a.compareTo(b));

			String teste = slice.toString().replaceAll("[\\[, \\,, \\]]", "").trim();

			stringsReorder.add(teste);
		});


		stringsReorder.forEach(System.out::println);

		int a = 3;
//		int b = a / 0;
		
		
//		ContaCorrente outra = null;
//		outra.deposita(200.0);
					
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());


	}

}

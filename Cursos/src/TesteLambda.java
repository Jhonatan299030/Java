import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TesteLambda {
    public static void main(String args[]){
        List<Cursos> cursos = new ArrayList<Cursos>();
        cursos.add(new Cursos("Python", 45));
        cursos.add(new Cursos("JavaScript", 150));
        cursos.add(new Cursos("Java 8", 113));
        cursos.add(new Cursos("C", 55));

//        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        cursos.sort((a, b) -> Integer.compare(b.getAlunos(), a.getAlunos()));

        Stream<String> nomes = cursos.stream().map(Cursos::getNome);

        System.out.println(nomes);

//        cursos.forEach(c -> System.out.println(c.getNome() + ":" + c.getAlunos()));
//
//        System.out.println("-------------------------------------------------");
//        cursos.stream().filter(e -> e.getAlunos() > 50).forEach(p -> System.out.println(p.getNome()));
    }
}

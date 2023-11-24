import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ToDoList {
    private static List<Zadanie> zadania = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\nWybierz opcje:");
            System.out.println("[ 1 ] - Dodaj nowe zadanie.");
            System.out.println("[ 2 ] - Oznacz zadanie jako wykonane.");
            System.out.println("[ 3 ] - Usun zadanie.");
            System.out.println("[ 4 ] - Wyswietl liste zadan.");
            System.out.println("[ 5 ] - Zakoncz dzialanie programu.");
            byte wybranaOpcja = s.nextByte();
            s.nextLine();

            switch (wybranaOpcja) {
                case 1:
                    //Dodawanie nowego zadania
                    dodajZadanie(s);
                    break;
                case 2:
                    // Oznaczanie zadan jako wykonane
                    oznaczZadanie(s);
                    break;
                case 3:
                    //usuwanie zadan
                    usunZadanie(s);
                    break;
                case 4:
                    //wyswietlanie listy zadan
                    wyswietlZadania(s);
                    break;
                case 5:
                    //wylaczanie programu
                    System.out.println("Wylaczanie programu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Niepoprawna opcja, wybierz ponownie.");
                    break;
            }
        }
    }

    private static void dodajZadanie(Scanner s) {
        System.out.println("\n\nPodaj nazwe nowego zadania:");
        String n = s.nextLine();
        System.out.println("Podaj opis dla zadania "+n);
        String opis = s.nextLine();
        Zadanie zadanie = new Zadanie(n,opis);
        zadania.add(zadanie);
        System.out.println("Pomyslnie stworzono zadanie: '"+n+ "'");
    }

    private static void oznaczZadanie(Scanner s) {
        System.out.println("Podaj numer zadania do oznaczenia jako wykonane:");
        int numer = s.nextInt();
        if (numer >= 1 && numer <= zadania.size()) {
            Zadanie zadanie = zadania.get(numer - 1);
            zadanie.ustawJakoSkonczone(true);
            System.out.println("Pomylsnie ustawiono zadanie "+numer+" jako wykonane.");
        } else {
            System.out.println("Niepoprawny numer zadania.");
        }
    }

    private static void usunZadanie(Scanner s) {
        System.out.println("Podaj numer zadania w liscie:");
        int numer = s.nextInt();
        if (numer >= 1 && numer <= zadania.size()) {
            Zadanie zadanie = zadania.remove(numer - 1);
            System.out.println("Pomyslnie usunieto zadanie "+numer+" z listy zadan.");
        } else {
            System.out.println("Niepoprawny numer zadania.");
        }
    }

    private static void wyswietlZadania(Scanner s) {
        System.out.println("Wyswietlanie listy zadan:");
        if (zadania.isEmpty()) {
            System.out.println("Pusta lista zadan.");
        } else {
            for (int i = 0; i < zadania.size(); i++){
                System.out.println((i + 1) + "." + zadania.get(i));
            }
        }
    }



}
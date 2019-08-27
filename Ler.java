import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Ler {
    ArrayList<CriarAgenda> agenda = new ArrayList();
    ArrayList<String> contatos = new ArrayList<>();
    CriarAgenda ca;

    public Ler() throws IOException {
        String fileName = "contatos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                contatos.add(line);
            }

        } catch (IOException e) {
            System.out.println("nao ha o arquivo contatos.txt, criando um novo contato.txt");
        }

    }

    public void nome() {

        for (int i = 0; i < contatos.size(); i++) {
            String nome = contatos.get(i);
            String[] t = nome.split (Pattern.quote (", "));
            agenda.add(ca = new CriarAgenda(t[0],t[1]));
        }

    }

    public ArrayList<CriarAgenda> getAgenda(){
        return agenda;
    }

}

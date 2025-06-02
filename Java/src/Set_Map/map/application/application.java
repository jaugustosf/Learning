package Set_Map.map.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String PATH = "C:/Dev/Projects/Learning/Java/src/Set_Map/map/VoteList.txt";
        Map<String, Integer> votes = new LinkedHashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String line = bufferedReader.readLine();

            while (line != null){
                String[] campos = line.split(",");
                String name = campos[0].trim();
                int votesCount = Integer.parseInt(campos[1].trim());

                if (votes.containsKey(name)) {
                    int votesAtMoment = votes.get(name); //Pega o valor associado a key
                    votes.put(name, votesCount + votesAtMoment);
                } else {
                    votes.put(name, votesCount);
                }
                line = bufferedReader.readLine();
            }
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        sc.close();
    }
}

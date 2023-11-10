package vectors.CpfValidator;

import vectors.entities.Cpf;

public class Program {
    public static void main(String[] args) {
        Cpf cpf = new Cpf("94216525091"); //94216525091
        for (int i = 0; i < 11; i++) System.out.print(cpf.getCpf()[i]);

        System.out.println();
        Cpf cpf2 = new Cpf("942.165.250-91"); //00000000000
        for (int i = 0; i < 11; i++) System.out.print(cpf2.getCpf()[i]);

        System.out.println();
        Cpf cpf3 = new Cpf(); //true
        System.out.println(cpf3.isCpfValido("35369404046"));

        Cpf cpf4 = new Cpf(); //false
        System.out.println(cpf4.isCpfValido("353.694.040-46"));
    }
}
package vectors.entities;

public class Cpf {
    private int[] cpf = new int[11];
    private String nome;
    private String data;

    public Cpf() {
    }

    public Cpf(String cpf) {
        this.cpf = cpfString2Array(cpf);
    }

    public int[] getCpf() {
        return cpf;
    }

    public boolean setData(String data) {
        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            this.data = data;
            return true;
        } else if (data.matches("\\d{1}/\\d{1}/\\d{4}")) {
            this.data = data;
            return true;
        } else {
            this.data = null;
            return false;
        }
    }

    public boolean isCpfValido(String cpf) {
        int[] cpfArray = cpfString2Array(cpf);

        if (cpfArray.length != 11 || isEmptyArray(cpfArray)) {
            return false;
        }

        int j = calcJ(cpfArray);
        int k = calcK(cpfArray);

        return cpfArray[9] == j && cpfArray[10] == k;
    }

    public int[] cpfString2Array(String cpf) {
        int[] cpfArray = new int[11];

        if (cpf.length() != 11) {
            return cpfArray;
        }

        cpf = cpf.replaceAll("\\D", ""); //Retira todos os caractéries não numericos

        for (int i = 0; i < 11; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }

        return cpfArray;
    }

    private boolean isEmptyArray(int[] array) {
        for (int value : array) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    private int calcJ(int[] cpfArray) {
        int soma1 = cpfArray[0] * 10 + cpfArray[1] * 9 + cpfArray[2] * 8
                + cpfArray[3] * 7 + cpfArray[4] * 6 + cpfArray[5] * 5
                + cpfArray[6] * 4 + cpfArray[7] * 3 + cpfArray[8] * 2;

        int resto1 = soma1 % 11;
        int j = (resto1 <= 1) ? 0 : 11 - resto1;
        return j;
    }

    private int calcK(int[] cpfArray) {
        int soma2 = cpfArray[0] * 11 + cpfArray[1] * 10 + cpfArray[2] * 9 + cpfArray[3] * 8 + cpfArray[4] * 7
                + cpfArray[5] * 6 + cpfArray[6] * 5 + cpfArray[7] * 4 + cpfArray[8] * 3 + cpfArray[9] * 2;

        int resto2 = soma2 % 11;
        int k = (resto2 <= 1) ? 0 : 11 - resto2;
        return k;
    }
}
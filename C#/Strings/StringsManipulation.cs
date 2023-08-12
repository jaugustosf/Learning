using System;
using System.Globalization;

namespace Strings{
    public class Program{
        public static void StringManipu(){
            string produto1 = "Computador";
            string produto2 = "Mesa de escritorio";

            int idade = 30;
            int codigo = 5290;
            char genero = 'M';

            double preco1 = 2100.0;
            double preco2 = 650.50;
            double medida = 53.294769;

            System.Console.WriteLine("Produtos:");
            System.Console.WriteLine($"{produto1}, cujo preco e {preco1:F2}", produto1, preco1);
            System.Console.WriteLine($"{produto2}, cujo preco e ${preco2:F2}", produto2, preco2);
            System.Console.WriteLine();
            System.Console.WriteLine($"Registro: {idade} anos de idade, codigo {codigo} e genero: {genero}", idade, codigo, genero);
            System.Console.WriteLine();
            System.Console.WriteLine($"Medida com oito casas decimais: {medida:F8}", medida);
            System.Console.WriteLine($"Arredondado {medida:F3}", medida);
            System.Console.WriteLine($"Arredondado: {medida.ToString("F3", CultureInfo.InvariantCulture)}");
        }
    }
}
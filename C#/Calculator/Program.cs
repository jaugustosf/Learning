using System.Security.AccessControl;
using System;

namespace Calculator{
    class Program{
        static void Main(string[] args){
            Menu();
        }


        static void Menu(){
            Console.Clear();
            int option = -1;

            while(option != 0){
                System.Console.WriteLine("MathCalc");
                System.Console.WriteLine("1 - Soma");
                System.Console.WriteLine("2 - Subtração");
                System.Console.WriteLine("3 - Multiplicação");
                System.Console.WriteLine("4 - Divisão");
                System.Console.WriteLine("0 - Sair");
                
                System.Console.WriteLine("");
                System.Console.Write("Escolha uma opção:");
                
                option = int.Parse(Console.ReadLine());

                switch(option){
                    case 1:
                        Soma();
                        break;
                    case 2:
                        Sub();
                        break;
                    case 3:
                        Multip();
                        break;
                    case 4:
                        Div();
                        break;
                    case 0:
                        System.Console.WriteLine("Saindo...");
                        System.Environment.Exit(0);
                        break;
                    default:
                        Menu();
                        break;
                }   
            }
        }

        static void Soma(){
            Console.Clear();

            System.Console.WriteLine("Primeiro valor: ");
            float v1 = float.Parse(Console.ReadLine());

            System.Console.WriteLine("Segundo valor: ");
            float v2 = float.Parse(Console.ReadLine());

            float result = v1 + v2;

            System.Console.WriteLine($"Resultado: {result:F1}");

            Console.ReadKey();
            
        }

        static void Sub(){
            Console.Clear();

            System.Console.WriteLine("Primeiro valor: ");
            float v1 = float.Parse(Console.ReadLine());

            System.Console.WriteLine("Segundo valor: ");
            float v2 = float.Parse(Console.ReadLine());

            float result = v1 - v2;

            System.Console.WriteLine($"Resultado: {result:F1}");
            
            Console.ReadKey();
            
        }

        static void Div(){
            Console.Clear();

            System.Console.WriteLine("Primeiro valor: ");
            float v1 = float.Parse(Console.ReadLine());

            System.Console.WriteLine("Segundo valor: ");
            float v2 = float.Parse(Console.ReadLine());

            float result = v1/v2;

            System.Console.WriteLine($"Resultado: {result:F2}");

            Console.ReadKey();
            
        }

        static void Multip(){
            Console.Clear();

            System.Console.WriteLine("Primeiro valor: ");
            float v1 = float.Parse(Console.ReadLine());

            System.Console.WriteLine("Segundo valor: ");
            float v2 = float.Parse(Console.ReadLine());

            float result = v1 * v2;

            System.Console.WriteLine($"Resultado: {result:F2}");

            Console.ReadKey();
            
        }
    }
}
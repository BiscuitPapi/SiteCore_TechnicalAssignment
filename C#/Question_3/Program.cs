using System;
using System.Collections.Generic;

namespace Q3
{
    public class Minefield
    {
        public static void Main(string[] args)
        {
            int m = 5;
            int n = 7;

            char[,] minefield = GenerateRandomMinefield(m, n);
            Console.WriteLine("Minefield:");
            DisplayMinefield(minefield);

            Console.WriteLine("\nStart Journey:");
            DisplayMovement(minefield);
        }

        public static char[,] GenerateRandomMinefield(int m, int n)
        {
            char[,] field = new char[m, n];

            for (int x = 0; x < m; x++)
            {
                for (int y = 0; y < n; y++)
                {
                    field[x, y] = '0';
                }
            }

            Random random = new Random();

            for (int x = 0; x < m; x++)
            {
                int numMines = (int)(0.5 * n);

                for (int y = 0; y < numMines; y++)
                {
                    bool flag = true;
                    while (flag)
                    {
                        int randY = random.Next(n);
                        if (field[x, randY] != '*')
                        {
                            field[x, randY] = '*'; // '*' indicates a mine
                            flag = false;
                        }
                    }
                }
            }
            return field;
        }

        public static void DisplayMinefield(char[,] field)
        {
            for (int i = 0; i < field.GetLength(0); i++)
            {
                for (int j = 0; j < field.GetLength(1); j++)
                {
                    Console.Write(field[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        public static int StartCheck(char[,] field)
        {
            List<int> dynamicList = new List<int>();

            for (int x = 0; x < field.GetLength(1); x++)
            {
                if (field[0, x] != '*')
                {
                    dynamicList.Add(x);
                }
            }

            Random random = new Random();
            int randomIndex = random.Next(dynamicList.Count);

            return dynamicList[randomIndex];
        }

        public static void DisplayMovement(char[,] field)
        {
            int totoY = StartCheck(field);
            int allyY = -1;

            int px = 0;
            int py = 0;

            for (int x = 0; x < field.GetLength(0); x++)
            {
                int nextTotoY = totoY;

                if (totoY > 0 && field[x, totoY - 1] != '*')
                {
                    nextTotoY = totoY - 1;
                }
                else if (totoY < field.GetLength(1) - 1 && field[x, totoY + 1] != '*')
                {
                    nextTotoY = totoY + 1;
                }

                if (nextTotoY != totoY)
                {
                    field[x, totoY] = 'T'; // 'T' represents Totoshka's movement
                    Console.WriteLine($"\nStep {x + 1}: Totoshka moves");
                    DisplayMinefield(field); // Display the minefield after Totoshka's movement

                    System.Threading.Thread.Sleep(1000); // Delay for one second (1000 ms)

                    if (allyY != -1)
                    {
                        field[x, allyY] = '0'; // Set Ally's previous position back to '0'
                    }

                    allyY = totoY;
                    totoY = nextTotoY; // Update Totoshka's current position
                    if (x != 0)
                    {
                        field[px, py] = '0';
                    }
                    field[x, allyY] = 'A'; // 'A' represents Ally following Totoshka
                    px = x;
                    py = allyY;

                    System.Threading.Thread.Sleep(1000); // Delay for one second (1000 ms)
                }
            }
        }
    }
}

import java.util.Scanner;
public class MainClass 
{
    public static void main(String args[])
    {
        System.out.println("Enter The Value For N :");
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] spiral = new int[n][n];
        
        int value = 1;
        
        int minCol = 0;
        
        int maxCol = n-1;
        
        int minRow = 0;
        
        int maxRow = n-1;
        
        while (value <= n*n)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                spiral[minRow][i] = value;
                    
                value++;
            }
            
            for (int i = minRow+1; i <= maxRow; i++) 
            { 
                spiral[i][maxCol] = value; 
                
                value++; 
            } 
            
            for (int i = maxCol-1; i >= minCol; i--)
            {
                spiral[maxRow][i] = value;
                            
                value++;
            }
            
            for (int i = maxRow-1; i >= minRow+1; i--) 
            {
                spiral[i][minCol] = value;
                
                value++;
            }
            
            minCol++;
            
            minRow++;
            
            maxCol--;
            
            maxRow--;
        }
        System.out.println("Array Spiral: ");
        for (int i = 0; i < spiral.length; i++)
        {
            for (int j = 0; j < spiral.length; j++)
            {
                System.out.print(spiral[i][j]+ "\t");
            }
            
            System.out.println();
        }
        System.out.println("HTML Text format Spiral: ");
        
        System.out.println(toHTML(spiral));
    }
    
    public static String toHTML(int[][] data){
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1'>\n");
        for(int row = 0; row < data.length; row++){
            sb.append("\t<tr>\n");
            for(int col = 0; col < data[0].length; col++){
                sb.append("\t\t<td>" + data[row][col] + "</td>\n");
            }
            sb.append("\t</tr>\n");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
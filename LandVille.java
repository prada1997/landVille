import java.util.Scanner;

class LandVille {
	private int[][] land;
	static  int landRows = 0;
    static int landColumns = 0;
    static int houseRows = 0;
    static int houseColumns = 0;
    
	static Scanner input = new Scanner (System.in);
	
	// you will need to add the variable 'hasHouse'
	boolean hasHouse;

	// Constructor...
	// Assumption - rows and columns has been validated beforehand.
	// Create the array that the land variable above will reference (using the 'new' operator)
	// Initialise the land so that each cell is set to the character '0' (hint: use one of your
	// methods!).
	// Set the value of any other variables
	public LandVille(int maxRows, int maxColumns) 
	{		
		land = new int[maxRows][maxColumns];				
		hasHouse = false;
		
		for(int i = 0; i < maxRows; i++)
		{
			for(int j=0; j < maxColumns; j++)
			{
				land[i][j] = 0;
			}
		}
	}
	
	
	// Display the land grid 
	public void displayLand()
	{		
		for(int i = 0; i < land.length; i++)
		{
			for(int j = 0; j < land[i].length; j++)
			{
				System.out.print(land[i][j] + " ");
			}
			
			System.out.print("\n");
		}
	}
	
	
	// Clear out the land. This involves setting each cell to be the character '0'
	public void clearLand() 
	{
		hasHouse = false;
		
		System.out.println("Land Cleared");
		
		for(int i = 0; i < land.length; i++)
		{
			for(int j = 0; j < land[i].length; j++)
			{
				land[i][j] = 0;
			}
		}
		
		displayLand();
	}
	
	
	// Build a house
	// Validate the inputs to ensure they make sense for the size of the land
	// 		- display an error message and return if they don't.
	
	// Ensure none of the other rules are violated
	//		- again display an error message and return if they are violated
	
	// If all is ok "build" the house on the land (using the character '8') surrounded
	// by a pretty little fence of '1' characters.
	// Finally update 'hasHouse' and call on displayLand().	
	public void buildHouse(int rows, int columns) 
	{		
		for(int i = 1; i < (rows + 1); i++)
		{
			for(int j = 1; j < (columns + 1); j++)
			{
				land[i][j] = 8;
			}
		}

		for(int i = 0; i < (columns + 2); i++)
		{
			land[0][i] = 1;
			land[rows + 1][i] = 1;
		}

		for(int j = 1; j < (rows + 1); j++)
		{
			land[j][0] = 1;
			land[j][columns + 1] = 1;
		}
		
		hasHouse = true;
		
		System.out.print("\n");
		displayLand();		
	}
	
	
    // Input of rows and columns from the user for the Land.
	public static void landInput ()
	{
		do{
     	   System.out.println("Enter row number of the land:");
     	   landRows = input.nextInt();
     	   
     	   if (landRows <= 0 || landRows > 10)
            {
         	   System.out.println("Row should be greater than 0 and less than or equal to 10\n");
            }
     	   
        }while(landRows <=0 || landRows >= 10);
        
        do{
     	   System.out.println("\nEnter column number of the land:");
     	   landColumns = input.nextInt();
     	   
     	   if (landColumns <= 0 || landColumns > 10)
            {
         	   System.out.println("Column should be greater than 0 and less than or equal to 10\n");
            }
     	   
        }while(landColumns <= 0 || landColumns >= 10);
 
        // If the either input is too small replace it with the smallest feasible size the land could be.        
        if (landRows <= 2)
        {
     	   landRows = 3;
        }
        
        if (landColumns <= 2)
        {
     	   landColumns = 3;
        }
	}
	
	
	// Input of rows and columns from user for House.
	public static void houseInput()
	{		
		int checkRows = (landRows - 2);
 	    int checkColumns = (landColumns - 2);
 	    
		do
		{
			System.out.println("Enter row of the house:");
			houseRows = input.nextInt();
			
			if ( houseRows > checkRows)
			{
				System.out.println("Row should be less than or equal to " + (landRows - 2) + ". \nNo house is built\n");
			}
			
		}while(houseRows > checkRows);
	
		do{
			System.out.println("\nEnter column of the house:");
			houseColumns = input.nextInt();
			
			if (houseColumns > checkColumns)
			{
				System.out.println("Column should be less than or equal to " + (landColumns - 2) + ". \nNo house is built\n");
			}
			
		}while(houseColumns > checkColumns);	               			   
	}
	
		
	public static void main(String[] args) 
	{               
       			landInput();
                            
       		   // Create an object of class LandVille using the 'new' operator, calling on the LandVille constructor.               
               LandVille object = new LandVille(landRows,landColumns);                  
        
               // Build a loop to display the menu, prompt for input and process it as per requirements. 
               int menuInput = 0;
               
               do {              	   
            	   System.out.println("\nChoose from the Menu: \n1. Build a house \n2. Display land \n3. Clear the land \n4. Quit\n");            	               	    
            	   menuInput = input.nextInt();
            	   
            	   if (menuInput == 1) 
            	   {            			
            			if(object.hasHouse == true)
            			{
            				System.out.println("\nHouse Already Exist.");
            			}
            			
            			else
            			{
            				houseInput();
            				object.buildHouse(houseRows,houseColumns);            		    
            			}
            	   }
            	   
            	   else if (menuInput == 2) 
            	   {
            		   object.displayLand();
            	   }
            	   
            	   else if (menuInput == 3) 
            	   {
            		   object.clearLand();
            	   }
            	   
            	   else if (menuInput == 4)
            	   {
            		   System.exit(0);
            	   }
            	   
               }while(menuInput < 4);
               
               input.close();
	}
}
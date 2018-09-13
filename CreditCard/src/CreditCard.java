import java.util.Scanner;

public class CreditCard
	{

		static Scanner userLongPut = new Scanner(System.in);
		static Scanner userIntPut = new Scanner(System.in);
		static long[] digits = new long[16];
		static long[] otherAlts = new long[8];
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				System.out.println("What would you like to see? \n"
						+ "1) Check a known card number \n"
						+ "2) Generate 100 random numbers");
				int userChoice = userIntPut.nextInt();
				
				switch (userChoice)
				{
					case 1:
						long cardNum = takeNumber();
						doubAltDigits(cardNum);
						addUpAndCheck();
						break;
					case 2:
						for (int i = 0; i < 100; i++)
							{
								createCardNum();
							}
						break;
					default:
						break;
				}
			}
		public static long takeNumber()
		{
			System.out.println("What credit card number would you like to check?");
			return userLongPut.nextLong();
		}
		public static void doubAltDigits(long cardNum)
		{
			for (int i = (digits.length-1); i >= 0; i--)
				{
					digits[i] = cardNum % 10;
					cardNum /= 10;
				}
			for (int i = 0; i < 16; i+=2)
				{
					digits[i] *= 2;
					if (digits[i] / 10 != 0)
						{
							digits[i] = 1 + (digits[i] % 10);
						}
				}
			
		}
		public static void addUpAndCheck()
		{
			long finalSum = 0;
			for (int i = 0; i < digits.length; i++)
				{
					finalSum += digits[i];
				}
			if((finalSum % 10) == 0)
				{
					System.out.println("That is a valid credit card number!");
				}
			else
				{
					System.out.println("Sorry, but that number's not valid.");
				}
		}
		public static void createCardNum()
		{
			int[] cardDigits = new int[16];
			int fifteenSum = 0;
			int lastDigit = 0;
			int roundedSum = 0;
			
			for (int i = 0; i < (cardDigits.length - 1); i++)
				{
					cardDigits[i] = (int)(Math.random()*10); 
				}
			cardDigits[15] = lastDigit;
			for (int n : cardDigits)
				{
					fifteenSum += n;
				}
			
			roundedSum = (fifteenSum / 10);
			roundedSum += 1;
			roundedSum *= 10;
			
			lastDigit = (roundedSum - fifteenSum);
			if (lastDigit == 10)
				{
					cardDigits[15] = 0;
				}
			else 
				{
					cardDigits[15] = lastDigit;
				}
			/*int checkSum = 0;
			for (int n : cardDigits)
				{
					checkSum += n;
					System.out.print(n);
				}
			System.out.println();
			System.out.println(checkSum);*/
			
			for (int i = 0; i < cardDigits.length; i += 2)
				{
					if ((cardDigits[i] % 2) == 0)
						{
							cardDigits[i] /= 2;
						}
					else
						{
							switch (cardDigits[i])
							{
								case 1:
									cardDigits[i] = 5;
									break;
								case 3:
									cardDigits[i] = 6;
									break;
								case 5:
									cardDigits[i] = 7;
									break;
								case 7:
									cardDigits[i] = 8;
									break;
								case 9: 
									break;
							}
						}
				}
			for (int n : cardDigits)
				{
					System.out.print(n);
				}
			System.out.print("\n");
			
		}
	}

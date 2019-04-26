package mainPackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import bruteForce.bruteForceNew;
import dynamicPrograming.CreateDPArrays;
import dynamicPrograming.dynamicPR;
import matrixCreation.CreateArrays;


public class UserInputs {
	
	public static void main(String[] args) {
		// Project Author : Mehmet Atmaca
		// 
		//

		/*
		 You can see the created matrices on project root folder.
		 */
		
		//User Prompts
		System.out.println("Matrix-Chain Multiplication");
		System.out.println("1- Brute Force & Dynamic Program");
		System.out.println("2- Only Dynamic Programing for matrix > 20");
		//System.out.println("Please Delete The Old Array files from Project Root!!!");
		System.out.println("Please Select Test Algorithm : ");
		//Get User Input
		Scanner algr = new Scanner (System.in);
		
		//Instantiate the classes here
		CreateArrays cra = new CreateArrays();
		CreateDPArrays cdp = new CreateDPArrays();
		//bruteForce bForce = new bruteForce();
		bruteForceNew brFN = new bruteForceNew();
		dynamicPR DP = new dynamicPR();
		
		
		boolean flg = true;
		// Direct the program correct algorithm
		while(flg) {
			try {
				int pickedAlgo = algr.nextInt();
				if(pickedAlgo == 1) {
					System.out.println("Okay! Lets Test Brute Force and Dynamic Programming");
					//Get Created 2D arraylist from CreateArray Class.
					ArrayList<ArrayList<Integer>> doubleArray = cra.cA(); 
					//Pass the 2D arraylist to the bruteForce class and run brute force test.
					//bForce.testBruteForce(doubleArray);
					System.out.println("BF Result is :"+brFN.bfN(doubleArray));
					System.out.println("DP Result is :"+DP.testDP(doubleArray));
					
					flg =false;
				}
				else if(pickedAlgo ==2) {
					System.out.println("Okay! Lets Test Dynamic Programming!");
					//Get Created 2D arraylist from CreateArray Class.
					ArrayList<ArrayList<Integer>> doubleArray = cdp.cDPA(); 
					//DP.testDP(doubleArray);
					System.out.println("DP Result is :"+DP.testDP(doubleArray));
					flg = false;
				}else {
					System.out.println("Please choose 1 or 2!");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("You should pick an Integer!!! Please run the program again!");
				break;
			}
			
		}
		
		
		algr.close();
		
	}

}

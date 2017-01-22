import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Dhondtimplementation {
	
private ArrayList<Party> partyList = new ArrayList<Party>();
private int seats = 5;

public void addParty(Party party) {
	partyList.add(party);
}

public static void main(String[] args) throws IOException{
	Dhondtimplementation dhon = new Dhondtimplementation();
	BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
	
	while(true) {
		String command = "";
		
		command = breader.readLine();
		
		if(command.equals("finished")){
			break;
		}
		if(command.equals("Load")){
			dhon.LoadVotingData("testingData.txt");
			break;
		}
		if(command.equals("Print")) {
			dhon.printAllParties();
			break;
		}
	}
	dhon.delegateSeats();
	dhon.printAllParties();
	}


public void delegateSeats() {
	int seats = 63;
	while(seats > 0) {
		Party party = partyList.get(0);
		
		for(Party nextParty: partyList) {
			System.out.println(nextParty.Quotient());
			System.out.println(party.Quotient());
			System.out.println("");
			if(nextParty.Quotient() > party.Quotient()) {
				//System.out.println("Next party in the list " + nextParty.Quotient());
				//System.out.println("The next party in the lists votes " + nextParty.totalVotes());
				//System.out.println("Current party: " + party.Quotient());
				//System.out.println("Current parties votes: " + party.totalVotes());
				//System.out.println("");
				party = nextParty;
			}
			if(seats > 0) {
			System.out.println(party.partyName());
			party.addSeat();
			seats--;	
			
			}
		}
		}
	}



// load in data and create party data to be then used for calculating seats
public void LoadVotingData(String file) {
	Scanner sc;
	try{
		sc = new Scanner(new File(file));
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			Scanner scanLine = new Scanner(line);
			String partyName = scanLine.next();
			int votes = scanLine.nextInt();
			Party newParty = new Party(partyName, votes);
			this.addParty(newParty);
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
	} 
	}
public void printAllParties() {
	 for(Party party: partyList) {
		 System.out.println(party.printPartyData());
	 }
}

 
}

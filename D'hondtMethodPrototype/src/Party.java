
public class Party {

private String partyName;
private int totalVotes;
private int totalSeats;

public Party(String name, int votes) {
	totalVotes = votes;
	partyName = name;
	
}

public void addSeat() {
	totalSeats += 1;
}

// formula for calculating the quotients
public Double Quotient() {
	return (double) totalVotes / (totalSeats + 1); 
}

public String partyName() {
	return partyName;
}

public int totalVotes() {
	return totalVotes;
}

public int totalSeats() {
	return totalSeats;
	
}
public String printPartyData() {
	return partyName + " Votes " + Integer.toString(totalVotes) + " Seats " + Integer.toString(totalSeats);
}

}

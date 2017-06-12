package calculator;

import java.math.BigInteger;

public class IBANModel {
	private String iban;
	private String land;
	private BigInteger pruefendeZahl;
	
	private BigInteger pruefZahl;

	public void setIban(String iban) {
		this.iban = iban;
		this.land= iban.substring(0,2);
		BigInteger a = new BigInteger(iban.substring(2,4));
		this.pruefZahl=a;
		BigInteger b = new BigInteger(iban.substring(4));
		this.pruefendeZahl=b;
	}
	
	
	public boolean istCorrect(){
		int one = land.charAt(0);
		one = one - 64+9;
		int two = land.charAt(1);
		two = two - 64+9;
		String toBeCompared=this.pruefendeZahl+""+one+""+two+"00";
		BigInteger a = new BigInteger(toBeCompared);
		BigInteger b= new BigInteger("97");
		BigInteger c= new BigInteger("98");
		a=a.mod(b);
		a=c.subtract(a);
		toBeCompared=a.toString();
		if(toBeCompared.equals(this.pruefZahl.toString())){
			return true;
		} else {
			return false;
		}
	}
}

/* IPA 18 */

/*

create a class Antenna with below attributes.
antennaid=int
antennaName=String
projectLead=String
antennaVSWR=double

the above attribute should be private ,write getter and setter and parametrized constructor as well.

create class MyClass with main method.
implement two static methods searchAntennaByName and sortAntennaByVSWR in MyClass class.


searchAntennaByName :
---------------------------------------
This method will take an array of Antenna objects and the string value as input parameter.The method will find out Antenna name(String parameterpassed).
It will return Antennaid if found.if there is no Antenna that matches then the method will return zero.
The main method should print the antennaid,if the returned value is not 0.if the returned value is 0 then print,"There is no antenna with the given parameter".


sortAntennaByVSWR:
--------------------------------------
This method will take an array of Antenna Objects and a double value as input.
This method will return an array of Antenna objects sorted in ascending orderof their antennaVSWR, which is less than VSWR(double value passed).       

The main method should print name of the project leads from the returned array if the returned value is not null.if the returned value is null then main method 
should print "No Antenna found";


input1:

111
Reconfigurable
Hema
0.4
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.3
444
Dielectric
Sai
0.65
Microstrip
0.5

output:
333
Teju
Hema


input 2:
111
Reconfigurable
Hema
0.3
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.4
444
Dielectric
Sai
0.65
Resonator
0.25

output:
There is no antenna with given parameter
No Antenna found

 */

import java.util.*;

public class AntennaSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Antenna[] antennas = new Antenna[4];

		for (int i = 0; i < antennas.length; i++) {
			int antennaId = sc.nextInt();
			sc.nextLine();
			String antennaName = sc.next();
			String projectLead = sc.next();
			double antennaVSWR = sc.nextDouble();

			antennas[i] = new Antenna(antennaId, antennaName, projectLead, antennaVSWR);
		}

		String targetName = sc.next();
		double targetVSWR = sc.nextDouble();

		sc.close();

		int antennaID = searchAntennaByName(antennas, targetName);
		if (antennaID != 0) {
			System.out.println(antennaID);
		} else {
			System.out.println("There is no antenna with the given parameter");
		}

		Antenna[] sortedAntennas = sortAntennaByVSWR(antennas, targetVSWR);

		if (sortedAntennas != null) {
			for (int i = 0; i < sortedAntennas.length; i++) {
				System.out.println(sortedAntennas[i].getProjectLead());
			}
		} else {
			System.out.println("No Antenna found");
		}

	}

	public static int searchAntennaByName(Antenna[] antennas, String antennaName) {
		for (Antenna antenna : antennas) {
			if (antenna.getAntennaName().equalsIgnoreCase(antennaName)) {
				return antenna.getAntennaId();
			}
		}
		return 0;
	}

	public static Antenna[] sortAntennaByVSWR(Antenna[] antennas, double vswr) {
		int count = 0;
		for (Antenna antenna : antennas) {
			if (antenna.getAntennaVSWR() < vswr) {
				count++;
			}
		}
		if (count == 0) {
			return null;
		}

		Antenna[] sortedAntennas = new Antenna[count];
		int index = 0;
		for (Antenna antenna : antennas) {
			if (antenna.getAntennaVSWR() < vswr) {
				sortedAntennas[index] = antenna;
				index++;
			}
		}

		// sorting the array - sortedAntennas
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (sortedAntennas[j].getAntennaVSWR() > sortedAntennas[j + 1].getAntennaVSWR()) {
					Antenna temp = sortedAntennas[j];
					sortedAntennas[j] = sortedAntennas[j + 1];
					sortedAntennas[j + 1] = temp;

				}
			}
		}
		return sortedAntennas;

	}

}

class Antenna {
	private int antennaId;
	private String antennaName;
	private String projectLead;
	private double antennaVSWR;

	public Antenna(int antennaId, String antennaName, String projectLead, double antennaVSWR) {
		super();
		this.antennaId = antennaId;
		this.antennaName = antennaName;
		this.projectLead = projectLead;
		this.antennaVSWR = antennaVSWR;
	}

	public int getAntennaId() {
		return antennaId;
	}

	public void setAntennaId(int antennaId) {
		this.antennaId = antennaId;
	}

	public String getAntennaName() {
		return antennaName;
	}

	public void setAntennaName(String antennaName) {
		this.antennaName = antennaName;
	}

	public String getProjectLead() {
		return projectLead;
	}

	public void setProjectId(String projectLead) {
		this.projectLead = projectLead;
	}

	public double getAntennaVSWR() {
		return antennaVSWR;
	}

	public void setAntennaVSWR(double antennaVSWR) {
		this.antennaVSWR = antennaVSWR;
	}

}

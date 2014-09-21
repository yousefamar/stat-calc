import java.util.*;
import javax.swing.*;

public class Calc {

	private double yourHP;
	private double yourMP;
	private double yourNP;
	private double yourPSI;
	private double logHPCalc;
	private double yearBorn;
	private double logATK;
	private double logDEF;
	private double logSPR;
	private double logMAG;
	private double logSPD;
	private double logLCK;
	private double logEATK;
	private double logEDEF;
	private double statATK;
	private double statDEF;
	private double statSPR;
	private double statMAG;
	private double statSPD;
	private double statLCK;
	private double statEATK;
	private double statEDEF;
	private double yearNow;
	private double yourHPNow;
	private double yourMPNow;
	private double yourNPNow;
	private double yourPSINow;
	private double logHPCalcNow;
	private double logATKNow;
	private double logDEFNow;
	private double logSPRNow;
	private double logMAGNow;
	private double logSPDNow;
	private double logLCKNow;
	private double logEATKNow;
	private double logEDEFNow;
	private double statATKNow;
	private double statDEFNow;
	private double statSPRNow;
	private double statMAGNow;
	private double statSPDNow;
	private double statLCKNow;
	private double statEATKNow;
	private double statEDEFNow;
	private double usrTRANS;
	private double nonHPBase;
	private double nonATKBase;
	private double nonDEFBase;
	private double nonSPDBase;
	private double nonLCKBase;
	private double nonHPGain;
	private double nonATKGain;
	private double nonDEFGain;
	private double nonSPDGain;
	private double nonLCKGain;
	private double transHP;
	private double transMP;
	private double transNP;
	private double transPSI;
	private double transstatATK;
	private double transstatDEF;
	private double transstatSPR;
	private double transstatMAG;
	private double transstatSPD;
	private double transstatLCK;
	private double transstatEATK;
	private double transstatEDEF;
	private double transHPNow;
	private double transMPNow;
	private double transNPNow;
	private double transPSINow;
	private double transstatATKNow;
	private double transstatDEFNow;
	private double transstatSPRNow;
	private double transstatMAGNow;
	private double transstatSPDNow;
	private double transstatLCKNow;
	private double transstatEATKNow;
	private double transstatEDEFNow;
	private Map<String, Integer> elementMap = new HashMap<String, Integer>();
	{
		elementMap.put("fire", 10 * 2 * 2 / 32);
		elementMap.put("ice", 10 * 2 * 3 / 32);
		elementMap.put("water", 10 * 2 * 4 / 32);
		elementMap.put("wind", 10 * 2 * 5 / 32);
		elementMap.put("earth", 10 * 2 * 6 / 32);
		elementMap.put("poison", 10 * 2 * 7 / 32);
		elementMap.put("gravity", 10 * 2 * 8 / 32);
		elementMap.put("shadow", 10 * 2 * 9 / 32);
		elementMap.put("light", 10 * 2 * 10 / 32);
		elementMap.put("elec", 10 * 2 * 11 / 32);
		elementMap.put("holy", 10 * 2 * 12 / 32);
		elementMap.put("anti", 10 * 2 * 13 / 32);
		elementMap.put("void", 10 * 2 * 14 / 32);
		elementMap.put("time", 10 * 2 * 15 / 32);
	}
	
	private String selectedElements[];
	public Calc(JFrame frame, int birthYear, String[] selectedElements) {
		this.yearBorn = birthYear;
		this.yearNow = Calendar.getInstance().get(Calendar.YEAR);
		this.selectedElements = selectedElements;
		calculate();
		displayResults();
	}

	private void calculate() {
		//displayStartupText();

		double elemMod = getElementsValue();
		logHPCalc = 2.0 / 16.0 * elemMod;
		yourHP = yearBorn * logHPCalc;
		yourMP = yourHP / 2.0;
		yourNP = yourMP / 3.0;
		yourPSI = yourNP + yourMP / 32.0;
		// This is the calculation method block for a character's parameters:
		// Attack, Defense, Magic, Spirit, Speed, Luck, Etheric Attack and
		// Etheric Defense.
		logATK = yearBorn / 60.0;
		logDEF = yearBorn / 120.0;
		// NEED ELEMENT MODIFIER VARIABLE IN NEXT 2 LINES
		logMAG = yearBorn / 60.0 * elemMod;
		logSPR = yearBorn / 120.0 + elemMod;
		logSPD = yearBorn / 60.0;
		logLCK = yearBorn / 120.0;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT 2 LINES
		logEATK = yearBorn / 60.0 * elemMod * 2 / 12;
		logEDEF = yearBorn / 120.0 * elemMod * 4 / 24;
		// This is the endresult of the above block.
		statATK = yourHP / 2.0 + logATK;
		statDEF = yourHP / 3.0 + logDEF;
		statSPR = yourMP / 2.0 + logSPR;
		statMAG = yourMP / 3.0 + logMAG;
		statSPD = yourNP / 2.0 + logSPD;
		statLCK = yourNP / 3.0 + logLCK;
		statEATK = yourPSI / 2.0 + logEATK;
		statEDEF = yourPSI / 3.0 + logEDEF;

		// This is the consumable energy pool calcs scaled by +1 level a year.
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT LINE
		logHPCalcNow = logHPCalc * yearNow + 2.0 * 32.0 * elemMod;
		yourHPNow = yearBorn * logHPCalcNow;
		yourMPNow = yourHPNow / 2.0;
		yourNPNow = yourMPNow / 3.0;
		yourPSINow = yourMPNow + yourNPNow / 32.0;
		// This is the statistic calculation scaled to +1 level a year.
		logATKNow = yearBorn / 60.0 * yearNow + 2.0 * 32.0;
		logDEFNow = yearBorn / 120.0 * yearNow + 2.0 * 32.0;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT 2 LINES
		logMAGNow = yearBorn / 60.0 * yearNow + 2.0 * 32.0 * elemMod;
		logSPRNow = yearBorn / 120.0 * yearNow + 2.0 * 32.0 + elemMod;
		logSPDNow = yearBorn / 60.0 * yearNow + 2.0 * 32.0;
		logLCKNow = yearBorn / 120.0 * yearNow + 2.0 * 32.0;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT 2 LINES
		logEATKNow = yearBorn / 60.0 * yearNow * 2.0 * 32.0 * elemMod * 2 / 12;
		logEDEFNow = yearBorn / 120.0 * yearNow * 2.0 * 32.0 * elemMod * 4 / 24;
		// End result of previous block.
		statATKNow = yourHPNow / 2.0 + logATKNow;
		statDEFNow = yourHPNow / 3.0 + logDEFNow;
		statSPRNow = yourMPNow / 2.0 + logSPRNow;
		statMAGNow = yourMPNow / 3.0 + logMAGNow;
		statSPDNow = yourNPNow / 2.0 + logSPDNow;
		statLCKNow = yourNPNow / 3.0 + logLCKNow;
		statEATKNow = yourPSINow / 200.0 + logEATKNow;
		statEDEFNow = yourPSINow / 300.0 + logEDEFNow;

		// Block for nonmagical character creation.

		nonHPBase = 50;
		nonATKBase = 5;
		nonDEFBase = 5;
		nonSPDBase = 4;
		nonLCKBase = 2;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT 3 LINES
		nonHPGain = nonHPBase * nonDEFBase - 10 + yearNow * elemMod;
		nonATKGain = nonHPGain * nonATKBase / 25 + yearNow / 200 + elemMod;
		nonDEFGain = nonHPGain * nonDEFBase / 25 + yearNow / 200 - elemMod;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT LINE
		nonSPDGain = nonATKBase + nonDEFBase + 9999 / 4 - yearNow - 200
		/ elemMod;
		nonLCKGain = nonHPGain * nonSPDBase / 400 + yearNow / 200 - elemMod / 4;

		// Block for Transient (Supermagicals) Character stat calcs.

		usrTRANS = 4;
		// NEED ELEMENT MODIFIER VARIABLE HERE IN NEXT LINE
		transHP = yearBorn * logHPCalc * usrTRANS * elemMod + 100;
		transMP = yourHP / 2.0 * usrTRANS;
		transNP = yourMP / 3.0 * usrTRANS;
		transPSI = yourNP + yourMP / 32.0 * usrTRANS;
		transstatATK = yourHP / 2.0 + logATK * usrTRANS;
		transstatDEF = yourHP / 3.0 + logDEF * usrTRANS;
		transstatSPR = yourMP / 2.0 + logSPR * usrTRANS;
		transstatMAG = yourMP / 3.0 + logMAG * usrTRANS;
		transstatSPD = yourNP / 2.0 + logSPD * usrTRANS;
		transstatLCK = yourNP / 3.0 + logLCK * usrTRANS;
		transstatEATK = yourPSI / 2.0 + logEATK * usrTRANS;
		transstatEDEF = yourPSI / 3.0 + logEDEF * usrTRANS;
		transHPNow = yearBorn * logHPCalcNow * usrTRANS;
		transMPNow = yourHPNow / 2.0 * usrTRANS;
		transNPNow = yourMPNow / 3.0 * usrTRANS;
		transPSINow = yourMPNow + yourNPNow / 32.0 * usrTRANS;
		transstatATKNow = yourHPNow / 2.0 + logATKNow * usrTRANS;
		transstatDEFNow = yourHPNow / 3.0 + logDEFNow * usrTRANS;
		transstatSPRNow = yourMPNow / 2.0 + logSPRNow * usrTRANS;
		transstatMAGNow = yourMPNow / 3.0 + logMAGNow * usrTRANS;
		transstatSPDNow = yourNPNow / 2.0 + logSPDNow * usrTRANS;
		transstatLCKNow = yourNPNow / 3.0 + logLCKNow * usrTRANS;
		transstatEATKNow = yourPSINow / 200.0 + logEATKNow * usrTRANS;
		transstatEDEFNow = yourPSINow / 300.0 + logEDEFNow * usrTRANS;
	}
	
	private double getElementsValue() {
		int sum=0;
		for (String element:selectedElements)
			if (!element.equals("---"))
				sum+=elementMap.get(element);
		return sum;
	}

	private void displayResults() {
		//This looks a bit weird because I used replace search.
		String msg = "-------READOUT FOR TYPE 'NON'-------\n"
		+"This is your level-up curve based on your birth year of "
				+ yearBorn + "\n"
		+"Your HP   = " + nonHPBase + "\n"
		+"Your ATK  = " + nonATKBase + "\n"
		+"Your DEF  = " + nonDEFBase + "\n"
		+"Your SPD  = " + nonSPDBase + "\n"
		+"Your Luck = " + nonLCKBase + "\n"
		+"This is your current stats as of " + yearNow + "\n"
		+"Current HP   = " + nonHPGain + "\n"
		+"Current ATK  = " + nonATKGain + "\n"
		+"Current DEF  = " + nonDEFGain + "\n"
		+"Current SPD  = " + nonSPDGain + "\n"
		+"Current Luck = " + nonLCKGain + "\n"
		+"  \n"
		+"You're a Non, what the fuck did you expect?\n"
		+"Nons have one advantage; unaffectable by the paranormal.\n"
		+"  \n"
		+"-------READOUT FOR TYPE 'ACTIVE'-------\n"
		+"This is your level-up curve based on your birth year of " + yearBorn + "\n"
		+"Your HP   = " + yourHP + "\n"
		+"Your MP   = " + yourMP + "\n"
		+"Your NP   = " + yourNP + "\n"
		+"Your PSI  = " + yourPSI + "\n"
		+"Your ATK  = " + statATK + "\n"
		+"Your DEF  = " + statDEF + "\n"
		+"Your MAG  = " + statMAG + "\n"
		+"Your SPR  = " + statSPR + "\n"
		+"Your SPD  = " + statSPD + "\n"
		+"Your Luck = " + statLCK + "\n"
		+"Your EATK = " + statEATK + "\n"
		+"Your EDEF = " + statEDEF + "\n"
		+"  \n"
		+"This is your current stats as of " + yearNow + "\n"
		+"Current HP   = " + yourHPNow + "\n"
		+"Current MP   = " + yourMPNow + "\n"
		+"Current NP   = " + yourNPNow + "\n"
		+"Current PSI  = " + yourPSINow + "\n"
		+"Current ATK  = " + statATKNow + "\n"
		+"Current DEF  = " + statDEFNow + "\n"
		+"Current MAG  = " + statMAGNow + "\n"
		+"Current SPR  = " + statSPRNow + "\n"
		+"Current SPD  = " + statSPDNow + "\n"
		+"Current Luck = " + statLCKNow + "\n"
		+"Current EATK = " + statEATKNow + "\n"
		+"Current EDEF = " + statEDEFNow + "\n"
		+"  \n"
		+"These statistics do not reflect any equipment being held or worn.\n"
		+"You're not too shabby for a budding mage!\n"
		+"  \n"
		+"-------READOUT FOR TYPE 'TRANSIENT'-------\n"
		+"This is your level-up curve based on your birth year of " + yearBorn + "\n"
		+"Your HP   = " + transHP + "\n"
		+"Your MP   = " + transMP + "\n"
		+"Your NP   = " + transNP + "\n"
		+"Your PSI  = " + transPSI + "\n"
		+"Your ATK  = " + transstatATK + "\n"
		+"Your DEF  = " + transstatDEF + "\n"
		+"Your MAG  = " + transstatMAG + "\n"
		+"Your SPR  = " + transstatSPR + "\n"
		+"Your SPD  = " + transstatSPD + "\n"
		+"Your Luck = " + transstatLCK + "\n"
		+"Your EATK = " + transstatEATK + "\n"
		+"Your EDEF = " + transstatEDEF + "\n"
		+"  \n"
		+"This is your current stats as of " + yearNow + "\n"
		+"Current HP   = " + transHPNow + "\n"
		+"Current MP   = " + transMPNow + "\n"
		+"Current NP   = " + transNPNow + "\n"
		+"Current PSI  = " + transPSINow + "\n"
		+"Current ATK  = " + transstatATKNow + "\n"
		+"Current DEF  = " + transstatDEFNow + "\n"
		+"Current MAG  = " + transstatMAGNow + "\n"
		+"Current SPR  = " + transstatSPRNow + "\n"
		+"Current SPD  = " + transstatSPDNow + "\n"
		+"Current Luck = " + transstatLCKNow + "\n"
		+"Current EATK = " + transstatEATKNow + "\n"
		+"Current EDEF = " + transstatEDEFNow + "\n"
		+"  \n"
		+"These statistics do not reflect any equipment being held or worn.\n"
		+"Be advised that E(number) actually means 'move the decimal spot\nover (number) times to the right.'\n"
		+"As a Transient, you naturally have th-- HAAAAAAAAAAX! ::CRTMonitor PWNage!::.";
		
		new ResultsGUI(msg);
	}
	
	private void displayStartupText() {
		// Display Text on first run

		System.out.print("DaveOS activated");
		System.out.println("  ");
		System.out.print("Initializing Memory ............. ");
		System.out.println("  ");
		System.out.print("     ...10%");
		System.out.println("  ");
		System.out.print("     ...20%");
		System.out.println("  ");
		System.out.print("     ...30%");
		System.out.println("  ");
		System.out.print("     ...40%");
		System.out.println("  ");
		System.out.print("     ...60%");
		System.out.println("  ");
		System.out.print("     ...90%");
		System.out.println("  ");
		System.out
		.print("Activating Team Inzen Statistics Calculation Module (TISCM)");
		System.out.println("  ");
		System.out.print("     ...10%");
		System.out.println("  ");
		System.out.print("     ...20%");
		System.out.println("  ");
		System.out.print("     ...30%");
		System.out.println("  ");
		System.out.print("     ...40%");
		System.out.println("  ");
		System.out.print("     ...60%");
		System.out.println("  ");
		System.out.print("     ...90%");
		System.out.println("  ");
		System.out
		.print("«WARNING» This program was designed solely to generate documentation on a generic scale based on");
		System.out.println("  ");
		System.out
		.print("«WARNING» logarithmic scales tailored to translate aetheric growth to hard computer data entry! ");
		System.out.println("  ");
		System.out
		.print("«WARNING» Team Inzen is not responsible for any feelings of inadequacy or resentment based upon ");
		System.out.println("  ");
		System.out
		.print("«WARNING» whether or not you have trained your ass off or powerlevelled multiple times a year.  ");
		System.out.println("  ");
		System.out
		.print("«WARNING» This program only calculates on a per-yearly basis given a single level-up per year.  ");
		System.out.println("  ");
		System.out
		.print("«WARNING» The device will now ask you for the year you were born. using .1 to .12 will give a   ");
		System.out.println("  ");
		System.out
		.print("«WARNING» small bias towards the month you were born in. Please refer to a calendar if you are  ");
		System.out.println("  ");
		System.out
		.print("«WARNING» a complete and total dumbass and can't count.                                         ");
		System.out.println("  ");
	}
}

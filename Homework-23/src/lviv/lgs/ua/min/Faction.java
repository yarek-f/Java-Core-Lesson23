package lviv.lgs.ua.min;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Faction {
	
	MethodDeputy addDeputy = (deputyList) -> {
		System.out.println();
		Deputy deputy = new Deputy();

		System.out.println("Add detupy, enter weight:");
		Scanner sc = new Scanner(System.in);
		int parametrDeputy = sc.nextInt();
		deputy.setWeight(parametrDeputy);

		System.out.println("               , enter growth:");
		parametrDeputy = sc.nextInt();
		deputy.setHeight(parametrDeputy);

		System.out.println("               , enter first name:");
		String nameDeputy = sc.next();
		deputy.setName(nameDeputy);

		System.out.println("               , enter last name:");
		nameDeputy = sc.next();
		deputy.setSurname(nameDeputy);

		System.out.println("               , enter age:");
		parametrDeputy = sc.nextInt();
		deputy.setAge(parametrDeputy);

		System.out.println("     , enter 'Y' if a bribe taker, else if doesn't take bribe :");
		nameDeputy = sc.next();
		switch (nameDeputy.toUpperCase()) {
		case "Y":
			deputy.setBribeTaker(true);
			break;
		default:
			deputy.setBribeTaker(false);
			break;
		}

		deputyList.add(deputy);
	};
	
	MethodDeputy removeDeputy = (deputyList) -> {
		Iterator<Deputy> iterator = deputyList.iterator();
		while (iterator.hasNext()) {
			System.out.println("  \n Remove this deputy Y - yes, else no");
			System.out.println(iterator.next());
			Scanner sc = new Scanner(System.in);
			switch (sc.next().toUpperCase()) {
			case "Y":
				iterator.remove();
				break;
			default:
				break;
			}
		}
	};

	MethodDeputy allGrafter = (deputyList) -> {
		System.out.println("  \n List deputy bribe takers: ");		
		deputyList.stream().filter(d -> d.isBribeTaker()).peek(d -> System.out.println(d)).collect(Collectors.toList());
			
	};

	MethodDeputy biggerGrafter = (deputyList) -> {
		System.out.println(" \n biggest bribe: ");
		try {	
			Deputy biggerGrafter = deputyList.stream().max(new DeputyBribeSizeComparator()).get();
			System.out.println(biggerGrafter);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Err - no deputy bribe takers in this fraction");
		}

	};

	MethodDeputy allFraction = (deputyList) -> {
		System.out.println(" \n List deputy fraction: ");
		deputyList.forEach(System.out :: println);
	};
}

interface MethodDeputy{
	void method(List<Deputy> deputyList);
}

	/*String factionName;
	List<Deputy> deputies = new ArrayList<>();
	List<Faction> deputieds = new ArrayList<>();

	public Faction(String name) {
		this.factionName = name;
	}

	public String getFactionName() {
		return factionName;
	}

	public List<Deputy> getDeputies() {
		return deputies;
	}

	public void setName(String name) {
		this.factionName = name;
	}

	public void setDeputies(List<Deputy> deputies) {
		this.deputies = deputies;
	}

	@Override
	public String toString() {
		return "Faction [FactionName = " + factionName + ", deputies = " + deputies + "]";
	} 

	public void addDeputy() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter weight of deputy !");
		int inputWeight = s.nextInt();
		System.out.println("Enter growth of deputy !");
		int inputGrowth = s.nextInt();
		System.out.println("Enter first name of deputy !");
		String inputFirstName = s.next();
		System.out.println("Enter surname of deputy !");
		String inputLastName = s.next();
		System.out.println("Enter age of deputy !");
		int inputAge = s.nextInt();
		System.out.println("If the deputy is bribes enter: true !\nIf the deputy isn't bribes enter: false !");
		boolean inputisBribeTaker = s.nextBoolean();

		Deputy deputy = new Deputy(inputWeight, inputGrowth, inputFirstName, inputLastName, inputAge, inputisBribeTaker);

		if (inputisBribeTaker) {
			deputy.giveBribes(deputy.isBribeTaker());
		}

		deputies.add(deputy);

	}

	public void deleteDeputy() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter last name of deputy which you want to except from faction !");
		String inputFirsName = s.next();

		ListIterator<Deputy> deputyIterator = deputies.listIterator();

		while (deputyIterator.hasNext()) {
			if (inputFirsName.equals(deputyIterator.next().getName())) {
				deputyIterator.remove();
			}
		}
	}

	public void showBribeTakers() {
		ListIterator<Deputy> deputyIterator = deputies.listIterator();

		while (deputyIterator.hasNext()) {
			Deputy tempDeputy = deputyIterator.next();
			if (tempDeputy.isBribeTaker()) {
				System.out.println(tempDeputy);
			}
		}
	}

	public Deputy findTheBestBribeTakers() {
		return Collections.max(deputies, new DeputyBribeSizeComparator());
	}

	public void showAllDeputys() {
		ListIterator<Deputy> deputyIterator = deputies.listIterator();

		while (deputyIterator.hasNext()) {
			System.out.println(deputyIterator.next());
		}

	}

	public void cleanFaction() {
		deputies.clear();
	}*/


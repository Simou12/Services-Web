package agence.main;

import java.io.BufferedReader;

public class IntegerInputProcessor extends ComplexUserInputProcessor<Integer>{

	public IntegerInputProcessor(BufferedReader inputReader) {
		super(inputReader);
	}

	@Override
	protected void setMessage() {
		System.out.println("Veuillez saisir un entier ");
		
	}

	@Override
	protected void setParser() {
		try {
			parser = Integer.class.getMethod("parseInt", String.class);
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}	
	}

	@Override
	protected void setValidityCritersion() {
		isValid = str -> {
			try {
				Integer value = Integer.parseInt(str);
				return value instanceof Integer;
			} catch (NumberFormatException e) {
				return false;
			}
		};
		
	}
	

}

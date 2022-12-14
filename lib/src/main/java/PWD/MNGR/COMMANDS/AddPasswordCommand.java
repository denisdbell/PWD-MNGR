package PWD.MNGR.COMMANDS;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import PWD.MNGR.DATABASE.DataBase;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
	name = "Add Password",
	description = "Add Password to the database"
)
public class AddPasswordCommand implements Runnable {

	Configuration configuration;
	SessionFactory factory;
	DataBase dataBase = new DataBase();
	
	@Parameters
	String name;
	
	@Parameters
	String value;
		
	public static void main(String[] args) {
		int exitCde = new CommandLine(new AddPasswordCommand()).execute(args);
		System.exit(exitCde);
	}
	
	@Override
	public void run() {
		dataBase.addPassword(name,value);
		System.out.println("Password added successfully");
	}
}

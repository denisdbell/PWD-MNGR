package PWD.MNGR.COMMANDS;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import PWD.MNGR.DATABASE.DataBase;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
	name = "Update Password",
	description = "Update Password"
)
public class UpdatePasswordCommand implements Runnable {

	Configuration configuration;
	SessionFactory factory;
	DataBase dataBase = new DataBase();
	
	@Parameters
	Long id;
	
	@Parameters
	String name;
	
	@Parameters
	String value;
		
	public static void main(String[] args) {
		int exitCde = new CommandLine(new UpdatePasswordCommand()).execute(args);
		System.exit(exitCde);
	}
	
	@Override
	public void run() {
		dataBase.updatePassword(id,name,value);
		System.out.println("Password updated successfully");
	}
}

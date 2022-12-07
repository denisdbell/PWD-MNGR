package PWD.MNGR.COMMANDS;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import PWD.MNGR.DATABASE.DataBase;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command
public class DeletePasswordCommand implements Runnable {

	Configuration configuration;
	SessionFactory factory;
	DataBase dataBase = new DataBase();
	
	@Parameters
	Long id;
	
	public static void main(String[] args) {
		int exitCde = new CommandLine(new DeletePasswordCommand()).execute(args);
		System.exit(exitCde);
	}
	
	@Override
	public void run() {
		dataBase.deletePassword(id);
	}
}

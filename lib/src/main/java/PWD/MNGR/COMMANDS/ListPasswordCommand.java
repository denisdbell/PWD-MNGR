package PWD.MNGR.COMMANDS;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import PWD.MNGR.DATABASE.DataBase;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command
public class ListPasswordCommand implements Runnable {

	Configuration configuration;
	SessionFactory factory;
	DataBase dataBase = new DataBase();

	public static void main(String[] args) {
		int exitCde = new CommandLine(new ListPasswordCommand()).execute();
		System.exit(exitCde);
	}
	
	@Override
	public void run() {
		dataBase.listPasswords();
	}
}

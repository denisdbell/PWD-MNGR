package PWD.MNGR;


import java.util.logging.LogManager;

import PWD.MNGR.COMMANDS.AddPasswordCommand;
import PWD.MNGR.COMMANDS.DeletePasswordCommand;
import PWD.MNGR.COMMANDS.ListPasswordCommand;
import PWD.MNGR.COMMANDS.UpdatePasswordCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
	name = "PSWDMNGR",
	description = "Password manage Command Line Application"
)
public class MainCommand implements Runnable {

	
	@Option(names = { "-c","command" })
	String command;
	
	@Parameters
	String[] arguments;
		
	public static void main(String[] args) {
		//Disable logging
		LogManager.getLogManager().reset();
		
		int exitCde = new CommandLine(new MainCommand()).execute(args);
		System.exit(exitCde);
	}

	@Override
	public void run() {
		int exitCde = 0;
		switch(command) {
		  case "a":
				 exitCde = new CommandLine(new AddPasswordCommand()).execute(arguments);
		    break;
		  case "d":
			   exitCde = new CommandLine(new DeletePasswordCommand()).execute(arguments);
		    break;
		  case "l":
			   exitCde = new CommandLine(new ListPasswordCommand()).execute();
		    break;
		  case "u":
			  exitCde = new CommandLine(new UpdatePasswordCommand()).execute(arguments);
		    break;
		  default:
		    // code block
		}

	}

}

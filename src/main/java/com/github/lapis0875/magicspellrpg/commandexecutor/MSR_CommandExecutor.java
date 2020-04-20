package com.github.lapis0875.magicspellrpg.commandexecutor;

import com.github.lapis0875.magicspellrpg.console.FormattedConsole;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MSR_CommandExecutor implements CommandExecutor {

    // Colored, Formatted logger.
    FormattedConsole formattedConsole;

    public MSR_CommandExecutor(FormattedConsole formattedConsole){
        this.formattedConsole = formattedConsole;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equals("command") || label.equals("alias1") || label.equals("alias2")){
            switch (args.length){
                case 0:
                    break;
            }
        }
        return false;
    }


}

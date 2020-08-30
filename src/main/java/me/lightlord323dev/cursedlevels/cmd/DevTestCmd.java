package me.lightlord323dev.cursedlevels.cmd;

import me.lightlord323dev.cursedlevels.handler.SkillMainMenuHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Luda on 8/28/2020.
 */
public class DevTestCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!sender.hasPermission("!cursedlevels.dev"))
            return true;


        if (args[0].equalsIgnoreCase("skillsgui")) {

            SkillMainMenuHandler.openMainMenu(((Player) sender));

        }

        return true;
    }
}

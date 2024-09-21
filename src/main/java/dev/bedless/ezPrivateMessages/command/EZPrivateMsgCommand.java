package dev.bedless.ezPrivateMessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.bedless.ezPrivateMessages.EZPrivateMessages;
import dev.bedless.ezPrivateMessages.config.CString;
import dev.bedless.ezPrivateMessages.config.ConfigurationType;
import org.bukkit.command.CommandSender;

@CommandAlias("ezpm")
@CommandPermission("ezprivatemessage.command.ezpm")
public class EZPrivateMsgCommand extends BaseCommand {

    @HelpCommand
    @CommandPermission("ezprivatemessage.command.ezpm")
    public void onHelpCommand(CommandSender commandSender) {
        commandSender.sendMessage("§e§l------------------§r" + EZPrivateMessages.getMessages().getPrefix().toStringT() + "§e§l------------------");
        commandSender.sendMessage("§6/ezpm reload §f- §eReloads the Plugin");
    }

    @Subcommand("reload")
    @CommandPermission("ezprivatemessage.command.ezpm.reload")
    @Syntax("§f - §eReloads the Plugin")
    public void onReload(CommandSender commandSender) {
        commandSender.sendMessage(EZPrivateMessages.getMessages().getReloaded()
                .replaceIgnoreCase(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                .toStringT()
        );
        EZPrivateMessages.getInstance().reloadConfiguration(ConfigurationType.ALL);
    }

}

package dev.bedless.ezPrivateMessages.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.bedless.ezPrivateMessages.EZPrivateMessages;
import dev.bedless.ezPrivateMessages.config.CString;
import dev.bedless.ezPrivateMessages.config.Messages;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("msg|tell|w|message|whisper|pm")
@CommandPermission("ezprivatemessage.command.message")
public class MSGCommandOverride extends BaseCommand {

    @Default
    @CommandCompletion("@players")
    @Description("Message a player")
    @Syntax("&f<name> <message> &e- Player Name, Message")
    public void onMessage(CommandSender commandSender, OfflinePlayer receiver, String... message) {
        if (message.length == 0) {
            commandSender.sendMessage("§eUsage: §a/msg §f<name> <message> §e- Player Name, Message");
            return;
        }
        if (receiver == null) {
            commandSender.sendMessage(EZPrivateMessages.getMessages().getTargetNotFound()
                    .replace(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                    .replace(CString.Placeholder.RECEIVER, "404").toStringT());
            return;
        }
        if (receiver.isOnline()) {
            if (commandSender instanceof Player) {
                CString bString = EZPrivateMessages.getMessages().getPlayerMSGReceive().translate()
                        .replace(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                        .replace(CString.Placeholder.MESSAGE, String.join(" ", message))
                        .replace(CString.Placeholder.SENDER, commandSender.getName())
                        .replace(CString.Placeholder.RECEIVER, receiver.getName());
                if (EZPrivateMessages.getInstance().isPapi()) {
                    bString.replacePAPI((Player) commandSender);
                }
                receiver.getPlayer().sendMessage(bString
                        .toString()
                );
            } else {
                receiver.getPlayer().sendMessage(EZPrivateMessages.getMessages().getPlayerMSGReceiveConsole().translate()
                        .replace(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                        .replace(CString.Placeholder.MESSAGE, String.join(" ", message))
                        .replace(CString.Placeholder.SENDER, commandSender.getName())
                        .replace(CString.Placeholder.RECEIVER, receiver.getName())
                        .toString()
                );
            }
            CString bString = EZPrivateMessages.getMessages().getPlayerMSGSend().translate()
                    .replace(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                    .replace(CString.Placeholder.MESSAGE, String.join(" ", message))
                    .replace(CString.Placeholder.SENDER, commandSender.getName())
                    .replace(CString.Placeholder.RECEIVER, receiver.getName());
            if (EZPrivateMessages.getInstance().isPapi()) {
                bString.replacePAPI(receiver.getPlayer());
            }
            commandSender.sendMessage(bString
                    .toString()
            );
        } else {
            commandSender.sendMessage(EZPrivateMessages.getMessages().getTargetNotFound()
                    .replace(CString.Placeholder.PREFIX, EZPrivateMessages.getMessages().getPrefix().toStringT())
                    .replace(CString.Placeholder.RECEIVER, receiver.getName()).toStringT());
        }
    }
}

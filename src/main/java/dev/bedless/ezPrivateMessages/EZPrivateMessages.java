package dev.bedless.ezPrivateMessages;

import co.aikar.commands.CommandManager;
import co.aikar.commands.PaperCommandManager;
import dev.bedless.ezPrivateMessages.command.EZPrivateMsgCommand;
import dev.bedless.ezPrivateMessages.command.MSGCommandOverride;
import dev.bedless.ezPrivateMessages.config.ConfigurationType;
import dev.bedless.ezPrivateMessages.config.Messages;
import lombok.AccessLevel;
import lombok.Getter;
import me.petereo.pconfig.ConfigurationManager;
import me.petereo.pconfig.SpigotConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EZPrivateMessages extends JavaPlugin {


    @Getter(AccessLevel.PUBLIC)
    private static EZPrivateMessages instance;
    @Getter(AccessLevel.PUBLIC)
    private static Messages messages;

    @Getter(AccessLevel.PUBLIC)
    private boolean papi = false;

    private static ConfigurationManager configurationManager;
    private static PaperCommandManager paperCommandManager;


    @Override
    public void onEnable() {
        instance = this;
        registerConfiguration(ConfigurationType.ALL);
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(messages.getPrefix().toStringT() + " §aEnabled");
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getConsoleSender().sendMessage(messages.getPrefix().toStringT() + " §aPlaceholderAPI found! Enabling placeholders.");
            papi = true;
        } else {
            Bukkit.getConsoleSender().sendMessage(messages.getPrefix().toStringT() + " §cPlaceholderAPI not found! Disabling placeholders.");
            papi = false;
        }
    }

    private void registerCommands() {
        paperCommandManager = new PaperCommandManager(this);
        paperCommandManager.registerCommand(new EZPrivateMsgCommand());
        paperCommandManager.registerCommand(new MSGCommandOverride());
    }

    private void registerConfiguration(ConfigurationType configurationType) {
        configurationManager = new SpigotConfigurationManager(this);
        switch (configurationType) {
            case MESSAGE:
                configurationManager.registerConfiguration(Messages.class);
                messages = configurationManager.getConfiguration(Messages.class);
                break;
            case ALL:
                configurationManager.registerConfiguration(Messages.class);
                messages = configurationManager.getConfiguration(Messages.class);
                break;
        }
    }

    public void reloadConfiguration(ConfigurationType configurationType) {
        switch (configurationType) {
            case MESSAGE:
                registerConfiguration(ConfigurationType.MESSAGE);
                break;
            case ALL:
                registerConfiguration(ConfigurationType.ALL);
                break;
        }
    }


}

package dev.bedless.ezPrivateMessages.config;

import me.petereo.pconfig.config.BaseConfiguration;
import me.petereo.pconfig.config.Configuration;
import me.petereo.pconfig.config.ConfigurationType;
import me.petereo.pconfig.config.Information;

import java.util.ArrayList;

@Configuration(name = "Messages", path = "config", type = ConfigurationType.YAML)
public class Messages extends BaseConfiguration {
    @Information({"=====================================GLOBAL=====================================",
            "!! CBUIAM = Can be used in all Messages !!",
            "!! PAPI = Placeholder API !!",
            "Global Placeholders (CBUIAM): %prefix%",
            "Color Code Char (CBUIAM): '&' Example: &a == Green"
    })
    public String Prefix = "&8[&bEZPM&8]";

    @Information({"=====================================Plugin Messages====================================="})
    public String Reloaded = "%prefix% &aReloaded the configuration file!";

    @Information({"=====================================Command Messages=====================================",
            "Usable Placeholders: %sender%, %receiver%, %message%",
            "%sender%: Is replaced with the Sender",
            "%receiver%: Is replaced with the Receiver",
            "%message%: Is replaced with the Message",
            "PAPI: These messages support PAPI, you may use Installed placeholders as you please!"
    })
    public String CommandUsage = "&eUsage: &a/msg &f<name> <message> &e- Player Name, Message";
    public String TargetNotFound = "&c%receiver% is not online!";
    public String PlayerMSGSend = "&8[&bYou &8» %receiver%&8] &f%message%";
    public String PlayerMSGReceive = "&8[%sender% &8» &bYou&8] &f%message%";
    public String PlayerMSGReceiveConsole = "&8[&cConsole &8» &bYou&8] &f%message%";


    /*Getters*/
    public CString getPrefix() {
        return CString.fS(Prefix);
    }

    public CString getReloaded() {
        return CString.fS(Reloaded);
    }

    /*MSG*/
    public CString getCommandUsage() {
        return CString.fS(CommandUsage);
    }

    public CString getTargetNotFound() {
        return CString.fS(TargetNotFound);
    }

    public CString getPlayerMSGSend() {
        return CString.fS(PlayerMSGSend);
    }

    public CString getPlayerMSGReceive() {
        return CString.fS(PlayerMSGReceive);
    }

    /*MSG CONSOLE*/
    public CString getPlayerMSGReceiveConsole() {
        return CString.fS(PlayerMSGReceiveConsole);
    }


}

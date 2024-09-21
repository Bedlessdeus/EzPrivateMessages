# EZPrivateMessages
### This is a simple plugin that allows you to configure private messages between players.
### It provides several features that can be found [here](#features).

![Spigot Downloads](https://img.shields.io/spiget/downloads/98829) ![Rating](https://img.shields.io/spiget/stars/98829)

## Table of Contents
* [Features](#features)
* [Commands](#commands)
* [Permissions](#permissions)
* [Compatibility / Requirements](#compatibility--requirements)
* [Where to download](#where-to-download)
* [Support](#support)
* [Configuration](#configuration)

## Features
* PlaceholderAPI Support
* Customizable private messages

## Commands
* `/ezpm` - Main command for the plugin
    * `/ezpm reload` - Reloads the configuration file
* Following Commands are Aliases for `/msg`
  * `/msg` 
  * `/tell`
  * `/whisper`
  * `/w`
  * `/pm`

## Permissions
```yaml
# Allows the player to use the /ezpm command
ezprivatemessage.command.ezpm

# Allows the player to reload the configuration file
ezprivatemessage.command.ezpm.reload

# Allows the player to send private messages
ezprivatemessage.command.message
```

## Compatibility / Requirements
### Spigot or Paper Server 1.8.8 - 1.21.1
### SoftDepends: PlaceholderAPI (Optional)

## Where to download
### [Spigot](https://www.spigotmc.org/resources/ultimate-private-messages.98829/)

## Support
#### If you need help with the plugin, contact me on Discord: `bedlessdeus`<br>If you found a bug, create an Issue here on GitHub.

## Configuration
```yaml
# =====================================GLOBAL=====================================
# !! CBUIAM = Can be used in all Messages !!
# !! PAPI = Placeholder API !!
# Global Placeholders (CBUIAM): %prefix%
# Color Code Char (CBUIAM): '&' Example: &a == Green
Prefix: "&8[&bEZPM&8]"

# =====================================Plugin Messages=====================================
Reloaded: "%prefix% &aReloaded the configuration file!"

# =====================================Command Messages=====================================
# Usable Placeholders: %sender%, %receiver%, %message%
# %sender%: Is replaced with the Sender
# %receiver%: Is replaced with the Receiver
# %message%: Is replaced with the Message
# PAPI: These messages support PAPI, you may use Installed placeholders as you please!
TargetNotFound: "&c%receiver% is not online!"
PlayerMSGSend: "&8[&bYou &8» %receiver%&8] &f%message%"
PlayerMSGReceive: "&8[%sender% &8» &bYou&8] &f%message%"
PlayerMSGReceiveConsole: "&8[&cConsole &8» &bYou&8] &f%message%"
```
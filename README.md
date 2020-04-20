# JavaPluginTemplate
A template repository for Minecraft Bukkit Plugin. Made with Java.

## Contents
    com.github.lapis0875.javaplugin_template : project`s main package
    └ TemplatePlugin.java : Main class for Bukkit plugin.
    └ .console: package for console logging.
       └ FormattedConsole.java : Class for better logging. Use ConsoleSender class to color logs. Use LogType to classify logs.
       └ LogType.java : Enum to classify type of log.
    └ .commandexecutor : package for command executor.
       └ TemplateCommandExecutor.java : Class which implements Bukkit`s CommandExecutor interface. Use this class to create command features.
    └ .listener : package for listener.
       └ TemplateListener.java : Class which implements Bukkit`s Listener interface. Use this class to create Event features.
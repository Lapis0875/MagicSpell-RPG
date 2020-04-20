package com.github.lapis0875.magicspellrpg;

// Bukkit imports
import org.bukkit.plugin.java.JavaPlugin;

// RPG-related system class imports
import com.github.lapis0875.magicspellrpg.job.JobManager;
import com.github.lapis0875.magicspellrpg.skill.SkillManager;

// import Formatted Console
import com.github.lapis0875.magicspellrpg.console.*;

public final class MagicspellRpg extends JavaPlugin {

    private final FormattedConsole formattedConsole = new FormattedConsole(this.getDescription());
    private SkillManager skillManager;
    private JobManager jobManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        formattedConsole.console(LogType.INFO,"Enabling plugin...");

        // Initialize SkillManager
        this.skillManager = new SkillManager(formattedConsole);
        this.jobManager = new JobManager(formattedConsole);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

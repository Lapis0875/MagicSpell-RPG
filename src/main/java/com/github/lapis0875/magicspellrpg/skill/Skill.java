package com.github.lapis0875.magicspellrpg.skill;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Skill {
    private String skillname = "";            // Skill`s internal name (filename)
    private String magicspell_skillname = "";         // MagicSpell name which matches with the skill
    private String description = "";
    private int damage = 0;
    private int hit_count = 0;
    private int buff_duration = 0;

    public Skill(String skillname, String magicspell_skillname, String description,  int damamge, int hit_count, int buff_duration){
        this.skillname = skillname;
        this.magicspell_skillname = magicspell_skillname;
        this.description = description;
        this.damage = damamge;
        this.hit_count = hit_count;
        this.buff_duration = buff_duration;
    }

    public void execute_skill(Player player){
        player.performCommand(String.format("/c %s", magicspell_skillname));
    }

    public void teach_skill(Player player){
        player.performCommand(String.format("/c teach %s", magicspell_skillname));
    }

    public String getSkillname(){
        return this.skillname;
    }

    public String getMagicspellSkillname(){
        return this.magicspell_skillname;
    }

    public String getDescription(){
        return this.description;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getHitCount(){
        return this.hit_count;
    }

    public int getBuffDuration(){
        return this.buff_duration;
    }

    @Override
    public String toString(){
        return String.format(ChatColor.LIGHT_PURPLE + "{ Skillname : %s / Magicspell : %s }", this.getSkillname(), this.getMagicspellSkillname());
    }
}

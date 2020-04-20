package com.github.lapis0875.magicspellrpg.skill;

import com.github.lapis0875.magicspellrpg.console.FormattedConsole;
import com.github.lapis0875.magicspellrpg.console.LogType;

import java.util.HashMap;

public class SkillManager {
    private FormattedConsole formattedConsole;
    private HashMap<String, Skill> skillHashMap = new HashMap<>();

    private String config_dir = "./plugins/MagicSpell-RPG/skills";

    public SkillManager(FormattedConsole formattedConsole){
        this.formattedConsole = formattedConsole;
    }

    public void load(){

    }

    public boolean registerSkill(Skill skill){
        this.formattedConsole.console(LogType.LOG, String.format("Registering skill : { %s }", skill.toString()));
        boolean skillcheck = this.validateSkill(skill);
        if (skillcheck){
            this.formattedConsole.console(LogType.LOG, "Not Validate Skill. Reject registration of skill ");
            this.skillHashMap.put(skill.getSkillname(), skill);
            return true;
        } else {
            this.formattedConsole.console(LogType.ERROR, "Not Validate Skill. Reject registration of skill ");
            this.formattedConsole.console(LogType.ERROR, String.format("Rejected Skill info : { %s }", skill.toString()));
            return false;
        }
    }

    private boolean validateSkill(Skill skill){

        String skillname = skill.getSkillname();
        String magicspell_skillname = skill.getMagicspellSkillname();

        this.formattedConsole.console(LogType.LOG, String.format("Validating a skill : %s", skillname));

        // Check skill name
        this.formattedConsole.console(LogType.LOG, String.format("Validating skill`s name : %s", skillname));
        if (skillname.equals("")){
            this.formattedConsole.console(LogType.ERROR, "Skill cannot have a blank name! Finish validation.");
            return false;

        } else if (skillname.contains("CANNOT_FIND_FILE_") || skillname.contains("CANNOT_PARSE_FILE_") || skillname.contains("CANNOT_READ_FILE_")){
            this.formattedConsole.console(LogType.ERROR, "It seems something went wrong during parsing the skill! Validation result : ");
            this.formattedConsole.console(LogType.ERROR, String.format("DESCRIPTION : %s", skill.getDescription()));
            return false;
        } else {
            this.formattedConsole.console(LogType.LOG, "Finished name validation. Skill has a proper name.");
        }
        // Check magicspell
        this.formattedConsole.console(LogType.LOG, String.format("Validating skill`s magicspell : %s", magicspell_skillname));
        if (magicspell_skillname.equals("")) {
            this.formattedConsole.console(LogType.ERROR, "Skill cannot have a blank magicspell.");
            return false;
        } else {
            this.formattedConsole.console(LogType.LOG, "Finished magicspell validation. Skill has a proper magicspell.");
        }

        //Finish validation
        this.formattedConsole.console(LogType.LOG, "Finished validation. The skill has proper format.");
        return true;
    }
}

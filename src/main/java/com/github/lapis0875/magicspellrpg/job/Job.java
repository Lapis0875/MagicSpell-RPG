package com.github.lapis0875.magicspellrpg.job;

import com.github.lapis0875.magicspellrpg.skill.Skill;

public class Job {
    private String name = "";
    private String description = "";
    private Skill[] skills = {};

    public Job(String name, String description, Skill[] skills){
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Skill[] getSkills() {
        return this.skills;
    }
}

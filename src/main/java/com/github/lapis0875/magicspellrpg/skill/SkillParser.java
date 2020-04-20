package com.github.lapis0875.magicspellrpg.skill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.github.lapis0875.magicspellrpg.console.*;

/**
 * SkillParser
 * Class for parsing skill configs
 * Skill config file example -> src/resources/skills
 * */
public class SkillParser{
    FormattedConsole formattedConsole;

    public SkillParser(FormattedConsole formattedConsole){
        this.formattedConsole = formattedConsole;
    }

    public Skill parseSkill(File file){
        this.formattedConsole.console(LogType.LOG, String.format("Parsing skill configuration file : %s", file.getName()));
        if (file.canRead()){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                StringBuilder skillStringBuilder = new StringBuilder();
                for (Iterator<String> it = bufferedReader.lines().iterator(); it.hasNext(); ) {
                    String line = it.next();
                    this.formattedConsole.console(LogType.DEBUG, String.format("Read a line in skill file. %s", line));
                    skillStringBuilder.append(line.replace('\n', ' '));
                }
                JSONParser jsonParser = new JSONParser();
                this.formattedConsole.console(LogType.DEBUG, String.format("Parsed skill configuration : \n%s", skillStringBuilder.toString()));
                JSONObject skillJSON= (JSONObject) jsonParser.parse(skillStringBuilder.toString());

                return new Skill((String) skillJSON.get("name"), (String) skillJSON.get("magicspell_name"), (String) skillJSON.get("description"),
                        (int) skillJSON.get("damage"), (int) skillJSON.get("hit_count"), (int) skillJSON.get("duration"));

            } catch (FileNotFoundException e) {
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill file %s . Skip parsing the skill...", file.getName()) );
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill file %s . Skip parsing the skill...", file.getName()) );

                return new Skill(String.format("CANNOT_FIND_FILE_%s", file.getName()), "UNKNOWN", "CHECK_FILE_EXISTENCE_AND_REPORT_TO_DEVELOPER", 0, 0, 0);
            } catch (ParseException e){
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill config file `%s` . Skip parsing the skill...", file.getName()) );
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot parse skill config file `%s` . Maybe the content of the file is malformed? Skip parsing the skill...", file.getName()) );

                return new Skill(String.format("CANNOT_PARSE_FILE_%s", file.getName()), "UNKNOWN", "CHECK_FILE_CONTENT_AND_REPORT_TO_DEVELOPER", 0, 0, 0);

            }
        }else{
            this.formattedConsole.console(LogType.ERROR, String.format("Skill file %s cannot be read! Skip parsing the skill...", file.getName()));
            return new Skill(String.format("CANNOT_READ_FILE_%s", file.getName()), "UNKNOWN", "CHECK_FILE_ACCESSIBILITY_AND_REPORT_TO_DEVELOPER", 0, 0, 0);
        }
    }

}

package com.github.lapis0875.magicspellrpg.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Iterator;

import com.github.lapis0875.magicspellrpg.skill.Skill;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.github.lapis0875.magicspellrpg.console.*;

/**
 * Parse job configuration file to Job objects
 *
 * job config file content (example) -> src/resources/jobs
 */
public class JobParser {

    FormattedConsole formattedConsole;

    public JobParser(FormattedConsole formattedConsole){
        this.formattedConsole = formattedConsole;
    }

    public Job parseSkill(File file){
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
                JSONObject skillJSON= (JSONObject) jsonParser.parse(skillStringBuilder.toString());

                return new Job((String) skillJSON.get("name"),(String) skillJSON.get("description") , (Skill[]) skillJSON.get("skills"));

            } catch (FileNotFoundException e) {
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill file %s . Skip parsing the skill...", file.getName()) );
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill file %s . Skip parsing the skill...", file.getName()) );
                Skill[] empty = {};
                return new Job("CANNOT_READ_FILE","CHECK_FILE_EXISTENCE_AND_REPORT_TO_DEVELOPER" , empty);
            } catch (ParseException e){
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot find skill config file `%s` . Skip parsing the skill...", file.getName()) );
                this.formattedConsole.console(LogType.ERROR, String.format("Cannot parse skill config file `%s` . Maybe the content of the file is malformed? Skip parsing the skill...", file.getName()) );

                Skill[] empty = {};
                return new Job("CANNOT_PARSE_FILE", "CHECK_FILE_CONTENT_AND_REPORT_TO_DEVELOPER", empty);

            }
        }else{
            this.formattedConsole.console(LogType.ERROR, String.format("Skill file %s cannot be read! Skip parsing the skill...", file.getName()));
            Skill[] empty = {};
            return new Job(file.getName(),"CHECK_FILE_ACCESSIBILITY_AND_REPORT_TO_DEVELOPER", empty);
        }
    }



}

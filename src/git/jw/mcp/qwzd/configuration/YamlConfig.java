package git.jw.mcp.qwzd.configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class YamlConfig extends Config{
    YamlConfiguration cfg;
    public YamlConfig(Plugin p,String path){
        this.plugin=p;
        this.src=new File(p.getDataFolder(),path+".yml");
        if(!src.exists()){
            try {
                src.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfg=YamlConfiguration.loadConfiguration(src);
    }
    public YamlConfiguration getCfg(){
        return cfg;
    }
    public void save(){
        try {
            getCfg().save(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

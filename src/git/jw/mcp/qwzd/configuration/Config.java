package git.jw.mcp.qwzd.configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.plugin.Plugin;

import java.io.*;

public  class Config<T extends Configuration> {
    private File source;
    private Gson json;
    public Config(Plugin plugin, String path){
        source=new File(plugin.getDataFolder(),path+".json");
        try {
            if(!source.exists()){
                source.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        json=new Gson();
    }
    public T getConfig(){
        InputStreamReader fr = null;
        try {
             fr=new FileReader(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return json.fromJson(fr,new TypeToken<Configuration>(){}.getType());
    }

}

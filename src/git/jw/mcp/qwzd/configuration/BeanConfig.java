package git.jw.mcp.qwzd.configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;

public class BeanConfig  extends Config{
    Gson gson;
    public BeanConfig (Plugin p, String path){
        this.plugin=p;
        this.src=new File(p.getDataFolder(),path+".json");
        if(!src.exists()){
            try {
                src.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        gson=new Gson();
    }
    public <T> T load(Type type){
        try {
            FileReader fr=new FileReader(src);
            return gson.fromJson(fr,type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void save(Serializable serializable){
        try {
            FileWriter writer=new FileWriter(src);
            gson.toJson(serializable,writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

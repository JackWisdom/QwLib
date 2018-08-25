package git.jw.mcp.qwzd.cmd;

public class CmdConstruct {
    enum Type{
        STRING,INTEGER,DOUBLE
    }
    private Type[] list;
    public CmdConstruct(Type... types){
        list=types;
    }
    public boolean Matches(String[] strings ){
        try {
            for(int i=0;i<=strings.length;i++){
                if(list[i]==Type.INTEGER){
                    Integer.parseInt(strings[i]);
                }else
                if(list[i]==Type.DOUBLE){
                    Double.parseDouble(strings[i]);
                }
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }
}

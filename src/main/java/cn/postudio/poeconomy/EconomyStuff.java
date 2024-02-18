package cn.postudio.poeconomy;

import cn.postudio.pocore.FileFunction;
import cn.postudio.pocore.POFileType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.sql.PooledConnection;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class EconomyStuff {

    public static void initializePlayerEconomy(@NotNull Player player){
        UUID uuid = player.getUniqueId();
        File file = FileFunction.getFile(POFileType.PlayerData, String.valueOf(uuid));
        FileConfiguration fileConfiguration = FileFunction.getFileCfg(file);

        List<String> economyType = getEconomyTypeInConfig();
        String s1;
        if (fileConfiguration.get("Economy") == null){
            try{
                for (String string : economyType) {
                    s1 = string;
                    FileFunction.writeFile(file, "Economy." + s1, 0);
                }
            }catch (IOException ignored){}
        }else{
            List<String> l = new ArrayList<>(fileConfiguration.getKeys(true));
            List<String> playerFileEconomyType = new ArrayList<>();
            for (String string : l){
                if (string.contains("Economy.")){
                    playerFileEconomyType.add(string.replace("Economy.", ""));
                }
            }

            int a = economyType.size();
            String s2;
            for (String s : playerFileEconomyType) {
                if (!economyType.contains(s)) {
                    s2 = s;
                    try {
                        FileFunction.writeFile(file, "Economy." + s2, null);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            for (int i = 0; i < a; i++) {
                if (!playerFileEconomyType.contains(economyType.get(i))){
                    s2 = economyType.get(i);
                    try {
                        FileFunction.writeFile(file, "Economy." + s2, 0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private static @NotNull List<String> getEconomyTypeInConfig(){
        File config = FileFunction.getPOConfig();
        FileConfiguration configuration = FileFunction.getFileCfg(config);
        PoEconomy.getPlugin().getLogger().info(String.valueOf(config));
        return configuration.getStringList("EconomyType");
    }
}

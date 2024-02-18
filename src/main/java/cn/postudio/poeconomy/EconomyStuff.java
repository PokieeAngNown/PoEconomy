package cn.postudio.poeconomy;

import cn.postudio.pocore.FileFunction;
import cn.postudio.pocore.POFileType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class EconomyStuff {

    public static void initializePlayerEconomy(@NotNull Player player){
        UUID uuid = player.getUniqueId();
        File file = FileFunction.getFile(POFileType.PlayerData, String.valueOf(uuid));
        List<String> list = getEconomyTypeInConfig();
        String s;
        try{
            for (String string : list) {
                s = string;
                FileFunction.writeFile(file, s, 0);
            }
        }catch (IOException ignored){}
    }

    private static @NotNull List<String> getEconomyTypeInConfig(){
        File config = FileFunction.getPOConfig();
        FileConfiguration configuration = FileFunction.getFileCfg(config);
        PoEconomy.getPlugin().getLogger().info(String.valueOf(config));
        return configuration.getStringList("EconomyType");
    }
}

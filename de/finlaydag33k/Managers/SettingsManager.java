/*    */ package de.finlaydag33k.Managers;
/*    */ 
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ public class SettingsManager
/*    */ {
/* 17 */   public static File configFile = new File("plugins/BungeeSigns", "config.yml");
/* 18 */   public static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
/*    */   private static BungeeSigns BungeeSigns;
/*    */   
/*    */   public static void setBungeeSigns(BungeeSigns opject)
/*    */   {
/* 23 */     BungeeSigns = opject;
/*    */   }
/*    */   
/*    */   public static void saveConfig()
/*    */   {
/*    */     try
/*    */     {
/* 30 */       config.save(configFile);
/*    */     } catch (IOException e) {
/* 32 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public static void createSign(String signName, String serverName String serverIp, String serverPort, Location location) {
/* 37 */     config.set("location." + signName, location);
/* 38 */     config.set("name." + signName, serverName);
/* 39 */     config.set("port." + signName, serverPort);
/* 40 */     config.set("ip." + signName, serverIp));
/* 41 */     saveConfig();
/*    */   }
/*    */   
/* 44 */   public static String getServer(String signName) { 
				return config.getString("name." + signName); 
			}
/*    */   
/*    */   public static Location getLocation(String signName){
/* 48 */   		return (Location)config.get("location." + signName);
/*    */   }
/*    */   
/*    */   public static Integer getPort(String signName) {
/* 52 */     return Integer.valueOf(config.getInt("port." + signName));
/*    */   }
/*    */   
/* 55 */   public static String getIp(String signName) { return config.getString("ip." + signName); }
/*    */   
/*    */   public static HashMap<Sign, String> getSigns()
/*    */   {
/* 59 */     HashMap<Sign, String> signs = new HashMap();
/*    */     try {
/* 61 */       for (String key : config.getConfigurationSection("location").getKeys(true)) {
/* 62 */         Location location = (Location)config.get("location." + key);
/*    */         try {
/* 64 */           Sign sign = (Sign)location.getBlock().getState();
/* 65 */           signs.put(sign, key);
/*    */         }
/*    */         catch (ClassCastException ex) {
/* 68 */           config.set("location." + key, null);
/* 69 */           config.set("port." + key, null);
/* 70 */           config.set("name." + key, null);
/* 71 */           saveConfig();
/*    */         }
/*    */         
/*    */       }
/*    */     }
/*    */     catch (NullPointerException ex)
/*    */     {
/* 78 */       return signs;
/*    */     }
/* 80 */     return signs;
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Managers\SettingsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
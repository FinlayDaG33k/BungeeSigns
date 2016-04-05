/*    */ package de.finlaydag33k.Util;
/*    */ 
/*    */ import de.finlaydag33k.BungeeSigns.BungeeSigns;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.messaging.Messenger;
/*    */ 
/*    */ public class PlayerSender
/*    */ {
/*    */   private static BungeeSigns BungeeSigns;
/*    */   
/*    */   public static void setBungeeSigns(BungeeSigns BungeeSigns)
/*    */   {
/* 16 */     BungeeSigns = BungeeSigns;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void sendPlayerServer(Player player, String serverName)
/*    */   {
/* 22 */     ByteArrayOutputStream b = new ByteArrayOutputStream();
/* 23 */     DataOutputStream out = new DataOutputStream(b);
/*    */     try {
/* 25 */       out.writeUTF("Connect");
/* 26 */       out.writeUTF(serverName);
/*    */     } catch (IOException e) {
/* 28 */       e.printStackTrace();
/*    */     }
/* 30 */     org.bukkit.Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(BungeeSigns, "BungeeCord");
/* 31 */     player.sendPluginMessage(BungeeSigns, "BungeeCord", b.toByteArray());
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Util\PlayerSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
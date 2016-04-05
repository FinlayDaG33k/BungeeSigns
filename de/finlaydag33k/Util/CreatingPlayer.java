/*     */ package de.finlaydag33k.Util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class CreatingPlayer
/*     */ {
/*     */   private Player player;
/*     */   private boolean finish;
/*     */   private String signName;
/*     */   private String serverName;
/*     */   
/*     */   public CreatingPlayer()
/*     */   {
/*  19 */     this.finish = true;
/*  20 */     this.player = null;
/*     */   }
/*     */   
/*     */   public Player getPlayer() {
/*  24 */     return this.player;
/*     */   }
/*     */   
/*  27 */   public boolean isFinish() { return this.finish; }
/*     */   
/*     */   public void heFinished()
/*     */   {
/*  31 */     this.finish = true;
/*     */   }
/*     */   
/*  34 */   public String getServerName() { return this.serverName; }
/*     */   
/*     */   public String getSignName() {
/*  37 */     return this.signName;
/*     */   }
/*     */   
/*     */   public void initialise(Player player, String signName, String serverName)
/*     */   {
/*  42 */     this.player = player;
/*  43 */     this.finish = false;
/*  44 */     this.signName = signName;
/*  45 */     this.serverName = serverName;
/*     */   }
/*     */   
/*     */   public static class PingServer
/*     */   {
/*  50 */     private String host = null;
/*  51 */     private int port = 0;
/*  52 */     private Socket socket = new Socket();
/*  53 */     private String[] data = new String['ϧ'];
/*     */     
/*     */     public PingServer(String host, int port) {
/*  56 */       this.host = host;
/*  57 */       this.port = port;
/*     */       try
/*     */       {
/*  60 */         this.socket.connect(new InetSocketAddress(host, port));
/*  61 */         OutputStream out = this.socket.getOutputStream();
/*  62 */         InputStream in = this.socket.getInputStream();
/*  63 */         out.write(254);
/*     */         
/*     */ 
/*  66 */         StringBuffer str = new StringBuffer();
/*  67 */         int b; while ((b = in.read()) != -1) {
/*  68 */           if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
/*  69 */             str.append((char)b);
/*     */           }
/*     */         }
/*     */         
/*  73 */         this.data = str.toString().split("§");
/*  74 */         this.data[0] = this.data[0].substring(1, this.data[0].length());
/*     */       } catch (IOException e) {
/*  76 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/*     */     public String getMotd() {
/*  81 */       return this.data[0];
/*     */     }
/*     */     
/*     */     public int getOnline() {
/*  85 */       return Integer.parseInt(this.data[1]);
/*     */     }
/*     */     
/*     */     public int getMax() {
/*  89 */       return Integer.parseInt(this.data[2]);
/*     */     }
/*     */     
/*     */     public void update()
/*     */     {
/*     */       try {
/*  95 */         this.socket.close();
/*  96 */         this.socket = new Socket();
/*  97 */         this.socket.connect(new InetSocketAddress(this.host, this.port));
/*  98 */         OutputStream out = this.socket.getOutputStream();
/*  99 */         InputStream in = this.socket.getInputStream();
/* 100 */         out.write(254);
/*     */         
/*     */ 
/* 103 */         StringBuffer str = new StringBuffer();
/* 104 */         int b; while ((b = in.read()) != -1) {
/* 105 */           if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
/* 106 */             str.append((char)b);
/*     */           }
/*     */         }
/*     */         
/* 110 */         this.data = str.toString().split("§");
/* 111 */         this.data[0] = this.data[0].substring(1, this.data[0].length());
/*     */       } catch (IOException e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Util\CreatingPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
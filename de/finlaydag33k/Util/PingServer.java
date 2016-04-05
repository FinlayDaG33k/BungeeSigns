/*    */ package de.finlaydag33k.Util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.net.ConnectException;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.Socket;
/*    */ 
/*    */ public class PingServer
/*    */ {
/* 12 */   private String host = null;
/* 13 */   private int port = 0;
/* 14 */   private Socket socket = new Socket();
/* 15 */   private String[] data = new String['ϧ'];
/*    */   private boolean isOnline;
/*    */   
/*    */   public PingServer(String host, int port)
/*    */   {
/* 20 */     this.host = host;
/* 21 */     this.port = port;
/*    */     try
/*    */     {
/*    */       try {
/* 25 */         this.socket.connect(new InetSocketAddress(host, port));
/*    */       }
/*    */       catch (ConnectException ex) {
/* 28 */         this.isOnline = false;
/* 29 */         return;
/*    */       }
/* 31 */       this.isOnline = true;
/* 32 */       OutputStream out = this.socket.getOutputStream();
/* 33 */       InputStream in = this.socket.getInputStream();
/* 34 */       out.write(254);
/*    */       
/*    */ 
/* 37 */       StringBuffer str = new StringBuffer();
/* 38 */       int b; while ((b = in.read()) != -1) {
/* 39 */         if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
/* 40 */           str.append((char)b);
/*    */         }
/*    */       }
/*    */       
/* 44 */       this.data = str.toString().split("§");
/* 45 */       this.data[0] = this.data[0].substring(1, this.data[0].length());
/*    */     } catch (IOException e) {
/* 47 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public String getMotd() {
/* 52 */     return this.data[0];
/*    */   }
/*    */   
/*    */   public Integer getOnline() {
/* 56 */     return Integer.valueOf(Integer.parseInt(this.data[1]));
/*    */   }
/*    */   
/*    */   public Integer getMax() {
/* 60 */     return Integer.valueOf(Integer.parseInt(this.data[2]));
/*    */   }
/*    */   
/*    */   public void update()
/*    */   {
/*    */     try {
/* 66 */       this.socket.close();
/* 67 */       this.socket = new Socket();
/*    */       try {
/* 69 */         this.socket.connect(new InetSocketAddress(this.host, this.port));
/*    */       }
/*    */       catch (ConnectException ex) {
/* 72 */         this.isOnline = false;
/* 73 */         return;
/*    */       }
/*    */       
/* 76 */       this.isOnline = true;
/*    */       
/* 78 */       OutputStream out = this.socket.getOutputStream();
/* 79 */       InputStream in = this.socket.getInputStream();
/* 80 */       out.write(254);
/*    */       
/*    */ 
/* 83 */       StringBuffer str = new StringBuffer();
/* 84 */       int b; while ((b = in.read()) != -1) {
/* 85 */         if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
/* 86 */           str.append((char)b);
/*    */         }
/*    */       }
/*    */       
/* 90 */       this.data = str.toString().split("§");
/* 91 */       this.data[0] = this.data[0].substring(1, this.data[0].length());
/*    */     } catch (IOException e) {
/* 93 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isOnline() {
/* 98 */     return this.isOnline;
/*    */   }
/*    */ }


/* Location:              E:\Downloads\BungeeSigns.jar!\de\finlaydag33k\Util\PingServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
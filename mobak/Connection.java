package mobak;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.text.MessagesContainer;
import mobak.text.RMSManager;

// $FF: renamed from: mobak.g
final class Connection implements Runnable {

   // $FF: renamed from: a byte
   private byte field_645;
   // $FF: renamed from: a boolean
   private boolean field_646;
   // $FF: renamed from: a mobak.i
   private UserData userData;
   // $FF: renamed from: a mobak.Main2
   private final Main2 main2;


   // $FF: renamed from: <init> (mobak.Main2, byte) void
   Connection(Main2 var1, byte var2) {
      super();
      this.main2 = var1;
      this.field_645 = 0;
      this.field_645 = var2;
   }

   // $FF: renamed from: <init> (mobak.Main2, mobak.i) void
   Connection(Main2 var1, UserData var2) {
      super();
      this.main2 = var1;
      this.field_645 = 0;
      this.field_645 = 3;
      this.userData = var2;
   }

   public final void run() {
      this.field_646 = true;

      while(!Main2.field_650 && this.field_646) {
         try {
            Thread.sleep(300L);
            if(this.field_645 == 0) {
               continue;
            }
         } catch (Exception var11) {
            SocketListener.logMessage("runCon" + var11.toString());
         }

         if(this.field_645 == 1 || this.field_645 == 3) {
            ScreenDrawer.self.method_348(true, true);
         }

         for(byte var1 = 0; var1 < SocketListener.maxConnectionAttempts; ++var1) {
            try {
               SocketListener.self.connect();
               if(SocketListener.self.method_542()) {
                  this.field_646 = false;
                  ScreenDrawer.self.method_350(true);
                  return;
               }

               if(!SocketListener.self.field_477) {
                  SocketListener.self.sendConnectionSettings();
                  if(ScreenDrawer.self == null) {
                     ScreenDrawer.self = new ScreenDrawer();
                     ScreenDrawer.self.method_320();
                  }

                  Connection connection;
                  OutputGameMessage gameMessage;
                  if(this.field_645 == 1) {
                     connection = this;
                     Main2.setLoginAndPassAsEmpty(this.main2, false);
                     int var3 = this.main2.rmsManager.getInt((byte)9, -1);
                     boolean var4 = false;
                     if(var3 > 0) {
                        try {
                           byte[] var5;
                           short var14;
                           if((var14 = RMSManager.method_677(var5 = connection.main2.rmsManager.method_673((byte)8), 0, (short)-1)) > 0) {
                              Screen.nameOfMap = RMSManager.getString(var5, 2, var14, "");
                              var4 = true;
                           }
                        } catch (Exception var9) {
                           SocketListener.logMessage("Main2.Connector.dialup() ERROR " + var9.toString());
                        }
                     }

                     short var19 = MessageProcessor.packetTypes[20];
                     if(!var4) {
                        var19 = MessageProcessor.packetTypes[21];
                     }

                     gameMessage = new OutputGameMessage(MessageProcessor.packetTypes[0], (short)16, var19, true);
                     gameMessage.addToBody(Main2.getVersion());
                     gameMessage.addToBody(Hero.self.login);
                     gameMessage.addToBody(Main2.getPassword(this.main2));
                     gameMessage.addToBody(-1);
                     gameMessage.addToBody((byte)5);
                     gameMessage.addToBody(Main2.getVersion());
                     gameMessage.addToBody(Main2.self.rmsManager.getLong((byte)27, 0L));
                     String rmsLogin = Main2.self.rmsManager.getString((byte)17, (String)null);
                     String rmsPassword = Main2.self.rmsManager.getString((byte)2, (String)null);
                     if((rmsLogin == null || rmsLogin.equals("")) && (rmsPassword == null || rmsPassword.equals(""))) {
                        gameMessage.addToBody(Main2.getHomePageUrl(this.main2));

                        try {
                           gameMessage.addToBody(Long.parseLong(connection.main2.method_861("refID", "0")));
                        } catch (NumberFormatException var8) {
                           gameMessage.addToBody(0L);
                        }
                     }

                     SocketListener.self.sendCommand(gameMessage);
                     Main2.setConnection(this.main2, (Connection)null);
                  } else if(this.field_645 == 3) {
                     UserData userData = this.userData;
                     connection = this;
                     Main2.setLoginAndPassAsEmpty(this.main2, true);
                     short var18 = MessageProcessor.packetTypes[21];
                     gameMessage = new OutputGameMessage(MessageProcessor.packetTypes[0], (short)16, var18, true);
                     gameMessage.addToBody(Main2.getVersion());
                     gameMessage.addToBody(userData.login);
                     gameMessage.addToBody(userData.password);
                     gameMessage.addToBody(-1);
                     gameMessage.addToBody((byte)5);
                     gameMessage.addToBody(Main2.getVersion());
                     gameMessage.addToBody(Main2.self.rmsManager.getLong((byte)27, 0L));
                     gameMessage.addToBody((byte)0);
                     gameMessage.addToBody(userData.userName);
                     gameMessage.addToBody(userData.heroName);
                     gameMessage.addToBody(userData.raceId);
                     gameMessage.addToBody(Main2.getHomePageUrl(this.main2));

                     try {
                        gameMessage.addToBody(Long.parseLong(connection.main2.method_861("refID", "0")));
                     } catch (NumberFormatException var7) {
                        gameMessage.addToBody(0L);
                     }

                     SocketListener.self.sendCommand(gameMessage);
                     Main2.setConnection(this.main2, (Connection)null);
                  }

                  this.field_645 = 0;
                  return;
               }

               try {
                  Thread.sleep(5000L);
               } catch (InterruptedException var10) {
                  var10.printStackTrace();
               }
            } catch (Exception var12) {
               SocketListener.logMessage("connection" + var12.toString());

               try {
                  Thread.sleep(5000L);
               } catch (InterruptedException var6) {
                  var6.printStackTrace();
               }
            }
         }

         ScreenDrawer.self.method_350(true);
         class_20 var13 = new class_20(this);
         ScreenDrawer.createNotification(MessagesContainer.getMessage(29), MessagesContainer.getMessage(31), var13);
         if(SocketListener.self != null) {
            SocketListener.self.method_538();
         }

         this.field_645 = 0;
      }

   }

   // $FF: renamed from: a (mobak.g) boolean
   static boolean method_839(Connection var0) {
      return var0.field_646;
   }

   // $FF: renamed from: a (mobak.g, byte) byte
   static byte method_840(Connection var0, byte var1) {
      return var0.field_645 = 1;
   }
}

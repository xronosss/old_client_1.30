package mobak.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import mobak.GlobalStorage;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.a.a
public final class SocketListener {

   // $FF: renamed from: a short
   public static short field_455;
   // $FF: renamed from: b short
   public static short field_456;
   // $FF: renamed from: a int
   public static int repeatInterval;
   // $FF: renamed from: b int
   public static int maxConnectionAttempts;
   // $FF: renamed from: d short
   private static short maxPacketSize;
   // $FF: renamed from: c int
   public static int errorSymbol;
   // $FF: renamed from: a java.lang.String
   public static String encoding;
   // $FF: renamed from: a mobak.a.a
   public static SocketListener self;
   // $FF: renamed from: a java.lang.String[]
   private static String[] field_463;
   // $FF: renamed from: a byte
   private static byte field_464;
   // $FF: renamed from: b java.lang.String
   private static String field_465;
   // $FF: renamed from: a javax.microedition.io.SocketConnection
   private SocketConnection socketConnection;
   // $FF: renamed from: b boolean
   private boolean field_467;
   // $FF: renamed from: c boolean
   private boolean field_468;
   // $FF: renamed from: d boolean
   private boolean field_469;
   // $FF: renamed from: a mobak.a.b
   private class_57 dataReader;
   // $FF: renamed from: a mobak.a.d
   private class_61 dataSender;
   // $FF: renamed from: c short
   public short field_472;
   // $FF: renamed from: a long
   public long field_473;
   // $FF: renamed from: c java.lang.String
   private String domain;
   // $FF: renamed from: d java.lang.String
   private String port;
   // $FF: renamed from: b byte
   private byte field_476;
   // $FF: renamed from: a boolean
   public boolean field_477;
   // $FF: renamed from: e boolean
   private boolean field_478;
   // $FF: renamed from: a java.lang.StringBuffer
   private StringBuffer field_479;


   // $FF: renamed from: a (byte[]) short
   public static short method_519(byte[] var0) {
      return var0 == null?0:(short)((127 & var0[4]) << 8 | 255 & var0[5]);
   }

   // $FF: renamed from: a (byte[]) byte
   public static byte method_520(byte[] var0) {
      return var0 == null?0:var0[2];
   }

   // $FF: renamed from: a (short) boolean
   public final boolean method_521(short var1) {
      return this.field_472 == var1;
   }

   // $FF: renamed from: a (java.lang.String, boolean) void
   public static void method_522(String var0, boolean var1) {
      if(var0 != null && !var0.equals(field_465) && var1) {
         ScreenDrawer.method_330(MessagesContainer.getMessage(135), var0);
         field_465 = var0;
         ScreenDrawer.self.method_365();
      }

      field_463[field_464] = var0;
      if(++field_464 >= field_463.length) {
         field_464 = 0;
      }

   }

   // $FF: renamed from: a (java.lang.Exception) void
   public static void method_523(Exception var0) {
      var0.printStackTrace();
      method_522(var0.getMessage(), false);
   }

   // $FF: renamed from: a (java.lang.String) void
   public static void logMessage(String var0) {
      method_522(var0, false);
   }

   // $FF: renamed from: <init> () void
   public SocketListener() {
      super();
      this.field_467 = false;
      this.field_468 = false;
      this.field_476 = 0;
      this.field_477 = false;
      this.field_478 = false;
      self = this;
      this.field_468 = false;
      this.field_469 = false;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) void
   public final void method_526(String port, String domain) {
      this.domain = domain;
      this.port = port;
      class_57 var10001 = new class_57(this, (InputStream)null);
      this.dataReader = var10001;
      class_61 var3 = new class_61(this, (OutputStream)null);
      this.dataSender = var3;
      self = this;
      this.field_468 = false;
      this.field_469 = false;
   }

   // $FF: renamed from: a () void
   public final void connect() {
      try {
         this.field_477 = true;
         this.socketConnection = (SocketConnection)Connector.open("socket://" + this.domain + ":" + this.port);
         this.field_478 = false;
         this.field_477 = false;
         this.field_469 = true;
         this.dataReader.method_514(this.socketConnection.openDataInputStream());
         this.dataSender.method_557(this.socketConnection.openDataOutputStream());
      } catch (SecurityException var2) {
         this.field_478 = true;
         this.socketConnection = null;
         method_522("SocketListenerMe " + var2.toString(), false);
      } catch (Exception var3) {
         this.socketConnection = null;
         method_522("SocketListenerMe " + var3.toString(), false);
      }
   }

   // $FF: renamed from: a (mobak.a.a.l) boolean
   public final boolean sendCommand(OutputGameMessage gameMessage) {
      try {
         if(gameMessage != null && gameMessage.getNextPacketType() != 0) {
            this.method_529(gameMessage.getNextPacketType(), gameMessage.isNeedWaiting());
         }

         this.dataSender.method_559(gameMessage);
         return true;
      } catch (Exception var2) {
         method_522("SocketListenerMe.sendCommand(OutputGameMesage) ERROR " + var2.toString(), false);
         return false;
      }
   }

   // $FF: renamed from: a (short, boolean) void
   public final void method_529(short var1, boolean var2) {
      if(var1 != 0) {
         this.field_472 = var1;
         this.field_473 = System.currentTimeMillis();
         ScreenDrawer.self.method_348(var2, true);
      }
   }

   // $FF: renamed from: a () boolean
   public final boolean method_530() {
      this.field_467 = this.socketConnection != null;
      if(!this.field_467) {
         return false;
      } else {
         try {
            this.field_467 = true;
            this.socketConnection.getLocalPort();
         } catch (IOException var1) {
            this.field_467 = false;
            this.method_531();
         }

         return this.field_467;
      }
   }

   // $FF: renamed from: f () void
   private void method_531() {
      if(!this.field_477) {
         method_522(MessagesContainer.getMessage(147), false);
         if(ScreenDrawer.self.method_351()) {
            ScreenDrawer.self.method_352(false);
         }

         class_57.method_517(this.dataReader);
         this.field_477 = true;
         this.field_476 = 0;
      }
   }

   // $FF: renamed from: b () void
   public final void sendConnectionSettings() {
      try {
         OutputGameMessage commandManager = new OutputGameMessage(MessageProcessor.packetTypes[3], (short)30, (short)0);
         commandManager.addToBody(repeatInterval);
         commandManager.addToBody(maxConnectionAttempts);
         commandManager.addToBody(maxPacketSize);
         commandManager.addToBody(encoding);
         commandManager.addToBody("RU");
         this.sendCommand(commandManager);
      } catch (Exception var2) {
         ;
      }
   }

   // $FF: renamed from: b () boolean
   public final boolean method_533() {
      return this.field_472 != -1;
   }

   // $FF: renamed from: c () void
   public final void method_534() {
      this.field_472 = -1;
      ScreenDrawer.self.method_350(true);
   }

   // $FF: renamed from: d () void
   public final void method_535() {
      this.field_473 = System.currentTimeMillis();
   }

   // $FF: renamed from: a (mobak.b.b.q) void
   public final void method_536(class_55 var1) {
      if(var1 != null) {
         if(this.field_479 == null) {
            this.field_479 = new StringBuffer();
         } else {
            this.field_479.delete(0, this.field_479.length());
         }

         if(this.dataReader != null) {
            if(this.dataReader.field_444) {
               var1.method_490("Receiving", Screen.field_26, false, 0);
            } else {
               var1.method_490("Waiting", Screen.field_26, false, 0);
            }

            this.field_479.append("last read: ").append(this.dataReader.field_443);
            var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
            this.field_479.delete(0, this.field_479.length());
            this.field_479.append("bytes read: ").append(this.dataReader.field_449);
            var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
            this.field_479.delete(0, this.field_479.length());
         }

         if(this.dataSender != null) {
            this.field_479.append("last sent: ").append(class_61.method_560(this.dataSender));
            var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
            this.field_479.delete(0, this.field_479.length());
            this.field_479.append("pkg sent: ").append(this.dataSender.packageSent);
            var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
            this.field_479.delete(0, this.field_479.length());
            this.field_479.append("bytes sent: ").append(this.dataSender.commandLength);
            var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
            this.field_479.delete(0, this.field_479.length());
         }

         this.field_479.append("cur. sceen mode: ").append(ScreenDrawer.self.method_359());
         var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
         this.field_479.delete(0, this.field_479.length());
         this.field_479.append("prev. sceen mode: ").append(ScreenDrawer.self.method_360());
         var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
         this.field_479.delete(0, this.field_479.length());
         this.field_479.append("freeMemory: ").append(Runtime.getRuntime().freeMemory());
         var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);
         this.field_479.delete(0, this.field_479.length());
         this.field_479.append("images container: ").append(GlobalStorage.method_717());
         var1.method_490(this.field_479.toString(), Screen.field_26, false, 0);

         for(byte var2 = 0; var2 < field_463.length; ++var2) {
            if(field_463[var2] != null) {
               var1.method_490(field_463[var2], Screen.field_26, false, 0);
            }
         }

      }
   }

   // $FF: renamed from: a (boolean) void
   public final void method_537(boolean var1) {
      this.field_468 = true;
      if(var1) {
         OutputGameMessage outputGameMessage = new OutputGameMessage(MessageProcessor.packetTypes[24], (short)0, (short)0);
         this.sendCommand(outputGameMessage);
      }

   }

   // $FF: renamed from: e () void
   public final void method_538() {
      this.field_469 = false;

      try {
         if(this.socketConnection != null) {
            this.socketConnection.close();
         }

         this.socketConnection = null;
      } catch (IOException var2) {
         method_522(var2.getMessage(), false);
      } catch (Exception var3) {
         ;
      }

      self = null;
   }

   // $FF: renamed from: c () boolean
   public final boolean method_539() {
      return this.field_469;
   }

   // $FF: renamed from: a () short
   public static short method_540() {
      return maxPacketSize;
   }

   // $FF: renamed from: a (short) void
   public static void setMaxPacketSize(short var0) {
      maxPacketSize = var0;
      if(self != null) {
         SocketListener var1 = self;
         if(self.dataReader != null) {
            class_57.method_518(var1.dataReader);
         }
      }

   }

   // $FF: renamed from: d () boolean
   public final boolean method_542() {
      return this.field_478;
   }

   // $FF: renamed from: b () short
   static short method_543() {
      return maxPacketSize;
   }

   // $FF: renamed from: a (mobak.a.a) boolean
   static boolean method_544(SocketListener var0) {
      return var0.field_467;
   }

   // $FF: renamed from: a (mobak.a.a) void
   static void method_545(SocketListener var0) {
      var0.method_531();
   }

   // $FF: renamed from: b (mobak.a.a) boolean
   static boolean method_546(SocketListener var0) {
      return var0.field_469;
   }

   // $FF: renamed from: c (mobak.a.a) boolean
   static boolean method_547(SocketListener var0) {
      return var0.field_468;
   }

   // $FF: renamed from: a (mobak.a.a) byte
   static byte method_548(SocketListener var0) {
      return var0.field_476++;
   }

   // $FF: renamed from: b (mobak.a.a) byte
   static byte method_549(SocketListener var0) {
      return var0.field_476;
   }

   // $FF: renamed from: a (byte[], short, byte, byte, short) byte[]
   static byte[] method_550(byte[] var0, short var1, byte var2, byte var3, short var4) {
      var0 = var0;

      for(byte var5 = 0; var5 < field_455; ++var5) {
         var0[var5] = 0;
      }

      var0[0] = (byte)(var1 >> 8);
      var0[1] = (byte)var1;
      var0[2] = var2;
      var0[3] = var3;
      var0[4] = (byte)(var4 >> 8);
      var0[5] = (byte)var4;
      return var0;
   }

   // $FF: renamed from: <clinit> () void
   static {
      field_455 = 6;
      repeatInterval = 45;
      maxConnectionAttempts = 2;
      maxPacketSize = 1024;
      encoding = "";
      self = null;
      field_463 = new String[10];
      field_464 = 0;
      field_465 = null;
   }
}

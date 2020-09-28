package mobak.a;

import java.io.IOException;
import java.io.InputStream;
import mobak.Main2;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.PacketManager;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.ScreenDrawer;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.a.b
final class class_57 implements Runnable {

   // $FF: renamed from: a short
   public short field_443;
   // $FF: renamed from: a boolean
   public boolean field_444;
   // $FF: renamed from: a java.io.InputStream
   private InputStream field_445;
   // $FF: renamed from: b short
   private short field_446;
   // $FF: renamed from: a long
   private long field_447;
   // $FF: renamed from: a byte
   private byte field_448;
   // $FF: renamed from: a int
   public int field_449;
   // $FF: renamed from: b boolean
   private boolean field_450;
   // $FF: renamed from: a java.lang.Thread
   private Thread field_451;
   // $FF: renamed from: b byte
   private byte field_452;
   // $FF: renamed from: a byte[]
   private byte[] field_453;
   // $FF: renamed from: a mobak.a.a
   private final SocketListener field_454;


   // $FF: renamed from: <init> (mobak.a.a, java.io.InputStream) void
   public class_57(SocketListener var1, InputStream var2) {
      super();
      this.field_454 = var1;
      this.field_443 = 0;
      this.field_444 = false;
      this.field_449 = 0;
      this.field_450 = true;
      this.field_452 = 0;
      this.field_453 = new byte[SocketListener.method_543() + 10];
   }

   // $FF: renamed from: a (java.io.InputStream) void
   public final void method_514(InputStream var1) {
      this.field_445 = var1;
      if(this.field_451 == null) {
         this.field_451 = new Thread(this);
         this.field_451.start();
      }

   }

   // $FF: renamed from: a (int, int) short
   private short method_515(int var1, int var2) {
      this.field_454.method_530();
      if(SocketListener.method_544(this.field_454)) {
         try {
            return this.field_445.available() <= 0?0:(short)this.field_445.read(this.field_453, var1, var2);
         } catch (IOException var3) {
            SocketListener.method_522("readData: " + var3.getMessage(), false);
            return (short)0;
         } catch (Exception var4) {
            return (short)0;
         } catch (Error var5) {
            SocketListener.logMessage(var5.getMessage());
            return (short)0;
         }
      } else {
         return (short)0;
      }
   }

   public final void run() {
      boolean var1 = false;
      short var2 = 0;
      short var3 = SocketListener.field_455;
      boolean var4 = false;

      while(!Main2.field_650 && SocketListener.method_546(this.field_454) && !SocketListener.method_547(this.field_454)) {
         try {
            Thread.sleep(200L);
            if(this.field_454.field_477) {
               this.field_454.connect();
               if(this.field_454.method_530()) {
                  OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[55]);
                  OutputGameMessage var7 = var10000;
                  var10000.addToBody(Hero.self.heroId);
                  var7.addToBody(this.field_446);
                  this.field_454.sendCommand(var7);
               } else {
                  SocketListener.method_548(this.field_454);
               }

               if(SocketListener.method_549(this.field_454) > SocketListener.maxConnectionAttempts) {
                  class_22 var13 = new class_22(this);
                  class_22 var12 = var13;
                  ScreenDrawer.createNotification(MessagesContainer.getMessage(29), MessagesContainer.getMessage(31), var12);
                  this.field_454.field_477 = false;
               } else {
                  Thread.sleep(5000L);
               }
            }

            if(SocketListener.method_544(this.field_454) && !this.field_454.field_477 && !this.field_450 && System.currentTimeMillis() - this.field_447 > (long)((this.field_448 + 1) * SocketListener.repeatInterval * 1000) && Hero.self != null) {
               if(this.field_448 > SocketListener.maxConnectionAttempts) {
                  SocketListener.method_545(this.field_454);
               } else {
                  ++this.field_448;
                  SocketListener var14 = this.field_454;
                  OutputGameMessage var10001 = new OutputGameMessage(MessageProcessor.packetTypes[54], (short)0, (short)0);
                  var14.sendCommand(var10001);
               }
            }

            short var11;
            for(; this.field_445 != null && (var11 = this.method_515(var2, var3)) > 0 && SocketListener.method_544(this.field_454); Thread.sleep(100L)) {
               this.field_447 = System.currentTimeMillis();
               this.field_450 = false;
               this.field_448 = 0;
               var2 += var11;
               this.field_449 += var11;
               this.field_444 = true;
               if(!var1) {
                  if(var11 != SocketListener.field_455) {
                     var3 -= var11;
                  }

                  if(var2 == SocketListener.field_455) {
                     this.field_443 = (short)((127 & this.field_453[0]) << 8 | 255 & this.field_453[1]);
                     var3 = (short)((127 & this.field_453[4]) << 8 | 255 & this.field_453[5]);
                     var1 = true;
                  }
               } else if((var3 -= var11) == 0) {
                  this.putPkg();
                  var2 = 0;
                  var3 = SocketListener.field_455;
                  var1 = false;
               }
            }

            this.field_444 = false;
         } catch (Exception var9) {
            SocketListener.logMessage("inputRun " + var9.toString());
         } catch (Error var10) {
            SocketListener.logMessage(var10.getMessage());
         }
      }

      this.field_451 = null;
   }

   // $FF: renamed from: a () void
   private synchronized void putPkg() {
      try {
         byte var1 = SocketListener.method_520(this.field_453);
         if(this.field_452 == 0) {
            this.field_452 = var1;
         }

         PacketManager.method_964(this.field_453);
         --this.field_452;
         PacketManager.getPacketType();
         short var2;
         if((var2 = MessageProcessor.packetTypes[16]) == SocketListener.self.field_472 && SocketListener.self.field_473 > 0L) {
            SocketListener.self.field_473 = System.currentTimeMillis();
            ScreenDrawer.method_349((short)((var1 - this.field_452) * 100 / var1));
         }

         if(this.field_452 == 0) {
            class_57 var7 = this;

            try {
               boolean var8 = ScreenDrawer.self.method_358();
               short var3 = PacketManager.getPacketType();
               short var4 = PacketManager.getNextPacketType();
               MessageProcessor.execute();
               if(var7.field_454.method_521(var3)) {
                  var7.field_454.method_534();
               }

               if(var4 != 0) {
                  var7.field_454.method_529(var4, var8);
               }
            } catch (Exception var5) {
               SocketListener.logMessage("compileGameCommand: " + var5.getMessage());
            }

            this.field_446 = this.field_443;
            this.field_443 = 0;
         }

      } catch (Exception var6) {
         SocketListener.logMessage("putPkg " + var6.getMessage());
      }
   }

   // $FF: renamed from: a (mobak.a.b) void
   static void method_517(class_57 var0) {
      if((var0 = var0).field_453 != null) {
         for(int var1 = 0; var1 < var0.field_453.length; ++var1) {
            var0.field_453[var1] = 0;
         }
      }

   }

   // $FF: renamed from: b (mobak.a.b) void
   static void method_518(class_57 var0) {}
}

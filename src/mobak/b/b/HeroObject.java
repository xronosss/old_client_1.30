package mobak.b.b;

import java.util.Random;
import javax.microedition.lcdui.Graphics;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.b.a.Hero;

// $FF: renamed from: mobak.b.b.h
public final class HeroObject extends MapObject {

   // $FF: renamed from: a java.util.Random
   private Random random;
   // $FF: renamed from: d byte
   private byte field_363;
   // $FF: renamed from: a byte[][]
   private byte[][] field_364;
   // $FF: renamed from: e byte
   private byte field_365;
   // $FF: renamed from: f byte
   private byte field_366;
   // $FF: renamed from: g byte
   private byte field_367;
   // $FF: renamed from: b byte[][]
   private byte[][] field_368;
   // $FF: renamed from: a boolean
   private boolean field_369;
   // $FF: renamed from: h byte
   private byte field_370;


   // $FF: renamed from: a () java.util.Random
   private Random method_435() {
      if(this.random == null) {
         this.random = new Random();
      }

      return this.random;
   }

   // $FF: renamed from: <init> (byte) void
   public HeroObject(byte var1) {
      super();
      this.random = null;
      this.field_369 = true;
      this.field_370 = 0;
      this.field_363 = var1;
      this.field_365 = -1;
      this.field_368 = null;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_415(Graphics var1) {
      if(var1 != null) {
         if(this.method_414()) {
            short var2 = StrategicScreen.method_99(super.field_356);
            short var3 = StrategicScreen.method_100(super.field_357);
            boolean var4 = true;
            if(var2 >= 0 && var3 >= 0) {
               if(var2 <= ScreenDrawer.self.getWidth() && var3 <= ScreenDrawer.self.getHeight()) {
                  if(super.field_361 != 2) {
                     var4 = false;
                  }

                  if(ScreenDrawer.self.method_347()) {
                     var4 = false;
                  }

                  if(var4) {
                     HeroObject var7 = this;

                     try {
                        if(var7.field_365 >= 0 && var7.field_364 != null) {
                           if((var7.field_364[var7.field_365][0] != Hero.self.getPositionX() || var7.field_364[var7.field_365][1] != Hero.self.getPositionY()) && !ScreenDrawer.self.strategicScreen.method_121(var7.field_364[var7.field_365][0], var7.field_364[var7.field_365][1])) {
                              if(var7.field_370 < 5) {
                                 ++var7.field_370;
                              } else {
                                 var7.field_370 = 0;
                                 if(var7.field_341 >= StrategicScreen.field_84) {
                                    var7.field_342 = StrategicScreen.field_84 + 1;
                                    var7.field_341 = 0;
                                    var7.method_412(var7.field_364[var7.field_365][0], var7.field_364[var7.field_365][1], false);
                                 } else {
                                    ++var7.field_341;
                                 }

                                 if(var7.field_369) {
                                    ++var7.field_365;
                                 } else {
                                    --var7.field_365;
                                 }

                                 if(var7.field_365 >= var7.field_364.length) {
                                    var7.field_365 = (byte)(var7.field_364.length - 1);
                                    var7.field_369 = false;
                                 }

                                 if(var7.field_365 < 0) {
                                    var7.field_369 = true;
                                 }
                              }
                           }
                        } else if(var7.method_435().nextInt(100) > 90) {
                           GlobalStorage.method_706(var7);
                           if(var7.field_368 == null) {
                              var7.field_366 = var7.field_356;
                              var7.field_367 = var7.field_357;
                              var7.field_368 = StrategicScreen.getWaveMatrix(var7.field_366, var7.field_367, var7.field_363, var7.field_363);
                           }

                           if(var7.field_368 != null) {
                              var7.field_364 = null;

                              for(var3 = 0; var7.field_364 == null && var3 < 10; ++var3) {
                                 byte var8 = (byte)((int)((double)var7.field_356 + (double)(-var7.field_363) + (double)(2 * var7.field_363) * var7.method_435().nextDouble()));
                                 byte var5 = (byte)((int)((double)var7.field_357 + (double)(-var7.field_363) + (double)(2 * var7.field_363) * var7.method_435().nextDouble()));
                                 var7.field_364 = StrategicScreen.method_114(var7.field_366, var7.field_367, var7.field_368, var8, var5);
                              }

                              if(var7.field_364 != null) {
                                 var7.field_365 = 0;
                              }
                           }

                           GlobalStorage.method_707(var7);
                        }
                     } catch (Exception var6) {
                        SocketListener.logMessage("heroObject move " + var6);
                     }
                  }

                  super.method_415(var1);
               }
            }
         }
      }
   }

   // $FF: renamed from: a (byte, byte, boolean) void
   public final void method_411(byte var1, byte var2, boolean var3) {
      this.field_368 = null;
      this.field_365 = -1;
      this.method_412(var1, var2, false);
   }
}

package mobak.b.b;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.class_67;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.i
public class MapObject {

   // $FF: renamed from: a int
   protected int field_341;
   // $FF: renamed from: b int
   protected int field_342;
   // $FF: renamed from: c int
   private int field_343;
   // $FF: renamed from: d int
   private int field_344;
   // $FF: renamed from: a short
   private static short field_345;
   // $FF: renamed from: b short
   private static short field_346;
   // $FF: renamed from: c short
   private static short field_347;
   // $FF: renamed from: d short
   private static short field_348;
   // $FF: renamed from: e short
   private static short field_349;
   // $FF: renamed from: f short
   private static short field_350;
   // $FF: renamed from: g short
   private static short field_351;
   // $FF: renamed from: d byte
   private byte field_352;
   // $FF: renamed from: e byte
   private byte field_353;
   // $FF: renamed from: f byte
   private byte type;
   // $FF: renamed from: e int
   private int field_355;
   // $FF: renamed from: a byte
   byte field_356;
   // $FF: renamed from: b byte
   byte field_357;
   // $FF: renamed from: g byte
   private byte field_358;
   // $FF: renamed from: a int[]
   private int[] actions;
   // $FF: renamed from: a java.lang.String
   private String name;
   // $FF: renamed from: c byte
   byte field_361;


   // $FF: renamed from: a (byte) javax.microedition.lcdui.Image
   public static Image method_403(byte var0) {
      return var0 < 12? GlobalStorage.getImage(field_345): GlobalStorage.getImage(field_346);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int) void
   public static void method_404(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      if(field_347 == -1) {
         field_347 = GlobalStorage.method_711("name_label_left.png");
      }

      if(field_348 == -1) {
         field_348 = GlobalStorage.method_711("name_label_middle.png");
      }

      if(field_349 == -1) {
         field_349 = GlobalStorage.method_711("name_label_right.png");
      }

      int var6 = ScreenDrawer.method_377(field_347) / 6;
      int var7 = ScreenDrawer.method_378(field_347);
      int var8 = ScreenDrawer.method_378(field_348);
      int var9 = ScreenDrawer.method_377(field_349) / 6;
      int var10 = ScreenDrawer.method_378(field_349);
      ScreenDrawer.method_374(var0, field_347, var1 * var6, 0, var6, var7, 0, var2 - var6, var3 - (var8 - var5) / 2, 20);
      ScreenDrawer.method_375(var0, field_348, 6, var1, var2, var3 - (var8 - var5) / 2, var2 + var4, true, 16);
      ScreenDrawer.method_374(var0, field_349, var1 * var9, 0, var9, var10, 0, var2 + var4, var3 - (var10 - var5) / 2, 20);
   }

   // $FF: renamed from: <init> () void
   public MapObject() {
      super();
      this.field_341 = 0;
      this.field_342 = 0;
      this.field_352 = -1;
      this.field_356 = this.field_357 = -1;
   }

   // $FF: renamed from: a (int) void
   public final void method_406(int var1) {
      this.field_355 = var1;
   }

   // $FF: renamed from: a (int[]) void
   public final void setActions(int[] var1) {
      this.actions = var1;
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void setName(String name) {
      this.name = name;
   }

   // $FF: renamed from: a (byte) void
   public final void setType(byte type) {
      this.type = type;
   }

   // $FF: renamed from: a () byte
   public final byte getType() {
      return this.type;
   }

   // $FF: renamed from: a (byte, byte, boolean) void
   public void method_411(byte var1, byte var2, boolean var3) {
      this.method_412(var1, var2, var3);
   }

   // $FF: renamed from: b (byte, byte, boolean) void
   protected final void method_412(byte var1, byte var2, boolean var3) {
      if(var1 != this.field_356 || this.field_357 != var2) {
         if(this.field_356 >= 0 && this.field_357 >= 0) {
            GlobalStorage.method_706(this);
         }

         this.field_356 = var1;
         this.field_357 = var2;
         if(this.method_414()) {
            GlobalStorage.method_719(this, var3);
            if(!this.method_433()) {
               GlobalStorage.method_707(this);
            }
         }

      }
   }

   // $FF: renamed from: a () int[]
   public final int[] getActions() {
      return this.actions;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_414() {
      byte var1;
      return (var1 = (byte)(this.field_361 & -128)) != -128;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public void method_415(Graphics var1) {
      if(var1 != null) {
         try {
            if(this.method_414()) {
               short var2 = StrategicScreen.method_99(this.field_356);
               short var3 = (short)(StrategicScreen.method_100(this.field_357) + 50);
               if(var2 >= -100 && var3 >= 0) {
                  if(var2 <= ScreenDrawer.self.getWidth() && var3 <= ScreenDrawer.self.getHeight() + 100) {
                     byte var4;
                     Image var10000;
                     switch(this.type) {
                     case 1:
                        var10000 = method_403(this.field_358);
                        break;
                     case 2:
                        var4 = (byte)(this.field_358 + 1);
                        var10000 = GlobalStorage.getImage(GlobalStorage.method_711(var4 + "castle.png"));
                        break;
                     case 3:
                        var4 = this.field_358;
                        var10000 = this.field_358 == 0? GlobalStorage.getImage(GlobalStorage.method_711("sunduk_open.png")):(var4 == 1? GlobalStorage.getImage(GlobalStorage.method_711("sunduk.png")):(var4 == 2? GlobalStorage.getImage(GlobalStorage.method_711("meshok_o.png")):(var4 == 3? GlobalStorage.getImage(GlobalStorage.method_711("meshok_c.png")):null)));
                        break;
                     case 4:
                        if(field_350 == -1) {
                           field_350 = GlobalStorage.method_711("generators.png");
                        }

                        var10000 = GlobalStorage.getImage(field_350);
                        break;
                     case 5:
                        if(field_351 == -1) {
                           field_351 = GlobalStorage.method_711("teleport.png");
                        }

                        var10000 = GlobalStorage.getImage(field_351);
                        break;
                     default:
                        var10000 = null;
                     }

                     Image var9 = var10000;
                     if(var10000 != null) {
                        if(this.type != 1) {
                           if(this.field_353 <= 0) {
                              ScreenDrawer.method_370(var1, var9, var2, var3 - ScreenDrawer.method_383(var9), 0);
                              return;
                           }

                           byte var5 = (byte)(ScreenDrawer.method_382(var9) / this.field_353);
                           if(this.field_352 < 0) {
                              ScreenDrawer.method_372(var1, var9, var5 * this.field_358, 0, var5, ScreenDrawer.method_383(var9), 0, var2, var3 - ScreenDrawer.method_383(var9), 0);
                              return;
                           }

                           if(this.field_352 >= this.field_353) {
                              this.field_352 = 0;
                           }

                           ScreenDrawer.method_372(var1, var9, var5 * this.field_352, 0, var5, ScreenDrawer.method_383(var9), 0, var2, var3 - ScreenDrawer.method_383(var9), 0);
                           ++this.field_352;
                        } else {
                           byte var10 = 12;
                           byte var6 = this.field_358;
                           if(this.field_358 >= 12) {
                              var6 = (byte)(var6 - 12);
                              var10 = 10;
                           }

                           if(this.field_342 > 0) {
                              this.field_343 += (var2 - this.field_343) / this.field_342;
                              this.field_344 += (var3 - this.field_344) / this.field_342;
                           } else {
                              this.field_343 = var2;
                              this.field_344 = var3;
                           }

                           short var11 = (short)(ScreenDrawer.method_382(var9) / var10);
                           short var7 = (short) ScreenDrawer.method_383(var9);
                           ScreenDrawer.method_372(var1, var9, var11 * var6, 0, var11, var7, 0, this.field_343, this.field_344 - ScreenDrawer.method_383(var9), 0);
                           --this.field_342;
                           if(this.field_361 == 7) {
                              Screen.method_46(var1, (byte)14, (short)(var2 + 5), (short)(var3 + 5 - var7), 0);
                           }
                        }
                     }

                  }
               }
            }
         } catch (Exception var8) {
            SocketListener.method_523(var8);
         }
      }
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics) void
   public final void method_416(Graphics var1) {
      if(this.method_414()) {
         if(this.name != null && this.name.length() > 0) {
            ScreenDrawer.method_384(var1, 0);
            short var2 = StrategicScreen.method_99(this.field_356);
            int var3 = StrategicScreen.method_100(this.field_357) + 50 + 2;
            int var4 = Screen.field_25.method_563(this.name);
            method_404(var1, this.type == 2?this.field_358 + 1:5, var2, var3, var4, Screen.field_25.field_500);
            Screen.field_25.method_564(var1, this.name, var2, var3 + 1, 0);
         }

      }
   }

   // $FF: renamed from: a () int
   public final int method_417() {
      return this.field_355;
   }

   // $FF: renamed from: b () byte
   public final byte method_418() {
      return this.field_356;
   }

   // $FF: renamed from: c () byte
   public final byte method_419() {
      return this.field_357;
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_420() {
      return this.name;
   }

   public String toString() {
      StringBuffer var1;
      (var1 = new StringBuffer()).append("map object\n");
      var1.append("name: [").append(this.name).append("]\n");
      var1.append("type: [").append(this.type).append("]\n");
      if(this.actions != null && this.actions.length > 0) {
         var1.append("actions: ");

         for(byte i = 0; i < this.actions.length; ++i) {
            var1.append(this.actions[i]).append(" ");
         }

         var1.append("\n");
      }

      return var1.toString();
   }

   // $FF: renamed from: a () void
   public static void method_421() {}

   // $FF: renamed from: b (byte) void
   public final void method_422(byte var1) {}

   // $FF: renamed from: b () void
   public static void method_423() {}

   // $FF: renamed from: d () byte
   public final byte method_424() {
      return this.field_358;
   }

   // $FF: renamed from: c (byte) void
   public final void method_425(byte var1) {
      this.field_358 = var1;
      GlobalStorage.method_706(this);
      if(!this.method_433()) {
         GlobalStorage.method_707(this);
      }

      switch(this.type) {
      case 1:
         this.field_352 = -1;
         this.field_353 = 22;
      case 2:
         this.field_352 = 0;
         if(this.field_358 == 0) {
            this.field_353 = 3;
            return;
         }

         this.field_353 = 3;
         return;
      case 3:
         this.field_352 = 0;
         if(this.field_358 == 1) {
            this.field_353 = 4;
            return;
         }

         this.field_353 = 0;
         return;
      case 4:
         this.field_352 = -1;
         this.field_353 = 5;
         return;
      case 5:
         this.field_352 = 0;
         this.field_353 = 6;
         return;
      default:
      }
   }

   // $FF: renamed from: d (byte) void
   public final void method_426(byte var1) {}

   // $FF: renamed from: e () byte
   public final byte method_427() {
      return this.field_361;
   }

   // $FF: renamed from: e (byte) void
   public final void method_428(byte var1) {
      boolean var2 = this.method_414();
      this.field_361 = var1;
      if(var2 && !this.method_414()) {
         GlobalStorage.method_706(this);
      } else {
         if(!var2 && this.method_414()) {
            GlobalStorage.method_719(this, false);
            GlobalStorage.method_707(this);
         }

      }
   }

   // $FF: renamed from: c () void
   public final void method_429() {
      this.field_361 &= -128;
   }

   // $FF: renamed from: d () void
   public final void method_430() {
      this.field_361 = (byte)(this.field_361 & 127);
   }

   // $FF: renamed from: b () boolean
   public final boolean method_431() {
      return this.type == 2 || this.type == 4 || this.type == 5 || this.type == 3;
   }

   // $FF: renamed from: e () void
   public final void method_432() {
      String var1 = null;
      String var2 = null;
      switch(this.type) {
      case 2:
         var1 = MessagesContainer.getMessage(194) + MessagesContainer.method_575(this.field_358 + 1);
         var2 = MessagesContainer.getMessage(195);
         break;
      case 3:
         if(this.field_358 > 1) {
            var1 = MessagesContainer.getMessage(96);
            var2 = MessagesContainer.getMessage(199);
         } else {
            var1 = MessagesContainer.getMessage(97);
            var2 = MessagesContainer.getMessage(198);
         }
         break;
      case 4:
         var1 = MessagesContainer.getMessage(196) + MessagesContainer.method_575(this.field_358 + 1);
         var2 = MessagesContainer.getMessage(197);
         break;
      case 5:
         var1 = MessagesContainer.getMessage(200);
         var2 = MessagesContainer.getMessage(201);
      }

      ScreenDrawer.method_330(var1, var2);
   }

   // $FF: renamed from: c () boolean
   private boolean method_433() {
      class_67 var1;
      if((var1 = GlobalStorage.method_714(this.type)).field_542 == null) {
         return false;
      } else {
         for(byte var2 = 0; var2 < var1.field_542.length; ++var2) {
            if(var1.field_542[var2] == this.field_358) {
               return true;
            }
         }

         return false;
      }
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_345 = GlobalStorage.method_711("herouse1.png");
      field_346 = GlobalStorage.method_711("herouse2.png");
      field_347 = -1;
      field_348 = -1;
      field_349 = -1;
      field_350 = -1;
      field_351 = -1;
   }
}

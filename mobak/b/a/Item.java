package mobak.b.a;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.b.b.a.MenuScreen;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.a.e
public final class Item extends Thing {

   // $FF: renamed from: b boolean
   private static boolean field_594;
   // $FF: renamed from: c boolean
   private boolean field_595;
   // $FF: renamed from: a short[]
   private static short[] field_596;
   // $FF: renamed from: a short
   private static short field_597;
   // $FF: renamed from: b byte
   private byte field_598;
   // $FF: renamed from: b short
   private short field_599;
   // $FF: renamed from: d java.lang.String
   private String field_600;
   // $FF: renamed from: e java.lang.String
   private String description;
   // $FF: renamed from: c byte
   private byte itemCanUse;
   // $FF: renamed from: f int
   private int field_603;
   // $FF: renamed from: d byte
   private byte itemCategory;
   // $FF: renamed from: e byte
   private byte field_605;
   // $FF: renamed from: a mobak.b.a.d[]
   public Characteristic[] characteristics;


   // $FF: renamed from: a () void
   public static void method_779() {
      field_594 = false;
   }

   // $FF: renamed from: b () void
   public static void method_780() {
      field_594 = true;
   }

   // $FF: renamed from: a (int) javax.microedition.lcdui.Image
   public static Image method_781(int var0) {
      var0 = var0;
      int var1 = 0;

      int var10000;
      while(true) {
         if(var1 >= GlobalStorage.field_558.length) {
            var10000 = field_596.length - 1;
            break;
         }

         if(var0 < GlobalStorage.field_559[var1]) {
            var10000 = var1;
            break;
         }

         var0 -= GlobalStorage.field_559[var1];
         ++var1;
      }

      var0 = var10000;
      if(field_596[var0] == -1) {
         field_596[var0] = GlobalStorage.method_711(GlobalStorage.field_558[var0]);
      }

      return GlobalStorage.getImage(field_596[var0]);
   }

   // $FF: renamed from: <init> (boolean) void
   public Item(boolean var1) {
      super();
      this.field_598 = -2;
      this.field_599 = -1;
      this.itemCanUse = -1;
      this.field_603 = -1;
      this.field_595 = var1;
   }

   // $FF: renamed from: a (int) void
   public final void setImageIndex(int imageIndex) {
      try {
         super.imageIndex = imageIndex;
      } catch (Exception var2) {
         SocketListener.logMessage("set_imageCode" + var2.toString());
      }
   }

   // $FF: renamed from: e () byte
   public final byte method_783() {
      return this.field_598;
   }

   // $FF: renamed from: b () short
   public final short method_784() {
      return this.field_599;
   }

   // $FF: renamed from: d () byte
   public final byte isCanUse() {
      return this.itemCanUse;
   }

   // $FF: renamed from: a (mobak.b.a.a) boolean
   public final boolean method_755(Thing var1) {
      try {
         if(var1.method_754() != 2) {
            return false;
         } else {
            Item item = (Item)var1;
            return this.field_603 == item.field_603 && this.field_599 == item.field_599;
         }
      } catch (Exception var2) {
         SocketListener.logMessage("equal" + var2.toString());
         return false;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, mobak.b.a.e, short, short, short) void
   private static void method_785(Graphics var0, Item var1, short var2, short var3, short var4) {
      short var5 = (short)(var2 + 3 + 1);
      short var6 = (short)(var3 + 3);
      if((var4 & 1) != 1 && (var4 & 1024) != 1024) {
         MenuScreen.method_131(var0, var2, var3, 0);
      } else {
         MenuScreen.method_131(var0, var2, var3, (var4 & 1024) == 1024?2:1);
      }

      Image var7;
      if((byte)(var1.field_598 & 1) == 1) {
         if(field_597 == -1) {
            field_597 = GlobalStorage.method_711("magic.png");
         }

         var7 = GlobalStorage.getImage(field_597);
      } else {
         var7 = method_781(var1.imageIndex);
      }

      int var10 = var1.imageIndex;
      int var8 = 0;

      int var10002;
      while(true) {
         if(var8 >= GlobalStorage.field_558.length) {
            var10002 = 0;
            break;
         }

         if(var10 < GlobalStorage.field_559[var8]) {
            var10002 = var10;
            break;
         }

         var10 -= GlobalStorage.field_559[var8];
         ++var8;
      }

      ScreenDrawer.method_372(var0, var7, var10002 * 55, 0, 55, 47, 0, var5, var6, 0);
      if((var4 & 4) == 4) {
         Thing.method_767(var0, var2, var3, var1.raceId);
      }

      if((var4 & 8) == 8) {
         Thing.method_769(var0, var2, var3, var1.field_600);
      }

      Screen.field_25.method_563(var1.field_580);
      int var10000 = Screen.field_25.field_500;
      if((var4 & 2) == 2) {
         Thing.method_764(var0, var2, var3, var1.field_580);
      }

      if((var4 & 16) != 0 && var1.field_577 > 0) {
         Thing.method_765(var0, var2, var3, var1.field_578);
      }

      if((var4 & 768) != 0) {
         byte var9 = (byte)(((var4 & 768) >> 8) - 1);
         Thing.method_768(var0, var2, var3, var1.method_753(var9), var1.field_595);
      }

   }

   // $FF: renamed from: b () byte
   public final byte method_754() {
      return (byte)2;
   }

   // $FF: renamed from: c () byte
   public final byte getCategory() {
      return this.itemCategory;
   }

   // $FF: renamed from: b (byte) void
   public final void setIsItemCanUse(byte var1) {
      this.itemCanUse = var1;
   }

   // $FF: renamed from: a (mobak.b.b.q, java.lang.String, short) void
   public final void getDescription(class_55 var1, String var2, short var3) {
      if(var1 != null) {
         if(this.description != null && !this.description.equals("")) {
            try {
               if(var1.method_496()) {
                  StringBuffer info = new StringBuffer();
                  info.append(super.name).append("\n");
                  var1.method_490(info.toString(), Screen.field_26, false, -1);
                  info.delete(0, info.length());
                  info.append(MessagesContainer.getMessage(18)).append(": ").append(MessagesContainer.method_574(this.getRaceId())).append("\n");
                  var1.method_490(info.toString(), Screen.field_26, false, -1);
                  info.delete(0, info.length());
                  var1.field_429 += Screen.field_26.field_500 / 2;
                  if(var2 != null && !var2.equals("")) {
                     info.append(var2).append("\n");
                     var1.method_490(info.toString(), Screen.field_26, false, -1);
                     info.delete(0, info.length());
                  }

                  var1.field_429 += Screen.field_26.field_500 / 2;
                  if(!this.GetLocation().equals("") && (short)(var3 & 4096) == 4096) {
                     info.append(MessagesContainer.getMessage(174)).append(": ").append(this.GetLocation());
                     var1.method_490(info.toString(), Screen.field_26, false, -1);
                     info.delete(0, info.length());
                  }

                  if(this.characteristics != null && this.characteristics.length > 0) {
                     info.append(MessagesContainer.getMessage(55)).append(":\n");
                     var1.method_490(info.toString(), Screen.field_26, false, -1);
                     info.delete(0, info.length());

                     for(byte var6 = 0; var6 < this.characteristics.length; ++var6) {
                        info.append(this.characteristics[var6].name).append(": ");
                        if(this.characteristics[var6].value > 0) {
                           info.append("+");
                        } else {
                           info.append("-");
                        }

                        info.append(Math.abs(this.characteristics[var6].value)).append("\n");
                        var1.method_490(info.toString(), Screen.field_26, false, -1);
                        info.delete(0, info.length());
                     }
                  }

                  info.append(this.description).append("\n");
                  var1.method_490(info.toString(), Screen.field_26, false, -1);
                  info.delete(0, info.length());
               }

               return;
            } catch (Exception var5) {
               SocketListener.logMessage("getDescription" + var5.toString());
            }
         }

      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, short) void
   public final void method_758(Graphics var1, short var2, short var3, short var4) {
      if(var1 != null) {
         if((var4 & 32) == 32) {
            method_785(var1, this, var2, var3, var4);
            if((var4 & 64) == 64) {
               if(field_594) {
                  MenuScreen.method_138(var1, var2, var3, !super.isOnHero, this.itemCanUse > 0);
                  return;
               }

               MenuScreen.method_138(var1, var2, var3, !super.isOnHero, super.isOnHero);
               return;
            }
         } else {
            method_785(var1, this, var2, var3, var4);
         }

      }
   }

   public final String toString() {
      StringBuffer var1;
      (var1 = new StringBuffer()).append("id[_id").append("\n");
      var1.append("race[_raceId").append("\n");
      var1.append("level[_level").append("\n");
      var1.append("quantity[_quantity").append("\n");
      return var1.toString();
   }

   // $FF: renamed from: f (int) void
   public final void setPlace(int var1) {
      super.place = var1;
   }

   // $FF: renamed from: c (java.lang.String) void
   public final void setDescription(String var1) {
      this.description = var1;
   }

   // $FF: renamed from: a (short) void
   public final void setLvl(short var1) {
      this.field_599 = var1;
      this.field_600 = String.valueOf(var1);
   }

   // $FF: renamed from: c (byte) void
   public final void setItemCategory(byte var1) {
      this.itemCategory = var1;
   }

   // $FF: renamed from: g (int) void
   public final void method_791(int var1) {
      this.field_603 = var1;
   }

   // $FF: renamed from: d (byte) void
   public final void setMagicOrItem(byte var1) {
      this.field_598 = var1;
   }

   // $FF: renamed from: e (byte) void
   public final void method_793(byte var1) {
      this.field_605 = var1;
   }

   // $FF: renamed from: b (byte) boolean
   public final boolean method_794(byte var1) {
      return (byte)(this.field_605 & var1) == var1;
   }

   // $FF: renamed from: a (byte) boolean
   public final boolean method_771(byte var1) {
      return (this.field_598 & var1) > 0;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_594 = true;
      field_596 = new short[]{(short)-1, (short)-1, (short)-1};
      field_597 = -1;
   }
}

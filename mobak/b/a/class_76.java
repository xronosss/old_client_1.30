package mobak.b.a;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.MapObject;
import mobak.b.b.class_55;
import mobak.b.b.a.MenuScreen;

// $FF: renamed from: mobak.b.a.c
public final class class_76 extends Thing {

   // $FF: renamed from: d java.lang.String
   private String field_589;
   // $FF: renamed from: b byte
   private byte field_590;
   // $FF: renamed from: c byte
   private byte field_591;
   // $FF: renamed from: d byte
   private byte field_592;
   // $FF: renamed from: a byte[]
   private byte[] field_593;


   // $FF: renamed from: <init> (short, byte, byte, byte, java.lang.String, int) void
   public class_76(short imageIndex, byte var2, byte var3, byte var4, String name, int Id) {
      super();
      super.Id = Id;
      super.imageIndex = imageIndex;
      this.field_590 = var2;
      this.field_591 = var3;
      var2 = var4;
      this.field_592 = var4;
      var3 = 0;

      for(this.field_593 = null; var2 != 0; var2 = (byte)(var2 >> 1)) {
         if((byte)(var2 & 1) == 1) {
            ++var3;
         }
      }

      if(var3 > 0) {
         if(var3 > 1) {
            this.field_593 = new byte[var3 + 1];
            var3 = 1;
            this.field_593[0] = 51;
         } else {
            this.field_593 = new byte[var3];
            var3 = 0;
         }

         if((byte)(this.field_592 & 1) == 1) {
            this.field_593[var3++] = 81;
         }

         if((byte)(this.field_592 & 2) == 2) {
            this.field_593[var3++] = 59;
         }

         if((byte)(this.field_592 & 4) == 4) {
            this.field_593[var3] = 89;
         }
      }

      this.field_589 = name;
   }

   // $FF: renamed from: e () byte
   public final byte method_776() {
      return this.field_590;
   }

   // $FF: renamed from: f () byte
   public final byte method_777() {
      return this.field_591;
   }

   // $FF: renamed from: a () byte[]
   public final byte[] method_778() {
      return this.field_593;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, short) void
   public final void method_758(Graphics var1, short var2, short var3, short var4) {
      if(var1 != null) {
         Image var5 = MapObject.method_403((byte)super.imageIndex);
         byte var6 = 12;
         byte var7;
         if((var7 = (byte)super.imageIndex) >= 12) {
            var7 = (byte)(var7 - 12);
            var6 = 10;
         }

         short var13 = (short)(ScreenDrawer.method_382(var5) / var6);
         short var8 = (short) ScreenDrawer.method_383(var5);
         if(var5 != null) {
            short var9 = (short) ScreenDrawer.method_386(var1);
            short var10 = (short) ScreenDrawer.method_387(var1);
            short var11 = (short) ScreenDrawer.method_388(var1);
            short var12 = (short) ScreenDrawer.method_389(var1);
            ScreenDrawer.method_369(var1, var2, var3, 62, 55);
            MenuScreen.method_131(var1, var2, var3, (var4 & 1) == 1?1:0);
            ScreenDrawer.method_372(var1, var5, var7 * var13, 0, var13, var8, 0, var2 + 7, var3 + 4, 0);
            ScreenDrawer.method_369(var1, var9, var10, var11, var12);
         }
      }
   }

   // $FF: renamed from: a (mobak.b.b.q, java.lang.String, short) void
   public final void getDescription(class_55 var1, String var2, short var3) {
      if(var1 != null) {
         var1.method_495();
         if(var2 != null && !var2.equals("")) {
            var1.method_490(var2, Screen.field_26, false, -1);
         }

         var1.method_490(this.field_589, Screen.field_26, false, -1);
      }
   }

   // $FF: renamed from: a (mobak.b.a.a) boolean
   public final boolean method_755(Thing var1) {
      return false;
   }

   // $FF: renamed from: b () byte
   public final byte method_754() {
      return (byte)0;
   }
}

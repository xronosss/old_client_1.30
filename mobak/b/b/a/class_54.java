package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.GlobalStorage;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_50;

// $FF: renamed from: mobak.b.b.a.r
public final class class_54 extends class_50 {

   // $FF: renamed from: a mobak.b.b.a.w
   public class_52 field_404;
   // $FF: renamed from: a java.lang.String
   private String field_405;
   // $FF: renamed from: c short
   private short field_406;
   // $FF: renamed from: a int
   private int field_407;
   // $FF: renamed from: b int
   private int field_408;
   // $FF: renamed from: c int
   private int field_409;


   // $FF: renamed from: a () short
   public final short method_463() {
      return (short)this.field_408;
   }

   // $FF: renamed from: b () short
   public final short method_462() {
      short var1 = (short)this.field_407;
      if(this.field_409 >= 0) {
         var1 = (short)this.field_408;
      }

      return var1;
   }

   // $FF: renamed from: <init> () void
   public class_54() {
      super();
      this.field_404 = null;
      this.field_405 = "";
      this.field_406 = -1;
      this.field_407 = 0;
      this.field_408 = 0;
   }

   // $FF: renamed from: <init> (java.lang.String, int, int) void
   public class_54(String var1, int var2, int var3) {
      super();
      this.field_404 = null;
      this.field_405 = "";
      this.field_406 = -1;
      this.field_407 = 0;
      this.field_408 = 0;
      this.field_405 = var1;
      this.field_406 = GlobalStorage.method_711(var1);
      this.field_407 = ScreenDrawer.method_377(this.field_406);
      this.field_408 = ScreenDrawer.method_378(this.field_406);
      super.field_385 = (short)var2;
      this.field_409 = -1;
      this.method_468((short)var3);
   }

   // $FF: renamed from: <init> (java.lang.String, int, int, int) void
   public class_54(String var1, int var2, int var3, int var4) {
      this(var1, 0, 0);
      this.field_409 = var4;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public final void method_464(Graphics var1, short var2, short var3, byte var4) {
      if(var1 != null && this.field_405 != null) {
         if(GlobalStorage.getImage(this.field_406) == GlobalStorage.method_680()) {
            ScreenDrawer.method_370(var1, GlobalStorage.method_680(), super.field_385 - var2, super.field_386 - var3, 0);
            return;
         }

         if(this.field_409 >= 0) {
            if(var4 == 0) {
               ScreenDrawer.method_374(var1, this.field_406, this.method_462() * this.field_409, 0, this.method_462(), this.field_408, 0, super.field_385 - var2, super.field_386 - var3, super.field_390);
            } else {
               ScreenDrawer.method_374(var1, this.field_406, this.method_462() * this.field_409, 0, this.method_462(), this.field_408, 0, super.field_385 - var2, super.field_386 - var3, var4);
            }
         } else if(var4 == 0) {
            ScreenDrawer.method_371(var1, this.field_406, super.field_385 - var2, super.field_386 - var3, super.field_390);
         } else {
            ScreenDrawer.method_371(var1, this.field_406, super.field_385 - var2, super.field_386 - var3, var4);
         }

         if(this.field_404 != null) {
            int var10000 = super.field_385 - var2 + this.method_462() / 2;
            class_52 var5 = this.field_404;
            var2 = (short)(-(var10000 - this.field_404.field_396.method_563(this.field_404.toString()) / 2));
            var10000 = super.field_386 - var3 + (short)this.field_408 / 2;
            var5 = this.field_404;
            var3 = (short)(-(var10000 - this.field_404.field_396.field_500 / 2));
            this.field_404.method_464(var1, var2, var3, (byte)0);
         }
      }

   }

   public final String toString() {
      return "<" + this.field_405 + ">";
   }
}

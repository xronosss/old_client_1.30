package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_50;
import mobak.c.class_62;

// $FF: renamed from: mobak.b.b.a.w
public final class class_52 extends class_50 {

   // $FF: renamed from: a java.lang.String
   String field_395;
   // $FF: renamed from: a mobak.c.a
   class_62 field_396;
   // $FF: renamed from: a int
   private int field_397;
   // $FF: renamed from: b int
   private int field_398;


   // $FF: renamed from: <init> (java.lang.String, short, short, mobak.c.a, int) void
   public class_52(String var1, short var2, short var3, class_62 var4, int var5) {
      super();
      this.field_397 = -1;
      if(!var1.equals(" ")) {
         this.field_395 = var1;
      } else {
         this.field_395 = "";
      }

      super.field_385 = 0;
      this.method_468(0);
      this.field_396 = var4;
      super.field_387 = -16777216;
      super.field_388 = 0;
      this.field_398 = var5;
   }

   // $FF: renamed from: <init> (java.lang.String, short, short, mobak.c.a) void
   public class_52(String var1, short var2, short var3, class_62 var4) {
      super();
      this.field_397 = -1;
      if(!var1.equals(" ")) {
         this.field_395 = var1;
      } else {
         this.field_395 = "";
      }

      super.field_385 = 0;
      this.method_468(0);
      this.field_396 = var4;
      super.field_387 = -16777216;
      super.field_388 = 0;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public final void method_464(Graphics var1, short var2, short var3, byte var4) {
      if(var1 != null && this.field_395 != null && this.field_396 != null) {
         if(this.field_397 >= 0) {
            ScreenDrawer.method_384(var1, this.field_397);
            var1.fillRect(super.field_385 - var2, super.field_386 - var3, this.method_462(), this.method_463());
         }

         if(!this.field_395.equals("")) {
            if(var4 == 0) {
               this.field_396.method_564(var1, this.field_395, super.field_385 - var2, super.field_386 - var3, super.field_390);
            } else {
               this.field_396.method_564(var1, this.field_395, super.field_385 - var2, super.field_386 - var3, var4);
            }

            if(super.field_387 != -16777216) {
               int var6 = ScreenDrawer.method_385(var1);
               ScreenDrawer.method_384(var1, super.field_387);

               for(byte var5 = 1; var5 <= super.field_388; ++var5) {
                  var1.drawRect(super.field_385 - var2 - var5, super.field_386 - var3 - var5, this.field_396.method_563(this.field_395.trim()) + 2 * var5, this.field_396.field_500 + 2 * var5);
               }

               ScreenDrawer.method_384(var1, var6);
            }

         }
      }
   }

   // $FF: renamed from: b () short
   public final short method_462() {
      return this.field_396 != null && this.field_395 != null?(short)this.field_396.method_563(this.field_395):0;
   }

   // $FF: renamed from: a () short
   public final short method_463() {
      return this.field_396 != null && this.field_395 != null?(short)this.field_396.field_500:0;
   }

   public final String toString() {
      return this.field_395;
   }

   // $FF: renamed from: a (mobak.c.a) boolean
   public final boolean method_470(class_62 var1) {
      return var1 == this.field_396;
   }

   // $FF: renamed from: c () int
   public final int method_471() {
      return this.field_398;
   }

   // $FF: renamed from: d (int) void
   public final void method_472(int var1) {
      this.field_397 = var1;
   }
}

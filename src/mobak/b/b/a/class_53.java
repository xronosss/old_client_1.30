package mobak.b.b.a;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_50;
import mobak.text.class_62;

// $FF: renamed from: mobak.b.b.a.s
public final class class_53 extends class_50 {

   // $FF: renamed from: a int
   public int field_399;
   // $FF: renamed from: a java.util.Vector
   private Vector field_400;
   // $FF: renamed from: c short
   public short field_401;
   // $FF: renamed from: d short
   public short field_402;
   // $FF: renamed from: b int
   private int field_403;


   // $FF: renamed from: <init> (short, short) void
   public class_53(short var1, short var2) {
      super();
      this.field_399 = 0;
      this.field_403 = -1;
      this.field_400 = new Vector();
      super.field_385 = var1;
      this.method_468(var2);
      this.field_401 = 0;
      this.field_402 = 0;
   }

   // $FF: renamed from: a (mobak.b.b.r) short
   public final short method_477(class_50 var1) {
      var1.method_467(this.field_401);
      this.field_401 += var1.method_462();
      this.field_400.addElement(var1);
      if(var1.method_463() > this.field_402) {
         this.field_402 = var1.method_463();
      }

      this.method_478();
      return this.field_401;
   }

   // $FF: renamed from: a () void
   public void method_478() {
      int var1;
      class_50 var2;
      if(this.field_399 == 0) {
         for(var1 = 0; var1 < this.field_400.size(); ++var1) {
            (var2 = (class_50)this.field_400.elementAt(var1)).method_468(this.field_402 - var2.method_463());
         }

      } else if(this.field_399 == 1) {
         for(var1 = 0; var1 < this.field_400.size(); ++var1) {
            (var2 = (class_50)this.field_400.elementAt(var1)).method_468(this.field_402 / 2 - var2.method_463() / 2);
         }

      } else {
         if(this.field_399 == 2) {
            for(var1 = 0; var1 < this.field_400.size(); ++var1) {
               ((class_50)this.field_400.elementAt(var1)).method_468(0);
            }
         }

      }
   }

   // $FF: renamed from: b () short
   public final short method_462() {
      return this.field_401;
   }

   // $FF: renamed from: a () short
   public final short method_463() {
      return this.field_402;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public final void method_464(Graphics var1, short var2, short var3, byte var4) {
      if(var1 != null) {
         if(this.field_403 >= 0) {
            ScreenDrawer.method_384(var1, this.field_403);
            var1.fillRect(super.field_385 - var2, super.field_386 - var3, this.field_401, this.field_402);
         }

         var2 = (short)(-super.field_385 + var2);
         if((var4 & 1) > 0) {
            var2 = (short)(var2 + this.field_401 / 2);
         } else if((var4 & 8) > 0) {
            var2 += this.field_401;
         }

         var3 = (short)(-super.field_386 + var3);

         int var7;
         for(var7 = 0; var7 < this.field_400.size(); ++var7) {
            ((class_50)this.field_400.elementAt(var7)).method_464(var1, var2, var3, (byte)0);
         }

         if(super.field_387 != -16777216) {
            var7 = ScreenDrawer.method_385(var1);
            ScreenDrawer.method_384(var1, super.field_387);

            for(byte var6 = 1; var6 <= super.field_388; ++var6) {
               var1.drawRect(super.field_385 - var6, super.field_386 - var6, this.field_401 + 2 * var6, this.field_402 + 2 * var6);
            }

            ScreenDrawer.method_384(var1, var7);
         }
      }

   }

   // $FF: renamed from: d (int) void
   public final void method_472(int var1) {
      for(int var2 = 0; var2 < this.field_400.size(); ++var2) {
         ((class_50)this.field_400.elementAt(var2)).method_472(var1);
      }

   }

   // $FF: renamed from: c () int
   public final int method_471() {
      for(byte var1 = 0; var1 < this.field_400.size(); ++var1) {
         if(((class_50)this.field_400.elementAt(var1)).method_471() != 0) {
            return ((class_50)this.field_400.elementAt(var1)).method_471();
         }
      }

      return 0;
   }

   // $FF: renamed from: a (mobak.c.a) boolean
   public final boolean method_470(class_62 var1) {
      for(int var2 = 0; var2 < this.field_400.size(); ++var2) {
         if(((class_50)this.field_400.elementAt(var2)).method_470(var1)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: b (int, int) void
   public final void method_469(int var1, int var2) {
      super.field_387 = var1;
      super.field_388 = var2;
   }

   // $FF: renamed from: a (int) mobak.b.b.r
   public final class_50 method_479(int var1) {
      return (class_50)this.field_400.elementAt(var1);
   }

   public final String toString() {
      String var1 = "";

      for(int var2 = 0; var2 < this.field_400.size(); ++var2) {
         int var3 = ((class_50)this.field_400.elementAt(var2)).method_471();
         var1 = var1 + "\'" + ((class_50)this.field_400.elementAt(var2)).toString() + "\' id=" + var3;
      }

      return var1 + "\' bgR=" + super.field_391 + " bgC=" + super.field_392 + " bgEnd=" + super.field_393;
   }
}

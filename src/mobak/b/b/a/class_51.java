package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.b.a.Thing;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_50;

// $FF: renamed from: mobak.b.b.a.k
public final class class_51 extends class_50 {

   // $FF: renamed from: c short
   private short field_394;


   // $FF: renamed from: <init> (short, short, short) void
   public class_51(short var1, short var2, short var3) {
      super();
      this.field_394 = var1;
      super.field_385 = var2;
      this.method_468(var3);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public final void method_464(Graphics var1, short var2, short var3, byte var4) {
      short var7 = (short) ScreenDrawer.method_388(var1);
      short var5 = (short) ScreenDrawer.method_386(var1);
      ScreenDrawer.method_369(var1, (short)(super.field_385 - var2), ScreenDrawer.method_387(var1), 62, ScreenDrawer.method_389(var1));
      if(super.field_390 == 1) {
         ViewHelp.method_271(var1, (short)(super.field_385 - var2), (short)(super.field_386 - var3));
      } else {
         ViewHelp.method_270(var1, (short)(super.field_385 - var2), (short)(super.field_386 - var3));
      }

      Thing.method_770(this.field_394, var1, (short)(super.field_385 - var2), (short)(super.field_386 - var3));
      ScreenDrawer.method_369(var1, var5, ScreenDrawer.method_387(var1), var7, ScreenDrawer.method_389(var1));
   }

   // $FF: renamed from: a () short
   public final short method_463() {
      return (short)61;
   }

   // $FF: renamed from: b () short
   public final short method_462() {
      return (short)62;
   }

   public final String toString() {
      return "<help_image>";
   }
}

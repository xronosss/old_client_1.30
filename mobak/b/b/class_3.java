package mobak.b.b;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// $FF: renamed from: mobak.b.b.d
public final class class_3 extends class_2 {

   // $FF: renamed from: a javax.microedition.lcdui.Image
   private Image field_1;
   // $FF: renamed from: a short
   private short field_2;
   // $FF: renamed from: b short
   private short field_3;
   // $FF: renamed from: c short
   private short field_4;
   // $FF: renamed from: d short
   private short field_5;
   // $FF: renamed from: e short
   private short field_6;


   // $FF: renamed from: <init> (mobak.b.b.a, javax.microedition.lcdui.Image, short, short) void
   public class_3(BattleScreen var1, Image var2, short var3, short var4) {
      super(var1);
      this.field_4 = 0;
      this.field_1 = var2;
      this.field_2 = (short) ScreenDrawer.method_383(var2);
      this.field_3 = (short)(ScreenDrawer.method_382(this.field_1) / this.field_2);
      this.field_5 = var3;
      this.field_6 = var4;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   final void method_6(Graphics var1) {
      if(this.field_4 < this.field_3) {
         ScreenDrawer.method_372(var1, this.field_1, this.field_2 * this.field_4, 0, this.field_2, ScreenDrawer.method_383(this.field_1), 0, this.field_5 + (51 - this.field_2) / 2, this.field_6, 0);
      }

      ++this.field_4;
   }

   // $FF: renamed from: a () boolean
   final boolean method_7() {
      return this.field_1 != null && this.field_4 < this.field_3?false:super.method_7();
   }

   // $FF: renamed from: a () void
   final void method_8() {}
}

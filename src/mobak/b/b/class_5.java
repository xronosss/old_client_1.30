package mobak.b.b;

import javax.microedition.lcdui.Graphics;
import mobak.b.a.Unit;

// $FF: renamed from: mobak.b.b.f
public final class class_5 extends class_2 {

   // $FF: renamed from: a byte[]
   private byte[] field_10;
   // $FF: renamed from: a byte
   private byte field_11;
   // $FF: renamed from: b byte
   private byte field_12;
   // $FF: renamed from: a mobak.b.b.a
   private final BattleScreen field_13;


   // $FF: renamed from: <init> (mobak.b.b.a, byte[], byte) void
   public class_5(BattleScreen var1, byte[] var2, byte var3) {
      super(var1);
      this.field_13 = var1;
      this.field_10 = null;
      this.field_11 = 0;
      this.field_12 = -1;
      this.field_10 = var2;
      this.field_12 = BattleScreen.method_310(var1, var3);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   final void method_6(Graphics var1) {
      if(BattleScreen.method_311(this.field_13, this.field_12)) {
         Unit var2;
         if((var2 = this.field_13.method_301(this.field_12)) != null) {
            if(this.field_11 == 0) {
               BattleScreen.method_312(this.field_13)[var2.method_797()][var2.method_798()] &= -128;
            }

            short var3 = BattleScreen.method_313(this.field_13, var2.method_797());
            short var4 = (short)(BattleScreen.method_314(this.field_13, var2.method_798()) - 45);
            if(var2.method_835() >= 2) {
               var2.method_809(BattleScreen.method_286(this.field_10[this.field_11]));
               var2.method_808(BattleScreen.method_287(this.field_10[this.field_11]));
               var3 = BattleScreen.method_313(this.field_13, var2.method_797());
               var4 = (short)(BattleScreen.method_314(this.field_13, var2.method_798()) - 45);
               var2.method_830(3);
               ++this.field_11;
               if(this.field_11 >= this.field_10.length) {
                  this.field_10 = null;
                  this.field_11 = 0;
                  BattleScreen.method_312(this.field_13)[var2.method_797()][var2.method_798()] = (byte)(BattleScreen.method_312(this.field_13)[var2.method_797()][var2.method_798()] & -128 | this.field_12);
                  this.field_12 = -1;
               }

               var2.method_836(0);
            } else {
               var2.method_836(var2.method_835() + 1);
            }

            var2.method_758(var1, var3, var4, (short)-126);
         }
      }
   }

   // $FF: renamed from: a () boolean
   final boolean method_7() {
      return this.field_10 != null && BattleScreen.method_311(this.field_13, this.field_12) && this.field_11 < this.field_10.length?false:super.method_7();
   }

   // $FF: renamed from: a () void
   final void method_8() {
      this.field_10 = null;
   }
}

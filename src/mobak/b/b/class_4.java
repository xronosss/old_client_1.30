package mobak.b.b;

import javax.microedition.lcdui.Graphics;
import mobak.a.SocketListener;
import mobak.b.a.Unit;

// $FF: renamed from: mobak.b.b.e
public final class class_4 extends class_2 {

   // $FF: renamed from: a byte
   private byte field_7;
   // $FF: renamed from: a int
   private int field_8;
   // $FF: renamed from: a mobak.b.b.a
   private final BattleScreen field_9;


   // $FF: renamed from: <init> (mobak.b.b.a, byte, int, byte) void
   public class_4(BattleScreen var1, byte var2, int var3, byte var4) {
      super(var1);
      this.field_9 = var1;
      this.field_7 = var2;
      this.field_8 = var3;
      if(BattleScreen.method_311(var1, this.field_7)) {
         ;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   final void method_6(Graphics var1){
      if(BattleScreen.method_311(this.field_9, this.field_7)) {
         Unit var4;
         if((var4 = this.field_9.method_301(this.field_7)) != null) {
            if(var4.method_828() == 0) {
               try {
                  var4.method_826(this.field_8);
               } catch (Exception var3) {
                  SocketListener.method_522("unitAttackAnimate: " + var3, false);
               }
            }

            var4.method_827((byte)(var4.method_828() + 1));
            if(var4.method_828() > 15) {
               var4.method_827((byte)-1);
               var4.method_832(this.field_8);
               if(var4.getQuantity() <= 0) {
                  BattleScreen.method_315(this.field_9, this.field_7, (Unit)null);
                  BattleScreen.method_316(this.field_9, this.field_7);
               }

               this.field_7 = -1;
               return;
            }
         } else {
            this.field_7 = -1;
         }

      }
   }

   // $FF: renamed from: a () boolean
   final boolean method_7() {
      return this.field_7 < 0?super.method_7():false;
   }

   // $FF: renamed from: a () void
   final void method_8() {}
}

package mobak.b.b;

import javax.microedition.lcdui.Graphics;

// $FF: renamed from: mobak.b.b.c
public abstract class class_2 {

   // $FF: renamed from: a byte
   private byte field_0;


   // $FF: renamed from: <init> (mobak.b.b.a) void
   public class_2(BattleScreen var1) {
      super();
      this.field_0 = 0;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   abstract void method_6(Graphics var1);

   // $FF: renamed from: a () boolean
   boolean method_7() {
      if(this.field_0 > 0) {
         return true;
      } else {
         ++this.field_0;
         return false;
      }
   }

   // $FF: renamed from: a () void
   abstract void method_8();
}

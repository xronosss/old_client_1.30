package mobak.b.b;

import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.k
final class class_27 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.j
   private final Screen field_23;


   // $FF: renamed from: <init> (mobak.b.b.j) void
   class_27(Screen var1) {
      super();
      this.field_23 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      this.field_23.method_68();
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      Screen.method_79(this.field_23);
      return true;
   }
}

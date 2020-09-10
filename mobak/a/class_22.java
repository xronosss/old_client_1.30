package mobak.a;

import mobak.Main2;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.a.c
final class class_22 extends NotifyLabel {

   // $FF: renamed from: <init> (mobak.a.b) void
   class_22(class_57 var1) {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      Main2.self.exit();
      return true;
   }
}

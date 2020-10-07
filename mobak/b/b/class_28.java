package mobak.b.b;

import mobak.Main2;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.b.b.l
final class class_28 extends NotifyLabel {

   // $FF: renamed from: <init> (mobak.b.b.j) void
   class_28(Screen var1) {
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

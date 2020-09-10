package mobak.a.a;

import mobak.Main2;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.a.a.f
final class class_9 extends NotifyLabel {

   // $FF: renamed from: <init> () void
   class_9() {
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

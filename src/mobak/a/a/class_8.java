package mobak.a.a;

import mobak.Main2;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.a.a.g
final class class_8 extends NotifyLabel {

   // $FF: renamed from: <init> () void
   class_8() {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      Main2.self.method_843((byte)0);
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      Main2 var10000 = Main2.self;
      Main2.gotoUrl1(Main2.self.method_850());
      Main2.self.exit();
      return true;
   }
}

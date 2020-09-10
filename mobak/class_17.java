package mobak;

import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.e
final class class_17 extends NotifyLabel {

   // $FF: renamed from: <init> (mobak.Main2) void
   class_17(Main2 var1) {
      super();
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
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

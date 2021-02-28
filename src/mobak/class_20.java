package mobak;

import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.h
final class class_20 extends NotifyLabel {

   // $FF: renamed from: <init> (mobak.g) void
   class_20(Connection var1) {
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

package mobak.a.a;

import mobak.Main2;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.a.a.i
final class ErrorUserDataNotifyLabel extends NotifyLabel {

   // $FF: renamed from: <init> () void
   ErrorUserDataNotifyLabel() {
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

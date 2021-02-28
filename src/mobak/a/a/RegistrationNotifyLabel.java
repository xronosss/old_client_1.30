package mobak.a.a;

import mobak.Main2;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.a.a.h
final class RegistrationNotifyLabel extends NotifyLabel {

   // $FF: renamed from: <init> () void
   RegistrationNotifyLabel() {
      super();
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      Main2.self.changeForm((byte)7);
      return true;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }
}

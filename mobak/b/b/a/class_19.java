package mobak.b.b.a;

import mobak.a.SocketListener;
import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.b
final class class_19 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.a
   private final class_40 field_17;


   // $FF: renamed from: <init> (mobak.b.b.a.a) void
   class_19(class_40 var1) {
      super();
      this.field_17 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      try {
         class_40.method_266(this.field_17);
      } catch (Exception var2) {
         SocketListener.logMessage("dismiss: " + var2.getMessage());
      }

      return true;
   }
}

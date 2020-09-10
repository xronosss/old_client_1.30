package mobak.a.a;

import mobak.c.NotifyLabel;

// $FF: renamed from: mobak.a.a.k
final class class_13 extends NotifyLabel {

   // $FF: renamed from: a boolean
   private final boolean field_14;


   // $FF: renamed from: <init> (boolean) void
   class_13(boolean var1) {
      super();
      this.field_14 = var1;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      if(!this.field_14 && MessageProcessor.method_1057() != null) {
         MessageProcessor.method_1057().setCurrentFormAsMain();
      }

      return true;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }
}

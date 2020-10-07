package mobak.b.b.a;

import java.util.Vector;
import mobak.b.a.Thing;
import mobak.text.NotifyLabel;

// $FF: renamed from: mobak.b.b.a.aa
final class class_26 extends NotifyLabel {

   // $FF: renamed from: a mobak.b.b.a.y
   private final class_37 field_22;


   // $FF: renamed from: <init> (mobak.b.b.a.y) void
   class_26(class_37 var1) {
      super();
      this.field_22 = var1;
   }

   // $FF: renamed from: a () boolean
   public final boolean RightClick() {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean LeftClick() {
      if(class_37.method_237(this.field_22) == null) {
         class_37.method_238(this.field_22, new Vector());
      }

      Thing var1 = class_37.method_241(this.field_22, class_37.method_239(this.field_22), class_37.method_240(this.field_22));
      class_37.method_237(this.field_22).addElement(var1);
      var1.method_773(false);
      if(class_37.method_242(this.field_22, class_37.method_239(this.field_22), false) == 0) {
         byte var2 = class_37.method_239(this.field_22);
         class_37.method_243(this.field_22, true);
         class_37.method_244(this.field_22)[var2] = -1;
      } else {
         this.field_22.method_224(class_37.method_240(this.field_22) == class_37.method_244(this.field_22)[class_37.method_239(this.field_22)]);
      }

      return true;
   }
}

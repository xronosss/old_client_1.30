package mobak.b.b;

import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.n
final class class_45 implements Runnable {

   // $FF: renamed from: a mobak.b.b.m
   private final ScreenDrawer field_285;


   // $FF: renamed from: <init> (mobak.b.b.m) void
   class_45(ScreenDrawer var1) {
      super();
      this.field_285 = var1;
   }

   public final void run() {
      try {
         Thread.sleep(3000L);
         if(ScreenDrawer.method_399(this.field_285)) {
            ScreenDrawer.method_400();
            ScreenDrawer.method_330(MessagesContainer.getMessage(139), MessagesContainer.getMessage(143));
            ScreenDrawer.method_401(this.field_285, false);
         }

      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }
   }
}

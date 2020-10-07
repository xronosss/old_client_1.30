package mobak.a.a;

import mobak.Main2;
import mobak.UserData;
import mobak.a.SocketListener;
import mobak.b.b.ScreenDrawer;
import mobak.text.class_1;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.a.a.j
final class class_86 implements class_1 {

   // $FF: renamed from: <init> () void
   class_86() {
      super();
   }

   // $FF: renamed from: b (int) void
   public final void method_4(int var1) {}

   // $FF: renamed from: d () void
   public final void method_3() {}

   // $FF: renamed from: a (int) void
   public final void onButtonClick(int var1) {
      if(var1 == 0) {
         try {
            String var6;
            String var2 = var6 = MessageProcessor.method_1057().method_443(0);
            String var3 = MessageProcessor.method_1057().method_443(1);
            String var4 = MessageProcessor.method_1057().method_443(2);
            if(var3.trim().length() == 0) {
               var3 = Main2.self.rmsManager.getString((byte)17, (String)null);
            }

            if(var6 == null || var6.trim().equals("") || var4 == null || var4.trim().equals("") || var2 == null || var2.trim().equals("")) {
               MessageProcessor.method_1057().method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(290), 4);
               return;
            }

            if((var3 = Main2.checkLogin(var3)) == null) {
               MessageProcessor.method_1057().method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(30), 4);
               return;
            }

            Main2 var10000 = Main2.self;
            if(Main2.method_858(var3)) {
               MessageProcessor.method_1057().method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(292), 4);
               return;
            }

            if(!Main2.method_857(var4)) {
               MessageProcessor.method_1057().method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(293), 4);
               return;
            }

            UserData var8 = new UserData(var6, var3, var4, var2, (byte)5);
            MessageProcessor.method_1058(var8);
            OutputGameMessage var9 = new OutputGameMessage(MessageProcessor.packetTypes[114], (short)16, MessageProcessor.packetTypes[114], false);
            OutputGameMessage var7 = var9;
            var9.addToBody(MessageProcessor.method_1059().login);
            var7.addToBody(MessageProcessor.method_1059().userName);
            var7.addToBody(MessageProcessor.method_1059().heroName);
            var7.addToBody(MessageProcessor.method_1059().password);
            SocketListener.self.sendCommand(var7);
         } catch (Exception var5) {
            SocketListener.logMessage("onButtonClick REGISTRATION_SCREEN: " + var5.toString());
         }
      }

      ScreenDrawer.self.method_376();
   }
}

package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.Main2;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Thing;
import mobak.b.a.class_76;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.p
public final class class_41 extends View {

   // $FF: renamed from: a mobak.b.a.c[]
   private class_76[] field_241;
   // $FF: renamed from: a mobak.b.b.a.v
   private Button field_242;
   // $FF: renamed from: g boolean
   private boolean field_243;


   // $FF: renamed from: <init> (mobak.b.a.c[]) void
   public class_41(class_76[] var1) {
      super((short)-9);
      this.field_243 = false;
      this.method_268();
      this.field_241 = var1;
      super.field_225 = this.method_144(true);
      super.field_228 = 0;
      super.field_229 = 0;
      PopupMenu var10001 = new PopupMenu(new byte[]{(byte)51, (byte)81, (byte)59, (byte)89}, new byte[]{(byte)55}, (byte[][])null);
      super.popupMenu = var10001;
      super.popupMenu.method_597((short)248, (byte)81);
      this.method_51();
   }

   // $FF: renamed from: <init> () void
   public class_41() {
      super((short)-13);
      this.field_243 = false;
      this.method_268();
      super.field_225 = this.method_144(true);
      this.field_241 = new class_76[6];
      class_76[] var10000 = this.field_241;
      class_76 var10002 = new class_76((short)(Hero.self.getRace() - 1), (byte)0, (byte)0, (byte)0, "", 0);
      var10000[0] = var10002;
      var10000 = this.field_241;
      var10002 = new class_76((short)(Hero.self.getRace() + 4), (byte)0, (byte)0, (byte)0, "", 0);
      var10000[1] = var10002;
      var10000 = this.field_241;
      var10002 = new class_76((short)10, (byte)0, (byte)0, (byte)0, "", 0);
      var10000[2] = var10002;
      var10000 = this.field_241;
      var10002 = new class_76((short)11, (byte)0, (byte)0, (byte)0, "", 0);
      var10000[3] = var10002;
      var10000 = this.field_241;
      var10002 = new class_76((short)12, (byte)0, (byte)0, (byte)0, "", 0);
      var10000[4] = var10002;
      var10000 = this.field_241;
      var10002 = new class_76((short)(12 + Hero.self.getRace()), (byte)0, (byte)0, (byte)0, "", 0);
      var10000[5] = var10002;
      PopupMenu var10001 = new PopupMenu();
      super.popupMenu = var10001;
      Button var3 = new Button((byte)55);
      Button var1 = var3;
      super.popupMenu.method_594(false, var1);
      Button var2 = new Button((byte)58);
      this.field_242 = var2;
      this.field_242.method_656((short)7);
      this.field_242.method_654(MessagesContainer.getLine(257));
      super.popupMenu.method_594(true, this.field_242);
      this.field_243 = true;
      super.field_53.method_489(MessagesContainer.getLine(258), Screen.field_26, (byte)0, false, -1);
   }

   // $FF: renamed from: e () boolean
   protected final boolean method_254() {
      ScreenDrawer.self.method_346();
      return true;
   }

   // $FF: renamed from: b () void
   private void method_268() {
      this.method_57((short)81, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 32 - 61), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583() - 40), true);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void drawScreen(Graphics var1) {
      if(super.field_53.method_496() && !this.field_243) {
         this.method_269();
      }

      super.method_259(var1);
   }

   // $FF: renamed from: a (byte) mobak.b.a.a[]
   protected final Thing[] method_250(byte var1) {
      return this.field_241;
   }

   // $FF: renamed from: b (boolean) void
   protected final void method_249(boolean var1) {
      short var2 = (short)super.field_228;
      super.method_249(var1);
      if(var2 != super.field_228) {
         this.method_269();
      }

   }

   // $FF: renamed from: c () void
   private void method_269() {
      if(!this.field_243) {
         this.method_56();
         Thing var1;
         if((var1 = this.method_256()) != null) {
            this.method_247(var1, super.field_227[super.field_229]);
         }
      }

   }

   // $FF: renamed from: f () boolean
   protected final boolean method_257() {
      Thing var1;
      if((var1 = this.method_256()) == null) {
         return false;
      } else {
         try {
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[62], (short)0, (short)0);
            OutputGameMessage var2 = var10000;
            var10000.addToBody((byte)4);
            var2.addToBody(var1.getId());
            SocketListener.self.sendCommand(var2);
         } catch (Exception var3) {
            SocketListener.logMessage("invintation fixObject: " + var3.getMessage());
         }

         ScreenDrawer.self.method_346();
         boolean var4 = true;
         return true;
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      if(!this.field_243) {
         super.popupMenu.method_617(true, false);
         if(super.field_228 < 0 || super.field_229 < 0) {
            return;
         }

         if(this.method_256() == null) {
            return;
         }

         class_76 var1 = (class_76)this.method_256();
         super.popupMenu.method_620(var1.method_778(), false);
      }

   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      int var2 = button.field_543;
      class_76 var3;
      switch((byte) button.field_543) {
      case 58:
         IconSelectionNotifyLabel var10000 = new IconSelectionNotifyLabel(this);
         IconSelectionNotifyLabel var4 = var10000;
         Button var5 = this.field_242;
         ScreenDrawer.method_334("", this.field_242.field_546, "", var4);
         return true;
      case 59:
         if(this.method_256() == null) {
            return false;
         }

         var3 = (class_76)this.method_256();
         Main2.self.field_664 = var3.getId();
         Main2.self.changeForm((byte)6);
         return true;
      case 89:
         if(this.method_256() == null) {
            return false;
         } else {
            if(ScreenDrawer.self.strategicScreen == null) {
               return false;
            }

            var3 = (class_76)this.method_256();
            ScreenDrawer.self.strategicScreen.method_83(var3.method_776(), var3.method_777(), true);
            ScreenDrawer.self.setScreenId((byte)2);
            return true;
         }
      default:
         return super.method_38(button);
      }
   }

   // $FF: renamed from: a () mobak.b.a.a
   protected final Thing method_256() {
      return this.field_243?null:super.method_256();
   }
}

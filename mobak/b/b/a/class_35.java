package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.FormCreator;
import mobak.b.b.class_55;
import mobak.c.class_1;
import mobak.c.class_62;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.d
public final class class_35 extends MenuScreen implements class_1 {

   // $FF: renamed from: c byte
   private byte field_163;
   // $FF: renamed from: a java.lang.String[]
   private String[] field_164;
   // $FF: renamed from: a int[]
   private int[] field_165;
   // $FF: renamed from: j mobak.c.a
   private class_62 field_166;
   // $FF: renamed from: d byte
   private byte field_167;
   // $FF: renamed from: e int
   private int field_168;
   // $FF: renamed from: b java.lang.String[]
   private String[] field_169;
   // $FF: renamed from: b mobak.b.b.q
   private class_55 field_170;
   // $FF: renamed from: b int[]
   private int[] field_171;
   // $FF: renamed from: e byte
   private byte field_172;
   // $FF: renamed from: d java.lang.String
   private String field_173;
   // $FF: renamed from: g int
   private int field_174;
   // $FF: renamed from: c java.lang.String[]
   private String[] field_175;
   // $FF: renamed from: d java.lang.String[]
   private String[] field_176;
   // $FF: renamed from: a boolean
   private boolean field_177;
   // $FF: renamed from: d boolean
   private boolean field_178;
   // $FF: renamed from: a mobak.b.b.a.v
   private Button field_179;
   // $FF: renamed from: b mobak.b.b.a.v
   private Button field_180;
   // $FF: renamed from: c mobak.b.b.a.v
   private Button field_181;
   // $FF: renamed from: h int
   private int field_182;
   // $FF: renamed from: a mobak.b.b.a.d
   private static class_35 field_183;


   // $FF: renamed from: a () mobak.b.b.a.d
   public static final class_35 method_173() {
      if(field_183 == null) {
         Hero.self.field_702 = true;
         class_35 var10000 = new class_35();
         field_183 = var10000;
         ScreenDrawer.self.method_340(field_183, true);
         OutputGameMessage var1 = new OutputGameMessage(MessageProcessor.packetTypes[60], (short)0, MessageProcessor.packetTypes[61]);
         OutputGameMessage var0 = var1;
         SocketListener.self.sendCommand(var0);
      }

      return field_183;
   }

   // $FF: renamed from: <init> () void
   private class_35() {
      super();
      this.field_178 = false;
      super.field_52 = -107;
      this.field_173 = MessagesContainer.getMessage(81);
      super.field_116 = MessagesContainer.getMessage(154);
      this.field_164 = null;
      this.field_165 = null;
      this.field_166 = Screen.field_30;
      PopupMenu var10001 = new PopupMenu(new byte[]{(byte)51, (byte)81, (byte)96, (byte)58, (byte)98, (byte)79}, new byte[]{(byte)52, (byte)55, (byte)97}, (byte[][])null);
      super.popupMenu = var10001;
      super.popupMenu.method_597((short)208, (byte)98);
      super.popupMenu.method_597((short)169, (byte)97);
      super.popupMenu.method_597((short)34, (byte)55);
      super.popupMenu.method_597((short)237, (byte)79);
      super.popupMenu.method_600((byte)98, true);
      class_55 var3 = new class_55((short)10, (short)(this.method_136() + 8), (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.method_136() - 12 - PopupMenu.method_583()), false, false);
      this.field_170 = var3;
      super.popupMenu.method_597((short)152, (byte)96);
      super.popupMenu.method_597((short)153, (byte)58);
      super.popupMenu.method_600((byte)51, true);
      super.popupMenu.method_600((byte)96, true);
      super.popupMenu.method_600((byte)58, true);
      super.popupMenu.method_600((byte)79, true);
      Button var4 = new Button((byte)71);
      this.field_179 = var4;
      this.field_179.method_648(false);
      this.field_179.method_656((short)241);
      super.popupMenu.method_594(true, this.field_179);
      var4 = new Button((byte)30);
      this.field_180 = var4;
      this.field_180.method_648(false);
      this.field_180.method_656((short)267);
      this.field_180.method_659(true);
      short var2 = MessageProcessor.packetTypes[88];
      Button var1 = this.field_180;
      this.field_180.field_544 = var2;
      super.popupMenu.method_594(true, this.field_180);
      var4 = new Button((byte)30);
      this.field_181 = var4;
      this.field_181.method_648(false);
      this.field_181.method_656((short)252);
      this.field_181.method_659(true);
      var2 = MessageProcessor.packetTypes[89];
      var1 = this.field_181;
      this.field_181.field_544 = var2;
      super.popupMenu.method_594(true, this.field_181);
   }

   // $FF: renamed from: a (java.lang.String[], int[]) void
   public final void method_175(String[] var1, int[] var2) {
      this.method_186();
      this.field_164 = var1;
      this.field_165 = var2;
      this.field_163 = 1;
   }

   // $FF: renamed from: b (int, int) void
   public final void method_176(int var1, int var2) {
      if(var1 < 0 && var2 < 0) {
         this.field_178 = true;
      } else {
         this.field_178 = false;
         this.method_186();
         this.field_163 = 2;
         super.field_116 = this.field_164[this.field_172];
         if(this.field_165[this.field_172] != -1) {
            this.field_169 = new String[]{MessagesContainer.getMessage(80) + "(" + var1 + ")", MessagesContainer.getMessage(160) + "(" + var2 + ")"};
         } else {
            this.field_169 = new String[]{MessagesContainer.getMessage(66) + "(" + var1 + ")", MessagesContainer.getMessage(67) + "(" + var2 + ")"};
         }
      }
   }

   // $FF: renamed from: a (java.lang.String[], java.lang.String[], int[], int[], boolean, boolean) void
   public final void method_177(String[] var1, String[] var2, int[] var3, int[] var4, boolean var5, boolean var6) {
      this.method_186();
      this.field_171 = var3;
      this.field_170.method_495();
      this.method_191(var1, var2, var4);
      this.field_173 = this.field_164[this.field_172];
      super.field_116 = MessagesContainer.getMessage(160);
      this.field_163 = 4;
      super.popupMenu.method_597((short)156, (byte)81);
      if(var5) {
         super.popupMenu.method_600((byte)96, false);
      } else {
         super.popupMenu.method_600((byte)96, true);
      }

      if(var6) {
         super.popupMenu.method_600((byte)58, false);
      } else {
         super.popupMenu.method_600((byte)58, true);
      }

      super.popupMenu.method_600((byte)79, false);
      this.field_180.method_648(true);
      this.field_181.method_648(true);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      super.method_30(var1);
      synchronized(this) {
         switch(this.field_163) {
         case 1:
            if(this.field_164 != null) {
               this.method_139(var1, this.method_178(), this.field_164, this.field_167, this.field_166);
            }
            break;
         case 2:
            if(this.field_169 != null) {
               this.method_139(var1, this.method_178(), this.field_169, this.field_167, this.field_166);
            }
            break;
         case 3:
         case 4:
            this.field_170.method_484(var1, (byte)0);
         }

         super.popupMenu.method_604(var1);
         if(this.field_175 != null) {
            synchronized(this) {
               if(this.field_174 == this.field_175.length - 1) {
                  this.field_175 = this.field_176 = null;
                  this.field_174 = 0;
               } else {
                  for(short var3 = (short)this.field_174; var3 < this.field_175.length; ++var3) {
                     if(ScreenDrawer.self.method_356() >= 0) {
                        ScreenDrawer.self.method_357(this.field_176[var3], this.field_175[var3]);
                        ++this.field_174;
                     }
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: b () short
   private short method_178() {
      return (short)(this.method_136() + 10);
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      if(this.field_163 == 1) {
         super.popupMenu.method_615((byte)55);
      } else {
         super.popupMenu.method_616((byte)55);
      }

      if(this.field_163 == 4 && this.field_170.method_496()) {
         super.popupMenu.method_600((byte)81, true);
      } else {
         super.popupMenu.method_600((byte)81, false);
      }

      if(this.field_163 == 3) {
         super.popupMenu.method_600((byte)81, true);
         boolean var1 = false;
         if(this.field_165[this.field_172] == -1) {
            if(!this.field_170.method_496()) {
               if(this.field_177) {
                  super.popupMenu.method_597((short)156, (byte)81);
               } else {
                  super.popupMenu.method_597((short)157, (byte)81);
               }

               var1 = true;
            }
         } else {
            var1 = true;
            if(this.field_170.method_496()) {
               super.popupMenu.method_597((short)156, (byte)81);
            } else {
               super.popupMenu.method_597((short)157, (byte)81);
            }
         }

         if(var1) {
            super.popupMenu.method_600((byte)81, false);
         }
      }

      if(this.field_178) {
         super.popupMenu.method_600((byte)81, true);
      }

   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button var1) {
      int var2 = var1.field_543;
      OutputGameMessage var10000;
      switch((byte)var1.field_543) {
      case 30:
         if(var1.field_544 == MessageProcessor.packetTypes[89] && var1.method_658()) {
            var2 = this.method_71();
            if(Hero.self.heroId != var2) {
               var10000 = new OutputGameMessage(var1.field_544);
               OutputGameMessage var6 = var10000;
               var10000.setNextCommandType(var1.field_545);
               var6.addToBody(var2);
               SocketListener.self.sendCommand(var6);
               return true;
            }

            return false;
         }

         return super.method_38(var1);
      case 55:
         this.method_185();
         return true;
      case 58:
         if(this.field_163 == 3) {
            method_182((byte)1, (byte)0);
         } else {
            method_183((byte)1);
         }

         return true;
      case 71:
         if(this.field_170.method_493(this.field_168 + 1) != null) {
            class_16 var10 = new class_16(this);
            class_16 var9 = var10;
            ScreenDrawer.method_334("", MessagesContainer.getMessage(244), "", var9);
         }

         return true;
      case 79:
         var10000 = new OutputGameMessage(MessageProcessor.packetTypes[79], (short)0, MessageProcessor.packetTypes[79]);
         OutputGameMessage var8 = var10000;
         var10000.addToBody((byte)1);
         SocketListener.self.sendCommand(var8);
         return true;
      case 81:
         switch(this.field_163) {
         case 1:
            this.method_179();
            return true;
         case 2:
            this.method_181();
            return true;
         case 3:
         case 4:
            this.field_182 = -1;
            String var5 = null;
            if(this.field_170.method_493(this.field_168) != null) {
               var5 = this.field_170.method_493(this.field_168).toString();
               this.field_182 = this.field_170.method_493(this.field_168).method_471();
            }

            boolean var10001 = var5 != null;
            String var3 = var5;
            boolean var7 = var10001;
            FormCreator var11 = new FormCreator(MessagesContainer.getMessage(79), this);
            super.formCreator = var11;
            super.formCreator.addCommandAtIndex(MessagesContainer.getMessage(129), 0);
            super.formCreator.addCommandAtIndex(MessagesContainer.getMessage(34), 1);
            if(var7 && this.field_165[this.field_172] != -1) {
               super.formCreator.method_444(MessagesContainer.getMessage(79), 1, new String[]{MessagesContainer.getMessage(155), MessagesContainer.getMessage(159) + " (" + var3 + ")"}, new boolean[]{!var7, var7});
            }

            super.formCreator.createLabel(MessagesContainer.getMessage(79), "", 200, 0);
            super.formCreator.setCurrentFormAsMain();
            return true;
         default:
            return true;
         }
      case 96:
         if(this.field_163 == 3) {
            method_182((byte)2, (byte)0);
         } else {
            method_183((byte)2);
         }

         return true;
      case 97:
         method_184();
         return true;
      case 98:
         method_182((byte)0, (byte)0);
         return true;
      default:
         return super.method_38(var1);
      }
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      int var2;
      switch(this.field_163) {
      case 1:
      case 2:
         var2 = -1;
         switch(this.field_163) {
         case 1:
            if(this.field_164 != null) {
               var2 = this.field_164.length;
            }
            break;
         case 2:
            if(this.field_169 != null) {
               var2 = this.field_169.length;
            }
         case 3:
         case 4:
         }

         if(var2 == -1) {
            return;
         }

         if(ScreenDrawer.self.getGameAction(var1) == 6) {
            if(this.field_167 < var2 - 1) {
               ++this.field_167;
               return;
            }

            this.field_167 = 0;
            return;
         }

         if(ScreenDrawer.self.getGameAction(var1) == 1) {
            if(this.field_167 > 0) {
               --this.field_167;
               return;
            }

            this.field_167 = (byte)(var2 - 1);
            return;
         }
         break;
      case 3:
      case 4:
         var2 = -1;
         if(ScreenDrawer.self.getGameAction(var1) == 6) {
            var2 = this.field_170.method_498(this.field_168);
         } else if(ScreenDrawer.self.getGameAction(var1) == 1) {
            var2 = this.field_170.method_499(this.field_168);
         }

         if(var2 != -1) {
            try {
               this.method_192(var2);
               return;
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      }

   }

   // $FF: renamed from: e () boolean
   private boolean method_179() {
      byte var1 = this.field_167;
      if(this.field_167 >= 0 && var1 < this.field_165.length) {
         this.field_172 = this.field_167;
         this.method_180(this.field_165[var1], true);
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (int, boolean) void
   private void method_180(int var1, boolean var2) {
      try {
         OutputGameMessage var10000;
         OutputGameMessage var4;
         if(var2) {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[57], (short)4, MessageProcessor.packetTypes[57]);
            var4 = var10000;
         } else {
            var10000 = new OutputGameMessage(MessageProcessor.packetTypes[57], (short)4, (short)0);
            var4 = var10000;
         }

         var4.addToBody(var1);
         SocketListener.self.sendCommand(var4);
         this.field_170.method_495();
      } catch (Exception var3) {
         SocketListener.method_522("select room: " + var3.getMessage(), false);
      }
   }

   // $FF: renamed from: f () boolean
   private boolean method_181() {
      if(this.field_165[this.field_172] != -1) {
         if(this.field_167 == 0) {
            method_182((byte)0, (byte)0);
         } else if(this.field_167 == 1) {
            method_183((byte)0);
         }
      } else {
         this.field_177 = this.field_167 != 0;
         method_182((byte)0, (byte)(this.field_167 + 1));
      }

      return true;
   }

   // $FF: renamed from: a (byte, byte) void
   private static void method_182(byte var0, byte var1) {
      try {
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[58], (short)0, MessageProcessor.packetTypes[56]);
         OutputGameMessage var2 = var10000;
         var10000.addToBody(var0);
         if(var1 != 0) {
            var2.addToBody(var1);
         }

         SocketListener.self.sendCommand(var2);
      } catch (Exception var3) {
         SocketListener.logMessage("Chat3.sendMessageListNavigation() " + var3.getMessage());
      }
   }

   // $FF: renamed from: a (byte) void
   private static void method_183(byte var0) {
      try {
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[61], (short)0, MessageProcessor.packetTypes[61]);
         OutputGameMessage var1 = var10000;
         var10000.addToBody(var0);
         SocketListener.self.sendCommand(var1);
      } catch (Exception var2) {
         SocketListener.logMessage("MSG_LIST: " + var2.getMessage());
      }
   }

   // $FF: renamed from: b () void
   public static void method_184() {
      Hero.self.field_702 = false;
      field_183 = null;

      try {
         OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[60]);
         OutputGameMessage var0 = var10000;
         var10000.addToBody((byte)1);
         SocketListener.self.sendCommand(var0);
      } catch (Exception var1) {
         SocketListener.logMessage("closeChat " + var1.getMessage());
      }

      ScreenDrawer.self.method_346();
   }

   // $FF: renamed from: c () void
   private void method_185() {
      while(true) {
         if(this.field_163 == 3) {
            this.method_186();
         }

         switch(this.field_163) {
         case 2:
            this.field_178 = false;
            this.field_163 = 1;
            super.field_116 = MessagesContainer.getMessage(154);
            this.field_173 = MessagesContainer.getMessage(81);
            super.popupMenu.method_619((byte)81);
            this.method_180(-100, false);
            return;
         case 3:
         case 4:
            if(!this.field_178) {
               this.method_180(this.field_165[this.field_172], true);
               this.field_173 = MessagesContainer.getMessage(81);
               super.field_116 = this.field_164[this.field_172];
               super.popupMenu.method_619((byte)81);
               return;
            }

            this.field_163 = 2;
            break;
         default:
            return;
         }
      }
   }

   // $FF: renamed from: o () void
   private void method_186() {
      this.field_179.method_648(false);
      this.field_180.method_648(false);
      this.field_181.method_648(false);
      super.popupMenu.method_600((byte)51, true);
      super.popupMenu.method_600((byte)96, true);
      super.popupMenu.method_600((byte)58, true);
      super.popupMenu.method_600((byte)79, true);
      super.popupMenu.method_597((short)7, (byte)81);
      super.popupMenu.method_600((byte)98, true);
      this.field_167 = 0;
      this.field_168 = 0;
      this.field_170.method_495();
   }

   // $FF: renamed from: a (java.lang.String[], java.lang.String[], int[], int[]) void
   public final void method_187(String[] var1, String[] var2, int[] var3, int[] var4) {
      if(this.field_171 != null && this.field_171.length > 15) {
         this.method_188();
      }

      if(this.field_171 == null) {
         this.field_171 = var3;
      } else {
         int[] var5 = new int[this.field_171.length + var3.length];
         System.arraycopy(this.field_171, 0, var5, var3.length, this.field_171.length);
         System.arraycopy(var3, 0, var5, 0, var3.length);
         this.field_171 = var5;
      }

      this.method_191(var1, var2, var4);
      if(!this.field_170.method_496()) {
         this.method_192(0);
         this.field_167 = 0;
      }

   }

   // $FF: renamed from: p () void
   private void method_188() {
      this.field_171 = null;
      this.field_167 = 0;
      this.field_168 = 0;
      this.field_170.method_495();
      super.popupMenu.method_600((byte)98, true);
   }

   // $FF: renamed from: a (java.lang.String[], java.lang.String[], int[], int[], boolean, boolean, boolean) void
   public final void method_189(String[] var1, String[] var2, int[] var3, int[] var4, boolean var5, boolean var6, boolean var7) {
      this.method_186();
      this.method_188();
      super.popupMenu.method_600((byte)98, false);
      if(this.field_163 != 3) {
         this.field_173 = this.field_164[this.field_172];
         super.field_116 = MessagesContainer.getMessage(80);
         this.field_163 = 3;
         this.field_170.method_495();
      }

      this.method_187(var1, var2, var3, var4);
      if(var5 && var6) {
         super.popupMenu.method_600((byte)51, false);
         super.popupMenu.method_600((byte)96, false);
         super.popupMenu.method_600((byte)58, false);
      } else if(var6) {
         super.popupMenu.method_600((byte)51, false);
         super.popupMenu.method_600((byte)58, false);
      } else if(var5) {
         super.popupMenu.method_600((byte)51, false);
         super.popupMenu.method_600((byte)96, false);
      }

      this.field_180.method_648(true);
      this.field_181.method_648(true);
      this.field_179.method_648(var7);
   }

   // $FF: renamed from: b (java.lang.String[], java.lang.String[], int[], int[]) void
   public final synchronized void method_190(String[] var1, String[] var2, int[] var3, int[] var4) {
      if(this.field_165[this.field_172] == -1) {
         this.method_187(var1, var2, var3, var4);
      } else {
         int var5;
         if(var2.length > 5) {
            if(this.field_176 == null) {
               this.field_176 = new String[var2.length];
               this.field_175 = new String[var2.length];

               for(var5 = 0; var5 < var2.length; ++var5) {
                  if(var2[var5] != null && !var2[var5].trim().equals("")) {
                     this.field_175[var5] = var1[var5] + ": " + var2[var5];
                  }
               }

               this.field_174 = 0;
            } else {
               String[] var6 = new String[this.field_175.length + var2.length];
               System.arraycopy(this.field_175, 0, var6, 0, this.field_175.length);
               System.arraycopy(var2, 0, var6, this.field_175.length, var2.length);
               this.field_175 = var6;
               System.arraycopy(this.field_176, 0, var6, 0, this.field_176.length);
               System.arraycopy(var2, 0, var6, this.field_176.length, var2.length);
               this.field_176 = var6;
            }
         } else {
            for(var5 = 0; var5 < var2.length; ++var5) {
               ScreenDrawer.self.method_357(var1[var5], var2[var5]);
            }

         }
      }
   }

   // $FF: renamed from: a (java.lang.String[], java.lang.String[], int[]) void
   private void method_191(String[] var1, String[] var2, int[] var3) {
      if(this.field_170.method_496()) {
         this.field_170.field_429 += 10;
      }

      for(int var4 = 0; var4 < var2.length; ++var4) {
         synchronized(this) {
            this.field_170.method_490(var2[var4], Screen.field_26, true, -1);
            if(var3 != null && var3[var4] > 0 && var3[var4] < 10) {
               this.field_170.method_490(var1[var4], Screen.field_33, true, -1);
            } else {
               this.field_170.method_490(var1[var4], Screen.field_32, true, -1);
            }
         }
      }

   }

   // $FF: renamed from: a () java.lang.String
   public final String method_58() {
      return this.field_173;
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      if(Math.abs(Screen.field_36 - Screen.field_34) > 20 || Math.abs(Screen.field_37 - Screen.field_35) > 20) {
         Screen.field_38 = false;
      }

      int var6;
      if(this.field_163 == 1 || this.field_163 == 2) {
         if(super.field_86) {
            class_62 var10001 = this.field_166;
            byte var3;
            if((var3 = this.method_140(this.field_164.length, this.method_178(), var2)) >= 0 && var3 < this.field_164.length) {
               this.field_167 = var3;
               return true;
            }
         } else {
            if((var6 = this.field_164.length) > 0) {
               int var10000 = Screen.field_37 - var2;
               class_62 var4 = this.field_166;
               int var7 = var10000 / (this.field_166.field_500 + 5);
               if(ScreenDrawer.self.method_380()) {
                  var7 = (Screen.field_37 - var2) / ScreenDrawer.method_378(MenuScreen.field_101);
               }

               if(var7 != 0) {
                  int var5;
                  if((var5 = (ScreenDrawer.self.getHeight() - this.method_178() - PopupMenu.method_583()) / ScreenDrawer.method_378(MenuScreen.field_101)) < var6) {
                     super.field_118 += var7;
                  }

                  if(super.field_118 < 0) {
                     super.field_118 = 0;
                  }

                  if(var5 < var6 && super.field_118 + var5 > var6) {
                     super.field_118 = var6 - var5;
                  }

                  Screen.field_37 = var2;
               }
            }

            Screen.field_36 = var1;
         }
      }

      if(this.field_170.method_507()) {
         var6 = var2 - Screen.field_37;
         this.field_170.method_503(this.field_170.method_502() - var6);
         Screen.field_37 = var2;
      }

      return false;
   }

   // $FF: renamed from: e (int) void
   private void method_192(int var1) {
      this.field_170.method_508();
      this.field_168 = var1;
      this.field_170.method_510(this.field_168);
      short var3 = this.field_170.method_493(this.field_168).method_466();
      int var2 = this.field_170.method_493(this.field_168).method_466() + this.field_170.method_493(this.field_168).method_463();
      if(var3 - this.field_170.method_502() <= this.field_170.method_466() + 5) {
         this.field_170.method_503(this.field_170.method_493(this.field_168).method_466() - this.field_170.method_466() - 5);
      }

      if(var2 - this.field_170.method_502() >= this.field_170.method_466() + this.field_170.method_505() - 5) {
         this.field_170.method_503(var2 - this.field_170.method_466() - this.field_170.method_504() + 10);
      }

      var3 = this.field_170.method_493(this.field_168).method_466();
      var2 = this.field_170.method_493(this.field_168).method_466() + this.field_170.method_493(this.field_168).method_463();
      this.field_170.field_387 = 16773632;
      this.field_170.field_388 = 2;
      this.field_170.field_412 = this.field_170.method_465();
      this.field_170.field_413 = var3;
      this.field_170.field_414 = this.field_170.method_504();
      this.field_170.field_415 = var2 - var3;
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      switch(this.field_163) {
      case 1:
      case 2:
         Screen.field_38 = true;
         Screen.field_34 = var1;
         Screen.field_35 = var2;
         Screen.field_36 = var1;
         Screen.field_37 = var2;
         super.field_85 = System.currentTimeMillis();
         super.field_86 = false;
         break;
      case 3:
      case 4:
         int var3;
         if((var3 = this.field_170.method_494(var2 + this.field_170.method_502())) >= 0) {
            this.method_192(var3);
            this.field_170.method_506(var1, var2);
            Screen.field_37 = var2;
            Screen.field_35 = var2;
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      if(this.field_163 != 1 && this.field_163 != 2) {
         if(this.field_163 == 4 || this.field_163 == 3) {
            this.method_192(this.field_168);
         }
      } else if(Screen.field_38) {
         class_62 var10001 = this.field_166;
         byte var4;
         if((var4 = this.method_140(this.field_164.length, this.method_178(), var2)) >= 0 && var4 < this.field_164.length) {
            this.field_167 = var4;
            if(this.field_163 == 1) {
               return this.method_179();
            }

            if(this.field_163 == 2) {
               return this.method_181();
            }
         }
      }

      return false;
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      if((this.field_163 == 1 || this.field_163 == 2) && System.currentTimeMillis() - super.field_85 > 200L && Screen.field_38 && !super.field_86) {
         super.field_86 = true;
         class_62 var10001 = this.field_166;
         byte var4;
         if((var4 = this.method_140(this.field_164.length, this.method_178(), var2)) >= 0 && var4 < this.field_164.length) {
            this.field_167 = var4;
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: d (int) void
   public final void method_32(int var1) {
      if(var1 == 51 && super.field_46 == 1) {
         byte var2 = this.field_167;
         if(this.field_167 >= 0 && var2 < this.field_165.length) {
            this.field_172 = this.field_167;
            this.method_180(this.field_165[var2], true);
         }
      } else {
         super.method_32(var1);
      }
   }

   // $FF: renamed from: a (int) void
   public final void onButtonClick(int var1) {
      if(var1 == 1) {
         ScreenDrawer.self.method_376();
         super.formCreator = null;
      } else {
         if(var1 == 0) {
            String var5;
            if((var5 = super.formCreator.method_443(0)) == null || var5.trim().equals("")) {
               return;
            }

            try {
               OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[56]);
               OutputGameMessage var2 = var10000;
               boolean var3 = false;
               if(super.formCreator.method_448() > 0) {
                  var3 = super.formCreator.method_447(0) != 0;
               }

               if(!var3 && this.field_165[this.field_172] != -1) {
                  var2.addToBody((byte)0);
                  var2.addToBody(0);
               } else {
                  var2.addToBody((byte)1);
                  var2.addToBody(this.field_182);
               }

               var2.addToBody(var5);
               SocketListener.self.sendCommand(var2);
               this.onButtonClick(1);
               return;
            } catch (Exception var4) {
               SocketListener.logMessage("Chat3 sendMsg: " + var4.getMessage());
            }
         }

      }
   }

   // $FF: renamed from: a () int
   public final int method_71() {
      switch(this.field_163) {
      case 1:
         return -1;
      case 2:
         return -1;
      case 3:
      case 4:
         if(this.field_170.method_493(this.field_168) != null) {
            return this.field_170.method_493(this.field_168).method_471();
         }
      default:
         return -1;
      }
   }

   // $FF: renamed from: b (int) void
   public final void method_4(int var1) {}

   // $FF: renamed from: a (mobak.b.b.a.d) int
   static int method_193(class_35 var0) {
      return var0.field_168;
   }

   // $FF: renamed from: a (mobak.b.b.a.d) mobak.b.b.q
   static class_55 method_194(class_35 var0) {
      return var0.field_170;
   }
}

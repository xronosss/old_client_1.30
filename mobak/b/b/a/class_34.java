package mobak.b.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a.l
public final class class_34 extends MenuScreen {

   // $FF: renamed from: b mobak.b.b.q
   private class_55 field_144;
   // $FF: renamed from: c mobak.b.b.q
   private class_55 field_145;
   // $FF: renamed from: d mobak.b.b.q
   private class_55 field_146;
   // $FF: renamed from: a mobak.b.b.a.o[]
   private class_60[] field_147;
   // $FF: renamed from: a short[][]
   private short[][] field_148;
   // $FF: renamed from: a java.lang.String[][]
   private String[][] field_149;
   // $FF: renamed from: b short[][]
   private short[][] field_150;
   // $FF: renamed from: b java.lang.String[][]
   private String[][] field_151;
   // $FF: renamed from: e int
   private int field_152;
   // $FF: renamed from: g int
   private int field_153;
   // $FF: renamed from: d java.lang.String
   private String field_154;
   // $FF: renamed from: e java.lang.String
   private String field_155;
   // $FF: renamed from: a boolean
   private boolean field_156;
   // $FF: renamed from: c byte
   private byte field_157;
   // $FF: renamed from: d boolean
   private boolean field_158;
   // $FF: renamed from: h int
   private int field_159;
   // $FF: renamed from: k short
   private short field_160;
   // $FF: renamed from: l short
   private short field_161;
   // $FF: renamed from: m short
   private static short field_162;


   // $FF: renamed from: <init> (int, int) void
   public class_34(int var1, int var2) {
      super();
      this.field_147 = null;
      this.field_156 = false;
      this.field_157 = 0;
      this.field_159 = 16773632;
      this.field_153 = var2;
      this.field_152 = var1;
      this.field_156 = true;
      this.method_166();
   }

   // $FF: renamed from: <init> (int) void
   public class_34(int var1) {
      super();
      this.field_147 = null;
      this.field_156 = false;
      this.field_157 = 0;
      this.field_159 = 16773632;
      this.field_153 = this.field_152 = var1;
      this.method_166();
   }

   // $FF: renamed from: b () void
   private void method_166() {
      GlobalStorage.method_711("plus_minus.png");
      this.field_154 = String.valueOf(this.field_152);
      this.field_155 = String.valueOf(this.field_153);
      class_55 var10001 = new class_55((short)10, this.method_136(), (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.method_136() - PopupMenu.method_583()), false, false);
      this.field_144 = var10001;
      this.field_144.field_429 = 10;
      this.field_144.method_490(MessagesContainer.getMessage(134) + ":    \f4" + this.field_154 + " / " + this.field_155, Screen.field_26, false, -1);
      this.field_160 = (short)(this.field_144.field_429 + this.method_136() + 5);
      this.field_144.field_429 += 15;
      var10001 = new class_55((short)10, (short)this.field_144.field_429, (short)(ScreenDrawer.self.getWidth() - 20), (short)102, false, false);
      this.field_145 = var10001;
      this.field_144.method_491(this.field_145);
      this.field_145.field_429 = 2;
      this.field_150 = new short[Hero.self.characteristics.length][2];
      this.field_151 = new String[Hero.self.characteristics.length][2];

      byte var1;
      for(var1 = 0; var1 < Hero.self.characteristics.length; ++var1) {
         this.field_145.method_489(Hero.self.characteristics[var1].name + "\f4" + Hero.self.characteristics[var1].value + "\f7 ", Screen.field_26, (byte)2, false, -1);
         this.field_150[var1][0] = (short) Hero.self.characteristics[var1].index;
         this.field_151[var1][0] = String.valueOf(this.field_150[var1][0]);
      }

      for(var1 = 0; var1 < this.field_145.method_509(); ++var1) {
         ((class_53)this.field_145.method_493(var1)).method_479(1).method_467((short)((ScreenDrawer.self.getWidth() - 32) * 60 / 100));
         ((class_53)this.field_145.method_493(var1)).method_479(2).method_467((short)((ScreenDrawer.self.getWidth() - 32) * 80 / 100));
      }

      this.method_170((byte)0);
      this.field_144.field_429 += this.field_145.field_429 + 2;
      this.field_148 = new short[Hero.self.skills.length][2];
      this.field_149 = new String[Hero.self.skills.length][2];
      this.field_161 = (short)(this.field_144.field_429 + this.method_136() + 5);
      this.field_144.field_429 += 15;
      this.field_144.method_490(MessagesContainer.getMessage(104) + ":", Screen.field_26, false, -1);
      var10001 = new class_55((short)10, (short)this.field_144.field_429, (short)(ScreenDrawer.self.getWidth() - 20), (short)(ScreenDrawer.self.getHeight() - this.field_144.field_429), false, false);
      this.field_146 = var10001;
      this.field_146.field_429 = 2;
      this.field_144.method_491(this.field_146);

      for(var1 = 0; var1 < Hero.self.skills.length; ++var1) {
         this.field_146.method_489(Hero.self.skills[var1].name + "\f4" + Hero.self.skills[var1].value + "\f7 ", Screen.field_26, (byte)2, false, -1);
         this.field_148[var1][0] = (short) Hero.self.skills[var1].index;
         this.field_149[var1][0] = String.valueOf(this.field_148[var1][0]);
      }

      for(var1 = 0; var1 < this.field_146.method_509(); ++var1) {
         ((class_53)this.field_146.method_493(var1)).method_479(1).method_467((short)((ScreenDrawer.self.getWidth() - 32) * 60 / 100));
         ((class_53)this.field_146.method_493(var1)).method_479(2).method_467((short)((ScreenDrawer.self.getWidth() - 32) * 80 / 100));
      }

      this.field_158 = false;
      PopupMenu var2 = new PopupMenu(new byte[]{(byte)81}, new byte[]{(byte)55}, (byte[][])null);
      super.popupMenu = var2;
      super.name = MessagesContainer.getMessage(144);
      super.popupMenu.method_597((short)148, (byte)55);
   }

   // $FF: renamed from: a (byte) void
   public final void method_167(byte var1) {
      if(var1 > 0) {
         this.field_147 = new class_60[var1];
      }
   }

   // $FF: renamed from: a (byte, byte, int[][]) void
   public final void method_168(byte var1, byte var2, int[][] var3) {
      if(var1 >= 0 && this.field_147 != null && var1 < this.field_147.length) {
         class_60[] var10000;
         if(this.field_147[var1] == null) {
            var10000 = this.field_147;
            var10000[var1] = new class_60(this);
         }

         this.field_147[var1].field_481 = var3;
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {}

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      if(!this.field_158) {
         if(ScreenDrawer.self.getGameAction(var1) == 6) {
            if(this.field_157 < this.field_150.length - 1) {
               this.method_170((byte)(this.field_157 + 1));
               return;
            }

            this.method_170((byte)0);
            return;
         }

         if(ScreenDrawer.self.getGameAction(var1) == 1) {
            if(this.field_157 > 0) {
               this.method_170((byte)(this.field_157 - 1));
               return;
            }

            this.method_170((byte)(this.field_150.length - 1));
            return;
         }
      } else {
         class_52 var10000;
         int[][] var2;
         byte var3;
         String var4;
         class_52 var5;
         byte var6;
         if(ScreenDrawer.self.getGameAction(var1) == 1) {
            if(this.field_152 <= 0) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(135), MessagesContainer.getMessage(136));
               return;
            }

            --this.field_152;
            this.field_154 = String.valueOf(this.field_152);
            ++this.field_150[this.field_157][1];
            this.field_151[this.field_157][1] = String.valueOf(this.field_150[this.field_157][1]);
            var10000 = (class_52)((class_53)this.field_144.method_493(0)).method_479(1);
            var4 = this.field_154 + " / " + this.field_155;
            var10000.field_395 = var4;
            var5 = (class_52)((class_53)this.field_145.method_493(this.field_157)).method_479(2);
            if(this.field_150[this.field_157][1] != 0) {
               if(this.field_150[this.field_157][1] > 0) {
                  var4 = "+" + this.field_151[this.field_157][1];
                  var5.field_395 = var4;
               } else {
                  var4 = this.field_151[this.field_157][1];
                  var5.field_395 = var4;
               }
            } else {
               var4 = " ";
               var5.field_395 = var4;
            }

            if(this.field_147 != null) {
               var2 = null;
               if(this.field_157 >= 0 && this.field_157 < this.field_147.length) {
                  var2 = this.field_147[this.field_157].field_481;
               }

               if(var2 != null) {
                  for(var3 = 0; var3 < var2.length; ++var3) {
                     for(var6 = 0; var6 < this.field_148.length; ++var6) {
                        if(this.field_148[var6][0] == var2[var3][0]) {
                           this.field_148[var6][1] = (short)(this.field_148[var6][1] + var2[var3][1]);
                           this.field_149[var6][1] = String.valueOf(this.field_148[var6][1]);
                           var5 = (class_52)((class_53)this.field_146.method_493(var6)).method_479(2);
                           if(this.field_148[var6][1] > 0) {
                              var4 = "+" + this.field_149[var6][1];
                              var5.field_395 = var4;
                           } else {
                              var4 = this.field_149[var6][1];
                              var5.field_395 = var4;
                           }
                           break;
                        }
                     }
                  }
               }
            }

            return;
         }

         if(ScreenDrawer.self.getGameAction(var1) == 6) {
            if(this.field_152 + 1 > this.field_153) {
               ScreenDrawer.method_330(MessagesContainer.getMessage(135), MessagesContainer.getMessage(137));
               return;
            }

            if(this.field_150[this.field_157][1] == 0 && !this.field_156) {
               return;
            }

            if(this.field_156 && !this.method_169()) {
               return;
            }

            ++this.field_152;
            this.field_154 = String.valueOf(this.field_152);
            --this.field_150[this.field_157][1];
            this.field_151[this.field_157][1] = String.valueOf(this.field_150[this.field_157][1]);
            var10000 = (class_52)((class_53)this.field_144.method_493(0)).method_479(1);
            var4 = this.field_154 + " / " + this.field_155;
            var10000.field_395 = var4;
            var5 = (class_52)((class_53)this.field_145.method_493(this.field_157)).method_479(2);
            if(this.field_150[this.field_157][1] != 0) {
               if(this.field_150[this.field_157][1] > 0) {
                  var4 = "+" + this.field_151[this.field_157][1];
                  var5.field_395 = var4;
               } else {
                  var4 = this.field_151[this.field_157][1];
                  var5.field_395 = var4;
               }
            } else {
               var4 = " ";
               var5.field_395 = var4;
            }

            if(this.field_147 == null) {
               return;
            }

            var2 = null;
            if(this.field_157 >= 0 && this.field_157 < this.field_147.length) {
               var2 = this.field_147[this.field_157].field_481;
            }

            if(var2 != null) {
               for(var3 = 0; var3 < var2.length; ++var3) {
                  for(var6 = 0; var6 < this.field_148.length; ++var6) {
                     if(this.field_148[var6][0] == var2[var3][0]) {
                        this.field_148[var6][1] = (short)(this.field_148[var6][1] - var2[var3][1]);
                        this.field_149[var6][1] = String.valueOf(this.field_148[var6][1]);
                        var5 = (class_52)((class_53)this.field_146.method_493(var6)).method_479(2);
                        if(this.field_148[var6][1] != 0) {
                           if(this.field_148[var6][1] > 0) {
                              var4 = "+" + this.field_149[var6][1];
                              var5.field_395 = var4;
                           } else {
                              var4 = this.field_149[var6][1];
                              var5.field_395 = var4;
                           }
                        } else {
                           var4 = "";
                           var5.field_395 = var4;
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   // $FF: renamed from: e () boolean
   private boolean method_169() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.field_150.length; ++var2) {
         if(this.field_150[var2][1] < 0) {
            var1 += this.field_150[var2][1];
         }
      }

      if(this.field_153 + var1 <= 0 && this.field_150[this.field_157][1] <= 0) {
         return false;
      } else {
         Hero var10000 = Hero.self;
         if(Hero.method_894(Hero.self.characteristics, (byte)this.field_150[this.field_157][0]).value + this.field_150[this.field_157][1] - 1 < 0) {
            return false;
         } else if(this.field_147 == null) {
            return true;
         } else {
            int[][] var5 = null;
            if(this.field_157 >= 0 && this.field_157 < this.field_147.length) {
               var5 = this.field_147[this.field_157].field_481;
            }

            if(var5 != null) {
               for(byte var4 = 0; var4 < var5.length; ++var4) {
                  for(byte var3 = 0; var3 < this.field_148.length; ++var3) {
                     if(this.field_148[var3][0] == var5[var4][0]) {
                        var10000 = Hero.self;
                        if(Hero.method_894(Hero.self.skills, (byte)this.field_148[this.field_157][0]).value + this.field_148[this.field_157][1] - var5[var4][1] < 0) {
                           return false;
                        }
                        break;
                     }
                  }
               }
            }

            return true;
         }
      }
   }

   // $FF: renamed from: b (byte) void
   private void method_170(byte var1) {
      ((class_53)this.field_145.method_493(this.field_157)).method_469(-16777216, 0);
      this.field_157 = var1;
      ((class_53)this.field_145.method_493(this.field_157)).method_469(16773632, 2);
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      int var2 = button.field_543;
      switch((byte) button.field_543) {
      case 55:
         label60: {
            if(this.field_152 == 0) {
               label58: {
                  if(this.field_156) {
                     class_34 var8 = this;
                     short var3 = 0;
                     short var4 = 0;

                     for(byte var5 = 0; var5 < var8.field_150.length; ++var5) {
                        if(var8.field_150[var5][1] < 0) {
                           var3 += var8.field_150[var5][1];
                        }

                        if(var8.field_150[var5][1] > 0) {
                           var4 += var8.field_150[var5][1];
                        }
                     }

                     if(-var3 != var8.field_153 || var4 != -var3 || var3 >= 0) {
                        break label58;
                     }
                  }

                  class_23 var10000 = new class_23(this);
                  class_23 var6 = var10000;
                  ScreenDrawer.method_334("", MessagesContainer.getMessage(41), (String)null, var6);
                  break label60;
               }
            }

            class_24 var9 = new class_24(this);
            class_24 var7 = var9;
            ScreenDrawer.method_334(MessagesContainer.getMessage(135) + "!", MessagesContainer.getMessage(145), MessagesContainer.getMessage(41) + "?", var7);
         }

         boolean var10 = true;
         return true;
      case 81:
         if(this.field_158) {
            this.field_159 = 16773632;
            super.popupMenu.method_597((short)7, (byte)81);
         } else {
            this.field_159 = 255;
            super.popupMenu.method_597((short)106, (byte)81);
         }

         this.field_158 = !this.field_158;
         this.field_145.method_493(this.field_157).method_469(this.field_159, 2);
         return true;
      default:
         return super.method_38(button);
      }
   }

   // $FF: renamed from: g () void
   public final void helpViewInit() {}

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      try {
         super.method_30(var1);
         this.field_144.method_484(var1, (byte)0);
         ScreenDrawer.method_371(var1, field_162, ScreenDrawer.self.getWidth() / 2, this.field_160, 3);
         ScreenDrawer.method_371(var1, field_162, ScreenDrawer.self.getWidth() / 2, this.field_161, 3);
         if(this.field_158) {
            this.method_145(var1, ScreenDrawer.self.getHeight() / 2);
         }

         super.popupMenu.method_604(var1);
      } catch (Exception var2) {
         SocketListener.logMessage("HeroIncrease " + var2.getMessage());
      }
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      return false;
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      byte var3;
      if(this.field_158) {
         if((var3 = this.method_146(var1, var2)) == 1) {
            ScreenDrawer.self.method_367(1);
         }

         if(var3 == 2) {
            ScreenDrawer.self.method_367(6);
         }
      } else if((var3 = (byte)this.field_145.method_494(var2)) >= 0) {
         this.method_170(var3);
      }

      return true;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      return false;
   }

   // $FF: renamed from: a (mobak.b.b.a.l) void
   static void sendSelection(class_34 var0) {
      OutputGameMessage packet = new OutputGameMessage(MessageProcessor.packetTypes[53], (short)(4 * var0.field_150.length), (short)0);

      try {
         packet.addToBody((byte)var0.field_150.length);

         for(byte i = 0; i < var0.field_150.length; ++i) {
            packet.addToBody(var0.field_150[i][0]);
            packet.addToBody(var0.field_150[i][1]);
         }
      } catch (Exception var3) {
         SocketListener.logMessage("sendSelection" + var3.toString());
      }

      SocketListener.self.sendCommand(packet);
   }

   // $FF: renamed from: a (mobak.b.b.a.l, int) int
   static int method_172(class_34 var0, int var1) {
      return var0.field_159 = 16773632;
   }

   // $FF: renamed from: <clinit> () void
   static {
      field_162 = GlobalStorage.method_711("separator.png");
   }
}

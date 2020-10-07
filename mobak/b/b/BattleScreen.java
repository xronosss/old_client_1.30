package mobak.b.b;

import java.util.Date;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Item;
import mobak.b.a.Unit;
import mobak.b.a.Characteristic;
import mobak.b.a.Hero;
import mobak.b.b.a.MenuScreen;
import mobak.b.b.a.PopupMenu;
import mobak.b.b.a.Button;
import mobak.text.MessagesContainer;

// $FF: renamed from: mobak.b.b.a
public final class BattleScreen extends Screen {

   // $FF: renamed from: a byte[]
   private static final byte[] field_245;
   // $FF: renamed from: e int
   private static int field_246;
   // $FF: renamed from: b short
   private short field_247;
   // $FF: renamed from: c short
   private short field_248;
   // $FF: renamed from: d short
   private short field_249;
   // $FF: renamed from: e short
   private short field_250;
   // $FF: renamed from: f short
   private short field_251;
   // $FF: renamed from: g short
   private short field_252;
   // $FF: renamed from: h short
   private short field_253;
   // $FF: renamed from: i short
   private short field_254;
   // $FF: renamed from: j short
   private short field_255;
   // $FF: renamed from: k short
   private short field_256;
   // $FF: renamed from: l short
   private short field_257;
   // $FF: renamed from: a byte[][]
   private byte[][] field_258;
   // $FF: renamed from: c byte
   private byte field_259;
   // $FF: renamed from: d byte
   private byte field_260;
   // $FF: renamed from: a boolean
   public boolean field_261;
   // $FF: renamed from: m short
   private short field_262;
   // $FF: renamed from: e byte
   private byte field_263;
   // $FF: renamed from: a mobak.b.a.e
   public Item field_264;
   // $FF: renamed from: b byte[][]
   private byte[][] field_265;
   // $FF: renamed from: a long
   private long field_266;
   // $FF: renamed from: d boolean
   private boolean field_267;
   // $FF: renamed from: f byte
   private byte field_268;
   // $FF: renamed from: g byte
   private byte field_269;
   // $FF: renamed from: e boolean
   private boolean field_270;
   // $FF: renamed from: f boolean
   private boolean field_271;
   // $FF: renamed from: a mobak.b.b.c[]
   private class_2[] field_272;
   // $FF: renamed from: h byte
   private byte field_273;
   // $FF: renamed from: i byte
   private byte field_274;
   // $FF: renamed from: a mobak.b.a.f[]
   private Unit[] field_275;
   // $FF: renamed from: b mobak.b.a.f[]
   private Unit[] field_276;
   // $FF: renamed from: j byte
   private byte field_277;
   // $FF: renamed from: k byte
   private byte field_278;
   // $FF: renamed from: l byte
   private byte field_279;
   // $FF: renamed from: m byte
   private byte field_280;
   // $FF: renamed from: f int
   private int field_281;
   // $FF: renamed from: a mobak.b.b.a.v
   private Button field_282;
   // $FF: renamed from: a mobak.a.a.l
   private OutputGameMessage field_283;
   // $FF: renamed from: a mobak.b.a.b
   public Hero hero;


   // $FF: renamed from: <init> () void
   public BattleScreen() {
      super();
      this.field_247 = -1;
      this.field_248 = -1;
      this.field_249 = -1;
      this.field_250 = -1;
      this.field_251 = -1;
      this.field_252 = -1;
      this.field_253 = -1;
      this.field_254 = -1;
      this.field_255 = -1;
      this.field_256 = -1;
      this.field_257 = -1;
      this.field_258 = new byte[5][6];
      this.field_259 = 0;
      this.field_260 = 0;
      this.field_261 = false;
      this.field_262 = 0;
      this.field_263 = -1;
      this.field_267 = false;
      this.field_268 = 0;
      this.field_269 = 0;
      this.field_270 = false;
      this.field_271 = false;
      this.field_272 = new class_2[50];
      this.field_273 = 0;
      this.field_274 = 0;
      this.field_275 = null;
      this.field_276 = null;
      this.field_277 = 0;
      this.field_278 = -1;
      this.field_283 = null;
      this.hero = null;
      byte var1 = 1;

      try {
         GlobalStorage.method_715();
         int var5 = var1 + 1;
         this.field_278 = 0;
         String var2;
         switch(GlobalStorage.method_720(GlobalStorage.method_702((short) Hero.self.getPositionX(), (short) Hero.self.getPositionY()))) {
         case 2:
            var2 = "tiles_rocks.png";
            this.field_278 = 1;
            break;
         case 3:
            var2 = "tiles_sand.png";
            this.field_278 = 2;
            break;
         case 4:
            var2 = "tiles_snow.png";
            this.field_278 = 3;
            break;
         case 5:
            var2 = "tiles_grass.png";
            this.field_278 = 2;
            break;
         case 6:
         case 7:
         case 8:
         default:
            var2 = "tiles_rocks.png";
            this.field_278 = 1;
            break;
         case 9:
            var2 = "tiles_stone.png";
            this.field_278 = 1;
         }

         ++var5;
         this.field_249 = GlobalStorage.method_711("battle_bottom_corner.png");
         this.field_250 = GlobalStorage.method_711("battle_bottom.png");
         this.field_251 = GlobalStorage.method_711("battle_bottom_mid.png");
         this.field_252 = GlobalStorage.method_711("battle_vertical_mid.png");
         this.field_253 = GlobalStorage.method_711("battle_vertical.png");
         this.field_254 = GlobalStorage.method_711("battle_top.png");
         this.field_255 = GlobalStorage.method_711("battle_middle_top.png");
         this.field_256 = GlobalStorage.method_711("battle_progress_fill.png");
         this.field_257 = GlobalStorage.method_711("battle_over_deco.png");
         ++var5;
         this.field_247 = GlobalStorage.method_711(var2);
         this.field_248 = GlobalStorage.method_711("leg_cursors.png");
      } catch (Exception var4) {
         SocketListener.logMessage("BattleScreen resources loading error on step " + String.valueOf(var1) + ": " + var4.toString());
      }

      for(byte var7 = 0; var7 < 5; ++var7) {
         for(byte var3 = 0; var3 < 6; ++var3) {
            this.field_258[var7][var3] = 0;
         }
      }

      this.field_281 = Hero.self.method_893(Hero.self.skills, (byte)10, 0);
      PopupMenu var10001 = new PopupMenu(new byte[]{(byte)51, (byte)56, (byte)4, (byte)1, (byte)5}, new byte[]{(byte)51, (byte)2, (byte)58, (byte)53, (byte)54, (byte)59, (byte)63}, (byte[][])null);
      super.popupMenu = var10001;
      super.popupMenu.method_617(true, false);
      super.popupMenu.method_597((short)190, (byte)58);
      Button var9 = new Button((byte)30);
      this.field_282 = var9;
      this.field_282.method_656((short)264);
      this.field_282.method_654(MessagesContainer.getMessage(265, new String[]{String.valueOf(GlobalStorage.ArmyByGemsCost)}));
      short var8 = MessageProcessor.packetTypes[87];
      Button var6 = this.field_282;
      this.field_282.packetType = var8;
      this.field_282.method_648(true);
      super.popupMenu.method_594(false, this.field_282);
      this.method_293();
      this.method_294();
      this.field_266 = 0L;
      super.field_52 = -101;
      ScreenDrawer.self.method_350(true);
      if(Hero.self != null) {
         this.setRace(Hero.self.method_932());
      }

   }

   // $FF: renamed from: a (byte) void
   public final void method_278(byte var1) {
      this.field_267 = true;
      this.field_268 = var1;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_30(Graphics var1) {
      byte var2 = 1;

      try {
         if(Hero.self.field_673 && Hero.self.method_882((byte)1) != null) {
            super.popupMenu.method_616((byte)54);
         } else {
            super.popupMenu.method_615((byte)54);
         }

         int var16 = var2 + 1;
         this.method_51();
         ++var16;
         Graphics var4 = var1;
         BattleScreen var3 = this;
         byte var25;
         if(var1 != null) {
            short var5 = this.method_280((byte)0);
            short var6 = this.method_282((byte)0);
            int var7 = var5 % 51 - 51;
            int var8 = var6 % 45 - 45;
            ScreenDrawer.method_369(var1, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());

            for(int var9 = var7; var9 <= ScreenDrawer.self.getWidth(); var9 += 51) {
               for(int var10 = var8; var10 <= ScreenDrawer.self.getHeight(); var10 += 45) {
                  ScreenDrawer.method_374(var4, var3.field_247, 0, 0, 51, 45, 0, var9, var10, 20);
               }
            }

            for(var25 = 0; var25 < 5; ++var25) {
               for(byte var26 = 0; var26 < 6; ++var26) {
                  short var11 = var3.method_280(var25);
                  var5 = (short)(var3.method_282(var26) - 45);
                  ScreenDrawer.method_369(var4, var11, var5, 51, 45);
                  if((var25 + var26) % 2 == 0) {
                     ScreenDrawer.method_374(var4, var3.field_247, 0, 0, 51, 45, 0, var11, var5, 20);
                  } else {
                     ScreenDrawer.method_374(var4, var3.field_247, 51, 0, 51, 45, 0, var11, var5, 20);
                  }
               }
            }

            ScreenDrawer.method_369(var4, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
         }

         ++var16;
         var4 = var1;
         var3 = this;
         if(var1 != null && this.field_258 != null) {
            for(byte var21 = 0; var21 < 5; ++var21) {
               for(byte var22 = 0; var22 < 6; ++var22) {
                  if(var3.field_258[var21][var22] != 0) {
                     short var23 = var3.method_280(var21);
                     short var24 = (short)(var3.method_282(var22) - 45);
                     if(var3.field_258[var21][var22] == -1) {
                        ScreenDrawer.method_369(var4, var23, var24, 51, 45);
                        if((var21 + var22) % 2 == 0) {
                           ScreenDrawer.method_374(var4, var3.field_247, 102, 0, 51, 45, 0, var23, var24, 20);
                        } else {
                           ScreenDrawer.method_374(var4, var3.field_247, 153, 0, 51, 45, 0, var23, var24, 20);
                        }

                        ScreenDrawer.method_369(var4, 0, 0, ScreenDrawer.self.getWidth(), ScreenDrawer.self.getHeight());
                     } else {
                        if(!var3.field_270 && var3.field_274 == var3.field_273 && var3.field_258[var21][var22] == -128) {
                           ScreenDrawer.method_374(var4, var3.field_248, 36 * var3.field_278, 0, 36, 34, 0, (short)(var23 + 7) + 1, (short)(var24 + 5), 0);
                        }

                        var25 = (byte)(var3.field_258[var21][var22] & 127);
                        if(var3.method_300(var25)) {
                           Unit var27 = null;

                           try {
                              var27 = var3.method_301(var25);
                           } catch (Exception var14) {
                              SocketListener.method_522("unitDraw [" + var25 + "]" + var14, true);
                           }

                           if(var27 != null) {
                              synchronized(var27) {
                                 var27.method_758(var4, var23, var24, (short)-126);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         ++var16;
         if(this.field_261) {
            if(!this.field_270 && this.field_274 == this.field_273) {
               this.method_45(var1, (short)(this.method_280(this.field_259) + 8), (short)(this.method_282(this.field_260) - 45 + 5), 0);
            } else {
               this.method_45(var1, (short)(this.method_280(this.field_259) + 10), (short)(this.method_282(this.field_260) - 45 + 4), 0);
            }
         }

         ++var16;
         if(this.field_266 != 0L) {
            int var17 = Hero.self.method_893(Hero.self.skills, (byte)10, 0);
            if(this.field_281 != 0) {
               var17 = var17 * 100 / this.field_281;
            } else {
               var17 = 100;
            }

            String var18;
            (var18 = (var18 = (new Date((long)field_246 - (System.currentTimeMillis() - this.field_266))).toString()).substring(var18.indexOf(":") + 1)).substring(0, var18.indexOf(" "));
            if((long)field_246 - (System.currentTimeMillis() - this.field_266) < 0L) {
               if(this.field_261) {
                  super.popupMenu.method_621(field_245, true, true, true);
                  this.field_261 = false;
               }

               this.method_279(var1, 0, var17);
            } else {
               int var19 = 0;
               if(field_246 != 0) {
                  var19 = (int)(100L * ((long)field_246 - (System.currentTimeMillis() - this.field_266)) / (long)field_246);
               }

               this.method_279(var1, var19, var17);
            }
         }

         ++var16;
         super.popupMenu.method_604(var1);
         ++var16;
         if(this.field_272[this.field_274] != null && this.field_274 != this.field_273) {
            if(this.field_272[this.field_274].method_7()) {
               this.field_272[this.field_274].method_8();
               this.field_272[this.field_274] = null;
               ++this.field_274;
               if(this.field_274 >= this.field_272.length) {
                  this.field_274 = 0;
               }
            } else {
               try {
                  this.field_272[this.field_274].method_6(var1);
               } catch (Exception var12) {
                  SocketListener.method_522("m_draw " + var12.toString(), false);
               }
            }
         }

         ++var16;
         if(this.field_267) {
            if(this.field_265 != null) {
               this.method_290();
            }

            if(this.field_269 > 20) {
               ScreenDrawer.self.method_364();
               ScreenDrawer.self.setScreenId(this.field_268);
               ScreenDrawer.self.battleScreen = null;
               OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[73]);
               OutputGameMessage var20 = var10000;
               SocketListener.self.sendCommand(var20);
               return;
            }

            if(this.field_274 == this.field_273) {
               ++this.field_269;
            }
         }

      } catch (Exception var15) {
         SocketListener.logMessage("BattleScreen DrawScreen() Exception on step " + String.valueOf(var2) + ": " + var15.getMessage());
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int) void
   private void method_279(Graphics var1, int var2, int var3) {
      try {
         int var4 = ScreenDrawer.self.getWidth();
         int var5 = ScreenDrawer.self.getHeight();
         int var6 = ScreenDrawer.method_377(this.field_251);
         int var7 = (var4 - var6) / 2;
         ScreenDrawer.method_371(var1, this.field_251, var7, var5, 36);
         int var8 = ScreenDrawer.method_377(this.field_249) / 2;
         int var9 = ScreenDrawer.method_378(this.field_249);
         if(var6 + (var8 << 1) < var4) {
            ScreenDrawer.method_375(var1, this.field_250, 2, 0, var7, var5, var8, true, 32);
            ScreenDrawer.method_375(var1, this.field_250, 2, 1, var7 + var6, var5, var4 - var8, true, 32);
         }

         var6 = ScreenDrawer.method_378(this.field_252);
         var7 = ScreenDrawer.method_377(this.field_252) / 2;
         int var10 = (var5 - var6) / 2;
         ScreenDrawer.method_374(var1, this.field_252, 0, 0, var7, var6, 0, 0, var10, 20);
         ScreenDrawer.method_374(var1, this.field_252, var7, 0, var7, var6, 0, var4, var10, 24);
         if(var10 + var6 < var5 - var9) {
            ScreenDrawer.method_375(var1, this.field_253, 2, 0, 0, var10 + var6, var5 - var9, false, 4);
            ScreenDrawer.method_375(var1, this.field_253, 2, 1, var4, var10 + var6, var5 - var9, false, 8);
         }

         ScreenDrawer.method_375(var1, this.field_253, 2, 0, 0, var10, 0, false, 4);
         ScreenDrawer.method_375(var1, this.field_253, 2, 1, var4, var10, 0, false, 8);
         ScreenDrawer.method_374(var1, this.field_249, 0, 0, var8, var9, 0, 0, var5, 36);
         ScreenDrawer.method_374(var1, this.field_249, var8, 0, var8, var9, 0, var4, var5, 40);
         var6 = ScreenDrawer.method_377(this.field_254) / 2;
         var7 = ScreenDrawer.method_378(this.field_254);
         if(var4 > var6 << 1) {
            ScreenDrawer.method_375(var1, this.field_255, 1, 0, var6, 0, var4 - var6, true, 16);
         }

         ScreenDrawer.method_374(var1, this.field_254, 0, 0, var6, var7, 0, 0, 0, 20);
         ScreenDrawer.method_374(var1, this.field_254, var6, 0, var6, var7, 0, var4, 0, 24);
         var6 = var4 - 98;
         var7 = ScreenDrawer.method_377(this.field_256) / 4;
         var8 = ScreenDrawer.method_378(this.field_256);
         var2 = 50 + var6 * var2 / 100;
         ScreenDrawer.method_369(var1, 50, 2, var2 - 50, var8);
         ScreenDrawer.method_375(var1, this.field_256, 4, 3, 50, 2, var2 - var7, true, 16);
         ScreenDrawer.method_374(var1, this.field_256, var7 << 1, 0, var7, var8, 0, var2, 2, 24);
         var2 = var4 - 48 - var6 * var3 / 100;
         ScreenDrawer.method_369(var1, var2, 17, var4 - 48 - var2, var8);
         ScreenDrawer.method_375(var1, this.field_256, 4, 1, var4 - 48, 17, var2 + var7, true, 16);
         ScreenDrawer.method_374(var1, this.field_256, 0, 0, var7, var8, 0, var2, 17, 20);
         ScreenDrawer.method_369(var1, 0, 0, var4, var5);
         var2 = ScreenDrawer.method_377(this.field_257) / 2;
         var3 = ScreenDrawer.method_378(this.field_257);
         ScreenDrawer.method_374(var1, this.field_257, 0, 0, var2, var3, 0, 42, 17, 20);
         ScreenDrawer.method_374(var1, this.field_257, var2, 0, var2, var3, 0, var4 - 42 + 1, 2, 24);
      } catch (Exception var11) {
         SocketListener.logMessage("BS d.f.e, step " + String.valueOf(0) + ": " + var11.toString());
      }
   }

   // $FF: renamed from: a (byte) short
   private short method_280(byte var1) {
      return (short)(method_281() + var1 * 51);
   }

   // $FF: renamed from: a () short
   private static short method_281() {
      return (short)((ScreenDrawer.self.getWidth() - 255) / 2);
   }

   // $FF: renamed from: b (byte) short
   private short method_282(byte var1) {
      return (short)(this.method_283() + 45 * (var1 + 1));
   }

   // $FF: renamed from: b () short
   private short method_283() {
      int var1;
      return (short)((var1 = ScreenDrawer.method_378(this.field_255)) + (ScreenDrawer.self.getHeight() - var1 - PopupMenu.method_583() - 270) / 2);
   }

   // $FF: renamed from: a (mobak.b.b.a.v) boolean
   public final boolean method_38(Button button) {
      if(button == null) {
         return false;
      } else {
         int var2 = button.field_543;
         switch((byte) button.field_543) {
         case 1:
            try {
               if(this.field_273 != this.field_274 || this.field_270) {
                  return true;
               }

               this.field_270 = true;
               this.method_43((byte)-1);
               this.method_296(this.field_259, this.field_260);
               SocketListener.self.sendCommand(this.field_283);
               this.field_283 = null;
               this.field_265 = null;
               this.method_299().method_804(false);
               this.method_290();
               this.field_263 = -1;
            } catch (Exception var5) {
               SocketListener.logMessage("GO " + var5);
            }

            return true;
         case 2:
         case 58:
            if(this.field_273 == this.field_274 && !this.field_270) {
               if(this.field_283 != null) {
                  SocketListener.self.sendCommand(this.field_283);
                  this.field_283 = null;
               }

               var2 = button.field_543;
               return this.method_284((byte) button.field_543 == 58);
            }

            return true;
         case 4:
            if(this.field_273 == this.field_274 && !this.field_270) {
               this.field_279 = this.field_259;
               this.field_280 = this.field_260;
               Hero.self.field_673 = false;
               this.field_270 = true;
               this.method_43((byte)-1);

               try {
                  OutputGameMessage var11 = new OutputGameMessage(MessageProcessor.packetTypes[46], (short)6, (short)0);
                  OutputGameMessage var9 = var11;
                  var11.addToBody(this.field_264.getId());
                  var9.addToBody(this.field_259);
                  var9.addToBody(this.field_260);
                  SocketListener.self.sendCommand(var9);
                  this.field_277 = 1;
                  this.field_264.setQuantity(this.field_264.getQuantity() - 1);
                  Hero.self.field_673 = false;
                  Hero var12 = Hero.self;
                  Characteristic var10;
                  if((var10 = Hero.method_894(Hero.self.skills, Characteristic.field_665)) != null) {
                     var10.value -= this.field_264.method_784();
                  }

                  if(this.field_264.getQuantity() <= 0) {
                     Hero.self.method_895(this.field_264.getId());
                  }
               } catch (Exception var4) {
                  SocketListener.logMessage("BattleScreen.action() case CS_MAGIC" + var4.toString());
               }

               this.field_264 = null;
               return true;
            }

            return true;
         case 5:
            if(this.field_273 == this.field_274 && !this.field_270) {
               this.field_270 = true;
               this.method_43((byte)-1);

               try {
                  this.method_303();
               } catch (Exception var3) {
                  SocketListener.logMessage("CS_ATTACK" + var3.toString());
               }

               return true;
            }

            return true;
         case 53:
            ScreenDrawer.self.method_340(MenuScreen.method_133((short)-4), true);
            return true;
         case 54:
            if(this.field_273 != this.field_274) {
               return true;
            }

            Item[] var8;
            if((var8 = Hero.self.method_882((byte)1)) != null && var8.length > 0) {
               ScreenDrawer.self.method_340(MenuScreen.method_133((short)-1), true);
            }

            return true;
         case 56:
            if(this.field_273 != this.field_274) {
               return true;
            }

            this.field_264 = null;
            return true;
         case 59:
            Main2.self.field_664 = this.hero.heroId;
            Main2.self.changeForm((byte)6);
            return true;
         case 63:
            class_29 var10000 = new class_29(this);
            class_29 var7 = var10000;
            if(this.field_262 >= 3) {
               ScreenDrawer.method_334(MessagesContainer.getMessage(39), MessagesContainer.getMessage(209), MessagesContainer.getMessage(41) + "?", var7);
            } else {
               ScreenDrawer.method_334(MessagesContainer.getMessage(39), MessagesContainer.getMessage(40), MessagesContainer.getMessage(41) + "?", var7);
            }
            break;
         default:
            try {
               return super.method_38(button);
            } catch (Exception var6) {
               SocketListener.logMessage(var6.getMessage());
            }
         }

         return false;
      }
   }

   // $FF: renamed from: a (boolean) boolean
   private boolean method_284(boolean var1) {
      try {
         this.field_283 = null;
         if(this.method_299() == null) {
            return false;
         } else {
            this.method_299().method_804(false);
            this.field_263 = -1;
            this.method_290();
            this.field_265 = null;
            OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[36], (short)0, (short)0);
            OutputGameMessage var2 = var10000;
            if(var1) {
               try {
                  var2.addToBody((byte)1);
               } catch (Exception var3) {
                  SocketListener.logMessage(var3.getMessage());
               }
            }

            SocketListener.self.sendCommand(var2);
            return true;
         }
      } catch (Exception var4) {
         SocketListener.logMessage("sendPass " + var4);
         return false;
      }
   }

   // $FF: renamed from: a () void
   public final void method_51() {
      try {
         Item[] var1;
         if((var1 = Hero.self.method_882((byte)1)) != null && var1.length > 0 && Hero.self.field_673) {
            super.popupMenu.method_616((byte)54);
         } else {
            super.popupMenu.method_615((byte)54);
         }

         if(this.field_274 == this.field_273) {
            if(!this.field_270) {
               this.method_43((byte)0);
               if(!super.popupMenu.method_611()) {
                  byte var8 = this.field_258[this.field_259][this.field_260];
                  super.popupMenu.method_617(true, false);
                  if(this.field_261) {
                     boolean var3;
                     if(var8 == -1 && this.field_264 == null) {
                        this.method_43((byte)10);
                     } else if(this.field_264 != null && Hero.self.field_673) {
                        this.method_43((byte)3);
                        byte var2;
                        if((var2 = this.field_258[this.field_259][this.field_260]) != -1) {
                           var2 = (byte)(this.field_258[this.field_259][this.field_260] & 127);
                        }

                        var3 = false;
                        if(var2 == 0) {
                           var3 = this.field_264.method_794((byte)16);
                        } else if(var2 > 0 && var2 <= 5) {
                           var3 = this.field_264.method_794((byte)2);
                        } else if(var2 >= 51 && var2 <= 100) {
                           var3 = this.field_264.method_794((byte)1);
                        } else if(var2 == -1) {
                           var3 = this.field_264.method_794((byte)32);
                        }

                        if(var3) {
                           super.popupMenu.method_600((byte)56, false);
                           super.popupMenu.method_600((byte)4, false);
                           this.method_43((byte)4);
                           return;
                        }

                        super.popupMenu.method_600((byte)56, false);
                        this.method_43((byte)3);
                        return;
                     }

                     if(this.field_263 > 0) {
                        Unit var9;
                        if((var9 = this.method_299()) == null) {
                           return;
                        }

                        var3 = var9.method_803();
                        boolean var4 = false;
                        byte var5 = this.method_299().method_797();
                        byte var6 = this.method_299().method_798();
                        if(var3 && var5 - 1 >= 0 && this.field_258[var5 - 1][var6] != -1 && (byte)(this.field_258[var5 - 1][var6] & 127) > 50) {
                           var3 = false;
                        }

                        if(var3 && var5 + 1 < 5 && this.field_258[var5 + 1][var6] != -1 && (byte)(this.field_258[var5 + 1][var6] & 127) > 50) {
                           var3 = false;
                        }

                        if(var3 && var6 - 1 >= 0 && this.field_258[var5][var6 - 1] != -1 && (byte)(this.field_258[var5][var6 - 1] & 127) > 50) {
                           var3 = false;
                        }

                        if(var3 && var6 + 1 < 6 && this.field_258[var5][var6 + 1] != -1 && (byte)(this.field_258[var5][var6 + 1] & 127) > 50) {
                           var3 = false;
                        }

                        if(var8 == 0) {
                           if(this.method_299() != null && this.method_299().method_799() == -1) {
                              this.method_43((byte)7);
                           } else {
                              this.method_43((byte)10);
                           }
                        } else if((byte)(var8 & 128) == -128 && var8 != -1) {
                           this.method_43((byte)1);
                        }

                        if(var8 != -1) {
                           if((var8 = (byte)(var8 & 127)) > 0 && var8 <= 50) {
                              this.method_43((byte)9);
                           } else if(var8 >= 51 && var8 <= 100) {
                              if(var3 && var9.method_803()) {
                                 this.method_43((byte)5);
                              } else {
                                 var8 = this.method_302(this.field_259, this.field_260, true);
                                 if((var9.method_799() == -1 || var9.method_799() >= var8) && var8 >= 0) {
                                    this.method_43((byte)5);
                                 } else {
                                    this.method_43((byte)10);
                                 }
                              }
                           }
                        }
                     }

                     if(super.field_46 == 5) {
                        super.popupMenu.method_600((byte)5, false);
                     } else if(super.field_46 == 1 || super.field_46 == 7) {
                        super.popupMenu.method_600((byte)1, false);
                     }

                     this.field_282.method_648(true);
                  }
               }
            }
         }
      } catch (Exception var7) {
         SocketListener.logMessage("defineMenu " + var7);
      }
   }

   // $FF: renamed from: c (int) void
   protected final void method_39(int var1) {
      switch(ScreenDrawer.self.getGameAction(var1)) {
      case 1:
         if(this.field_260 > 0) {
            --this.field_260;
         }

         return;
      case 2:
         if(this.field_259 > 0) {
            --this.field_259;
         }

         return;
      case 3:
      case 4:
      default:
         return;
      case 5:
         if(this.field_259 < 4) {
            ++this.field_259;
         }

         return;
      case 6:
         if(this.field_260 < 5) {
            ++this.field_260;
         }

      }
   }

   // $FF: renamed from: a (byte[]) void
   public final void method_285(byte[] var1) {
      if(var1 != null && var1.length != 0) {
         byte var2;
         byte var3;
         for(var2 = 0; var2 < 5; ++var2) {
            for(var3 = 0; var3 < 6; ++var3) {
               if(this.field_258[var2][var3] == -1) {
                  this.field_258[var2][var3] = 0;
               }
            }
         }

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = (byte)((var1[var2] & -16) >> 4);
            byte var4 = (byte)(var1[var2] & 15);
            if(var3 >= 0 && var3 < 5 && var4 >= 0 && var4 < 6) {
               this.field_258[var3][var4] = -1;
            }
         }

      }
   }

   // $FF: renamed from: a (byte) byte
   public static final byte method_286(byte var0) {
      return (byte)((var0 & -16) >> 4);
   }

   // $FF: renamed from: b (byte) byte
   public static final byte method_287(byte var0) {
      return (byte)(var0 & 15);
   }

   // $FF: renamed from: b (byte[]) void
   public final void method_288(byte[] var1) {
      try {
         this.field_265 = null;
         if(var1 != null && var1.length != 0) {
            Unit var2;
            byte var3;
            if((var3 = (var2 = this.method_299()).method_799()) != -1) {
               this.field_265 = new byte[(var3 << 1) + 1][(var3 << 1) + 1];

               for(short var4 = 0; var4 < var1.length; ++var4) {
                  this.field_265[var4 % ((var3 << 1) + 1)][var4 / ((var3 << 1) + 1)] = var1[var4];
               }

               byte var9 = var2.method_797();
               byte var10 = var2.method_798();

               for(byte var11 = 0; var11 < 5; ++var11) {
                  for(byte var5 = 0; var5 < 6; ++var5) {
                     byte var6 = (byte)(var11 - var9 + var3);
                     byte var7 = (byte)(var5 - var10 + var3);
                     if(var6 >= 0 && var7 >= 0 && var6 < 2 * var3 + 1 && var7 < 2 * var3 + 1 && this.field_265[var6][var7] <= var3) {
                        this.field_258[var11][var5] |= -128;
                     }
                  }
               }

            }
         }
      } catch (Exception var8) {
         SocketListener.logMessage("set unit environs: " + var8.getMessage());
      }
   }

   // $FF: renamed from: a (byte, byte, byte) void
   public final void reassureActiveUnitPosition(byte var1, byte var2, byte var3) {
      try {
         Unit var4;
         if((var4 = this.method_301(var1)) != null) {
            var4.method_809(var2);
            var4.method_808(var3);

            for(byte var8 = 0; var8 < 5; ++var8) {
               for(byte var5 = 0; var5 < 6; ++var5) {
                  if(this.field_258[var8][var5] != -1) {
                     if((byte)(this.field_258[var8][var5] & 127) == var1 && (var8 != var2 || var5 != var3)) {
                        this.field_258[var8][var5] = 0;
                        SocketListener.logMessage("BattleScreen: misplaced unit №" + String.valueOf(var1) + " found in (" + var8 + ", " + var5 + ") but must be in (" + var2 + ", " + var3 + ")");
                     } else if((byte)(this.field_258[var8][var5] & 127) != var1 && var8 == var2 && var5 == var3) {
                        this.field_258[var8][var5] = var1;
                        SocketListener.logMessage("BattleScreen: unit №" + String.valueOf(var1) + " must be in (" + var8 + ", " + var5 + ") but it wasn\'t there");
                     }
                  }
               }
            }
         }

      } catch (Exception var7) {
         SocketListener.logMessage("BattleScreen.reassureActiveUnitPosition (" + String.valueOf(var1) + ", " + var2 + ", " + var3 + ") error: " + var7.toString());
      }
   }

   // $FF: renamed from: o () void
   private void method_290() {
      this.field_265 = null;

      for(byte var1 = 0; var1 < 5; ++var1) {
         for(byte var2 = 0; var2 < 6; ++var2) {
            if(this.field_258[var1][var2] != -1 && (byte)(this.field_258[var1][var2] & -128) == -128) {
               this.field_258[var1][var2] = (byte)(this.field_258[var1][var2] & 127);
            }
         }
      }

   }

   // $FF: renamed from: c (byte[]) void
   public final void method_291(byte[] var1) {
      if(var1 != null) {
         byte var3;
         byte var2 = (byte)(((var3 = var1[0]) & -16) >> 4);
         var3 = (byte)((var3 = var1[0]) & 15);
         class_5 var10001 = new class_5(this, var1, this.field_258[var2][var3]);
         this.method_304(var10001);
      }
   }

   // $FF: renamed from: a (byte, int) void
   public final void setActiveUnit(byte var1, int var2) {
      try {
         this.field_270 = false;
         this.method_290();
         if(var1 > 0 && var1 <= 50) {
            this.field_283 = null;
            if(!this.field_261) {
               ++this.field_262;
               Hero.self.field_673 = Hero.self.method_882((byte)1) != null;
               if(var2 > 0) {
                  field_246 = var2;
               }

               this.field_266 = System.currentTimeMillis();
               this.field_271 = false;
               super.popupMenu.method_621(field_245, false, true, true);
            }

            this.field_261 = true;
         }

         if(var1 >= 51 && var1 <= 100) {
            if(this.field_261 || this.field_266 == 0L) {
               ++this.field_262;
               super.popupMenu.method_621(field_245, true, true, true);
               field_246 = var2;
               this.field_266 = System.currentTimeMillis();
            }

            this.field_261 = false;
         }

         Unit var4;
         if((var4 = this.method_299()) != null) {
            var4.method_804(false);
         }

         this.field_263 = var1;
         if((var4 = this.method_301(var1)) != null) {
            var4.method_804(true);
            if(this.field_261) {
               this.field_259 = var4.method_797();
               this.field_260 = var4.method_798();
            }
         }

      } catch (Exception var3) {
         SocketListener.logMessage("setActiveUnit: " + var3.getMessage());
      }
   }

   // $FF: renamed from: b () void
   public final void method_293() {
      byte var2;
      for(byte var1 = 0; var1 < 5; ++var1) {
         for(var2 = 0; var2 < 6; ++var2) {
            byte var3;
            if((var3 = (byte)(this.field_258[var1][var2] & 127)) > 0 && var3 <= 50) {
               this.field_258[var1][var2] = 0;
            }
         }
      }

      Unit[] var4;
      if((var4 = Hero.self.method_880()) != null && var4.length > 0) {
         for(var2 = 0; var2 < var4.length; ++var2) {
            if(var4[var2] != null) {
               this.field_258[var4[var2].getUnitPlace()][5] = (byte)(var2 + 1);
               var4[var2].method_809(var2);
               var4[var2].method_808((byte)5);
            }
         }
      }

   }

   // $FF: renamed from: c () void
   public final void method_294() {
      byte var2;
      for(byte var1 = 0; var1 < 5; ++var1) {
         for(var2 = 0; var2 < 6; ++var2) {
            byte var3;
            if((var3 = (byte)(this.field_258[var1][var2] & 127)) >= 51 && var3 <= 100) {
               this.field_258[var1][var2] = 0;
            }
         }
      }

      if(this.hero != null) {
         Unit[] var4 = this.hero.method_880();

         for(var2 = 0; var2 < var4.length; ++var2) {
            if(var4[var2] != null) {
               this.field_258[5 - var4[var2].getUnitPlace() - 1][0] = (byte)(var2 + 51);
               var4[var2].method_809((byte)(5 - var4[var2].getUnitPlace() - 1));
               var4[var2].method_808((byte)0);
            }
         }
      }

   }

   // $FF: renamed from: a (byte, byte) byte[]
   private byte[] method_295(byte b, byte b2) {
      try {
         final Unit a;
         if ((a = this.method_299()) == null) {
            return null;
         }
         if (b < 0 || b >= 5) {
            return null;
         }
         if (b2 < 0 || b2 >= 6) {
            return null;
         }
         a.method_807(false);
         byte[] array;
         if (this.field_265 != null && this.field_265.length > 1) {
            byte b3 = (byte)(b - a.method_797() + a.method_799());
            byte b4 = (byte)(b2 - a.method_798() + a.method_799());
            array = new byte[this.field_265[b3][b4] + 1];

            array[array.length - 1] = method_297(b, b2);
            int i = 0;
            int n = 2;
            while (i == 0) {
               i = 1;
               byte b5 = b3;
               byte b6 = b4;
               if (b3 > 0 && this.field_265[b3 - 1][b4] < this.field_265[b5][b6]) {
                  b5 = (byte)(b3 - 1);
               }
               if (b3 < a.method_799() << 1 && this.field_265[b3 + 1][b4] < this.field_265[b5][b6]) {
                  b5 = (byte)(b3 + 1);
               }
               if (b4 > 0 && this.field_265[b3][b4 - 1] < this.field_265[b5][b6]) {
                  b6 = (byte)(b4 - 1);
               }
               if (b4 < a.method_799() << 1 && this.field_265[b3][b4 + 1] < this.field_265[b5][b6]) {
                  b6 = (byte)(b4 + 1);
               }
               if (b5 != b3 || b6 != b4) {
                  if (n > array.length) {
                     continue;
                  }
                  b3 = b5;
                  b4 = b6;
                  array[array.length - n] = method_297((byte)(a.method_797() + b3 - a.method_799()), (byte)(a.method_798() + b4 - a.method_799()));
                  n = (byte)(n + 1);
                  i = 0;
               }
            }
         }
         else {
            final byte b7 = (byte)Math.abs(b - a.method_797());
            final byte b8 = (byte)Math.abs(b2 - a.method_798());
            final byte[] array2 = array = new byte[b7 + b8 + 1];
            array2[array.length - 1] = method_297(b, b2);
            byte b9 = b;
            byte b10 = b2;
            if (b7 == 0) {
               for (int j = 1; j < array.length; j = (byte)(j + 1)) {
                  if (b2 - a.method_798() > 0) {
                     --b10;
                  }
                  else {
                     ++b10;
                  }
                  array[array.length - 1 - j] = method_297(b, b10);
               }
            }
            else if (b8 == 0) {
               for (int k = 1; k < array.length; k = (byte)(k + 1)) {
                  if (b - a.method_797() > 0) {
                     --b9;
                  }
                  else {
                     ++b9;
                  }
                  array[array.length - k - 1] = method_297(b9, b2);
               }
            }
            else {
               int n2 = 0;
               for (int l = 1; l < array.length; l = (byte)(l + 1)) {
                  if ((n2 != 0 || b10 == a.method_798()) && b9 != a.method_797()) {
                     if (b - a.method_797() > 0) {
                        --b9;
                     }
                     else {
                        ++b9;
                     }
                  }
                  else if (b2 - a.method_798() > 0) {
                     --b10;
                  }
                  else {
                     ++b10;
                  }
                  n2 = ((n2 == 0) ? 1 : 0);
                  array[array.length - 1 - l] = method_297(b9, b10);
               }
            }
         }
         array[0] = method_297(a.method_797(), a.method_798());
         return array;
      }
      catch (Exception obj) {
         //new class_72().method_727("getStep " + obj);
         return null;
      }
   }

   // $FF: renamed from: a (byte, byte) void
   private void method_296(byte var1, byte var2) {
      byte[] var4;
      if((var4 = this.method_295(var1, var2)) != null) {
         OutputGameMessage var10001 = new OutputGameMessage(MessageProcessor.packetTypes[35], (short)(1 + var4.length), (short)0);
         this.field_283 = var10001;

         try {
            this.field_283.addToBody((byte)var4.length);
            this.field_283.addToBody(var4);
         } catch (Exception var3) {
            ;
         }

         class_5 var5 = new class_5(this, var4, this.field_263);
         this.method_304(var5);
      }

   }

   // $FF: renamed from: a (byte, byte) byte
   private static byte method_297(byte var0, byte var1) {
      return (byte)((byte)(var0 << 4 & -16) | (byte)(var1 & 15));
   }

   // $FF: renamed from: a (boolean, mobak.b.a.f, int) void
   public final void method_298(boolean var1, Unit var2, int var3) {
      Unit[] var4;
      if(var1) {
         var4 = this.field_275;
      } else {
         var4 = this.field_276;
      }

      byte var5 = -1;
      if(var4 == null) {
         var4 = new Unit[1];
      }

      for(byte var6 = 0; var6 < var4.length; ++var6) {
         if(var4[var6] == null) {
            var5 = var6;
            break;
         }
      }

      if(var5 < 0) {
         var5 = (byte)var4.length;
         Unit[] var7 = new Unit[var4.length + 1];
         System.arraycopy(var4, 0, var7, 0, var4.length);
         var4 = var7;
      }

      var4[var5] = var2;
      field_246 += var3;
      if(var1) {
         this.field_275 = var4;
         this.field_258[var2.method_797()][var2.method_798()] = (byte)(var2.getUnitPlace() + 1);
      } else {
         this.field_276 = var4;
         this.field_258[var2.method_797()][var2.method_798()] = (byte)(var2.getUnitPlace() + 51);
      }
   }

   // $FF: renamed from: a () mobak.b.a.f
   private Unit method_299() {
      if(this.field_263 <= 0) {
         return null;
      } else {
         try {
            return this.method_301(this.field_263);
         } catch (Exception var2) {
            SocketListener.logMessage("cannot get active group: " + var2);
            return null;
         }
      }
   }

   // $FF: renamed from: a (byte) boolean
   private boolean method_300(byte var1) {
      try {
         return this.method_301(var1) != null;
      } catch (Exception var2) {
         return false;
      }
   }

   // $FF: renamed from: a (byte) mobak.b.a.f
   public final Unit method_301(byte var1){
      if(var1 > 0 && var1 <= 5) {
         return Hero.self.method_878((byte)(var1 - 1));
      } else if(var1 > 5 && var1 <= 50) {
         if(this.field_275 != null) {
            return this.field_275[var1 - 6];
         }
      } else if(var1 >= 51 && var1 <= 55) {
         return this.hero.method_878((byte)(var1 - 51));
      } else if(var1 > 55 && var1 <= 100) {
         if(this.field_276 != null) {
            return this.field_276[var1 - 56];
         }
      } else {
         //throw new Exception("5 bad unit index " + var1);
      }
      return null;
   }

   // $FF: renamed from: a (byte, byte, boolean) byte
   private byte method_302(byte b, byte b2, boolean b3) {
      try {
         if (!this.field_261) {
            return (byte)-1;
         }
         final Unit type;
         if ((type = this.method_299()) == null) {
            return (byte)-1;
         }
         if (!b3) {
            if (b < 0 || b2 < 0) {
               return (byte)-1;
            }
            if (b >= 5 || b2 >= 6) {
               return (byte)-1;
            }
            if (type.method_799() == -1 || this.field_265 == null) {
               if (b == type.method_797() && b2 == type.method_798()) {
                  return (byte)0;
               }
               if ((this.field_258[b][b2] & 0x7F) == 0x0) {
                  return (byte)((byte)Math.abs(b - type.method_797()) + (byte)Math.abs(b2 - type.method_798()) + 1);
               }
               return (byte)-1;
            }
            else {
               final byte b4 = (byte)(b - type.method_797() + type.method_799());
               final byte b5 = (byte)(b2 - type.method_798() + type.method_799());
               if (b4 < 0 || b4 >= this.field_265.length) {
                  return (byte)-1;
               }
               if (b5 < 0 || b5 >= this.field_265[b4].length) {
                  return (byte)-1;
               }
               return this.field_265[b4][b5];
            }
         }
         else {
            final byte[] array2;
            final byte[] array = array2 = new byte[] { 127, 127, 127, 127 };
            array[0] = this.method_302((byte)(b - 1), b2, false);
            array2[1] = this.method_302(b, (byte)(b2 + 1), false);
            array2[2] = this.method_302((byte)(b + 1), b2, false);
            array2[3] = this.method_302(b, (byte)(b2 - 1), false);
            int n = 0;
            if (array2[1] >= 0 && (array2[1] < array2[0] || array2[0] < 0)) {
               n = 1;
            }
            if (array2[2] >= 0 && (array2[2] < array2[n] || array2[n] < 0)) {
               n = 2;
            }
            if (array2[3] >= 0 && (array2[3] < array2[n] || array2[n] < 0)) {
               n = 3;
            }
            if (array2[n] < 0 || array2[n] >= 127) {
               return (byte)-1;
            }
            if (type.method_799() == -1) {
               return array2[n];
            }
            if (array2[n] <= type.method_799()) {
               return array2[n];
            }
            return (byte)-1;
         }
      }
      catch (Exception obj) {
         return (byte)-1;
      }
   }

   // $FF: renamed from: p () void
   private void method_303() throws Exception {
      Unit var1;
      if((var1 = this.method_299()) != null) {
         boolean var2 = true;
         boolean var3 = false;
         Unit[] var4 = this.hero.method_880();
         byte var5;
         if(var1.method_803()) {
            for(var5 = 0; var5 < var4.length; ++var5) {
               if(var4[var5] != null && (Math.abs(var4[var5].method_797() - var1.method_797()) == 1 && var4[var5].method_798() == var1.method_798() || Math.abs(var4[var5].method_798() - var1.method_798()) == 1 && var4[var5].method_797() == var1.method_797())) {
                  var2 = false;
                  break;
               }
            }

            if(this.field_276 != null) {
               for(int var9 = 0; var9 < this.field_276.length; ++var9) {
                  if(this.field_276[var9] != null && (Math.abs(this.field_276[var9].method_797() - var1.method_797()) == 1 && this.field_276[var9].method_798() == var1.method_798() || Math.abs(this.field_276[var9].method_798() - var1.method_798()) == 1 && this.field_276[var9].method_797() == var1.method_797())) {
                     var2 = false;
                     break;
                  }
               }
            }
         }

         label167: {
            if(!var2 || !var1.method_803()) {
               var5 = (byte)(this.field_258[this.field_259][this.field_260] & 127);
               if(this.method_301(var5) == null) {
                  return;
               }

               byte var6 = 0;
               if((Math.abs(this.method_299().method_797() - this.field_259) != 1 || this.method_299().method_798() != this.field_260) && (Math.abs(this.method_299().method_798() - this.field_260) != 1 || this.method_299().method_797() != this.field_259)) {
                  var6 = this.method_302(this.field_259, this.field_260, true);
               }

               if(var6 != 0) {
                  byte[] var7;
                  (var7 = new byte[]{(byte)127, (byte)127, (byte)127, (byte)127})[0] = this.method_302((byte)(this.field_259 - 1), this.field_260, false);
                  var7[1] = this.method_302(this.field_259, (byte)(this.field_260 + 1), false);
                  var7[2] = this.method_302((byte)(this.field_259 + 1), this.field_260, false);
                  var7[3] = this.method_302(this.field_259, (byte)(this.field_260 - 1), false);
                  byte var8 = 0;
                  if(var7[1] > 0 && (var7[1] < var7[0] || var7[0] < 0)) {
                     var8 = 1;
                  }

                  if(var7[2] > 0 && (var7[2] < var7[var8] || var7[var8] < 0)) {
                     var8 = 2;
                  }

                  if(var7[3] > 0 && (var7[3] < var7[var8] || var7[var8] < 0)) {
                     var8 = 3;
                  }

                  if(var7[var8] <= 0) {
                     break label167;
                  }

                  switch(var8) {
                  case 0:
                     this.method_296((byte)(this.field_259 - 1), this.field_260);
                     break;
                  case 1:
                     this.method_296(this.field_259, (byte)(this.field_260 + 1));
                     break;
                  case 2:
                     this.method_296((byte)(this.field_259 + 1), this.field_260);
                     break;
                  case 3:
                     this.method_296(this.field_259, (byte)(this.field_260 - 1));
                  }
               }
            }

            var3 = true;
         }

         if(var3) {
            if(this.field_283 == null) {
               OutputGameMessage var10001 = new OutputGameMessage(MessageProcessor.packetTypes[37], (short)50, (short)0);
               this.field_283 = var10001;
            } else {
               this.field_283.addToBody((byte)1);
            }

            this.field_283.addToBody((byte)(this.field_263 - 1));
            this.field_283.addToBody(this.field_259);
            this.field_283.addToBody(this.field_260);
            SocketListener.self.sendCommand(this.field_283);
            this.field_265 = null;
            this.field_283 = null;
            this.method_299().method_804(false);
            this.method_290();
            this.field_263 = -1;
         }

      }
   }

   // $FF: renamed from: a (mobak.b.b.c) void
   private void method_304(class_2 var1) {
      if(var1 != null) {
         this.field_272[this.field_273] = var1;
         ++this.field_273;
         if(this.field_273 >= this.field_272.length) {
            this.field_273 = 0;
         }

         this.method_43((byte)-1);
      }
   }

   // $FF: renamed from: a (byte, int, byte) void
   public final void method_305(byte var1, int var2, byte var3) {
      class_4 var10001 = new class_4(this, var1, var2, var3);
      this.method_304(var10001);
   }

   // $FF: renamed from: b (byte) void
   public final void method_306(byte var1) {
      if(1 == this.field_277) {
         this.field_277 = 0;
         this.field_270 = false;
      }

   }

   // $FF: renamed from: a (boolean, byte, byte) void
   public final void method_307(boolean var1, byte var2, byte var3) {
      Image var4;
      if(var1) {
         var4 = GlobalStorage.getImage(GlobalStorage.method_711("magic_success.png"));
      } else {
         var4 = GlobalStorage.getImage(GlobalStorage.method_711("magic_failure.png"));
      }

      class_3 var10001;
      if(var2 == -1 && var3 == -1) {
         var10001 = new class_3(this, var4, this.method_280(this.field_279), (short)(this.method_282(this.field_280) - 45));
         this.method_304(var10001);
      } else {
         var10001 = new class_3(this, var4, this.method_280(var2), (short)(this.method_282(var3) - 45));
         this.method_304(var10001);
      }
   }

   // $FF: renamed from: a (byte, byte, byte, byte) void
   public final void method_308(byte var1, byte var2, byte var3, byte var4) {
      byte var5 = (byte)(this.field_258[var1][var2] & 127);
      this.field_258[var1][var2] &= -128;
      this.field_258[var3][var4] |= var5;
   }

   // $FF: renamed from: d (int, int) boolean
   private boolean method_309(int var1, int var2) {
      if(var1 >= method_281() && var2 >= this.method_283()) {
         if(var1 <= method_281() + 255 && var2 <= this.method_283() + 315) {
            byte var3 = (byte)((var1 - method_281()) / 51);
            byte var4 = (byte)((var2 - this.method_283()) / 45);
            if(var3 < 0) {
               var3 = 0;
            }

            if(var3 >= 5) {
               var3 = 4;
            }

            if(var4 < 0) {
               var4 = 0;
            }

            if(var4 >= 6) {
               var4 = 5;
            }

            this.field_259 = var3;
            this.field_260 = var4;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (int, int, int) boolean
   protected final boolean method_61(int var1, int var2, int var3) {
      return false;
   }

   // $FF: renamed from: a (int, int) boolean
   protected final boolean method_59(int var1, int var2) {
      this.method_309(var1, var2);
      this.method_51();
      return true;
   }

   // $FF: renamed from: b (int, int, int) boolean
   protected final boolean method_60(int var1, int var2, int var3) {
      this.method_309(var1, var2);
      this.method_51();
      if(!PopupMenu.method_624(var1, var2) && !PopupMenu.method_625(var1, var2) && !super.popupMenu.method_612() && !super.popupMenu.method_613()) {
         this.method_36();
      }

      return true;
   }

   // $FF: renamed from: b (int, int) boolean
   protected final boolean method_62(int var1, int var2) {
      return this.method_59(var1, var2);
   }

   // $FF: renamed from: a (mobak.b.b.a, byte) byte
   static byte method_310(BattleScreen var0, byte var1) {
      return (byte)(var1 & 127);
   }

   // $FF: renamed from: a (mobak.b.b.a, byte) boolean
   static boolean method_311(BattleScreen var0, byte var1) {
      return var0.method_300(var1);
   }

   // $FF: renamed from: a (mobak.b.b.a) byte[][]
   static byte[][] method_312(BattleScreen var0) {
      return var0.field_258;
   }

   // $FF: renamed from: a (mobak.b.b.a, byte) short
   static short method_313(BattleScreen var0, byte var1) {
      return var0.method_280(var1);
   }

   // $FF: renamed from: b (mobak.b.b.a, byte) short
   static short method_314(BattleScreen var0, byte var1) {
      return var0.method_282(var1);
   }

   // $FF: renamed from: a (mobak.b.b.a, byte, mobak.b.a.f) void
   static void method_315(BattleScreen var0, byte var1, Unit var2) {
      var2 = null;
      if(var1 > 0 && var1 <= 5) {
         Hero.self.setUnit((byte)(var1 - 1), var2);
      } else {
         if(var1 > 5 && var1 <= 50) {
            if(var0.field_275 != null && var0.field_275.length > var1 - 6) {
               var0.field_275[var1 - 6] = var2;
               return;
            }
         } else {
            if(var1 >= 51 && var1 <= 55) {
               var0.hero.setUnit((byte)(var1 - 51), var2);
               return;
            }

            if(var1 > 55 && var1 <= 100 && var0.field_276 != null && var0.field_276.length > var1 - 56) {
               var0.field_276[var1 - 56] = var2;
            }
         }

      }
   }

   // $FF: renamed from: a (mobak.b.b.a, byte) void
   static void method_316(BattleScreen var0, byte var1) {
      var1 = var1;
      var0 = var0;

      for(byte var2 = 0; var2 < 5; ++var2) {
         for(byte var3 = 0; var3 < 6; ++var3) {
            if((byte)(var0.field_258[var2][var3] & 127) == var1) {
               var0.field_258[var2][var3] &= -128;
               return;
            }
         }
      }

   }

   // $FF: renamed from: <clinit> () void
   static{
      field_245 = new byte[]{(byte)2, (byte)58, (byte)53, (byte)54};
      field_246 = 0;
   }
}

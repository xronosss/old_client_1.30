package mobak.b.b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import mobak.CanvasDrawerStoppedListener;
import mobak.Main2;
import mobak.GlobalStorage;
import mobak.class_71;
import mobak.class_73;
import mobak.a.SocketListener;
import mobak.b.a.Thing;
import mobak.b.a.Hero;
import mobak.b.b.a.MenuScreen;
import mobak.b.b.a.MainMenuScreen;
import mobak.b.b.a.PopupMenu;
import mobak.c.NotifyLabel;
import mobak.c.MessagesContainer;

// $FF: renamed from: mobak.b.b.m
public final class ScreenDrawer extends GameCanvas implements Runnable {

   // $FF: renamed from: a mobak.b.b.m
   public static ScreenDrawer self;
   // $FF: renamed from: a boolean
   private boolean field_287;
   // $FF: renamed from: a byte
   private byte field_288;
   // $FF: renamed from: a java.lang.String[]
   private String[] field_289;
   // $FF: renamed from: b java.lang.String[]
   private String[] field_290;
   // $FF: renamed from: a short[]
   private short[] field_291;
   // $FF: renamed from: b boolean
   private boolean field_292;
   // $FF: renamed from: a mobak.b.a.a[]
   public static Thing[] field_293;
   // $FF: renamed from: a short
   private static short field_294;
   // $FF: renamed from: b short
   private static short field_295;
   // $FF: renamed from: c short
   private static short field_296;
   // $FF: renamed from: d short
   private static short field_297;
   // $FF: renamed from: b short[]
   private static short[] field_298;
   // $FF: renamed from: e short
   private static short field_299;
   // $FF: renamed from: f short
   private static short field_300;
   // $FF: renamed from: g short
   private static short field_301;
   // $FF: renamed from: h short
   private static short field_302;
   // $FF: renamed from: i short
   private static short field_303;
   // $FF: renamed from: j short
   private static short field_304;
   // $FF: renamed from: b int
   private static int field_305;
   // $FF: renamed from: c int
   private static int field_306;
   // $FF: renamed from: d int
   private static int field_307;
   // $FF: renamed from: e int
   private static int field_308;
   // $FF: renamed from: b byte
   private byte field_309;
   // $FF: renamed from: a mobak.b.b.a.f
   public MainMenuScreen menuScreen;
   // $FF: renamed from: a mobak.b.b.p
   public StrategicScreen strategicScreen;
   // $FF: renamed from: a mobak.b.b.a
   public BattleScreen battleScreen;
   // $FF: renamed from: a mobak.b.b.a.t[]
   private MenuScreen[] field_313;
   // $FF: renamed from: c byte
   private byte screenId;
   // $FF: renamed from: c boolean
   private boolean field_315;
   // $FF: renamed from: d boolean
   private boolean field_316;
   // $FF: renamed from: e boolean
   private boolean field_317;
   // $FF: renamed from: f boolean
   private boolean field_318;
   // $FF: renamed from: g boolean
   private boolean field_319;
   // $FF: renamed from: a mobak.b.b.q
   private class_55 field_320;
   // $FF: renamed from: a java.util.Vector
   private static Vector field_321;
   // $FF: renamed from: h boolean
   private static boolean field_322;
   // $FF: renamed from: a int
   public static int field_323;
   // $FF: renamed from: i boolean
   private static boolean field_324;
   // $FF: renamed from: j boolean
   private boolean field_325;
   // $FF: renamed from: k boolean
   private boolean field_326;
   // $FF: renamed from: a long
   private long field_327;
   // $FF: renamed from: f int
   private int field_328;
   // $FF: renamed from: g int
   private int field_329;
   // $FF: renamed from: h int
   private int field_330;
   // $FF: renamed from: l boolean
   private boolean field_331;
   // $FF: renamed from: d byte
   private byte field_332;
   // $FF: renamed from: m boolean
   private boolean field_333;
   // $FF: renamed from: b long
   private long field_334;
   // $FF: renamed from: n boolean
   private boolean field_335;
   // $FF: renamed from: a java.lang.String
   private String field_336;
   // $FF: renamed from: a java.lang.Thread
   private Thread field_337;
   // $FF: renamed from: a javax.microedition.lcdui.Graphics
   private Graphics field_338;
   // $FF: renamed from: i int
   private int field_339;
   // $FF: renamed from: o boolean
   private boolean field_340;


   // $FF: renamed from: <init> () void
   public ScreenDrawer() {
      super(false);
      this.field_287 = false;
      this.field_288 = -1;
      this.field_289 = new String[5];
      this.field_290 = new String[5];
      this.field_291 = new short[5];
      this.field_309 = 0;
      this.field_313 = new MenuScreen[10];
      this.field_315 = false;
      this.field_316 = false;
      this.field_317 = false;
      this.field_318 = false;
      this.field_319 = false;
      this.field_326 = false;
      this.field_330 = 0;
      this.field_331 = false;
      this.field_332 = 0;
      this.field_334 = System.currentTimeMillis();
      this.field_335 = false;
      this.field_336 = "";
      this.field_338 = null;
      if(field_295 == -1) {
         field_295 = GlobalStorage.method_711("bigclock.png");
      }

      if(field_296 == -1) {
         field_296 = GlobalStorage.method_711("bigclockfon.png");
      }

      this.setFullScreenMode(true);
      this.field_340 = this.hasPointerEvents();
      self = this;
      this.menuScreen = MenuScreen.initMainMenu();
      StrategicScreen var10001 = new StrategicScreen();
      this.strategicScreen = var10001;
      this.field_330 = 0;
      field_305 = 0;
      field_306 = 0;
      field_307 = this.getWidth();
      field_308 = this.getHeight();
   }

   public final void run() {
      while(!Main2.field_650 && this.field_287) {
         try {
            long var1 = System.currentTimeMillis();
            if(Display.getDisplay(Main2.self).getCurrent() == this) {
               try {
                  if(this.field_330 != 0 && (this.field_335 && var1 - this.field_334 > 500L || !this.field_335 && var1 - this.field_334 > 200L)) {
                     this.field_335 = false;
                     this.keyPressed(this.field_330);
                  }
               } catch (Exception var16) {
                  SocketListener.logMessage("key repeat error: " + var16.getMessage());
               }

               ScreenDrawer var3 = this;
               System.currentTimeMillis();
               if(this.field_338 == null) {
                  this.field_338 = this.getGraphics();
               }

               try {
                  var3.field_292 = false;
                  Screen var4;
                  if(var3.field_326 && (var4 = var3.GetScreen()) != null && !var3.method_366()) {
                     var4.method_66(var3.field_328, var3.field_329, (int)(System.currentTimeMillis() - var3.field_327));
                  }

                  byte var19 = var3.method_322();
                  byte var6 = var19;
                  ScreenDrawer var5 = var3;

                  try {
                     switch(var6) {
                     case 1:
                        if(var5.menuScreen != null && var5.menuScreen.method_52()) {
                           var5.menuScreen.method_31(var5.field_338);
                        }
                        break;
                     case 2:
                        if(var5.strategicScreen != null && var5.menuScreen.method_52()) {
                           var5.strategicScreen.method_31(var5.field_338);
                        }
                        break;
                     case 3:
                        if(var5.battleScreen != null && var5.menuScreen.method_52()) {
                           var5.battleScreen.method_31(var5.field_338);
                        }
                        break;
                     case 4:
                        if(var5.field_288 >= 0 && var5.field_313 != null && var5.field_313.length > var5.field_288 && var5.field_313[var5.field_288] != null && var5.field_313[var5.field_288].method_52()) {
                           var5.field_313[var5.field_288].method_31(var5.field_338);
                        }
                     }
                  } catch (Exception var13) {
                     SocketListener.logMessage("drawScreen: " + var13.getMessage() + " mode: " + method_361(var3.method_322()));
                     var13.printStackTrace();
                  }

                  if(var3.field_318 && method_338() == null) {
                     if(!var3.field_315) {
                        var3.field_315 = true;
                     }

                     int var7;
                     int var8;
                     int var11;
                     if(!var3.field_319) {
                        method_372(var3.field_338, GlobalStorage.getImage(field_296), 0, 0, GlobalStorage.getImage(field_296).getWidth(), GlobalStorage.getImage(field_296).getHeight(), 0, var3.getWidth() / 2, var3.getHeight() / 2, 3);
                        if(var3.field_309 >= 8) {
                           var3.field_309 = 0;
                        }

                        Image var21;
                        var7 = (var21 = GlobalStorage.getImage(field_295)).getWidth() / 8;
                        var8 = var21.getHeight();
                        method_372(var3.field_338, var21, var7 * var3.field_309, 0, var7, var8, 0, (var3.getWidth() - var7) / 2, (var3.getHeight() - var8) / 2, 0);
                        ++var3.field_309;
                     } else {
                        if(field_297 < 0) {
                           field_297 = GlobalStorage.method_711("logo.png");
                        }

                        var11 = 3342336;
                        Graphics var10 = var3.field_338;
                        var3.field_338.setColor(var11);
                        var3.field_338.fillRect(0, 0, var3.getWidth(), var3.getHeight());
                        method_370(var3.field_338, GlobalStorage.getImage(field_297), var3.getWidth() / 2, var3.getHeight() / 2, 3);
                     }

                     Graphics var22 = var3.field_338;
                     if(field_300 == -1) {
                        field_300 = GlobalStorage.method_711("progressbar_center.png");
                     }

                     if(field_301 == -1) {
                        field_301 = GlobalStorage.method_711("progressbar_right.png");
                     }

                     if(field_299 == -1) {
                        field_299 = GlobalStorage.method_711("progressbar_left.png");
                     }

                     if(field_302 == -1) {
                        field_302 = GlobalStorage.method_711("progressbar_position_center.png");
                     }

                     if(field_303 == -1) {
                        field_303 = GlobalStorage.method_711("progressbar_position_right.png");
                     }

                     if(field_304 == -1) {
                        field_304 = GlobalStorage.method_711("progressbar_position_100.png");
                     }

                     var7 = method_377(field_299);
                     short var24 = field_299;
                     var8 = GlobalStorage.getImage(field_299).getHeight();
                     int var9 = method_377(field_301);
                     var24 = field_301;
                     GlobalStorage.getImage(field_301).getHeight();
                     var24 = field_300;
                     int var25 = method_383(GlobalStorage.getImage(field_300));
                     method_371(var22, field_299, 0, var3.getHeight(), 36);
                     method_375(var22, field_300, 1, 0, var7, var3.getHeight() - (var8 - var25) / 2, var3.getWidth() - var9, true, 32);
                     method_371(var22, field_301, var3.getWidth(), var3.getHeight(), 40);
                     var25 = method_377(field_302);
                     var11 = method_378(field_302);
                     var9 = var3.getWidth() - var9;
                     int var12 = var7 + (var9 - var7) * field_294 / 100;
                     method_375(var22, field_302, 1, 0, var7 - var25, var3.getHeight() - (var8 - var11) / 2, var12, true, 32);
                     if(field_294 >= 99) {
                        method_371(var22, field_304, var9, var3.getHeight() - (var8 - method_378(field_304)) / 2, 36);
                     } else {
                        method_371(var22, field_303, var12, var3.getHeight() - (var8 - method_378(field_303)) / 2, 36);
                     }
                  }

                  if(!var3.field_316) {
                     byte var10001;
                     switch(var19) {
                     case 1:
                        var10001 = var3.menuScreen != null?var3.menuScreen.method_35():(Hero.self == null?0: Hero.self.method_932());
                        break;
                     case 2:
                        var10001 = var3.strategicScreen != null?var3.strategicScreen.method_35():(Hero.self == null?0: Hero.self.method_932());
                        break;
                     case 3:
                        var10001 = var3.battleScreen != null?var3.battleScreen.method_35():(Hero.self == null?0: Hero.self.method_932());
                        break;
                     case 4:
                        var10001 = var3.field_288 >= 0 && var3.field_313 != null && var3.field_313.length > var3.field_288 && var3.field_313[var3.field_288] != null?var3.field_313[var3.field_288].method_35():(Hero.self == null?0: Hero.self.method_932());
                        break;
                     default:
                        var10001 = Hero.self == null?0: Hero.self.method_932();
                     }

                     var6 = var10001;
                     Graphics var20 = var3.field_338;
                     class_56 var23;
                     if((var23 = method_338()) != null) {
                        if(var23.field_439 == null) {
                           method_336();
                        } else if((long)var23.field_441 > System.currentTimeMillis()) {
                           if(var23.field_440 != null) {
                              var23.field_440.LeftClick();
                           }

                           method_336();
                        } else {
                           method_329(var20, var23.field_433, var23.field_434, var23.field_435, var23.field_436);
                           if(var23.field_438 != null && var23.field_438.length() > 0) {
                              var23.field_442.method_564(var20, var23.field_438, self.getWidth() / 2, method_396() + 30, 3);
                           }

                           var23.field_439.method_484(var20, (byte)0);
                           if(var23.field_437 == 3) {
                              PopupMenu.method_590(var20, var6);
                           } else {
                              PopupMenu.method_591(var20, var6);
                           }
                        }
                     }
                  }

                  if(!var3.field_292) {
                     var3.method_355(var3.field_338);
                  }

                  if(var3.method_324() && var3.field_320 != null) {
                     var3.field_320.method_495();
                     SocketListener.self.method_536(var3.field_320);
                     var3.field_320.method_484(var3.field_338, (byte)0);
                  }

                  if(field_322) {
                     var3.field_336 = (new Date(System.currentTimeMillis())).toString();
                     var3.field_336 = var3.field_336.substring(var3.field_336.indexOf(":") - 2);
                     var3.field_336 = var3.field_336.substring(0, var3.field_336.indexOf(" "));
                     var3.field_338.setColor(0);
                     var3.field_338.fillRect(8, 5 + Screen.field_30.field_500 - Screen.field_30.field_500 / 2, Screen.field_30.method_563(var3.field_336) + 3, Screen.field_30.field_500);
                     Screen.field_30.method_564(var3.field_338, var3.field_336, 10 + Screen.field_30.method_563(var3.field_336) / 2, 5 + Screen.field_30.field_500, 3);
                  }

                  var3.flushGraphics();
               } catch (Exception var14) {
                  SocketListener.logMessage("drawScreen: " + var14.toString());
               } catch (Error var15) {
                  SocketListener.logMessage("drawScreen error: " + var15.toString());
               }

               System.currentTimeMillis();
               if(System.currentTimeMillis() - var1 > 100L) {
                  Thread.yield();
               } else {
                  Thread.sleep(100L);
               }
            }
         } catch (Exception var17) {
            ;
         } catch (Error var18) {
            ;
         }
      }

      Object var10000;
      if(class_73.field_572 == null) {
         var10000 = new class_71();
      } else {
         var10000 = class_73.field_572;
      }

      ((CanvasDrawerStoppedListener)var10000).onStopped();
      this.field_287 = false;
   }

   // $FF: renamed from: a () void
   public static void method_319() {
      if(Main2.self.method_855()) {
         Display.getDisplay(Main2.self).vibrate(500);
      }

   }

   // $FF: renamed from: b () void
   public final void method_320() {
      if(!this.field_287) {
         Display.getDisplay(Main2.self).setCurrent(this);
         this.setFullScreenMode(true);
         this.field_287 = true;
         this.field_337 = new Thread(this, "ScreenDrawer");
         this.field_337.start();
      }
   }

   // $FF: renamed from: c () void
   public final void method_321() {
      this.field_287 = false;
   }

   // $FF: renamed from: a () byte
   public final byte method_322() {
      return (byte)(this.screenId & 7);
   }

   // $FF: renamed from: e () byte
   private final byte method_323() {
      return (byte)((byte)(this.screenId >> 4) & 7);
   }

   // $FF: renamed from: g () boolean
   private boolean method_324() {
      return (byte)(this.screenId & 8) != 0;
   }

   // $FF: renamed from: a (boolean, boolean, boolean) boolean
   private static boolean method_325(boolean var0, boolean var1, boolean var2) {
      class_56 var3;
      if((var3 = method_338()) != null && var0 || var1) {
         if(var3.field_440 != null) {
            boolean var4 = false;
            if(!var2 && !var0) {
               if(var2 || var1) {
                  var4 = var3.field_440.RightClick();
               }
            } else {
               var4 = var3.field_440.LeftClick();
            }

            if(var4) {
               method_336();
            }

            return true;
         }

         if(var0) {
            method_336();
         }
      }

      return false;
   }

   protected final synchronized void keyPressed(int var1) {
      try {
         if(this.field_331) {
            if(this.field_332 == 0) {
               PopupMenu.method_631(var1);
               method_336();
               method_330(MessagesContainer.getMessage(139), MessagesContainer.getMessage(140) + MessagesContainer.getMessage(142));
               this.field_332 = 1;
               return;
            }

            if(this.field_332 == 1) {
               PopupMenu.method_632(var1);
               method_336();
               this.field_333 = true;
               class_45 var10002 = new class_45(this);
               Thread var10000 = new Thread(var10002);
               var10000.start();
               method_330(MessagesContainer.getMessage(139), MessagesContainer.getMessage(140) + MessagesContainer.getMessage(260));
               this.field_332 = 2;
               return;
            }

            if(this.field_332 == 2) {
               this.field_333 = false;
               field_323 = var1;
               method_336();
               method_330(MessagesContainer.getMessage(139), MessagesContainer.getMessage(143));
               this.field_331 = false;
               PopupMenu.method_633();
               Main2.self.rmsManager.setInt((byte)19, field_323);
               return;
            }
         }

         if(!PopupMenu.method_629(var1) && !PopupMenu.method_630(var1) && this.getGameAction(var1) != 8 && this.field_330 != var1) {
            this.field_330 = var1;
            this.field_334 = System.currentTimeMillis();
            this.field_335 = true;
         }

         Screen var2 = this.GetScreen();
         if(var1 == field_323) {
            field_322 = !field_322;
         }

         if(var1 == 48) {
            if(SocketListener.self == null) {
               return;
            }

            if(!this.method_324()) {
               class_55 var10001 = new class_55((short)0, (short)0, (short)(this.getWidth() - 5), (short)(this.getHeight() - 5), true, false);
               this.field_320 = var10001;
               SocketListener.self.method_536(this.field_320);
               this.screenId = (byte)(this.screenId | 8);
            } else {
               this.field_320 = null;
               this.screenId &= -9;
            }
         } else {
            if(!this.field_318 || !this.field_315 || this.field_317) {
               class_56 var3 = method_338();
               if(!this.field_316 && var3 != null) {
                  boolean var7 = false;
                  var7 = PopupMenu.method_629(var1) || self.getGameAction(var1) == 8;
                  boolean var4 = PopupMenu.method_630(var1);
                  if(method_325(var7, var4, false)) {
                     return;
                  }

                  if(this.getGameAction(var1) == 6) {
                     var3.field_439.method_486();
                     return;
                  }

                  if(this.getGameAction(var1) == 1) {
                     var3.field_439.method_485();
                     return;
                  }
               } else if(!this.field_315) {
                  if(var2 != null) {
                     try {
                        var2.method_32(var1);
                        return;
                     } catch (Exception var5) {
                        SocketListener.logMessage("screen.keyPressed " + var5.toString());
                     }
                  }

                  return;
               }
            }

            return;
         }
      } catch (Exception var6) {
         SocketListener.logMessage("keyPressedSD " + var6.toString());
      }

   }

   protected final void keyReleased(int var1) {
      this.field_330 = 0;
   }

   // $FF: renamed from: a () mobak.b.b.j
   public final synchronized Screen GetScreen() {
      switch(this.method_322()) {
      case 1:
         return this.menuScreen;
      case 2:
         return this.strategicScreen;
      case 3:
         return this.battleScreen;
      case 4:
         if(this.field_288 >= 0) {
            return this.field_313[this.field_288];
         }
      default:
         this.screenId = 1;
         this.menuScreen = MenuScreen.initMainMenu();
         return this.menuScreen;
      }
   }

   // $FF: renamed from: b () byte
   public final byte method_327() {
      return (byte)(this.getWidth() / 50);
   }

   // $FF: renamed from: c () byte
   public final byte method_328() {
      return (byte)(this.getHeight() / 50);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public static void method_329(Graphics var0, int var1, int var2, int var3, int var4) {
      int var5;
      if(field_298 == null) {
         field_298 = new short[GlobalStorage.field_560.length];

         for(var5 = 0; var5 < GlobalStorage.field_560.length; ++var5) {
            field_298[var5] = GlobalStorage.method_711(GlobalStorage.field_560[var5]);
         }
      }

      var5 = method_377(field_298[0]);
      short var6;
      int var8 = GlobalStorage.getImage(var6 = field_298[0]).getHeight();
      int var7 = (var4 - (var8 << 1)) / var8;
      if((var4 - (var8 << 1)) % var8 > 0) {
         ++var7;
      }

      method_371(var0, field_298[0], var1, var2, 20);
      if(var3 > var5 << 1) {
         var4 = var1 + (var3 - (var5 << 1) << 1) / 3;
         method_375(var0, field_298[9], 1, 0, var1 + var5, var2, var4, true, 16);
         method_371(var0, field_298[1], var4, var2, 20);
         method_375(var0, field_298[9], 1, 0, var4 + var5, var2, var1 + var3 - var5, true, 16);
      }

      method_371(var0, field_298[2], var1 + var3, var2, 24);

      for(var2 += var8; var7-- > 0; var2 += var8) {
         method_371(var0, field_298[var7 % 3 == 1?10:3], var1, var2, 20);
         method_375(var0, field_298[4], 1, 0, var1 + var5, var2, var1 + var3 - var5, true, 16);
         method_371(var0, field_298[var7 % 3 == 2?11:5], var1 + var3, var2, 24);
      }

      method_371(var0, field_298[6], var1, var2, 20);
      if(var3 > var5 << 1) {
         var4 = var1 + (var3 - (var5 << 1) << 1) / 3;
         method_375(var0, field_298[12], 1, 0, var1 + var5, var2, var4, true, 16);
         method_371(var0, field_298[7], var4, var2, 20);
         method_375(var0, field_298[12], 1, 0, var4 + var5, var2, var1 + var3 - var5, true, 16);
      }

      method_371(var0, field_298[8], var1 + var3, var2, 24);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) void
   public static void method_330(String var0, String var1) {
      method_335((byte)1, var0, var1, (NotifyLabel)null, -1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, mobak.c.i) void
   public static void createNotification(String title, String text, NotifyLabel var2) {
      method_335((byte)1, title, text, var2, -1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, int) void
   public static void method_332(String var0, String var1, int var2) {
      method_335((byte)1, var0, var1, (NotifyLabel)null, var2);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, mobak.c.i, int) void
   public static void method_333(String var0, String var1, NotifyLabel var2, int var3) {
      method_335((byte)1, var0, var1, var2, 15000);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, mobak.c.i) void
   public static void method_334(String var0, String var1, String var2, NotifyLabel var3) {
      if(var2 != null) {
         method_335((byte)3, var0, var1 + "\n" + var2, var3, -1);
      } else {
         method_335((byte)3, var0, var1, var3, -1);
      }
   }

   // $FF: renamed from: a (byte, java.lang.String, java.lang.String, mobak.c.i, int) void
   private static void method_335(byte var0, String var1, String var2, NotifyLabel var3, int var4) {
      if(var1 != null || var2 != null) {
         Vector var10000 = field_321;
         class_56 var10001 = new class_56(var0, var1, var2, var3, var4);
         var10000.addElement(var10001);
      }
   }

   // $FF: renamed from: o () void
   private static void method_336() {
      if(!field_321.isEmpty()) {
         field_321.removeElementAt(0);
      }

      if(field_321.isEmpty() && self != null) {
         self.field_317 = false;
      }

      if(self != null && self.strategicScreen != null) {
         self.strategicScreen.method_83(Hero.self.getPositionX(), Hero.self.getPositionY(), true);
      }

   }

   // $FF: renamed from: d () void
   public static void method_337() {
      while(!field_321.isEmpty()) {
         method_336();
      }

   }

   // $FF: renamed from: a () mobak.b.b.o
   private static class_56 method_338() {
      return field_321.isEmpty()?null:(class_56)field_321.elementAt(0);
   }

   // $FF: renamed from: a (mobak.b.b.a.f, boolean) void
   public final synchronized void method_339(MainMenuScreen var1, boolean var2) {
      ScreenDrawer var3 = this;

      for(byte var4 = 0; var4 < var3.field_313.length; ++var4) {
         var3.field_313[var4] = null;
      }

      var3.field_288 = -1;
      Screen var5;
      if((var5 = var3.GetScreen()) != null) {
         var5.helpViewInit();
      }

      System.gc();
      this.method_340(var1, var2);
   }

   // $FF: renamed from: a (mobak.b.b.a.t, boolean) void
   public final synchronized void method_340(MenuScreen var1, boolean var2) {
      if(var1 != null) {
         ++this.field_288;
         if(this.field_288 >= this.field_313.length) {
            MenuScreen[] var5 = new MenuScreen[this.field_313.length * 3 / 2];
            System.arraycopy(this.field_313, 0, var5, 0, this.field_313.length);
            this.field_313 = var5;
         }

         this.field_313[this.field_288] = var1;
         if(var2 && this.method_322() != 4) {
            if(Hero.self != null) {
               var1.setRace(Hero.self.method_932());
            }

            this.method_343((byte)4);
         } else {
            if(this.field_288 > 0) {
               var1.method_34(this.field_313[this.field_288 - 1]);
            }

            this.field_313[this.field_288].helpViewInit();
         }
      }
   }

   // $FF: renamed from: e () void
   public final synchronized void method_341() {
      if(Hero.self != null) {
         if(this.battleScreen != null) {
            this.battleScreen.setRace(Hero.self.method_932());
         }

         if(this.strategicScreen != null) {
            this.strategicScreen.setRace(Hero.self.method_932());
         }
      }

   }

   // $FF: renamed from: a () mobak.b.b.a.t
   public final MenuScreen method_342() {
      return this.field_288 < 0?null:this.field_313[this.field_288];
   }

   // $FF: renamed from: b (byte) void
   private synchronized void method_343(byte var1) {
      if(this.method_322() != 4) {
         this.screenId = (byte)(this.screenId << 4);
         this.screenId = (byte)(this.screenId | 4);
         Screen var2;
         if((var2 = this.GetScreen()) != null) {
            var2.helpViewInit();
         }

         System.gc();
      }
   }

   // $FF: renamed from: a (byte) void
   public final void setScreenId(byte var1) {
      this.screenId = var1;
      if(this.method_322() != 4) {
         this.field_288 = -1;
         if(this.method_322() != 3) {
            for(var1 = 0; var1 < this.field_313.length; ++var1) {
               this.field_313[var1] = null;
            }
         }
      }

      Screen var2;
      if((var2 = this.GetScreen()) != null) {
         var2.helpViewInit();
      }

   }

   // $FF: renamed from: f () void
   public final void method_345() {
      byte var1 = this.method_322();
      byte var2;
      if((var2 = this.method_323()) == 3 || var2 == 1 || var2 == 4 || var2 == 2) {
         var1 = (byte)(var1 << 4);
         this.screenId = (byte)(this.screenId >> 4);
         this.screenId |= var1;
         Screen var3;
         if((var3 = this.GetScreen()) != null) {
            var3.helpViewInit();
         }

      }
   }

   // $FF: renamed from: g () void
   public final synchronized void method_346() {
      this.field_313[this.field_288] = null;
      --this.field_288;
      if(this.field_288 >= 0 && this.field_313[this.field_288] != null) {
         this.field_313[this.field_288].helpViewInit();
      }

      if(this.field_288 < 0 && this.method_322() == 4) {
         this.method_345();
      }

   }

   // $FF: renamed from: a () boolean
   public final boolean method_347() {
      return this.field_318;
   }

   // $FF: renamed from: a (boolean, boolean) void
   public final void method_348(boolean var1, boolean var2) {
      this.field_319 = var1;
      var2 = true;
      this.field_315 = var2;
      this.field_309 = 0;
      field_294 = 0;
      this.field_318 = true;
   }

   // $FF: renamed from: a (short) void
   public static void method_349(short var0) {
      field_294 = var0;
   }

   // $FF: renamed from: a (boolean) void
   public final void method_350(boolean var1) {
      this.field_319 = false;
      this.field_318 = false;
      this.field_309 = 0;
      boolean var2 = false;
      this.field_315 = var2;
   }

   // $FF: renamed from: b () boolean
   public final boolean method_351() {
      return this.field_315;
   }

   // $FF: renamed from: b (boolean) void
   public final void method_352(boolean var1) {
      this.field_315 = var1;
   }

   // $FF: renamed from: h () void
   public final void method_353() {
      this.field_331 = true;
      this.field_332 = 0;
   }

   // $FF: renamed from: i () void
   public final void method_354() {
      if(this.field_337 != null) {
         this.field_287 = false;

         try {
            Thread.sleep(1000L);
         } catch (Exception var2) {
            SocketListener.logMessage("kill () " + var2.toString());
         }

         self = null;
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_355(Graphics var1) {
      if(!this.field_292) {
         this.field_292 = true;
         if(!this.method_324()) {
            for(byte var2 = 0; var2 < this.field_290.length; ++var2) {
               if(this.field_290[var2] != null) {
                  short var3 = this.field_291[var2];
                  int var4 = self.getHeight() - PopupMenu.method_583() - Screen.field_29.field_500 * (var2 + 1);
                  int var6 = 4605510;
                  var1.setColor(var6);
                  var1.fillRect(0, var4, self.getWidth(), Screen.field_29.field_500);
                  var6 = 8421504;
                  var1.setColor(var6);
                  var1.drawLine(0, var4, self.getWidth(), var4);
                  var1.drawLine(0, var4 + Screen.field_29.field_500, self.getWidth(), var4 + Screen.field_29.field_500);
                  if(this.field_289[var2] != null && !this.field_289[var2].trim().equals("")) {
                     Screen.field_29.method_564(var1, this.field_289[var2].trim() + ": ", var3, var4, 0);
                     var3 = (short)(var3 + Screen.field_29.method_563(this.field_289[var2].trim() + ": "));
                  }

                  Screen.field_26.method_564(var1, this.field_290[var2], var3, var4, 0);
                  var3 = (short)(var3 + Screen.field_26.method_563(this.field_290[var2]));
                  this.field_291[var2] = (short)(this.field_291[var2] - 5);
                  if(this.field_291[var2] + var3 < 0) {
                     this.field_290[var2] = this.field_289[var2] = null;
                     this.field_291[var2] = 0;
                  }
               }
            }
         }
      }

   }

   // $FF: renamed from: d () byte
   public final synchronized byte method_356() {
      for(byte var1 = 0; var1 < this.field_289.length; ++var1) {
         if(this.field_290[var1] == null) {
            return var1;
         }
      }

      return (byte)-1;
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String) void
   public final synchronized void method_357(String var1, String var2) {
      if(var2 != null && !var2.trim().equals("")) {
         byte var3;
         if((var3 = this.method_356()) >= 0) {
            if(var1.startsWith("\\id") && var1.indexOf(" ") > 0) {
               var1 = var1.substring(var1.indexOf(" ") + 1);
            }

            this.field_289[var3] = var1;
            if(var2.startsWith("\\id") && var2.indexOf(" ") > 0) {
               var2 = var2.substring(var2.indexOf(" ") + 1);
            }

            this.field_290[var3] = var2;
            this.field_291[var3] = (short) self.getWidth();
         }

      }
   }

   // $FF: renamed from: c () boolean
   public final boolean method_358() {
      return this.field_319;
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_359() {
      return method_361(this.method_322());
   }

   // $FF: renamed from: b () java.lang.String
   public final String method_360() {
      return method_361(this.method_323());
   }

   // $FF: renamed from: a (byte) java.lang.String
   private static String method_361(byte var0) {
      switch(var0) {
      case 1:
         return "MainMenu";
      case 2:
         return "Strategical";
      case 3:
         return "Battle";
      case 4:
         return "MenuStack";
      default:
         return "undef";
      }
   }

   // $FF: renamed from: d () boolean
   public final boolean method_362() {
      return this.field_316;
   }

   // $FF: renamed from: j () void
   public final void method_363() {
      this.field_316 = true;
   }

   // $FF: renamed from: k () void
   public final void method_364() {
      this.field_316 = false;
   }

   // $FF: renamed from: l () void
   public final void method_365() {
      this.field_317 = true;
   }

   // $FF: renamed from: e () boolean
   public final boolean method_366() {
      return !this.field_316 && method_338() != null;
   }

   protected final void pointerDragged(int var1, int var2) {
      class_56 var3;
      if((var3 = method_338()) != null) {
         var1 = var2 - this.field_339;
         if(var3.field_439.method_507()) {
            var3.field_439.method_503(var3.field_439.method_502() - var1);
            this.field_339 = var2;
         }

      } else {
         if(this.field_326 && (!this.field_318 || !this.field_315 || this.field_317)) {
            int var6 = var2;
            var2 = var1;
            Screen var5;
            if((var5 = this.GetScreen()) != null) {
               var5.method_64(var2, var6);
            }
         }

      }
   }

   protected final void pointerPressed(int var1, int var2) {
      this.field_328 = var1;
      this.field_329 = var2;
      this.field_339 = var2;
      this.field_327 = System.currentTimeMillis();
      this.field_326 = true;
      class_56 var3;
      if((var3 = method_338()) != null && var2 < this.getHeight() - PopupMenu.method_583()) {
         var3.field_439.method_506(var1, var2);
      } else {
         this.field_325 = false;
         if(!this.field_318 || !this.field_315 || this.field_317) {
            boolean var4 = PopupMenu.method_624(var1, var2);
            boolean var5 = PopupMenu.method_625(var1, var2);
            if(!this.field_316 && var3 != null) {
               ScreenDrawer var10000;
               if(var4) {
                  var10000 = self;
                  method_325(true, false, false);
                  this.field_325 = true;
                  return;
               }

               if(var5) {
                  var10000 = self;
                  method_325(false, true, false);
                  this.field_325 = true;
               }

               return;
            }

            Screen var6;
            if(!this.field_315 && (var6 = this.GetScreen()) != null) {
               var6.method_67();
               this.field_325 = var6.method_63(var1, var2);
            }
         }

      }
   }

   protected final void pointerReleased(int var1, int var2) {
      if(method_338() != null) {
         method_338().field_439.method_508();
      } else {
         this.field_326 = false;
         if(!this.field_325 && (!this.field_318 || !this.field_315 || this.field_317)) {
            Screen var4 = this.GetScreen();
            long var7 = System.currentTimeMillis();
            var4.method_65(var1, var2, (int)(var7 - this.field_327));
         }

      }
   }

   // $FF: renamed from: a (int) void
   public final void method_367(int var1) {
      this.keyPressed(this.getKeyCode(var1));
      this.getKeyCode(var1);
      this.field_330 = 0;
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public static final void method_368(Graphics var0, int var1, int var2, int var3, int var4) {
      if(self != null) {
         if(var1 == 0 && var2 == 0 && var3 == self.getWidth() && var4 == self.getHeight()) {
            field_324 = false;
         } else {
            field_324 = true;
         }
      }

      field_305 = var1;
      field_306 = var2;
      field_307 = var3;
      field_308 = var4;
      method_369(var0, var1, var2, var3, var4);
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public static final void method_369(Graphics var0, int var1, int var2, int var3, int var4) {
      if(var0 != null) {
         if(!field_324) {
            var0.setClip(var1, var2, var3, var4);
         } else {
            int var5 = 0;
            int var6 = 0;
            if(var1 >= field_305 && var1 <= field_305 + field_307) {
               var5 = Math.min(field_305 + field_307, var1 + var3);
            } else if(var1 + var3 >= field_305 && var1 + var3 <= field_305 + field_307) {
               var5 = var1 + var3;
               var1 = field_305;
            } else {
               var1 = 0;
            }

            if(var2 >= field_306 && var2 <= field_306 + field_308) {
               var6 = Math.min(field_306 + field_308, var2 + var4);
            } else if(var2 + var4 >= field_306 && var2 + var4 <= field_306 + field_308) {
               var6 = var2 + var4;
               var2 = field_306;
            } else {
               var2 = 0;
            }

            var0.setClip(var1, var2, var5 - var1, var6 - var2);
         }
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int) void
   public static final void method_370(Graphics var0, Image var1, int var2, int var3, int var4) {
      try {
         var0.drawImage(var1, var2, var3, var4);
      } catch (Exception var5) {
         SocketListener.logMessage("ScreenDrawer.drawImage(Graphics,Image,int,int,int) " + var5);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, int, int, int) void
   public static final void method_371(Graphics var0, short var1, int var2, int var3, int var4) {
      method_370(var0, GlobalStorage.getImage(var1), var2, var3, var4);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, javax.microedition.lcdui.Image, int, int, int, int, int, int, int, int) void
   public static final void method_372(Graphics var0, Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if(var0 != null && var1 != null) {
         if(var9 == 0) {
            var9 = 20;
         }

         var0.drawRegion(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, int, int, int, int, int, int) void
   public static final void method_373(Graphics var0, short var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      try {
         Image var9;
         var2 = (var9 = GlobalStorage.getImage(var1)).getWidth() / 9;
         var3 = var9.getHeight();
         method_372(var0, var9, var2 * var4, 0, var2, var3, 0, var6, var7, 0);
      } catch (Exception var8) {
         SocketListener.logMessage("drawImage: " + var8.toString());
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, int, int, int, int, int, int, int, int) void
   public static final void method_374(Graphics var0, short var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      try {
         if((var9 & 8) != 0) {
            var7 -= var4;
            var9 = (var9 &= -9) | 4;
         }

         method_372(var0, GlobalStorage.getImage(var1), var2, var3, var4, var5, 0, var7, var8, var9);
      } catch (Exception var10) {
         String var11 = GlobalStorage.method_726(var1);
         SocketListener.logMessage("drawImageShort (" + var11 + ", " + var2 + ", " + var3 + ", " + var4 + ", " + var5 + ", 0" + ", " + var7 + ", " + var8 + ", " + var9 + "): " + var10.toString());
         var10.printStackTrace();
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, int, int, int, int, int, boolean, int) void
   public static final void method_375(Graphics var0, short var1, int var2, int var3, int var4, int var5, int var6, boolean var7, int var8) {
      var2 = method_377(var1) / var2;
      int var9 = GlobalStorage.getImage(var1).getHeight();
      if(var8 == 0) {
         var8 = var7?16:4;
      }

      int var10;
      int var11;
      int var10000;
      if((var7?var4:var5) > var6) {
         var10 = var7?8:32;
         var10000 = var7?var4:var5;

         while(true) {
            var11 = var10000;
            if(var10000 < var6) {
               return;
            }

            method_374(var0, var1, var2 * var3, 0, var2, var9, 0, var7?var11:var4, var7?var5:var11, var10 | var8);
            var10000 = var11 - (var7?var2:var9);
         }
      } else {
         var10 = var7?4:16;
         var10000 = var7?var4:var5;

         while(true) {
            var11 = var10000;
            if(var10000 > var6 + 2) {
               return;
            }

            method_374(var0, var1, var2 * var3, 0, var2, var9, 0, var7?var11:var4, var7?var5:var11, var10 | var8);
            var10000 = var11 + (var7?var2:var9);
         }
      }
   }

   // $FF: renamed from: m () void
   public final void method_376() {
      Display.getDisplay(Main2.self).setCurrent(this);
   }

   // $FF: renamed from: a (short) int
   public static final int method_377(short var0) {
      return GlobalStorage.getImage(var0) != null? GlobalStorage.getImage(var0).getWidth():0;
   }

   // $FF: renamed from: b (short) int
   public static final int method_378(short var0) {
      return GlobalStorage.getImage(var0).getHeight();
   }

   public final int getGameAction(int var1) {
      try {
         return super.getGameAction(var1);
      } catch (Exception var2) {
         SocketListener.logMessage("getGameAction " + var2.toString());
         return 999;
      }
   }

   // $FF: renamed from: a (int) boolean
   public final boolean method_379(int var1) {
      return 8 == this.getGameAction(var1);
   }

   // $FF: renamed from: f () boolean
   public final boolean method_380() {
      return this.field_340;
   }

   // $FF: renamed from: a (byte[]) javax.microedition.lcdui.Image
   public static final Image load(byte[] imageBytes) {
      Image result = null;
      ByteArrayInputStream var2 = null;
      if(imageBytes != null) {
         try {
            result = Image.createImage(var2 = new ByteArrayInputStream(imageBytes));
         } catch (Exception var9) {
            SocketListener.logMessage("GlobalStorage.load() error loading from RMS");
         } finally {
            try {
               var2.close();
            } catch (IOException var8) {
               ;
            }

         }
      }

      return result;
   }

   public final int getWidth() {
      return super.getWidth();
   }

   public final int getHeight() {
      return super.getHeight();
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Image) int
   public static int method_382(Image var0) {
      return var0.getWidth();
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Image) int
   public static int method_383(Image var0) {
      return var0.getHeight();
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int) void
   public static void method_384(Graphics var0, int var1) {
      var0.setColor(var1);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) int
   public static int method_385(Graphics var0) {
      return var0.getColor();
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics) int
   public static int method_386(Graphics var0) {
      return var0.getClipX();
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics) int
   public static int method_387(Graphics var0) {
      return var0.getClipY();
   }

   // $FF: renamed from: d (javax.microedition.lcdui.Graphics) int
   public static int method_388(Graphics var0) {
      return var0.getClipWidth();
   }

   // $FF: renamed from: e (javax.microedition.lcdui.Graphics) int
   public static int method_389(Graphics var0) {
      return var0.getClipHeight();
   }

   // $FF: renamed from: a (int, int) javax.microedition.lcdui.Image
   public static final Image method_390(int var0, int var1) {
      return Image.createImage(var0, var1);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Image) javax.microedition.lcdui.Image
   public static final Image method_391(Image var0) {
      return Image.createImage(var0);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Image, int) javax.microedition.lcdui.Image
   public static final Image method_392(Image var0, int var1) {
      var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = new int[var1 * var2];
      var0.getRGB(var3, 0, var1, 0, 0, var1, var2);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         if((var3[var4] & 16777215) == 16777215) {
            var3[var4] &= 16777215;
         }
      }

      return Image.createRGBImage(var3, var1, var2, true);
   }

   // $FF: renamed from: d (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public static final void method_393(Graphics var0, int var1, int var2, int var3, int var4) {
      var0.fillArc(var1, var2, var3, var4, 0, 360);
   }

   // $FF: renamed from: e (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public static final void method_394(Graphics var0, int var1, int var2, int var3, int var4) {
      var0.fillRect(var1, var2, var3, var4);
   }

   // $FF: renamed from: a () short
   static short method_395() {
      return (short)10;
   }

   // $FF: renamed from: b () short
   static short method_396() {
      return (short)15;
   }

   // $FF: renamed from: c () short
   static short method_397() {
      return (short)(self.getWidth() - 20);
   }

   // $FF: renamed from: d () short
   static short method_398() {
      return (short)(self.getHeight() - PopupMenu.method_583() - 15 - 10);
   }

   // $FF: renamed from: a (mobak.b.b.m) boolean
   static boolean method_399(ScreenDrawer var0) {
      return var0.field_333;
   }

   // $FF: renamed from: n () void
   static void method_400() {
      method_336();
   }

   // $FF: renamed from: a (mobak.b.b.m, boolean) boolean
   static boolean method_401(ScreenDrawer var0, boolean var1) {
      return var0.field_331 = false;
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_294 = 0;
      field_295 = -1;
      field_296 = -1;
      field_297 = -1;
      field_298 = null;
      field_299 = -1;
      field_300 = -1;
      field_301 = -1;
      field_302 = -1;
      field_303 = -1;
      field_304 = -1;
      field_321 = new Vector(10);
      field_322 = false;
      field_323 = 49;
   }
}

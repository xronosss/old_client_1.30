package mobak.b.b;

import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import mobak.Main2;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.c.class_1;
import mobak.c.MessagesContainer;
import mobak.c.class_64;

// $FF: renamed from: mobak.b.b.g
public final class FormCreator implements CommandListener, ItemStateListener {

   // $FF: renamed from: a java.util.Vector
   private Vector field_371;
   // $FF: renamed from: a javax.microedition.lcdui.Form
   private Form field_372;
   // $FF: renamed from: a mobak.c.c[]
   private class_64[] field_373;
   // $FF: renamed from: a javax.microedition.lcdui.Command
   private Command field_374;
   // $FF: renamed from: b javax.microedition.lcdui.Command
   private Command field_375;
   // $FF: renamed from: a short
   private short field_376;
   // $FF: renamed from: b short
   private short field_377;
   // $FF: renamed from: b java.util.Vector
   private Vector field_378;
   // $FF: renamed from: c java.util.Vector
   private Vector field_379;
   // $FF: renamed from: d java.util.Vector
   private Vector field_380;
   // $FF: renamed from: e java.util.Vector
   private Vector field_381;
   // $FF: renamed from: a mobak.c.b
   private class_1 field_382;
   // $FF: renamed from: a javax.microedition.lcdui.Alert
   private Alert field_383;
   // $FF: renamed from: a int
   private int field_384;


   // $FF: renamed from: <init> (java.lang.String, mobak.c.b) void
   public FormCreator(String var1, class_1 var2) {
      super();
      this.field_384 = 0;
      this.field_372 = new Form(var1);
      this.field_372.setCommandListener(this);
      this.field_372.setItemStateListener(this);
      this.field_378 = new Vector();
      this.field_379 = new Vector();
      this.field_381 = new Vector();
      this.field_380 = new Vector();
      this.field_382 = var2;
   }

   // $FF: renamed from: <init> (mobak.c.c[], java.lang.String, short, short) void
   public FormCreator(class_64[] var1, String var2, short var3, short var4) {
      super();
      this.field_384 = 0;
      this.field_373 = var1;
      this.field_372 = new Form(var2);
      this.field_374 = new Command(MessagesContainer.getLine(34), 4, 0);
      this.field_375 = new Command("ok", 4, 0);
      this.field_372.addCommand(this.field_374);
      this.field_372.addCommand(this.field_375);
      this.field_372.setCommandListener(this);

      for(int var5 = 0; var5 < this.field_373.length; ++var5) {
         this.method_459(this.field_373[var5]);
      }

      Display.getDisplay(Main2.self).setCurrent(this.field_372);
      this.field_376 = var3;
      this.field_377 = var4;
   }

   // $FF: renamed from: a () int
   public final int method_439() {
      return this.field_384;
   }

   // $FF: renamed from: a (int) void
   public final void method_440(int var1) {
      this.field_384 = var1;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, int, int) void
   public final void createLabel(String var1, String var2, int var3, int var4) {
      TextField var5 = new TextField(var1, var2, var3, var4);
      this.field_378.addElement(var5);
      this.field_372.append(var5);
      this.field_372.setCommandListener(this);
   }

   // $FF: renamed from: b () int
   public final int method_442() {
      return this.field_378.size();
   }

   // $FF: renamed from: a (int) java.lang.String
   public final String method_443(int var1) {
      return ((TextField)this.field_378.elementAt(var1)).getString();
   }

   // $FF: renamed from: a (java.lang.String, int, java.lang.String[], boolean[]) void
   public final void method_444(String var1, int var2, String[] var3, boolean[] var4) {
      ChoiceGroup var5 = new ChoiceGroup(var1, var2);

      for(var2 = 0; var2 < var3.length; ++var2) {
         var5.append(var3[var2], (Image)null);
      }

      if(var4 != null) {
         var5.setSelectedFlags(var4);
      }

      this.field_379.addElement(var5);
      this.field_372.append(var5);
   }

   // $FF: renamed from: a (int, int) boolean
   public final boolean method_445(int var1, int var2) {
      return ((ChoiceGroup)this.field_379.elementAt(0)).isSelected(var2);
   }

   // $FF: renamed from: a (java.lang.String) javax.microedition.lcdui.Gauge
   public final Gauge method_446(String var1) {
      Object var2 = null;

      for(int var3 = 0; var3 < this.field_371.size(); ++var3) {
         if(((Gauge)this.field_371.elementAt(var3)).getLabel().equals(var1)) {
            var2 = this.field_371.elementAt(var3);
            break;
         }
      }

      return (Gauge)var2;
   }

   // $FF: renamed from: a (int) int
   public final int method_447(int var1) {
      return ((ChoiceGroup)this.field_379.elementAt(var1)).getSelectedIndex();
   }

   // $FF: renamed from: c () int
   public final int method_448() {
      return this.field_379.size();
   }

   // $FF: renamed from: b (int) void
   public final void method_449(int var1) {
      if(this.field_379 != null && this.field_379.size() > 1) {
         ChoiceGroup var2 = (ChoiceGroup)this.field_379.elementAt(1);
         this.field_379.removeElementAt(1);

         for(var1 = 0; var1 <= this.field_372.size(); ++var1) {
            if(this.field_372.get(var1) == var2) {
               this.field_372.delete(var1);
               return;
            }
         }

      }
   }

   // $FF: renamed from: c (int) void
   public final void method_450(int var1) {
      if(this.field_381.size() > 1) {
         StringItem var2 = (StringItem)this.field_381.elementAt(1);
         this.field_381.removeElementAt(1);

         for(var1 = 0; var1 <= this.field_372.size(); ++var1) {
            if(this.field_372.get(var1) == var2) {
               this.field_372.delete(var1);
               return;
            }
         }

      }
   }

   // $FF: renamed from: a () void
   public final void setCurrentFormAsMain() {
      Display.getDisplay(Main2.self).setCurrent(this.field_372);
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void addCommand(String var1) {
      Command var2 = new Command(var1, 4, 0);
      this.field_380.addElement(var2);
      this.field_372.addCommand(var2);
   }

   // $FF: renamed from: a (java.lang.String, int) void
   public final void addCommandAtIndex(String var1, int var2) {
      Command var5 = new Command(var1, var2 == 1?2:4, 0);
      if(this.field_380.size() < var2) {
         int var3 = var2 - this.field_380.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            this.field_380.addElement((Object)null);
         }
      }

      if(this.field_380.size() == var2) {
         this.field_380.insertElementAt(var5, var2);
      } else {
         this.field_380.setElementAt(var5, var2);
      }

      this.field_372.addCommand(var5);
   }

   // $FF: renamed from: d (int) void
   public final void method_454(int var1) {
      this.field_372.removeCommand((Command)this.field_380.elementAt(0));
      this.field_380.setElementAt((Object)null, 0);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) void
   public final void addStringItem(String var1, String var2) {
      StringItem var3 = new StringItem(var1, var2);
      this.field_381.addElement(var3);
      this.field_372.append(var3);
   }

   // $FF: renamed from: a (int, java.lang.String) void
   public final void method_456(int var1, String var2) {
      try {
         ((StringItem)this.field_381.elementAt(0)).setText(var2);
      } catch (ArrayIndexOutOfBoundsException var3) {
         SocketListener.logMessage("There\'s no label with index " + String.valueOf(0) + ", " + var3.toString());
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, int) void
   public final void method_457(String var1, String var2, int var3) {
      String var10001 = var1;
      boolean var5 = true;
      AlertType var10003;
      switch(4) {
      case 1:
         var10003 = AlertType.ALARM;
         break;
      case 2:
      default:
         var10003 = AlertType.CONFIRMATION;
         break;
      case 3:
         var10003 = AlertType.INFO;
         break;
      case 4:
         var10003 = AlertType.WARNING;
      }

      AlertType var4 = var10003;
      String var6 = var2;
      var2 = var10001;
      this.field_383 = new Alert(var2, var6, (Image)null, var4);
      this.field_374 = new Command(MessagesContainer.getLine(34), 2, 0);
      this.field_383.addCommand(this.field_374);
      this.field_383.setCommandListener(this);
      this.field_383.setTimeout(-2);
      Display.getDisplay(Main2.self).setCurrent(this.field_383);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, javax.microedition.lcdui.AlertType, java.lang.String) void
   public final void method_458(String var1, String var2, AlertType var3, String var4) {
      this.field_383 = new Alert(var1, var2, (Image)null, var3);
      this.field_374 = new Command(MessagesContainer.getLine(34), 2, 0);
      this.field_383.addCommand(this.field_374);
      this.field_383.addCommand(new Command(var4, 4, 0));
      this.field_383.setCommandListener(this);
      this.field_383.setTimeout(-2);
      Display.getDisplay(Main2.self).setCurrent(this.field_383);
   }

   // $FF: renamed from: a (mobak.c.c) void
   private void method_459(class_64 var1) {
      switch(var1.field_505) {
      case 1:
         this.field_372.append(var1.field_506);
         this.field_372.append(new TextField(MessagesContainer.getLine(235), String.valueOf(var1.field_509), 10, 5));
         this.field_372.append(new TextField(MessagesContainer.getLine(236), String.valueOf(var1.field_510), 10, 5));
         return;
      case 2:
         String[] var2 = var1.field_507;
         boolean[] var3 = var1.field_508;
         ChoiceGroup var5 = new ChoiceGroup(var1.field_506, 2);

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var5.append(var2[var4], (Image)null);
         }

         var5.setSelectedFlags(var3);
         this.field_372.append(var5);
         return;
      case 3:
         this.field_372.append(new TextField(var1.field_506, var1.field_511, 10, 0));
      default:
      }
   }

   public final void commandAction(Command var1, Displayable var2) {
      if(var2 == this.field_383) {
         this.setCurrentFormAsMain();
         if(var1 != this.field_374) {
            this.field_382.method_3();
         }

         this.field_383 = null;
      }

      if(var1 == this.field_374) {
         Display.getDisplay(Main2.self).setCurrent(ScreenDrawer.self);
         ScreenDrawer.self.method_350(true);
      }

      int var10;
      if(var1 == this.field_375) {
         try {
            var10 = 0;
            OutputGameMessage var10000 = new OutputGameMessage(this.field_376);
            OutputGameMessage var3 = var10000;
            var10000.setNextCommandType(this.field_377);

            label74:
            for(int var4 = 0; var4 < this.field_373.length; ++var4) {
               int var5;
               int var13;
               switch(this.field_373[var4].field_505) {
               case 1:
                  ++var10;
                  String var15 = ((TextField)this.field_372.get(var10++)).getString();
                  String var11;
                  if((var11 = ((TextField)this.field_372.get(var10++)).getString()).length() > 0 && var15.length() > 0) {
                     var13 = Integer.parseInt(var15);
                     var5 = Integer.parseInt(var11);
                     if(var13 < var5) {
                        var3.addToBody(this.field_373[var4].field_504);
                        var3.addToBody(var13);
                        var3.addToBody(var5);
                     }
                  }
                  break;
               case 2:
                  ChoiceGroup var12 = (ChoiceGroup)this.field_372.get(var10++);
                  boolean[] var7 = new boolean[var5 = this.field_373[var4].field_507.length];
                  if((var13 = var12.getSelectedFlags(var7)) > 0) {
                     var3.addToBody(this.field_373[var4].field_504);
                     var3.addToBody((byte)var13);
                     byte var14 = 0;

                     while(true) {
                        if(var14 >= var5) {
                           continue label74;
                        }

                        if(var7[var14]) {
                           var3.addToBody(var14);
                        }

                        ++var14;
                     }
                  } else {
                     var3.addToBody(this.field_373[var4].field_504);
                     var3.addToBody((byte)0);
                     break;
                  }
               case 3:
                  TextField var6;
                  if((var6 = (TextField)this.field_372.get(var10++)).getString().trim().length() > 0) {
                     var3.addToBody(this.field_373[var4].field_504);
                     var3.addToBody(var6.getString().trim());
                  }
               }
            }

            SocketListener.self.sendCommand(var3);
            Display.getDisplay(Main2.self).setCurrent(ScreenDrawer.self);
            return;
         } catch (Exception var9) {
            SocketListener.method_523(var9);
         }
      }

      for(var10 = 0; this.field_380 != null && var10 < this.field_380.size(); ++var10) {
         if(var1 == this.field_380.elementAt(var10)) {
            this.field_382.onButtonClick(var10);
            return;
         }
      }

   }

   public final void itemStateChanged(Item var1) {
      for(int var2 = 0; var2 < this.field_379.size(); ++var2) {
         if(this.field_379.elementAt(var2) == var1) {
            this.field_382.method_4(var2);
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, int, int) void
   public final void method_460(String var1, int var2, int var3) {
      Gauge var4 = new Gauge(var1, true, 5, var3);
      if(this.field_371 == null) {
         this.field_371 = new Vector();
      }

      this.field_371.addElement(var4);
      this.field_372.append(var4);
   }
}

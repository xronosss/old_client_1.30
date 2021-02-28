package mobak.a;

import java.io.IOException;
import java.io.OutputStream;
import mobak.Main2;
import mobak.a.a.OutputGameMessage;

// $FF: renamed from: mobak.a.d
final class class_61 implements Runnable {

   // $FF: renamed from: a java.lang.String
   private String field_482;
   // $FF: renamed from: a byte[][]
   private byte[][] commands;
   // $FF: renamed from: a byte
   private byte lastCommandIndex;
   // $FF: renamed from: b byte
   private byte field_485;
   // $FF: renamed from: c int
   private int field_486;
   // $FF: renamed from: d int
   private int field_487;
   // $FF: renamed from: e int
   private int field_488;
   // $FF: renamed from: c byte
   private byte field_489;
   // $FF: renamed from: a short
   private short field_490;
   // $FF: renamed from: a java.lang.Thread
   private Thread field_491;
   // $FF: renamed from: a java.io.OutputStream
   private OutputStream field_492;
   // $FF: renamed from: a int
   public int commandLength;
   // $FF: renamed from: b int
   public int packageSent;
   // $FF: renamed from: a mobak.a.a
   private final SocketListener field_495;


   // $FF: renamed from: <init> (mobak.a.a, java.io.OutputStream) void
   public class_61(SocketListener var1, OutputStream var2) {
      super();
      this.field_495 = var1;
      this.field_482 = new String(new byte[]{(byte)1});
      this.commands = new byte[5][0];
      this.lastCommandIndex = 0;
      this.field_486 = 0;
      this.field_487 = 0;
      this.field_488 = 0;
      this.field_490 = 1;
      this.commandLength = 0;
      this.packageSent = 0;
   }

   // $FF: renamed from: a (java.io.OutputStream) void
   public final void method_557(OutputStream var1) {
      this.field_492 = var1;
      if(this.field_491 == null) {
         this.field_491 = new Thread(this);
         this.field_491.start();
      }

   }

   // $FF: renamed from: a (byte[], byte[], int, int) boolean
   private boolean method_558(byte[] var1, byte[] var2, int var3, int var4) {
      this.field_495.method_530();
      if(SocketListener.method_544(this.field_495)) {
         try {
            this.field_492.write(var1);
            this.field_492.write(var2, var3, var4);
            this.field_492.flush();
            return true;
         } catch (IOException var5) {
            SocketListener.method_545(this.field_495);
            SocketListener.method_522("sendData " + var5.getMessage(), false);
            return false;
         } catch (Error var6) {
            SocketListener.logMessage(var6.getMessage());
         }
      }

      return false;
   }

   public final void run() {
      label128:
      while(true) {
         if(!Main2.field_650 && SocketListener.method_546(this.field_495)) {
            label143: {
               try {
                  Thread.sleep(200L);
               } catch (InterruptedException var8) {
                  SocketListener.method_522("Thread interrup: " + var8.getMessage(), false);
               }

               if(SocketListener.method_547(this.field_495)) {
                  boolean var1;
                  if(var1 = this.field_485 <= 0) {
                     for(byte var2 = 0; var2 < this.commands.length; ++var2) {
                        if(this.commands[var2] != null && this.commands[var2].length > 0) {
                           var1 = false;
                           break;
                        }
                     }
                  }

                  if(var1) {
                     this.field_495.method_538();
                     break label143;
                  }
               }

               if(this.field_485 <= 0) {
                  continue;
               }

               short var11 = 0;

               while(true) {
                  if(this.field_485 <= 0 || !SocketListener.method_544(this.field_495) || this.field_495.field_477) {
                     continue label128;
                  }

                  if(this.field_489 >= this.commands.length) {
                     this.field_489 = -1;
                  }

                  if(this.field_489 < 0) {
                     for(byte var10 = 0; var10 < this.commands.length; ++var10) {
                        if(this.commands[var10] != null) {
                           this.field_489 = var10;
                           break;
                        }
                     }

                     this.field_487 = 0;
                     this.field_486 = 0;
                  }

                  if(this.field_489 >= 0) {
                     byte[] var12;
                     if((var12 = this.commands[this.field_489]) != null && var12.length >= SocketListener.field_455) {
                        short var3 = (short)((short)((255 & var12[2]) << 8 | 255 & var12[3]) + OutputGameMessage.headerSize);
                        byte var4 = (byte)(var12.length / SocketListener.method_543());
                        if(var12.length % SocketListener.method_543() > 0) {
                           ++var4;
                        }

                        byte[] var5 = new byte[SocketListener.field_455];
                        String var6 = this.field_482;
                        synchronized(this.field_482) {
                           while(this.field_487 < var4 && SocketListener.method_544(this.field_495)) {
                              short var7 = SocketListener.method_543();
                              if(var3 - this.field_486 < SocketListener.method_543()) {
                                 var7 = (short)(var3 - this.field_486);
                              }

                              SocketListener.method_550(var5, this.field_490, var4, (byte)this.field_487, var7);
                              if(!this.method_558(var5, var12, this.field_486, var7)) {
                                 break;
                              }

                              this.field_486 += var7;
                              var11 = (short)(var11 + SocketListener.field_455 + var7);
                              ++this.field_487;
                           }

                           this.field_488 += var11;
                           if(this.field_487 == var4) {
                              this.commands[this.field_489] = null;
                              ++this.field_489;
                              this.field_487 = 0;
                              this.field_486 = 0;
                              --this.field_485;
                              ++this.field_490;
                              if(this.field_490 < 0) {
                                 this.field_490 = 1;
                              }
                           }
                        }
                     } else {
                        this.commands[this.field_489] = null;
                        ++this.field_489;
                        this.field_487 = 0;
                        this.field_486 = 0;
                     }
                  }
               }
            }
         }

         this.field_491 = null;
         return;
      }
   }

   // $FF: renamed from: a (mobak.a.a.l) void
   public final void method_559(OutputGameMessage outputGameMessage) {
      synchronized(this.field_482){}
      if(outputGameMessage != null) {
         try {
            this.commands[this.lastCommandIndex] = outputGameMessage.setBodySize();
            ++this.packageSent;
            this.commandLength += this.commands[this.lastCommandIndex].length;
            ++this.lastCommandIndex;
            if(this.lastCommandIndex >= this.commands.length) {
               if(this.commands[0] != null && this.commands[0].length != 0) {
                  byte[][] var5 = new byte[this.commands.length + 5][0];
                  System.arraycopy(this.commands, 0, var5, 0, this.commands.length);
                  this.commands = var5;
               } else {
                  this.lastCommandIndex = 0;
               }
            }

            ++this.field_485;
         } finally {
            ;
         }
      }
   }

   // $FF: renamed from: a (mobak.a.d) short
   static short method_560(class_61 var0) {
      return var0.field_490;
   }
}

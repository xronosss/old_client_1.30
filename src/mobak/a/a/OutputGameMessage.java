package mobak.a.a;

import mobak.a.SocketListener;

// $FF: renamed from: mobak.a.a.l
public final class OutputGameMessage {

   // $FF: renamed from: a short
   public static short headerSize;
   // $FF: renamed from: a byte[]
   private byte[] commandData;
   // $FF: renamed from: b short
   private short currentPositionInCommand;
   // $FF: renamed from: a boolean
   private boolean needWaitingNextPacket;


   // $FF: renamed from: <init> (short) void
   public OutputGameMessage(short packetType) {
      super();
      this.currentPositionInCommand = 0;
      this.needWaitingNextPacket = false;
      this.commandData = new byte[6];
      this.commandData[0] = (byte)(packetType >> 8);
      this.commandData[1] = (byte)packetType;
   }

   // $FF: renamed from: <init> (short, short, short, boolean) void
   public OutputGameMessage(short packetType, short packetSize, short nextPacketSize, boolean needWaitingNextPacket) {
      super();
      this.currentPositionInCommand = 0;
      this.needWaitingNextPacket = false;
      this.commandData = new byte[packetSize + 6];
      this.commandData[0] = (byte)(packetType >> 8);
      this.commandData[1] = (byte)packetType;
      this.commandData[4] = (byte)(nextPacketSize >> 8);
      this.commandData[5] = (byte)nextPacketSize;
      this.needWaitingNextPacket = needWaitingNextPacket;
   }

   // $FF: renamed from: <init> (short, short, short) void
   public OutputGameMessage(short packetType, short packetSize, short nextPacketSize) {
      super();
      this.currentPositionInCommand = 0;
      this.needWaitingNextPacket = false;
      this.commandData = new byte[packetSize + 6];
      this.commandData[0] = (byte)(packetType >> 8);
      this.commandData[1] = (byte)packetType;
      this.commandData[4] = (byte)(nextPacketSize >> 8);
      this.commandData[5] = (byte)nextPacketSize;
   }

   // $FF: renamed from: a () short
   public final short getNextPacketType() throws Exception {
      if(this.commandData != null && this.commandData.length >= 2) {
         return (short)((255 & this.commandData[4]) << 8 | 255 & this.commandData[5]);
      } else {
         throw new Exception("command data isn\'t defined");
      }
   }

   // $FF: renamed from: a () byte[]
   public final byte[] setBodySize() {
      this.commandData[2] = (byte)(this.currentPositionInCommand >> 8);
      this.commandData[3] = (byte)this.currentPositionInCommand;
      return this.commandData;
   }

   // $FF: renamed from: a (short) void
   public final void setNextCommandType(short var1) {
      if(this.commandData == null || this.commandData.length < 4) {
         this.commandData = new byte[6];
      }

      this.commandData[4] = (byte)(var1 >> 8);
      this.commandData[5] = (byte)var1;
   }

   // $FF: renamed from: a (byte[]) int
   public final int addToBody(byte[] value) {
      if(value != null && value.length != 0) {
         if(this.commandData.length - 6 - this.currentPositionInCommand < value.length) {
            byte[] var2 = new byte[6 + this.currentPositionInCommand + value.length];
            System.arraycopy(this.commandData, 0, var2, 0, this.commandData.length);
            this.commandData = var2;
         }

         System.arraycopy(value, 0, this.commandData, this.currentPositionInCommand + 6, value.length);
         this.currentPositionInCommand = (short)(this.currentPositionInCommand + value.length);
         this.commandData[2] = (byte)(this.currentPositionInCommand >> 8);
         this.commandData[3] = (byte)this.currentPositionInCommand;
         return value.length;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: a (int) void
   public final void addToBody(int var1) {
      if(this.commandData.length - 6 - this.currentPositionInCommand < 4) {
         byte[] var2 = new byte[6 + this.currentPositionInCommand + 4];
         System.arraycopy(this.commandData, 0, var2, 0, this.commandData.length);
         this.commandData = var2;
      }

      this.commandData[6 + this.currentPositionInCommand] = (byte)(var1 >>> 24);
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)(var1 >> 16);
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)(var1 >> 8);
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)var1;
      ++this.currentPositionInCommand;
   }

   // $FF: renamed from: b (short) void
   public final void addToBody(short var1) {
      if(this.commandData.length - 6 - this.currentPositionInCommand < 2) {
         byte[] var2 = new byte[6 + this.currentPositionInCommand + 2];
         System.arraycopy(this.commandData, 0, var2, 0, this.commandData.length);
         this.commandData = var2;
      }

      this.commandData[6 + this.currentPositionInCommand] = (byte)(var1 >> 8);
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)var1;
      ++this.currentPositionInCommand;
   }

   // $FF: renamed from: a (byte) void
   public final void addToBody(byte var1) {
      if(this.commandData.length - 6 - this.currentPositionInCommand <= 0) {
         byte[] var2 = new byte[6 + this.currentPositionInCommand + 1];
         System.arraycopy(this.commandData, 0, var2, 0, this.commandData.length);
         this.commandData = var2;
      }

      this.commandData[6 + this.currentPositionInCommand] = (byte)var1;
      ++this.currentPositionInCommand;
   }

   // $FF: renamed from: a (long) void
   public final void addToBody(long var1) {
      if(this.commandData.length - 6 - this.currentPositionInCommand < 8) {
         byte[] var3 = new byte[6 + this.currentPositionInCommand + 8];
         System.arraycopy(this.commandData, 0, var3, 0, this.commandData.length);
         this.commandData = var3;
      }

      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 56 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 48 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 40 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 32 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 24 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 16 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 >> 8 & 255L));
      ++this.currentPositionInCommand;
      this.commandData[6 + this.currentPositionInCommand] = (byte)((int)(var1 & 255L));
      ++this.currentPositionInCommand;
   }

   // $FF: renamed from: b () short
   public static final short method_960() {
      return (short)8;
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void addToBody(String var1) {
      if(var1 != null && !var1.equals("")) {
         byte[] var2 = null;
         if(!SocketListener.encoding.equals("")) {
            try {
               var2 = var1.getBytes(SocketListener.encoding);
            } catch (Exception var3) {
               SocketListener.logMessage("SocketListenerMe.addToBody(String)" + var3.toString());
            }
         } else {
            var2 = var1.getBytes();
         }

         if(var2 != null) {
            this.addToBody((short)var2.length);
            this.addToBody(var2);
         } else {
            this.addToBody((short)0);
         }
      } else {
         this.addToBody((short)0);
      }
   }

   // $FF: renamed from: a () boolean
   public final boolean isNeedWaiting() {
      return this.needWaitingNextPacket;
   }

   // $FF: renamed from: <clinit> () void
   static {
      headerSize = 6;
   }
}

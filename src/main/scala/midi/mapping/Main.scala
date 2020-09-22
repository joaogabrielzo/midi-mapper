package midi.mapping

import javax.sound.midi.{MidiSystem, Receiver, Transmitter}

object Main {

  def main(args: Array[String]) {

    println(" __  __   ___   ____    ___       __  __                             ")
    println("|  \\/  | |_ _| |  _ \\  |_ _|     |  \\/  | __ _ _ __  _ __   ___ _ __ ")
    println("| |\\/| |  | |  | | | |  | |      | |\\/| |/ _` | '_ \\| '_ \\ / _ \\ '__|")
    println("| |  | |  | |  | |_| |  | |   _  | |  | | (_| | |_) | |_) |  __/ |   ")
    println("|_|  |_| |___| |____/  |___| (_) |_|  |_|\\__,_| .__/| .__/ \\___|_|   ")
    println("                                              |_|   |_|              ")
    println("\n")

    val devInfo = MidiSystem.getMidiDeviceInfo

    val device = MidiSystem.getMidiDevice(
      devInfo.last)

    val transmitter: Transmitter = device.getTransmitter

    transmitter.setReceiver(new InputReceiver(device.getDeviceInfo.toString))

    device.open()
  }
}

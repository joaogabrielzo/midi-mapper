package midi.mapping

import javax.sound.midi.{MidiMessage, Receiver}

class InputReceiver(val name: String) extends Receiver {

  override def send(message: MidiMessage, timeStamp: Long): Unit = {

    message.getStatus match {
      case 144 =>
        val msgList = message.getMessage.map(_.toChar)
        val msgNote = msgList.mkString.charAt(1).toInt - 12

        println(NoteMapping.getNote(msgNote))

      case _ => null
    }

  }

  override def close(): Unit = {}
}

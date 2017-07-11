import akka.actor.{Actor, ActorLogging}

/**
  * Created by WU on 2017-07-11.
  */
class DeviceManager extends Actor with ActorLogging {

  override def receive: Receive = ???
}

object DeviceManager {
  final case class RequestTrackDevice(groupId: String, deviceId: String)
  case object DeviceRegistered
}
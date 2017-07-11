import akka.actor.ActorSystem
import akka.testkit.TestProbe
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by WU on 2017-07-10.
  */
class DeviceTest extends FlatSpec with Matchers{

  implicit val system = ActorSystem("test-iot-system")

  it should "reply with empty reading if no temperature is known" in {
    val probe = TestProbe()
    val deviceActor = system.actorOf(Device.props("group", "device"))

    deviceActor.tell(Device.ReadTemperature(requestId = 42), probe.ref)
    val response = probe.expectMsgType[Device.RespondTemperature]
    response.requestId should ===(42)
    response.value should ===(None)
  }

}

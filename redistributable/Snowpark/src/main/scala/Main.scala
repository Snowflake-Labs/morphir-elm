import utils._

object Main extends App {
  implicit val session = SessionUtil.getSessionFromEnv()

  println("Connected");

  session.close()
}

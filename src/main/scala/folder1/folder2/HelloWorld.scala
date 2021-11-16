package folder1.folder2

import zio._
import zhttp.http._
import zhttp.service.Server
import play.twirl.api.Html

object HelloWorld extends App {
  val app = Http.collect[Request] {
    case Method.GET -> Root / "text" => Response.text("Hello World!")
    case Method.GET -> Root / "twirl" =>
      asHtml(frontpage.html.index("Hello World!"))
  }

  def asHtml(html: Html): UResponse = Response.http(
    status = Status.OK,
    headers = List(Header.contentTypeXhtmlXml),
    content = HttpData.CompleteData(
      Chunk.fromArray(html.toString().getBytes(HTTP_CHARSET))
    )
  )

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    Server.start(8090, app).exitCode
}

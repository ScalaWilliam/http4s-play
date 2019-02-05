package controllers

import cats.effect.{ContextShift, IO}
import javax.inject.Inject
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.server.play.PlayRouteBuilder
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter

import scala.concurrent.ExecutionContext

class Http4sRouter @Inject()(implicit executionContext: ExecutionContext) extends SimpleRouter {
  implicit val contextShift: ContextShift[IO] = IO.contextShift(executionContext)

  val exampleService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> _ =>
      Ok(s"Hello World!")
  }

  override def routes: Routes = new PlayRouteBuilder[IO](exampleService).build
}

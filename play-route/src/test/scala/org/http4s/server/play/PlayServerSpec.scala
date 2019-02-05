package org.http4s.server.play

import cats.effect.{ContextShift, IO}

import scala.concurrent.ExecutionContext

class PlayServerSpec /*extends ServerSpec*/ {
  implicit val contextShift: ContextShift[IO] = IO.contextShift(ExecutionContext.global)

  def builder: PlayTestServerBuilder[IO] = PlayTestServerBuilder[IO]
}

lazy val testing = Project(id = "testing", base = file("http4s"))
lazy val core = Project(id="core", base=file("http4s"))
lazy val examples = Project(id = "examples", base = file("http4s"))
lazy val server = Project(id = "server", base = file("http4s"))

lazy val fs2Io                            = "co.fs2"                 %% "fs2-io"                    % "0.10.3"
lazy val fs2ReactiveStreams = "com.github.zainab-ali" %% "fs2-reactive-streams" % "0.5.1"

lazy val `examples-play` = project
 .enablePlugins(PlayScala)
  .settings(
    description := "Example of http4s on Play",
    scalacOptions in Compile -= "-Xfatal-warnings",
    libraryDependencies ++= Seq(
      guice,
      jaxbApi,
    ),
  )
  .dependsOn(`play-route`)


lazy val `play-route` = project
  .settings(
    description := "Play wrapper of http4s services",
    libraryDependencies ++= Seq(
      play,
      fs2Io,
      fs2ReactiveStreams,
      playAkkaHttpServer % "test"
    )
  )
.dependsOn(examples)
  .dependsOn(core, server % "compile;test->test", testing % "test->test") 


  lazy val play                             = "com.typesafe.play"      %% "play"                      % "2.6.13"
  lazy val playAkkaHttpServer               = "com.typesafe.play"      %% "play-akka-http-server"     % "2.6.13"
  lazy val jaxbApi = "javax.xml.bind" % "jaxb-api" % "2.3.0"



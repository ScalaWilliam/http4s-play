version := "0.0.1"

lazy val `examples-play` = project.in(file("example"))
  .enablePlugins(PlayScala)
  .settings(
    description := "Example of http4s on Play",
    scalacOptions in Compile -= "-Xfatal-warnings",
    libraryDependencies ++= Seq(
      guice,
      "javax.xml.bind" % "jaxb-api" % "2.3.0",
      "org.http4s" %% "http4s-dsl" % "0.20.0-M4",
    ),
  )
  .dependsOn(`play-route`)


lazy val `play-route` = project
  .settings(
    description := "Play wrapper of http4s services",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % "2.6.20",
      "com.typesafe.play" %% "play-akka-http-server" % "2.6.20" % "test",
      "co.fs2" %% "fs2-core" % "1.0.2",
      "co.fs2" %% "fs2-reactive-streams" % "1.0.2",
      "org.http4s" %% "http4s-core" % "0.20.0-M4",
      "org.http4s" %% "http4s-server" % "0.20.0-M4" % "test",
      "org.http4s" %% "http4s-testing" % "0.20.0-M4" % "test",
    )
  )

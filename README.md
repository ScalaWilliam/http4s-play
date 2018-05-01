# http4s-play

Use [http4s](https://github.com/http4s/http4s) routes as [Play framework routes](https://github.com/playframework/playframework/blob/master/framework/src/play/src/main/scala/play/api/routing/Router.scala).

What's the benefit? To benefit from the nice features that both Play and http4s offer, without drastic nearly-impossible migrations. Play can still be the outside, while you use http4s for the nice fully pure FP.

See https://github.com/http4s/http4s/pull/1819/ for more background.

## Usage

Run the tests:
```
$ sbt play-route/test
```
Running:
```
$ sbt example/run
```

val scala3Version = "2.13.7"

val zhttpVersion = "1.0.0.0-RC17"

lazy val root = project
  .in(file("."))
  .settings(
    name := "ZIO http Twirl",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    libraryDependencies += "io.d11" %% "zhttp"      % zhttpVersion,
// libraryDependencies += "io.d11" %% "zhttp-test" % zhttpVersion % Test,
  )

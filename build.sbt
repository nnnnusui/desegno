val scala3Version = "3.4.2"
val lwjglVersion = "3.3.3"
val os = "linux" // Change to "windows" or "linux" or "macos" if necessary

lazy val root = project
  .in(file("."))
  .settings(
    name := "desegno",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,
    libraryDependencies ++= List(
      "org.lwjgl" % "lwjgl" % lwjglVersion,
      "org.lwjgl" % "lwjgl" % lwjglVersion classifier s"natives-$os",
      "org.lwjgl" % "lwjgl-glfw" % lwjglVersion,
      "org.lwjgl" % "lwjgl-glfw" % lwjglVersion classifier s"natives-$os",
      "org.lwjgl" % "lwjgl-vulkan" % lwjglVersion,
    ),
  )

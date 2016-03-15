lazy val trialSbtWeb = project
  .copy(id = "trial-sbt-web")
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning, SbtWeb)

name := "trial-sbt-web"

libraryDependencies ++= Vector(
  Library.akkaHttp
)

initialCommands := """|import de.heikoseeberger.trialsbtweb._
                      |""".stripMargin

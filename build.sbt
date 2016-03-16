lazy val trialSbtWeb = project
  .copy(id = "trial-sbt-web")
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning, SbtWeb)

name := "trial-sbt-web"

libraryDependencies ++= Vector(
  Library.akkaHttp,
  Library.webjarsLocator
)

initialCommands := """|import de.heikoseeberger.trialsbtweb._
                      |""".stripMargin

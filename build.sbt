lazy val trialSbtWeb = project
  .copy(id = "trial-sbt-web")
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

name := "trial-sbt-web"

libraryDependencies ++= Vector(
  Library.scalaCheck % "test"
)

initialCommands := """|import de.heikoseeberger.trial.sbt.web._
                      |""".stripMargin

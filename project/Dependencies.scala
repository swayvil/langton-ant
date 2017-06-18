import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val scalaSwing = "org.scala-lang.modules" %% "scala-swing" % "1.0.1" //groupId % artifactId % version
  lazy val scalaLang = "org.scala-lang" % "scala-compiler" % "2.11.8"
}

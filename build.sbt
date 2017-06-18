import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "swayvil",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "LangtonAnt",
    libraryDependencies += scalaLang,
    libraryDependencies += scalaSwing
  )

scalaVersion := "2.12.8"

name := "oberon"
organization := "br.unb.cic.oberon"
version := "0.0.1"
parallelExecution in Test := false

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"


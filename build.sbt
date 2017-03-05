import Dependencies._

name := "Reactive-chat"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++=(`akka-libs` ++ `db-libs` ++ `test-libs` ++ `util-libs`)


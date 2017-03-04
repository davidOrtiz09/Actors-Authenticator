import Dependencies._

name := "Actors-Authenticator"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++=(`akka-libs` ++ `db-libs` ++ `test-libs` ++ `util-libs`)


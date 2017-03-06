import sbt._



object Dependencies {


  private[Dependencies] object Compile {

    import Versions._

    val akkaHttp: ModuleID        =  "com.typesafe.akka"                 %% "akka-http"        % akkaHttpVersion
    val akkaActors: ModuleID      =  "com.typesafe.akka"                 %% "akka-actor"       % akkaVersion
    val akkaStreams: ModuleID     = "com.typesafe.akka"                  %% "akka-stream"      % akkaVersion
    val slickDriver: ModuleID     = "com.typesafe.slick"                 %% "slick"            % slickVersion
    val slf4j: ModuleID           = "org.slf4j"                           % "slf4j-api"        % slfjVersion
    val hikariCp: ModuleID        = "com.typesafe.slick"                 %% "slick-hikaricp"   % hikariVersion
    val postgresDb: ModuleID      = "org.postgresql"                      % "postgresql"       % postgresVersion
    val typeSafeLogger: ModuleID  = "com.typesafe.scala-logging"         %% "scala-logging"    % typeSafeLoggerVersion
    val logback: ModuleID         =  "ch.qos.logback"                     % "logback-classic"  % logBackVersion
  }

  private[Dependencies] object TestDep {

    import Versions._

    val scalaTest: ModuleID = "org.scalactic" %% "scalactic" % scalaTestVersion % Test
    val akkaTestKit: ModuleID = "com.typesafe.akka" %% "akka-testkit" % akkaTestVersion % Test

  }

  import Dependencies.Compile._
  import Dependencies.TestDep._


  val `util-libs`: Seq[ModuleID] = Seq(typeSafeLogger , logback )
  val `akka-libs`: Seq[ModuleID] = Seq(akkaHttp , akkaActors , akkaStreams)
  val `db-libs`: Seq[ModuleID] = Seq(slickDriver , slf4j , hikariCp , postgresDb)
  val `test-libs`: Seq[ModuleID] = Seq(scalaTest ,akkaTestKit )

}

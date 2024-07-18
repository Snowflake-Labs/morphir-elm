package utils

import com.snowflake.snowpark.Session

object SessionUtil {
  def getSessionFromEnv(): Session = {
    val configMap: Map[String, String] = Map(
      "URL" -> (System.getenv("SNOWFLAKESQL_ACCOUNT") + ".snowflakecomputing.com"),
      "USER" -> System.getenv("SNOWFLAKESQL_USER"),
      "PASSWORD" -> System.getenv("SNOWFLAKESQL_PWD"),
      "DB" -> System.getenv("SNOWFLAKESQL_DATABASE"),
      "SCHEMA" -> System.getenv("SNOWFLAKESQL_SCHEMA"),
      "WAREHOUSE" -> System.getenv("SNOWFLAKESQL_WAREHOUSE")
    )

    val session = Session.builder.configs(configMap).create

    session.setQueryTag("""{"origin":"sf_sit","name":"morphir","version":{"major":1, "minor":0}}""")

    session
  }
}

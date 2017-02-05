heroku run echo $\JDBC_DATABASE_URL >.mydburl 2>.mydburlerr
myurl=`cat .mydburl`
export JDBC_DATABASE_URL="$myurl"
echo "Run application with $JDBC_DATABASE_URL DB URL."
java -jar target/dependency/webapp-runner.jar target/sample_maven_web_app-1.0-SNAPSHOT.war

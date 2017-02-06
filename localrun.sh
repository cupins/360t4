heroku run echo $\JDBC_DATABASE_URL >.mydburl 2>.mydburlerr
myurl=`cat .mydburl`
if [[ -z $myurl ]]
then
  heroku pg:credentials > .mydburl
  thing=`tail -n 1 .mydburl`
  usr=`echo $thing | cut -d'/' -f 3 | cut -d':' -f 1`
  pswd=`echo $thing | cut -d'/' -f 3 | cut -d':' -f 2 | cut -d'@' -f 1`
  url=`echo $thing | cut -d'/' -f 3 | cut -d':' -f 2 | cut -d'@' -f 2`
  db=`echo $thing | cut -d'/' -f 4`
  port=`echo $thing | cut -d':' -f 4 | cut -d'/' -f 1`
  echo "usr=$usr"
  echo "pswd=$pswd"
  echo "url=$url"
  echo "db=$db"
  echo "port=$port"
  myurl="jdbc:postgresql://${url}:${port}/${db}?user=${usr}&password=${pswd}&sslmode=require"
fi
export JDBC_DATABASE_URL="$myurl"
echo "Run application with $JDBC_DATABASE_URL DB URL."
java -jar target/dependency/webapp-runner.jar target/sample_maven_web_app-1.0-SNAPSHOT.war

ENDPOINT=https://enigmatic-peak-68851.herokuapp.com/rest/generic
# local web runner deploy
#ENDPOINT=http://localhost:8080/rest/generic
# net beans deploy
#ENDPOINT=http://localhost:8084/sample_maven_web_app/rest/generic
# manual deploy
#ENDPOINT=http://localhost:8080/sample_maven_web_app-1.0-SNAPSHOT/rest/generic
curl -X POST -H "Content-Type: application/json" -d @./fred.json $ENDPOINT
#curl -X POST -H "Content-type: application/json" -d '{"name":"Fred Smith","age":33}' $ENDPOINT
echo


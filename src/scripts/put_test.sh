ENDPOINT=https://frozen-temple-15527.herokuapp.com/rest/generic
#ENDPOINT=https://localhost:8080/rest/generic
curl -X PUT -H "Content-Type: text/plain" -d 'This is wonderful great text!' $ENDPOINT
echo


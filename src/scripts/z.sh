echo "Hello World i might suck"
hope=https://rickrolls.herokuapp.com/tcss360/share/0
chris=$(curl -X GET -H "Content-Type: application/html" $hope)
ENDPOINT=https://rickrolls.herokuapp.com/tcss360/share/
echo "commmmmooooon"
count=$(python helper.py $chris)
echo $count
for (( c=1; c<=$count; c++ ))
do
    json=$(python jp.py $chris $c)
    echo $json
    echo "we json"
    curl -X POST -H "Content-Type: application/json" --data $json $ENDPOINT
done
echo "we won"


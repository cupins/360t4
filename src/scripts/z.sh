echo " INFO running GET to POST"
hope=https://team4360.herokuapp.com/tcss360/shops

#ENDPOINT SHOULD BE HERE CHANGE TO DESIRED
ENDPOINT=https://gentle-coast-59786.herokuapp.com/tcss360/coffeeShop/api/shops
chris=$(curl -X GET -H "Content-Type: application/html" $ENDPOINT)
#echo $chris
count=$(python helper.py $chris)
#echo $count
for (( c=1; c<=$count; c++ ))
do
    json=$(python jp.py $chris $c)
    echo $json
    echo "we json"
    curl -X POST -H "Content-Type: application/json" --data $json $hope
done
#echo "we won"


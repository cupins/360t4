echo "Hello World i might suck"
hope=https://gentle-coast-59786.herokuapp.com/tcss360/coffeeShop/api/shops
chris=$(curl -X GET -H "Content-Type: application/html" $hope)
ENDPOINT=https://rickrolls.herokuapp.com/tcss360/share
echo "commmmmooooon"
count=$(python helper.py $chris)
echo $count
for (( c=1; c<=$count; c++ ))
do
    json=$(python jp.py $chris $c)
    curl -X POST -H "Content-Type: application/json" -d @$json $ENDPOINT
done



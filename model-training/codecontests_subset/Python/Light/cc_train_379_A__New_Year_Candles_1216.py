candle=list(map(int,input().split( )))
n=candle[0]
hour=n
while n>=candle[1]:
    hour+=n//candle[1]
    n=n//candle[1]+n%candle[1]
print(hour)
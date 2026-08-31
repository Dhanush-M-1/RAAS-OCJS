candles,conversion = map(int,input().split())
sum = candles
remains = 0
while candles >= conversion:
    remains = candles % conversion
    candles = candles // conversion
    sum += candles
    candles += remains

print(sum)
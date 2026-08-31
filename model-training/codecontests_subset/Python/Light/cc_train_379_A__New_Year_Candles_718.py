candles, reforge = map(int, input().split())
result = candles
while candles >= reforge:
    candles_left = candles % reforge
    candles = candles // reforge
    result += candles
    candles += candles_left
print(result)
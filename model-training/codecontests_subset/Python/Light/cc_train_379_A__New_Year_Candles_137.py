candles, b = map(int, input().split())

hours = 0
candle_ends = 0

while candles > 0:
    candle_ends += candles
    hours += candles
    candles, candle_ends = divmod(candle_ends, b)

print(hours)
 

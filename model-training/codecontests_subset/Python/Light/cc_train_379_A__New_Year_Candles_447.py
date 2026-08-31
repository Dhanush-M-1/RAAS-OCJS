candle, new_candle = map(int, input().split())
burnt_candles = 0
hours = 0

while candle > 0:
    burnt_candles += 1
    candle -= 1
    if burnt_candles == new_candle:
        burnt_candles = 0
        candle += 1
    hours += 1

print(hours)
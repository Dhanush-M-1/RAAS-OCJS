candles, mix = map(int, input().split())
count = candles
while candles >= mix:
    count += candles // mix
    candles = (candles // mix) + (candles % mix)
print(count)
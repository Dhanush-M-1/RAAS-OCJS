import math

new_candles, candles_to_new = input().split()
new_candles = int(new_candles)
candles_to_new = int(candles_to_new)
num_hours = new_candles
candles_left = new_candles
while True:
    if (candles_left < candles_to_new):
        break
    num_hours += candles_left// candles_to_new
    candles_left = candles_left%candles_to_new + candles_left //candles_to_new
    
print(num_hours)
inp = [int(a) for a in input().strip().split(' ')]
candles = inp[0]
needed_candles = inp[1]

hours = 0
remaining_candles = 0

while candles > 0:
    hours += candles
    new_candles = candles // needed_candles
    remaining_candles += candles % needed_candles

    if remaining_candles >= needed_candles:
        new_candles += remaining_candles // needed_candles
        remaining_candles = remaining_candles % needed_candles

    candles = new_candles

print(hours)

a, b = map(int, input().split())

hours = 0
candles = a

hours += candles
left_overs = candles

while left_overs >= b:
    new_candles = left_overs // b
    left_overs = left_overs % b + new_candles
    hours += new_candles

print(hours)

params = input()
candles,b = [int(i) for i in params.split(' ')]

hours = candles
burned = candles

while (burned >= b):
    candles = burned // b
    burned = (burned%b) + candles
    hours += candles

print(hours)

a, b = map(int, input().split())

t = 0
candles = a
old = 0

while candles > 0 and old < b:
    t = t + 1
    candles = candles - 1
    old = old + 1
    if old >= b:
        old = 0
        candles = candles + 1

print(t)

f = input().split()
a = int(f[0])
b = int(f[1])
candles = a
hours = 0
while candles > 0:
    #burn candle
    hours += 1
    candles -= 1
    if hours % b == 0:
        candles += 1
print(hours)

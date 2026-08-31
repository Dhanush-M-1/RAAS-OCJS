

[a,b] = [int(x) for x in input().split()]
candle = a
leftover = 0
day = 0
while candle > 0:
    day += 1
    candle -= 1
    leftover +=1
    if leftover == b:
        candle += 1
        leftover = 0

print(day)

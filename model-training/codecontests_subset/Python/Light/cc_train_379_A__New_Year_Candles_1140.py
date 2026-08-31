a = list(map(int, input().split()))
candle = a[0]
extinguished_candles = a[1]
i = 1
answer = 0
while candle > 0:
    candle -= 1
    answer += 1
    if answer == extinguished_candles * i:
        i += 1
        candle += 1
print(answer)

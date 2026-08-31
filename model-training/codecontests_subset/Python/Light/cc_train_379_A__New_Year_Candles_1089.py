__author__ = "runekri3"

a, b = list(map(int, input().split()))

candles = a
burnt_candles = 0
total_hours = 0
while 1:
    remakeable_candles = int(burnt_candles / b)
    candles += remakeable_candles
    burnt_candles -= remakeable_candles * b
    if candles <= 0:
        break
    total_hours += candles
    burnt_candles += candles
    candles = 0

print(total_hours)

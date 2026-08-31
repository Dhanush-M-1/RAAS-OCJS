n, m = [int(x) for x in input().split()]
candles = n
hours = candles
while True:
    new_hours = candles // m
    if new_hours < 1:
        break
    candles -= new_hours * m
    candles += new_hours
    hours += new_hours

print(hours)
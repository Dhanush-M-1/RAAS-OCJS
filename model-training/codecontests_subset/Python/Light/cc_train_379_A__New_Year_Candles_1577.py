import math as m
a,b=map(int,input().split())
hours=0
candles=a
used_candles=0
while True:
    hours+=candles
    used_candles+=candles
    candles=0
    if used_candles<b:
        print(hours)
        break
    else:
        candles=m.floor(used_candles/b)
        used_candles+=(-candles*b)
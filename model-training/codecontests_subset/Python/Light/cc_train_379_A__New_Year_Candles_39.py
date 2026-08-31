import math
a,b=map(int,input().split())
hours=a
if a>=b:
    new_candles=a
    while new_candles>=b:
        if math.floor(new_candles / b)==new_candles/b:
            new_candles = math.floor(new_candles / b)
            hours+=new_candles
        else:
            x = new_candles % b
            new_candles = math.floor(new_candles / b)
            hours += new_candles
            new_candles+=x

    print(hours)
else:
    print(hours)
























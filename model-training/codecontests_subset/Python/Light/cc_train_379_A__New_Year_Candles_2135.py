def burning_hour(candle, sub, hour):
    
    if(candle >= sub):
        subtraction = int(candle/sub) + int(candle%sub)
        hour += int(candle/sub)
        burning_hour(subtraction, sub, hour)
    else:
        print(hour)

x , y = map(int , input().split())
burning_hour(x, y, x)

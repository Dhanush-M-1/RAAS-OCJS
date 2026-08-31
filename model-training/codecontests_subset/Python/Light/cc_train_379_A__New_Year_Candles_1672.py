def candle(a,b):
    return a//b+candle(a//b+a%b,b) if a>=b else 0
a,b=map(int,input().split())
print(a+candle(a,b))
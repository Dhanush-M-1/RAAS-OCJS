def candle(m,n,a):
    if m+a>=n:
        return m+candle((m+a)//n,n,(m+a)%n)
    else:
        return m
m,n=map(int,input().split())
print(candle(m,n,0))
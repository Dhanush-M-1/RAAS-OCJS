def candle(c,k):
    if c < k:
        return c
    else:
        return c + candle(c//k+c%k,k) - c%k
    
a, b = map(int, input().split())

print(candle(a,b))

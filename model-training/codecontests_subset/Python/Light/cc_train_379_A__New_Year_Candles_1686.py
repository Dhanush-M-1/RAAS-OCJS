#A. New Year Candles
n, m = map(int, input().split())
sm = n

while n >= m :

    sm += n // m
    #print(sm)
    n = n // m + n % m
    #print(n)

print(sm)
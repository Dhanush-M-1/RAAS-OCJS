__author__ = 'Utena'
import math
n,m=map(int,input().split())
t=0
while True:
    if n>=m:
        t+=(n-(n%m))
        n=(n%m)+math.floor(n/m)
    else:
        t+=n
        print(t)
        break
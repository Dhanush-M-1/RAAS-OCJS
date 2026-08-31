import math
n,x,y=map(int,input().split())
tocome=y/100.0

if x<tocome*n:

    need=(math.ceil(tocome*n))-x
    print(need)
else:
    print(0)    
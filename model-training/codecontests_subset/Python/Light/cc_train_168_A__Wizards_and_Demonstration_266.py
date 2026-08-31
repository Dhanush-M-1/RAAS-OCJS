from math import ceil,floor
n,x,y = map(int,input().split())
if floor((x*100)/n) >= y:
    print(0)
else:
    print(ceil((y*n)/100) - x)
import math
for _ in range(int(input())):
    l,r,x = map(int,input().split())
    if l>x:
        print(x)
    else:
        print(x * (math.floor(r / x)+1))

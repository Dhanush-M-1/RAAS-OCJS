import math
for _ in range(int(input())):
    l,r,d=map(int,input().split())
    f=math.ceil(l/d)*d
    s=math.floor(r/d)*d
    if l>d:
        print(d)
    else:
        print(s+d)
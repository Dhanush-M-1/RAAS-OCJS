import math
q = int(input())
for _ in range(q):
    l,r,d = map(int,input().split())
    if(d>=l):
        x = math.ceil(r/d)*d
        if(x == r):
            x+=d
    else:
        x = d
        #print("fe")

    print(x)
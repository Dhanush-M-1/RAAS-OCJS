import math
t=int(input())
while t>0:
    l,r,d=map(int,input().split())
    if d<l or d>r:
        print(d)
    else:
        k=math.ceil(r/d)
        if d*k==r:
            print(d*(k+1))
        else:
            print(d*k)
    t-=1

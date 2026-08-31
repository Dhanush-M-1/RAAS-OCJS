from math import ceil

for _ in range(int(input())):
    l,r,d=map(int,input().split())
    if d<l:
        print(d)
    elif d>r:
        print(d)
    else:
        if r%d==0:
            print((ceil(r/d)+1)*d)
        else:
            print(ceil(r/d)*d)
        
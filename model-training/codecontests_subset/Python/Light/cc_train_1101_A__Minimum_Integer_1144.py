import math
for i in range(int(input())):
    l,r,d = map(int,input().split())
    if d<l:
        print(d)
    elif r/d == r//d:
        print((r//d+1)*d)
    else:
        print(math.ceil(r/d)*d)
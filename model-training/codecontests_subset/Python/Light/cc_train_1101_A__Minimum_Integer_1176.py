import math
mod=1000000007 
#c=[[0 for x in range(1001)] for y in range(1001)] 
t=int(input())
for _ in range(t):
    l,r,d=[int(i) for i in input().split()]
    if l>d:
        q=l//d
        re=l%d
        x=l-re-(q-1)*d
    else:
        re=r%d
        x=r+d-re
    print(x)

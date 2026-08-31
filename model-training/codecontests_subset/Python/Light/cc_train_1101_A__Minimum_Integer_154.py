from math import floor
q = int(input())
while q!=0:
    q-=1
    a,b,c = map(int,input().split())
    if c<a:
        print(c)
    else:
        print(c*floor(b/c)+c)

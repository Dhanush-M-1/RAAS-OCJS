from math import ceil, log
q = int(input().strip())
while q > 0:
    l, r, d = map(int , input().strip().split())
    if(d < l):
        print(d)
    else:
        if(d == 1):
            print(r+1)
        else:
            print((r//d)*d + d)
    q-=1

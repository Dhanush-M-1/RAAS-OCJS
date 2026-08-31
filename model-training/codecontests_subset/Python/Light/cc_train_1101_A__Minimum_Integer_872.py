t = int(input())
while t>0:
    t = t-1
    l,r,d = map(int,input().split())
    intial = (l-1)//d
    if intial>=1:
        print(d)
    else:
        if (r+1) % d != 0:
            final = (r+1)//d
            print(d*(final+1))
        else:
            print(r+1)
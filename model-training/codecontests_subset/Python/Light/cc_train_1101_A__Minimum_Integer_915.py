for _ in range(int(input())):
    l,r,d=map(int,input().split())
    z1 = d*(l//d)
    if l%d==0:
        z1-=d
    z2 = d*(r//d + 1)
    if z1<1:
        print(z2)
    else:
        print(d)

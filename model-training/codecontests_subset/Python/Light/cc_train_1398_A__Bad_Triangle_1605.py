t=int(input())
while t>0:
    n =int(input())
    g=list(map(int, input().split()))
    if g[0]+g[1]<=g[n-1]:
        print("1 2 {}".format(n))
    else:
        print(-1)
    t-=1
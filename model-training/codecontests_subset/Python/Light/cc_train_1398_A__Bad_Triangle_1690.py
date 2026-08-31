T=int(input())
for z in range(T):
    N=int(input())
    a=[int(x) for x in input().split()]
    if a[0]+a[1]<=a[len(a)-1]:
        print(1," ",2," ",len(a))
    else:
        print(-1)

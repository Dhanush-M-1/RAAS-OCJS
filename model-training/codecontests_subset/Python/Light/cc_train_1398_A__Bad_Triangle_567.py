n=int(input())
for i in range(n):
    flag=0
    m=int(input())
    a=[int(x) for x in input().split()]
    if a[0]+a[1]<=a[-1]:
        print(1,2,m)
    else:
        print(-1)
t = int(input())
for _ in range(t):
    n = int(input())
    a = sorted([int(x) for x in input().split()])
    if a[0]+a[1]>a[-1]:
        print(-1)
    else:
        print(1,2,len(a))
def findTr(n,a):
    apb = a[0]+a[1]
    c = a[-1]
    if apb<=c: print(1,2,n)
    else: print(-1)
    return

t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    findTr(n,a)
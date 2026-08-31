t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    find = False
    x = a[0]
    z = a[-1]
    for i in range(1,n-1):
        y = a[i]
        if x + y <= z:
            find = True
            break
    if find:
        print(1,i+1,n)
    else:
        print(-1)
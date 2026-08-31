
t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    ok = False
    
    for i in range(1, n-1):
        if a[i-1]+a[i] <= a[-1]:
            print(i, i+1, n)
            ok = True
            break
    
    if not ok:
        print(-1)
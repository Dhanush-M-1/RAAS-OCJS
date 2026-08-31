t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    ans = []
    f2 = True
    for i in range(n):
        if a[i] != -1:
            f2 = False
            break
    if f2:
        print(0,0)
        continue
    for i in range(n-1):
        if a[i] == -1 and a[i+1] == -1:
            pass
        elif a[i] == -1:
            ans.append(a[i+1])
        elif a[i+1] == -1:
            ans.append(a[i])
    mi = min(ans)
    mx = max(ans)
    k = (mi+mx)//2
    m = abs(mi-k)
    x = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    for i in range(n-1):
        x = max(x,abs(a[i]-a[i+1]))
    print(max(x,m),k)



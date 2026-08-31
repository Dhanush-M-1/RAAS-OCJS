t = int(input())
for kek in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    mi = 10**9
    ma = 0
    sosed = set()
    k = 777
    for i in range(n):
        if a[i] == -1:
            if i+1 < n:
                if a[i+1] != -1:
                    sosed.add(a[i+1])
            if i-1 >= 0:
                if a[i-1] != -1:
                    sosed.add(a[i-1])
    if len(sosed) != 0:
        k = (min(sosed) + max(sosed))//2
    if k == -1:
        k = 777
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    ans = 0
    for i in range(1,n):
        ans = max(ans, abs(a[i]-a[i-1]))
    print(ans, k)
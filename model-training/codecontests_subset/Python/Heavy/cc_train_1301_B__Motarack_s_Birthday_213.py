t = int(input())
for T in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    if max(a) == -1:
        print(0, 79)
        continue
    mi = max(a)
    ma = 0
    for i in range(n):
        if a[i] == -1:
             if i > 0 and a[i-1] != -1:
                 mi = min(mi, a[i-1])
                 ma = max(ma, a[i-1])
             if i < n-1 and a[i+1] != -1:
                 mi = min(mi, a[i+1])
                 ma = max(ma, a[i+1])
    k = (ma+mi)//2
    a = [k if i == -1 else i for i in a]
    m = max([abs(a[i-1]-a[i]) for i in range(1, n)])
    print(m, k)

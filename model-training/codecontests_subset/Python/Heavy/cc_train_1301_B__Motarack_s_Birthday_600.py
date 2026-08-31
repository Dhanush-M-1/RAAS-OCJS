t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    b = []
    for i in range(n):
        if a[i] != -1 and ((i > 0 and a[i-1] == -1) or (i < n-1 and a[i+1] == -1)):
            b.append(a[i])
    if not b:
        k = 0
    else:
        mn = min(b)
        mx = max(b)
        k = round((mn+mx)/2)
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    m = 0
    for i in range(1, n):
        diff = abs(a[i] - a[i-1])
        m = max(diff, m)
    print(m, k)
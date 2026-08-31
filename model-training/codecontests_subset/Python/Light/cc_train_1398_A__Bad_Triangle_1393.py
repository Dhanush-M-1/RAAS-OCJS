t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    b = []
    for i, val in enumerate(a):
        b.append((val, i))
    b.sort()
    i = b[0][1]
    j = b[1][1]
    k = b[n-1][1]
    if a[k] < a[i] + a[j] and a[j] - a[i] < a[k]:
        print(-1)
    else:
        print(i+1, j+1, k+1)
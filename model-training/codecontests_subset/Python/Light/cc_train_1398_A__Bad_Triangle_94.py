t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    i = 0
    j = 1
    k = 2
    breaked = False
    while i < n and j < n:
        if a[i] + a[j] <= a[k]:
            print(i+1, j+1, k+1)
            breaked = True
            break
        if k < n-1:
            k += 1
        elif j < n-2:
            j += 1
        else:
            i += 1
    if not breaked:
        print(-1)
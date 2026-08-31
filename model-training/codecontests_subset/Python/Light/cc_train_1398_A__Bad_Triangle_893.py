for t in range(int(input())):
    n = int(input())
    aa = [int(s) for s in input().split(' ')]
    mins = [0] * n
    maxs = [0] * n
    mins[0] = aa[0]
    maxs[n - 1] = aa[n - 1]
    for i in range(1, n):
        mins[i] = min(mins[i - 1], aa[i])
    for i in reversed(range(n - 1)):
        maxs[i] = max(maxs[i + 1], aa[i])

    found = False
    for i in range(1, n - 1):
        left = mins[i - 1]
        right = maxs[i + 1]
        if aa[i] + left <= right:
            found = True
            print(aa.index(left) + 1, i+1, aa[i+1:].index(right) + i+1 + 1)
            break
    if not found:
        print(-1)
    

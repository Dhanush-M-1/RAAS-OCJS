from bisect import bisect_left

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    a.sort()
    ans = [-1]
    
    for i in range(1, n):
        j = bisect_left(a, a[i] + a[i - 1])
        if j < n:
            ans = (i, i + 1, j + 1)

    print(*ans)
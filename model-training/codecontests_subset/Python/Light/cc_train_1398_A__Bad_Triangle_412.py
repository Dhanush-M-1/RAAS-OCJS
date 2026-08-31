ans = []
for t in range(int(input())):
    n = int(input())
    A = list(map(int, input().split()))
    if A[0] + A[1] <= A[-1]: ans += [[1, 2, n]]
    else: ans += [[-1]]
[print(*x) for x in ans]
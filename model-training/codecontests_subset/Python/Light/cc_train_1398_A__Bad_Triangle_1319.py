from bisect import bisect_left

for _ in range(int(input())):
    N = int(input())
    X = list(map(int, input().split()))
    Index = bisect_left(X, X[0] + X[1])
    print(-1 if Index == N else "1 2 " + str(Index+1))
# New Start

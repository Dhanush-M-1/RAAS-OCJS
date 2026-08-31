import sys;input=sys.stdin.readline
T, = map(int, input().split())
for _ in range(T):
    N, = map(int, input().split())
    X = list(map(int, input().split()))
    if X[0]+X[1]<=X[-1]:
        print(1, 2, N)
    else:
        print(-1)

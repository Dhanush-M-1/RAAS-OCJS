N, M = map(int, input().split())
S = [list(map(int, input().split())) for _ in range(N)]
C = [list(map(int, input().split())) for _ in range(M)]
for a, b in S:
    dist = [abs(a-c) + abs(b-d) for c, d in C]
    print(dist.index(min(dist))+1)

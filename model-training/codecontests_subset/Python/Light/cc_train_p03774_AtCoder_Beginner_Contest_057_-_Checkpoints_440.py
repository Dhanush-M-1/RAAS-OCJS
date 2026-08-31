N, M = map(int, input().split())
AB = [tuple(map(int, input().split())) for _ in range(N)]
CD = [tuple(map(int, input().split())) for _ in range(M)]
f = lambda ab: min((abs(ab[0]-CD[i][0])+abs(ab[1]-CD[i][1]),i+1) for i in range(M))[1]
print(*[f(ab) for ab in AB], sep="\n")
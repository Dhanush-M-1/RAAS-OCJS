N, M = map(int,input().split())
AB = [list(map(int,input().split())) for _ in range(N)]
CD = [list(map(int,input().split())) for _ in range(M)]

for ab in AB:
    man = [(abs(ab[0]-CD[i][0]) + abs(ab[1]-CD[i][1])) for i in range(len(CD))]
    print(man.index(min(man))+1)
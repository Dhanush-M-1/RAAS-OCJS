N, M = map(int, input().split())
s = [tuple(map(int, input().split())) for _ in range(N)]
c = [tuple(map(int, input().split())) for _ in range(M)]
for i in range(N):
    mn = [abs(s[i][0]-c[j][0])+abs(s[i][1]-c[j][1]) for j in range(M)]
    print(mn.index(min(mn))+1)
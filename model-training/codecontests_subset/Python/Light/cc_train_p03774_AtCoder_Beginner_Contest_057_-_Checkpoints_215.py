n,m = map(int,input().split())
a = [list(map(int,input().split())) for A in range(n)]
c = [list(map(int,input().split())) for C in range(m)]
for i in range(n):
    ans = []
    for j in range(m):
        ans.append((abs(a[i][0]-c[j][0])+abs(a[i][1]-c[j][1])))
    print(ans.index(min(ans))+1)
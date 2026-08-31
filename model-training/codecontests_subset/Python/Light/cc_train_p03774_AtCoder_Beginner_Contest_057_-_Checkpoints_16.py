n,m = map(int,input().split())
a = [list(map(int,input().split())) for i in range(n)]
c = [list(map(int,input().split())) for i in range(m)]

for i in a:
    ans = [abs(i[0]-j[0])+abs(i[1]-j[1])for j in c]
    ans_min = min(ans)
    print(ans.index(ans_min)+1)
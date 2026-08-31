N,M=map(int,input().split())
A = [list(map(int, input().split())) for i in range(N)]
C= [list(map(int, input().split())) for i in range(M)]

for i in A:
    ans=[abs(i[0]-j[0])+abs(i[1]-j[1]) for j in C]
    ans_min=min(ans)
    print(ans.index(ans_min)+1)
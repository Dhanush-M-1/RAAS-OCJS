N,M=map(int,input().split())
stu=[list(map(int,input().split())) for _ in range(N)]
che=[list(map(int,input().split())) for _ in range(M)]

for i in range(N):
    dis=[]
    for k in range(M):
        dis.append(abs(stu[i][0]-che[k][0])+abs(stu[i][1]-che[k][1]))
    shortest=min(dis)
    print(dis.index(shortest)+1)
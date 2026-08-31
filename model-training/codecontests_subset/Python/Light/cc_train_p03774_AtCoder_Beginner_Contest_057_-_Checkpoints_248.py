N,M=map(int,input().split())
a=[list(map(int,input().split())) for i in range(N)]
b=[list(map(int,input().split())) for i in range(M)]
for i in range(N):
    l=[]
    for j in range(M):
        l.append(abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]))
    print(l.index(min(l))+1)
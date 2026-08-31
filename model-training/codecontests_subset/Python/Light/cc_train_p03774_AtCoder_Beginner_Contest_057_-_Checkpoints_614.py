N,M=map(int,input().split())
A=[]
C=[]
for i in range(N):
    A.append([int(i) for i in input().split()])
for j in range(M):
    C.append([int(i) for i in input().split()])

for i in range(N):
    l=[]
    for k in range(M):
        l.append(abs(A[i][0]-C[k][0])+abs(A[i][1]-C[k][1]))
    print(l.index(min(l))+1)

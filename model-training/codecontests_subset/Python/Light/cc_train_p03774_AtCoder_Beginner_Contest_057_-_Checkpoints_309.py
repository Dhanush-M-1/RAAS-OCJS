#Checkpoints
N,M = list(map(int, input().split()))
s,c =[],[]
for i in range(N):
    s.append( list(map(int, input().split())) )
for i in range(M):
    c.append( list(map(int, input().split())) )
    
for si in s:
    l = [ abs(si[0]-c[i][0])+abs(si[1]-c[i][1]) for i in range(M) ]
    print(l.index(min(l))+1)
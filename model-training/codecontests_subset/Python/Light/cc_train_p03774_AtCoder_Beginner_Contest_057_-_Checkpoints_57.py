N,M=map(int,input().split())
S=[list(map(int,input().split())) for n in range(N)]
C=[list(map(int,input().split())) for m in range(M)]
for s in S:
    l=[]
    for c in C:
        l.append(abs(s[0]-c[0])+abs(s[1]-c[1]))
    print(l.index(min(l))+1)

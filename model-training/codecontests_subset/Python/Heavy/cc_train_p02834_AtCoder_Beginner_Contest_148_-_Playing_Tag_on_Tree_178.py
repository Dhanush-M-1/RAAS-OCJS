N,u,v = map(int, input().split())
G=[[] for i in range(N)]
for i in range(N-1):
    s,t = map(int, input().split())
    G[s-1].append(t-1)
    G[t-1].append(s-1)


def expro(u):
    D=[0]*N
    D[u]=0
    S=[]
    S.append(u)
    L=[]
    q=0
    while(q<N):
        l=S[q]
        for i in range(len(G[l])):
            m=G[l][i]
            if(len(G[l])==1 and l!=u):
                L.append(l)
            if(D[m]==0 and m!=u):
                D[m]=D[l]+1
                S.append(m)
        #S.remove(l)
        q+=1
    return L,D
L,D = expro(u-1)
M,E = expro(v-1)
k=0
ans=0
#print(G)
#print(D)
#print(L)
for i in M:
    if D[i]<E[i]:
        if k<E[i]:
            k=E[i]
            ans=E[i]-1
print(ans)

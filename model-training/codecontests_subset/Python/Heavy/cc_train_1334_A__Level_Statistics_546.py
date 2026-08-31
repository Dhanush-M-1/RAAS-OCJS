# cook your dish here
for t in range(int(input())):
    R=[]
    G=[]
    hu=0
    hi=0
    su=0
    p=0
    o=0
    for _ in range(int(input())):
        l,m=map(int,input().split())
        R.append(l)
        G.append(m)
    for i in range(len(R)):
        if R[i]>=0 and G[i]>=0:
            if i!=len(R)-1:
                if (R[i+1]-R[i]<G[i+1]-G[i]) :
                    su =su-1
                    
                    
        if R[i]>=G[i] and G[i]>=hu and R[i]>=hi  :
            su=su+1
            hu = G[i]
            hi=R[i]
            o=o+G[i]
            p=p+R[i]
        if i!=len(R)-1:
            if R[i+1]==hi and G[i+1]!=hu:
                su=su-1
                
    if su==len(R):
        print("YES")
    else:
        print("NO")
def answer(n,k,l):
    
    l.sort(key=lambda x:x[0])
    a=[]
    b=[]
    ab=[]

    for i in range(n):
        if l[i][1]==1 and l[i][2]==1:
            ab.append(l[i][0])
        elif l[i][1]==1:
            a.append(l[i][0])
        elif l[i][2]==1:
            b.append(l[i][0])
    mini=min(len(a),len(b))
    if mini+len(ab)<k:
        return -1
    t=0
    ai=0
    bi=0
    abi=0
    for i in range(k):
        if ai<len(a) and bi<len(b) and abi<len(ab):
            if a[ai]+b[bi]<=ab[abi]:
                t+=a[ai]+b[bi]
                ai+=1
                bi+=1
            else:
                t+=ab[abi]
                abi+=1
                
        elif (ai>=len(a) or bi>=len(b)):
            t+=ab[abi]
            abi+=1
        elif abi>=len(ab):
            t+=a[ai]+b[bi]
            ai+=1
            bi+=1
            
    return t
            
        
n,k=map(int,input().split())
l=[]
for i in range(n):
    t=list(map(int,input().split()))
    l.append(t)
print(answer(n,k,l))
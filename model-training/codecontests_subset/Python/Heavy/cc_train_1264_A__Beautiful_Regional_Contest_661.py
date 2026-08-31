import sys
def inp():
    return sys.stdin.readline().strip()
for _ in range(int(inp())):
    n=int(inp())
    a=list(map(int,inp().split()))
    a.sort(reverse=True)
    ind={}
    for i in range(n):
        ind[a[i]]=i
    k=sorted(ind.keys(),reverse=True)
    l=1
    gg=ind[k[0]]+1 
    ss=0
    while l<len(k) and gg>=ss:
        ss+=ind[k[l]]-ind[k[l-1]]
        l+=1 
    bb=0 
    while l<len(k) and (bb<=gg or (gg+bb+ss+ind[k[l]]-ind[k[l-1]])<=n//2):
        bb+=ind[k[l]]-ind[k[l-1]]
        l+=1 
    if gg==0 or bb==0 or ss==0 or gg>=min(bb,ss) or (gg+bb+ss)>n//2:
        print(0,0,0)
    else:
        print(gg,ss,bb)
            
        
        
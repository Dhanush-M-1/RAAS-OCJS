n,k=list(map(int,input().rstrip().split()))
t=[]
ta=[]
tb=[]
common=0
cm={}
for i in range(n):
    a=list(map(int,input().rstrip().split()))
    if a[1]==1 & a[2]==1:
        
        t.append(a[0])
    else:
        
        if a[1]==1:
            ta.append(a[0])
        if a[2]==1:
            tb.append(a[0])
if len(ta)<k-len(t) or len(tb)<k-len(t):
    print(-1)
else:
    ta.sort()
    tb.sort()
    t.sort()
    s=[]
    for i in range(min(len(ta),len(tb))):
        s.append(ta[i]+tb[i])
    
    l=t[:k]+s[:k]    
    l.sort()
   
    print(sum(l[:k]))
    
            
            
        
    
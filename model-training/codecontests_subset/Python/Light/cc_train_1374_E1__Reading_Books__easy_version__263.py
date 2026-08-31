# cook your dish here
n,k=map(int,input().split())
a=[]
b=[]
bb=[]
x=[]
cnta=0
cntb=0
for i in range(n):
    t,p,q=list(map(int,input().split()))
    
    t=[t,p,q]
    x.append(t)


    t,p,q=x[i]
    if p and q:
        bb.append(t)
        cnta+=1
        cntb+=1
    elif p:
        a.append(t)
        cnta+=1
    elif q:
        b.append(t)
        cntb+=1
a.sort()
b.sort()
if cnta>=k and cntb>=k:
    for i in range(min(len(a),len(b))):
        bb.append(a[i]+b[i])
    out=0
    bb.sort()
    for i in range(k):
        out+=bb[i]
    print(out)
    
                
        
    
else:
    print(-1)

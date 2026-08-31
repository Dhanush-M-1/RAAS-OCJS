
n,k=map(int,input().split())
a=[]
b=[]
ab=[]
counta=0
countb=0
for x in range(n):
        t,p,q=map(int,input().split())
        if p==1 and q==1:
            counta=counta+1
            countb=countb+1
            ab.append(t)
        elif p==1 and q!=1:
            counta=counta+1
            a.append(t)
        elif q==1 and p!=1:
            countb=countb+1
            b.append(t)
if counta>=k and countb>=k:
        a.sort()
        b.sort()
        for x in range(min(len(a),len(b))):
            ab.append(a[x]+b[x])
        res=0
        ab.sort()
        for x in range(k):
            res=res+ab[x]
        print(res)
                       


else:
        print(-1)
        
   

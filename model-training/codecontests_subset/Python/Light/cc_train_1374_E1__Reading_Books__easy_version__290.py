n,k=map(int,input().split())
A,B,C=[],[],[]
for i in range(n):
    t,x,y=map(int,input().split())
    if(x==1 and y==1):C.append(t);continue
    if(x==1):A.append(t);continue
    if(y==1):B.append(t)
def fun(l):
    pre=[0]
    for i in l:
        pre.append(pre[-1]+i)
    return pre
A.sort()
B.sort()
C.sort()

a=fun(A)
b=fun(B)
c=fun(C)
if(len(A)+len(C)<k or len(B)+len(C)<k):print(-1)
else:
    ans=999999999999999999999999999
    for i in range(min(len(C),k)+1):
        if(k-i<len(a) and k-i<len(b)):ans=min(ans,c[i]+a[k-i]+b[k-i])
    print(ans)    
    
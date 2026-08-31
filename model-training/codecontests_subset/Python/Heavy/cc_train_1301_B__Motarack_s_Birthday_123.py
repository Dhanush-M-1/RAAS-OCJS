n=int(input())
for i in range(n):
    a=int(input())
    b=list(map(int,input().split()))
    mx=-100000000
    mn=1000000000
    for i in range(a):
        if i>0 and b[i]==-1 and b[i-1]!=-1:
            mn=min(mn,b[i-1])
            mx=max(mx,b[i-1])
        if i<a-1 and b[i]==-1 and b[i+1]!=-1:
            mn=min(mn,b[i+1])
            mx=max(mx,b[i+1])
 
        
    h=mn
    m=mx
    l=(m+h)//2
    for i in range(a):
        if b[i]==-1:
            b[i]=l
    diff=0
    for i in range(1,a):
        if abs(b[i]-b[i-1])>diff:
            diff=abs(b[i]-b[i-1])
    print(diff,l)
            

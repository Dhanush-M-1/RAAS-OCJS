n=int(input())
x=[]
h=[]
for i in range(n):
   a,b=map(int,input().split())
   x.append(a)
   h.append(b)
c=1
if n>=2:
    c=2

for i in range(1,n-1):
    l=x[i]-x[i-1]-1
    r=x[i+1]-x[i]-1
    if h[i]<=l:
        c=c+1
        
    elif h[i]<=r:
        c=c+1
        x[i]=x[i]+h[i]
print(c)
        
        
    
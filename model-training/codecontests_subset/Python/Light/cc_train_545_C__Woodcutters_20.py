n=int(input())
x,h=[],[]
for i in range(n):
    a,b=map(int,input().split())
    x.append(a)
    h.append(b)

p=[0]*(n+1)
p[0]=x[0]
ans=1 if n==1 else 2
for i in range(1,n-1):
    if x[i]-h[i]>p[i-1]:
        p[i]=x[i]
        ans+=1
    elif x[i]+h[i]<x[i+1]:
        p[i]=x[i]+h[i]
        ans+=1
    else:
        p[i]=x[i]

print(ans)

n,a,b,c=map(int,input().split())
if a%2==1:a-=1
a//=2
if a>b: a,b=b,a
w=0
if 2*c+a+b>=0:
  for cc in range(c+1):
    s=n-2*cc
    if s>a+b: continue
    if s<0: break
    mn=max(0,s-b)
    mx=min(a,s)
    w+=(mx-mn+1)
print(w)
    

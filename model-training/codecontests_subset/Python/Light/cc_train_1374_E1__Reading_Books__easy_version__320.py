R=lambda:map(int,input().split())
s=sorted
n,k=R()
_,u,v,w=l=[[],[],[],[]]
for _ in[0]*n:t,a,b=R();l[2*a+b]+=t,
a=*map(sum,zip(s(u),s(v))),*w
print(sum((s(a)+[-sum(a)-1])[:k]))
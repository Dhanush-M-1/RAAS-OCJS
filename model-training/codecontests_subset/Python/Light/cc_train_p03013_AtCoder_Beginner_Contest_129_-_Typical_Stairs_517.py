n,_,*l=map(int,open(0).read().split())
s=set(l)
p,t=0,1
for i in range(n): p,t=t,(p+t)%(10**9+7)*(not{i+1}&s)
print(t)
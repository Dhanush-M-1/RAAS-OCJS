n,_,*l=map(int,open(0).read().split());l=set(l);s,t=0,1
for i in range(n):s,t=t,(s+t)%(10**9+7)*(not{i+1}&l)
print(t)
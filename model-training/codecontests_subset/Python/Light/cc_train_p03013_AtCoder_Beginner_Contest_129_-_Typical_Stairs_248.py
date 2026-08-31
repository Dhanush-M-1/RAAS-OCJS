n,_,*l=map(int,open(0).read().split());l=set(l);s=i=0;t=1
while i<n:i+=1;s,t=t,(s+t)%(10**9+7)*(not{i}&l)
print(t)
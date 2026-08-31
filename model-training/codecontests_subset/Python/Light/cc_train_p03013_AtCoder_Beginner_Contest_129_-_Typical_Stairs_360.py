n,b,*a=map(int,open(0).read().split())
a=set(a)
d=i=0
c=1
while i<n:i+=1;b=(c+d)%(10**9+7)*(not{i}&a);c,d=b,c
print(b)
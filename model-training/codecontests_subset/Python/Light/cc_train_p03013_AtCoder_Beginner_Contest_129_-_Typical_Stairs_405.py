n,m=map(int,input().split())
l=set(int(input())-1 for _ in range(m))
s,t=0,1
for i in range(n): s,t=t,(s+t)%(10**9+7)*(1-(i in l))
print(t)
fib=[0,0,1,2]
for i in range(4,100005):
  fib.append(fib[i-1]+fib[i-2])

n,m=map(int,input().split())
a=[int(input()) for i in range(m)]

a=set(a)

p,q=0,1

for i in range(1,n+1):
  p,q=q,(p+q)%(10**9+7)*(not i in a)

print(q)
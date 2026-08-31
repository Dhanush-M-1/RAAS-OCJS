n,m = map(int,input().split())
li=[0]*(n+1)
a=set([int(input()) for i in range(m)])
li[0]=1
for i in range(1,n+1):
  li[i]=(li[i-1]+li[i-2])%(10**9+7)
  if i in a:li[i]=0
print(li[n])
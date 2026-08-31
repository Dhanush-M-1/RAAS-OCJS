t=int(input())
for castle in range(t):
 n=int(input())
 ls=list(map(int,input().split()))
 a,b,c=ls[0],ls[1],ls[-1]
 if a+b>c:
  print(-1)
 else:
  print(*[1,2,n])
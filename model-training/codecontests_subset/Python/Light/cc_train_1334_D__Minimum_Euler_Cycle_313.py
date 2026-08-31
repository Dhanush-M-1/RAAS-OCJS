import sys
input=sys.stdin.readline
t=int(input())
for _ in range(t):
  n,l,r=map(int,input().split())
  begin=1
  while l>(n-begin)*2+1:
    if begin==n:
      break
    l-=(n-begin)*2
    r-=(n-begin)*2
    begin+=1
  if begin==n:
    ans=[n,1]
  else:
    ans=[]
    while len(ans)<=r:
      if begin==n:
        ans.append(1)
        break
      for j in range(begin+1,n+1):
        ans.append(begin)
        ans.append(j)
      begin+=1
  print(*ans[l-1:r])
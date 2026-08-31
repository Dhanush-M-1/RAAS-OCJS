import bisect

t=int(input())
for _ in range(t):
  n,l,r=map(int,input().split())
  ans=[]
  sums=[]
  tmp=0
  for i in range(n-1,0,-1):
    tmp+=i
    sums.append(tmp)
  for i in range(l-1,r):
    if i%2==0:
      k=i//2
      g=bisect.bisect_right(sums,k)
      tmp=0
      if g==n-1:
        ans.append(1)
      else:
        ans.append(g+1)
    else:
      k=(i-1)//2
      g=bisect.bisect_right(sums,k)
      tmp=(g*(2*(n-1)-(g-1)))//2
      ans.append(2+g+k-tmp)
  print(*ans)
for _ in range(int(input())):
  n=int(input())
  a=list(map(int,input().split()));a.sort()
  k=a[0]+a[1];c=0
  for i in range(2,n):
    if a[i]>=k:
      b=i;c=1
      break
  if c==0:
    print(-1)
  else:
    print(1,2,b+1)
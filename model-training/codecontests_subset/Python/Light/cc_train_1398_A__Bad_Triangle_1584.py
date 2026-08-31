for t in range(int(input())):
  n=int(input())
  a=list(map(int,input().split()))
  i=0
  y=1
  for z in range(2,n):
    if(a[i]+a[y]<=a[z]):
      break
  if(i==z or a[i]+a[y]>a[z]):
    print(-1)
  else:
    print(i+1,y+1,z+1)    
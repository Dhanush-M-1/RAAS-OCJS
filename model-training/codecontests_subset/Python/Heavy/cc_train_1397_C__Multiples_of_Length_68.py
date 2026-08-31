n=int(input())
li=list(map(int,input().split()))
if n==1:
  print(1,1)
  print(-li[0])
  print(1,1)
  print(0)
  print(1,1)
  print(0)
else:
  print(1,n)
  for i in range(n):
    if li[i]>=0:
      print(n*(-li[i]),end=" ")
    else:
      print(n*abs(li[i]),end=" ")
  print()
  print(1,n-1)
  for i in range(n-1):
    if li[i]>=0:
      print((n-1)*li[i],end=" ")
    else:
      print((n-1)*li[i],end=" ")
  print()
  print(2,n)
  for i in range(1,n):
    if i!=(n-1):
      print(0,end=" ")
    else:
      if li[i]>=0:
        print((n-1)*li[i],end=" ")
      else:
        print((n-1)*li[i],end=" ")























t=int(input())
for i in range(t):
  n=int(input())
  ar=[int(i) for i in input().split()]
  b=ar[0]
  a=ar[1]
  c=ar[-1]
  if a+b<=c:
    print(str(1)+' '+str(2)+' '+str(n))
  else:
    print(-1)
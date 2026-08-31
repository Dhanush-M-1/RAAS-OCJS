t=int(input())
for _ in range(t):
  n=int(input())
  li=list(map(int,input().split()))
  val=False
  for i in range(2,n):
    if li[0]+li[1]<=li[i]:
      print(f'1 2 {i+1}')
      val=True
      break
  if  not val:
    print(-1)

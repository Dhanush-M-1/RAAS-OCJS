t=int(input())
for _ in range(t):
  n=int(input())
  L=[int(x) for x in input().split()]
  if (L[0]+L[1])<=L[-1]:
      print('1 2 '+str(n))
  else:
      print(-1)


for i in range(int(input())):
  n=int(input())
  a=[int(x) for x in input().split()]
  k=True
  if (a[0]+a[1])<=a[-1]:
    print(1,2,n)
    k=False
  if k:
    print(-1)
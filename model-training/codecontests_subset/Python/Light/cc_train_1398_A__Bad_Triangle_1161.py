for i in range(int(input())):
 n=int(input())
 a=[int(num) for num in input().split()]
 if(a[0]+a[1]<=a[n-1]):
  print(1,2,n)
 else:
  print(-1)
 
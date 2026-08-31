t = int(input())
#print("out")
for _ in range(t):
  n = int(input())
  a = list(map(int,input().split()))
  i = 0
  k = n-1
  f = False
  while i+1<n and i+1<k:
    j = i+1
    while j<k and a[i]+a[j]>a[k]:
      k-=1
    if j<k and (not a[i]+a[j]>a[k]):
      print(i+1,j+1,k+1)
      break
    i+=1
  else:
    print(-1)
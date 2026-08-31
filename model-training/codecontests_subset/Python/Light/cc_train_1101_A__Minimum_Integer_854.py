n = int(input())
for _ in range(n):
  l,r,d = input().split()
  l,r,d = int(l),int(r),int(d)
  if(d<l):
    print(d)
  elif(d>r):
    print(d)
  else:
    k = int(r/d)
    k = k + 1
    print(d*k)
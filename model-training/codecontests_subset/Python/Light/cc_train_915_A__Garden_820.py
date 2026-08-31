n,k = list(map(int,input().split()))
r = 10**9
for l in list(map(int,input().split())):
  if k%l==0:
    r = min(r,k//l)
print(r)
  

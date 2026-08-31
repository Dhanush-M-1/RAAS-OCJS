_, k=map(int, input().split())
a=sorted(list(map(int, input().split())))
res=k
for i in range(len(a)):
  if (k%a[i]==0):
    res=min(res, k//a[i])
print (res)
import math
n,k=map(int,input().split())
a = list(map(int, input().split()))
mn=1000
for i in range(n):
    if k%a[i]==0 and k/a[i]<mn:
        mn=k/a[i]
print(math.trunc(mn))
from sys import stdin
import math
m = 998244353
def put():  return  map(int, stdin.readline().split())
 
def inv(a,b):
    return (pow(b, m-2, m)*(a%m))%m

n, k = put()
C = [0]*(n+1)
C[k-1] = 1
for i in range(k, n+1):
    C[i] = inv(C[i-1]*i,i-k+1)

l,r = [],[]
for _ in range(n):
    a,b = put()
    l.append(a)
    r.append(b)

l.sort()
r.sort()

i,j = 0,0
count = 0
ans = 0
while i<n and j<n:
    if l[i]<=r[j]:
        ans += C[count]
        count+=1
        i+=1
    else:
        count-=1
        j+=1

print(ans%m)
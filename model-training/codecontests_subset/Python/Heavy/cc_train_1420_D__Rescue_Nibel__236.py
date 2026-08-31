from sys import stdin
import math
input = stdin.readline
m = 998244353
def put():  return  map(int, input().split())
 
def inv(a,b):
    g = math.gcd(b,m)
    return (pow(b, m-2, m)*(a%m))%m

n, k = put()
C = [0]*(n+1)
C[k-1] = 1
for i in range(k, n+1):
    C[i] = inv(C[i-1]*(i%m),(i-k+1)%m)
    C[i]%= m
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

print(ans%998244353)
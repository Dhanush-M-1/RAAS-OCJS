import math
def fact(n):
    ans = 1
    for i in range(2, n+1):
        ans*= i
    return ans
def comb(n, c):
    return fact(n)//(fact(n-c)*c)

n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))
ans = []
f1 = 0
f2 = 0
for i in range(n-1):
    if(a[i]!= b[i]):
        ans.append(a[i])
        f1 = 1
        break
if(not f1):
    ans.append(a[n-1])
for i in range(n-2):
    if(b[i]!= c[i]):
        ans.append(b[i])
        f2 = 1
        break
if(not f2):
    ans.append(b[n-2])
for i in range(2):
    print(ans[i])
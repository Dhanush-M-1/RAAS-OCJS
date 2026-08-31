from math import gcd
n = int(input())
a = [int(i) for i in input().split()]

g = a[0]
for i in range(n):
    g = gcd(g,a[i])
if g != 1:
    print("not coprime")
    exit()

s = set(a)
a.sort()
m = a[-1]
isPrime = [False]*(m+1)
for i in range(2,m+1):
    if isPrime[i]: continue
    flag = False
    for j in range(i,m+1,i):
        isPrime[j] = True
        if j in s:
            if flag:
                print("setwise coprime")
                exit()
            flag = True
print("pairwise coprime")
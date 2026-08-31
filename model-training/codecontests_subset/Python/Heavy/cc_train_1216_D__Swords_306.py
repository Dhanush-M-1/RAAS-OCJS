import sys
input=sys.stdin.readline
from math import ceil,sqrt,gcd
n = int(input())
a = list(map(int,input().split()))
su = sum(a)
x1 = ceil(su / n)
x2 = max(a)
x = max(x1,x2)#min(x)
r = x-a[0]
for i in range(1,n):
    r = gcd(r,x-a[i])

t = ((x*n)-su)
print(max(r,t)//min(r,t),end=" ")
print(min(r,t))

'''
su = sum(a)
#y = ((n*x)-su) / z

x1 = ceil(su / n)
x2 = max(a)
x = max(x1,x2)#min(x)
t = ((x*n)-su)


z = (x-min(a))
print(z)
for i in range(z,0,-1):
    if t % i == 0:
        print(t//i,i)
        break
'''

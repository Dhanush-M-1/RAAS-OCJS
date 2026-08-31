import math
n , m =map(int,input().split())
s = n
l = n
while n>0:
    n = math.floor(l/m)
    l = l%m + n
    s+=n
print(s)
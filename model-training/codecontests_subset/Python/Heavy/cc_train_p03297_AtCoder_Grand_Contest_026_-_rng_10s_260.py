#from math import gcd
from fractions import gcd
T = int(input())
ABCD = [list(map(int,input().split())) for _ in range(T)]

for a,b,c,d in ABCD:
    if a < b:
        print('No')
        continue
    if d < b:
        print('No')
        continue
    tmp = a % b
    if tmp > c:
        print('No')
        continue
    if d % b == 0:
        print('Yes')
        continue
    if c >= b-1:
        print('Yes')
        continue
    if a%2 == 0 and b%2 == 0 and d %2 == 0 and b-c == 2:
        print('Yes')
        continue
    GCD = gcd(b,d)
    if b-GCD +(a%GCD) > c:
        print('No')
    else:
        print('Yes')



    
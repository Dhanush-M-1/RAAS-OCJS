from fractions import gcd
t = int(input())
for i in range(t):
    a,b,c,d = map(int, input().split())
    if a < b:
        print('No')
        continue
    if d < b:
        print('No')
        continue
    if c >= b - 1:
        print('Yes')
        continue
    if c < a % b:
        print('No')
        continue
    if d % b == 0:
        print('Yes')
        continue
    g = gcd(b,d)
    if c % b < (b - g + (a % g)) % b:
        print('No')
        continue
    print('Yes')

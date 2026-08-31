import math
for _ in range(int(input())):
    a,b,c,d = map(int,input().split())
    print('Yes' if b <= min(a, d, c+1+(a-c-1)%math.gcd(b,d)) else 'No')
from math import gcd

def solve(a,b,c,d):
  
    if a < b:
        return False
    if d < b:
        return False

    g = gcd(b,d)
    m = b - (b-a-1)%g - 1
    return m <= c

T = int(input())
for _ in range(T):
    print('Yes' if solve(*map(int,input().split())) else 'No')

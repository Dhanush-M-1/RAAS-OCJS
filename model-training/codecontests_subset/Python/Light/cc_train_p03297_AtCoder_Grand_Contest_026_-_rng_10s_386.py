from math import gcd

def solve(a,b,c,d):
  
    if a < b:
        return False
    if d < b:
        return False

    g = gcd(b,d)
    c += 1
    m = c + (a-c)%g
    return b <= m

T = int(input())
for _ in range(T):
    print('Yes' if solve(*map(int,input().split())) else 'No')
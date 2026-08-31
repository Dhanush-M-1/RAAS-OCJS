from fractions import gcd

T = int(input())
qs = [tuple(map(int,input().split())) for i in range(T)]

def solve(q):
    a,b,c,d = q
    if b > d: return False
    if a < b: return False
    a %= b
    if a > c: return False
    if b == d: return True
    g = gcd(b, d)
    return b-g <= c

for q in qs:
    print('Yes' if solve(q) else 'No')
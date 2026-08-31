import sys
import collections

input = sys.stdin.readline

def rints():
    return map(int, input().strip().split())
def rint():
    return int(input().strip())
def rintas():
    return [int(i) for i in input().strip().split()]
def gcd(a, b):
    if a == 0:
        return b
    return gcd(a%b, a)

n = rint()
for _ in range(n):
    a, b, c  = rints()
    ans = 0
    while (a > 0 and b > 1) or (b>0 and c > 1):
        if b > 0 and c > 1:
            ans += 3
            b -= 1
            c -= 2
        elif a > 0 and b > 1:
            ans += 3
            a -= 1
            b -= 2
        else:
            break
    print(ans)

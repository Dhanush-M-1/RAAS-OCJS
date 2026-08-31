import sys, math
import heapq

from collections import deque
input = sys.stdin.readline

#input
def ip(): return int(input())
def sp(): return str(input().rstrip())

def mip(): return map(int, input().split())
def mfp(): return map(float, input().split())
def msp(): return map(str, input().split())

def lmip(): return list(map(int, input().split()))
def lmsp(): return list(map(str, input().split()))

#gcd, lcm
def gcd(x, y):
    while y:
        x, y = y, x % y
    return x

def lcm(x, y):
    return x * y // gcd(x, y)

#prime
def isPrime(x):
    if x==1: return False
    for i in range(2, int(x**0.5)+1):
        if x%i==0:
            return False
    return True

# Union Find
# p = {i:i for i in range(1, n+1)}
def find(x):
    if x == p[x]:
        return x
    q = find(p[x])
    p[x] = q
    return q

def union(x, y):
    global n
    x = find(x)
    y = find(y)

    if x != y:
        p[y] = x

def getPow(a, x):
    ret =1
    while x:
        if x&1:
            ret = (ret*a) % MOD
        a = (a*a)%MOD
        x>>=1
    return ret

def getInv(x):
    return getPow(x, MOD-2)

############### Main! ###############

MOD = 10**9 + 7
dp = [0 for _ in range(202020)]
for i in range(9):
    dp[i]=2
dp[9]=3
for i in range(10,202020):
    dp[i] = (dp[i-9]+dp[i-10])%MOD

t = ip()
while t:
    ans=0
    t -= 1
    n,k = mip()

    while n:
        if k+n%10<10:
            ans += 1
        else:
            ans += dp[k + n%10 - 10]

        n//=10

    print(ans%MOD)

######## Priest W_NotFoundGD ########
# Fast IO (be careful about bytestring, not on interactive)
 
import os,io
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
 
n,k = map(int,input().split())
MOD = 998244353 
 
# modular inverse for positive a and b and nCk mod MOD depending on modinv
def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)
 
def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m
 
combinationList = []
 
def combination(n,k,MOD): 
    ans = 1
    combinationList.append(ans)
    for i in range(1,n - k + 1):
        ans *= k + i
        ans %= MOD
        ans *= modinv(i,MOD)
        ans %= MOD
        combinationList.append(ans)
 
query = []
 
for i in range(n):
    l,r = map(int,input().split())
    query.append(l * 3 + 1)
    query.append(r * 3 + 2)
 
query.sort()
 
combination(n,k - 1,MOD)
 
cnt = 0
ans = 0
for elem in query:
    if elem % 3 == 1:
        if cnt >= k - 1:
            ans += combinationList[cnt - k + 1]
            ans %= MOD
        cnt += 1
    else:
        cnt -= 1
print(ans % MOD)
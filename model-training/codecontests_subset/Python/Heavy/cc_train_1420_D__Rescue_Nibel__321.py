import sys
input=sys.stdin.readline
N = 300001
factorialNumInverse = [None] * (N + 1)
naturalNumInverse = [None] * (N + 1)
fact = [None] * (N + 1)
def InverseofNumber(p):
    naturalNumInverse[0] = naturalNumInverse[1] = 1
    for i in range(2, N + 1, 1):
        naturalNumInverse[i] = (naturalNumInverse[p % i] *
                                (p - int(p / i)) % p)
def InverseofFactorial(p):
    factorialNumInverse[0] = factorialNumInverse[1] = 1

    for i in range(2, N + 1, 1):
        factorialNumInverse[i] = (naturalNumInverse[i] *
                                  factorialNumInverse[i - 1]) % p

def factorial(p):
    fact[0] = 1
    for i in range(1, N + 1):
        fact[i] = (fact[i - 1] * i) % p
def Binomial(N, R, p):
    if N<R:
        ans=0
    else:
        ans = ((fact[N] * factorialNumInverse[R]) % p *
               factorialNumInverse[N - R]) % p
    return ans
p=998244353
InverseofNumber(p)
InverseofFactorial(p)
factorial(p)
n,k=map(int,input().split())
init=[]
final=[]
for _ in range(n):
    li,ri=map(int,input().split())
    init.append(li)
    final.append(ri)
init.sort()
final.sort()
i=0
j=0
ans=0
while i<n:
    while final[j]<init[i]:
        j+=1
    if i-j+1>=k:
        ans+=Binomial(i-j,k-1,p)
    i+=1
print(ans%p)
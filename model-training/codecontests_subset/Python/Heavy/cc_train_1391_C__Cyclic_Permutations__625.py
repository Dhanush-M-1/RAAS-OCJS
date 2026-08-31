import sys

sys.setrecursionlimit(10 ** 5)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

md=10**9+7
mx=10**6+5
fac=[1]
for i in range(1,mx+1):fac.append(fac[-1]*i%md)

n=II()
ans=fac[n]-pow(2,n-1,md)
print(ans%md)

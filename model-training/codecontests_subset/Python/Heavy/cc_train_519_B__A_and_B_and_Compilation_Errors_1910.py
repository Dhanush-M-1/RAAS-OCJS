import sys
from random import choice,randint
inp=sys.stdin.readline
out=sys.stdout.write
flsh=sys.stdout.flush
 
sys.setrecursionlimit(10**9)
inf = 10**20
eps = 1.0 / 10**10
mod = 10**9+7
dd = [(-1,0),(0,1),(1,0),(0,-1)]
ddn = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]
 
def MI(): return map(int, inp().strip().split())
def LI(): return list(map(int, inp().strip().split()))
def LLI(): return [list(map(int, l.split())) for l in sys.stdin.readlines().strip()]
def LI_(): return [int(x)-1 for x in inp().strip().split()]
def LF(): return [float(x) for x in inp().strip().split()]
def LS(): return inp().strip().split()
def I(): return int(inp().strip())
def F(): return float(inp().strip())
def S(): return inp().strip()
def pf(s): return out(s+'\n')
def JA(a, sep): return sep.join(map(str, a))
def JAA(a, s, t): return s.join(t.join(map(str, b)) for b in a)

def main():
    n = I()
    a = LI()
    b = LI()
    c = LI()
    a.sort()
    b.sort()
    c.sort()
    f1,f2=0,0
    for i in range(len(b)):
        if a[i]!=b[i]:
            f1=1
            if a[i]>b[i]:
                print(b[i])
            else:
                print(a[i])
            break
    if f1==0:
        print(a[-1])
    for i in range(len(c)):
        if b[i]!=c[i]:
            f2=1
            if b[i]>c[i]:
                print(c[i])
            else:
                print(b[i])
            break
    if f2==0:
        print(b[-1])
        

if __name__ == "__main__":
    main()
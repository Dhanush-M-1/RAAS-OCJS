import sys
from random import choice,randint
 
sys.setrecursionlimit(10**7)
inf = 10**20
eps = 1.0 / 10**10
mod = 10**9+7
dd = [(-1,0),(0,1),(1,0),(0,-1)]
ddn = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]
 
def MI(): return map(int, sys.stdin.readline().strip().split())
def LI(): return list(map(int, sys.stdin.readline().strip().split()))
def LLI(): return [list(map(int, l.split())) for l in sys.stdin.readlines().strip()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().strip().split()]
def LF(): return [float(x) for x in sys.stdin.readline().strip().split()]
def LS(): return sys.stdin.readline().strip().split()
def I(): return int(sys.stdin.readline().strip())
def F(): return float(sys.stdin.readline().strip())
def S(): return sys.stdin.readline().strip()
def pf(s): return print(s, flush=True)
def pe(s): return print(str(s), file=sys.stderr)
def JA(a, sep): return sep.join(map(str, a))
def JAA(a, s, t): return s.join(t.join(map(str, b)) for b in a)

inp=sys.stdin.readline
out=sys.stdout.write

def main():
    n = I()
    l=[]
    for i in range(n):
        h,a = MI()
        l.append([h,a])
    c=0
    for i in range(n):
        for j in range(n):
            x,y=l[i],l[j]
            if i!=j and x[0]==y[1]:
                c+=1
    pf(c)

if __name__ == "__main__":
    main()
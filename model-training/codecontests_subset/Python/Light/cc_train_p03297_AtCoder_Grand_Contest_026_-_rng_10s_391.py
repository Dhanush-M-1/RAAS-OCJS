printn = lambda x: print(x,end='')
inn = lambda : int(input())
inl   = lambda: list(map(int, input().split()))
inm   = lambda:      map(int, input().split())
ins = lambda : input().strip()
DBG = True # and False
BIG = 10**18
R = 10**9 + 7

def ddprint(x):
  if DBG:
    print(x)

import fractions
t = inn()
for i in range(t):
    a,b,c,d = inm()
    if a<b or d<b:
        print('No')
    else:
        g = fractions.gcd(b,d)
        r = a%g
        q = c%g
        p = c-q+r
        if p<=c:
            p += g
        #ddprint(f"a {a} b {b} c {c} d {d} g {g} r {r} q {q} p {p}")
        if p>=b:
            print('Yes')
        else:
            print('No')

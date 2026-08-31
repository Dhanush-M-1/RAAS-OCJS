import sys
input = sys.stdin.readline
from  math import ceil
 
(n, k) = map(int, input().split())
bob = []
alice = []
good = []
for i in range(n):
    (t, a, b) = map(int, input().split())
    if a == 1:
        if b == 1:
            good.append(t)
        else:
            alice.append(t)
    else:
        if b == 1:
            bob.append(t)

alice.sort()
bob.sort()
good.sort()

ma = len(alice); mb = len(bob); mg = len(good)
ka = k; kb = k
T = 0
ia = 0; ib = 0; ig = 0
while ka > 0 and kb > 0 and ig < mg and ia < ma and ib < mb:
    if good[ig] <= alice[ia] + bob[ib]:
        T += good[ig]
        ig += 1
    else:
        T += alice[ia] + bob[ib]
        ia += 1
        ib += 1
    ka -= 1
    kb -= 1

if ia == ma:
    while ka > 0 and ig < mg:
        T += good[ig]
        ig += 1
        kb -= 1
        ka -= 1
elif ib == mb:
    while kb > 0 and ig < mg:
        T += good[ib]
        ib += 1
        ka -= 1
        kb -= 1
else:
    while ka > 0 and ia < ma:
        T += alice[ia]
        ia += 1
        ka -= 1

    while kb > 0 and ib < mb:
        T += bob[ib]
        ib += 1
        kb -= 1

if ka > 0 or kb > 0:
    print(-1)
else:
    print(T)

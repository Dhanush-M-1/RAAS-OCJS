#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

n,k = ip()
t,a,b = [0]*n,[0]*n,[0]*n
both = []
alice,bob = [],[]
for i in range(n):
    t[i],a[i],b[i] = ip()
    if a[i] and b[i]:
        both.append(t[i])
    elif a[i]:
        alice.append(t[i])
    elif b[i]:
        bob.append(t[i])
if a.count(1) < k or b.count(1) < k:
    print(-1)
    exit()
alice.sort()
bob.sort()
m = min(len(alice),len(bob))
for i in range(m):
    both.append(alice[i]+bob[i])
both.sort()
print(sum(both[:k]))

    




   
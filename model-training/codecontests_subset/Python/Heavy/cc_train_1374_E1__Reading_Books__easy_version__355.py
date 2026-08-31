import itertools

n, k = map(int,input().split())

both = [0]
alice = [0]
bob = [0]
for _ in range(n):
    t, a, b = map(int,input().split())
    if a and b:
        both.append(t)
    elif a:
        alice.append(t)
    elif b:
        bob.append(t)
        
if len(alice)+len(both) < k or len(bob)+len(both) < k:
    print(-1)
    exit()
    
both.sort()
alice.sort()
bob.sort()

cs_both = list(itertools.accumulate(both))
cs_alice = list(itertools.accumulate(alice))
cs_bob = list(itertools.accumulate(bob))

"""
print(cs_both)
print(cs_alice)
print(cs_bob)
"""

ans = float('inf')
for i in range(k+1):
    try:
        tmp = cs_both[i]
    except IndexError:
        break
    if i == k:
        ans = min(ans, tmp)
    try:
        tmp += cs_alice[k-i]
    except IndexError:
        continue
    try:
        tmp += cs_bob[k-i]
    except IndexError:
        continue
    ans = min(ans, tmp)
if ans == float('inf'):
    print(-1)
else:
    print(ans)
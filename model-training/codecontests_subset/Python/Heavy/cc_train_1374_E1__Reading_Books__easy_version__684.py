from sys import stdin

n, k = list(map(int, stdin.readline().split()))
alice = []
bob = []
both = []
for _ in range(n):
    t, a, b = list(map(int, stdin.readline().split()))
    if a == b == 1:
        both.append(t)
    elif a == 1:
        alice.append(t)
    elif b == 1:
        bob.append(t)
alice = sorted(alice)
bob = sorted(bob)
both = sorted(both)
a, b, c = 0, 0, 0
res = 0
for _ in range(k):
    if c >= len(both) and (a >= len(alice) or b >= len(bob)):
        res = -1
        break
    if c >= len(both):
        res += alice[a]
        res += bob[b]
        a += 1
        b += 1
    elif a >= len(alice) or b >= len(bob):
        res += both[c]
        c += 1
    elif alice[a] + bob[b] < both[c]:
        res += alice[a]
        res += bob[b]
        a += 1
        b += 1
    elif both[c] <= alice[a] + bob[b]:
        res += both[c]
        c += 1
print(res)

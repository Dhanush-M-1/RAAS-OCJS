from heapq import heappush, heappush, heapify
n, k = map(int, input().split())
alice = []
bob = []
both = []
for i in range(n):
    t, a, b = map(int, input().rstrip().split())
    if a == 1 and b == 1:
        both.append(t)
    if a == 1 and b == 0:
        alice.append(t)
    if a == 0 and b == 1:
        bob.append(t)
if len(alice) + len(both) < k or len(bob) + len(both) < k:
    print(-1)
    exit()
alice.sort()
bob.sort()
both.sort()
ans = 0
m = len(both)
n = min(len(alice), len(bob))
i = 0# for both m
j = 0# for individual n
while k > 0:
    both_t = float("inf")
    ab_t = float("inf")
    if i < m:
        both_t = both[i]
    if j < n:
        ab_t = alice[j] + bob[j]
    if both_t <= ab_t:
        ans += both_t
        k -= 1
        i += 1
    else:
        ans += ab_t
        j += 1
        k -= 1
print(ans)
from collections import defaultdict
t = int(input())
res = []
for k in range(t):
    n, m = map(int, input().split())
    s = input()
    P = [int(x) for x in input().split()]
    counters = defaultdict(int)
    P = sorted(P)
    old_curr = 0
    for i in range(m):
        curr = P[i]
        for j in range(old_curr, curr):
            counters[s[j]] += m - i
        old_curr = curr
    for char in s:
        counters[char] += 1
    for char in 'abcdefghijklmnopqrstuvwxyz':
        print(counters[char], end = ' ')
    print()

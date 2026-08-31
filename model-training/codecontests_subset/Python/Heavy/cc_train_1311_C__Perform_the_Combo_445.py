def nLargerOrEqual(p, k):
    low, high = -1, len(p)
    while high - low > 1:
        m = int((low + high) / 2)
        if p[m] < k:
            low = m
        else:
            high = m
    return len(p) - low - 1

t = int(input())
for _ in range(t):
    m, n = map(int, input().split())
    combo = input()
    p = list(map(int, input().split()))
    p.append(len(combo))
    p.sort()
    ans = [0] * 26
    for i in range(len(combo)):
        ans[ord(combo[i]) - ord('a')] += nLargerOrEqual(p, i+1)
    print(*ans)
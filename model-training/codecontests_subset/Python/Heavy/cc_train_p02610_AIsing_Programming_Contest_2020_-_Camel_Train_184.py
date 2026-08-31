import heapq
import sys
input = sys.stdin.readline


t = int(input())
for _ in range(t):
    n = int(input())
    info = [list(map(int, input().split())) for i in range(n)]
    p_li = []
    m_li = []
    ans = 0
    for k, l, r in info:
        diff = l - r
        if diff > 0:
            p_li.append((k - 1, abs(diff)))
            ans += r
        elif diff < 0:
            m_li.append((n - k - 1, abs(diff)))
            ans += l
        else:
            ans += l

    p_li = sorted(p_li, reverse=True)
    l = 0
    q = []
    for i in range(n)[::-1]:
        while l < len(p_li) and p_li[l][0] == i:
            heapq.heappush(q, -p_li[l][1])
            l += 1
        if q:
            val = -heapq.heappop(q)
            ans += val

    m_li = sorted(m_li, reverse=True)
    l = 0
    q = []
    for i in range(n)[::-1]:
        while l < len(m_li) and m_li[l][0] == i:
            heapq.heappush(q, -m_li[l][1])
            l += 1
        if q:
            val = -heapq.heappop(q)
            ans += val
    print(ans)
import heapq
t = int(input())
for _ in range(t):
    n = int(input())
    lefts = [[] for _ in range(n)]
    rights = [[] for _ in range(n)]
    ans = 0
    for i in range(n):
        k, l, r = map(int, input().split())
        k -= 1
        if l >= r:
            ans += r
            lefts[k].append(l-r)
        else:
            ans += l
            rights[k].append(r-l)
    l_queue = []
    heapq.heapify(l_queue)
    for i in range(n):
        for j in range(len(lefts[i])):
            ans += lefts[i][j]
            heapq.heappush(l_queue,lefts[i][j])
        while len(l_queue) > i+1:
            m = heapq.heappop(l_queue)
            ans -= m
    r_queue = []
    heapq.heapify(r_queue)
    for i in range(n):
        for j in range(len(rights[n-i-1])):
            ans += rights[n-i-1][j]
            heapq.heappush(r_queue, rights[n-i-1][j])
        while len(r_queue) > i:
            m = heapq.heappop(r_queue)
            ans -= m
    print(ans)
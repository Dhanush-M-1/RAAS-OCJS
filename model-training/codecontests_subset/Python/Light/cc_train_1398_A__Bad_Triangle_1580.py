import heapq
for _ in range(int(input())):
    heap = []
    n = int(input())
    x = list(map(int, input().split()))
    for i in x:
        heapq.heappush(heap, i)

    a = heapq.heappop(heap)
    i = x.index(a)
    b = heapq.heappop(heap)
    if a==b:
        j = i+1
    else:
        j = x.index(b)
    y = max(x)
    k = x.index(y)
    if a+b <= y:
        print(i+1, j+1, k+1)
    else:
        print(-1)

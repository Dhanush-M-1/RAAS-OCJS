import heapq
T = int(input())

for _ in range(T):
    N = int(input())
    score = 0
    want_left = []
    want_right = []
    for _ in range(N):
        K, L, R = map(int, input().split())
        if K == N:
            score += L
        elif L == R:
            score += L
        elif L > R:
            want_left.append((K, L-R))
            score += R
        else:
            want_right.append((N-K, R-L))
            score += L

    want_left.sort()
    left_q = []
    index = 0
    i = 0
    while index < len(want_left):
        i += 1
        while index < len(want_left) and want_left[index][0] <= i:
            heapq.heappush(left_q, want_left[index][1])
            index += 1
        while len(left_q) > i:
            heapq.heappop(left_q)
    score += sum(left_q)
    
    want_right.sort()
    right_q = []
    index = 0
    i = 0
    while index < len(want_right):
        i += 1
        while index < len(want_right) and want_right[index][0] <= i:
            heapq.heappush(right_q, want_right[index][1])
            index += 1
        while len(right_q) > i:
            heapq.heappop(right_q)
    score += sum(right_q)

    print(score)
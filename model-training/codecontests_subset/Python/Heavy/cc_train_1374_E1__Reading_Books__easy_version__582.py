from heapq import heappush, heappop
import math as m
n, k = map(int, input().split())
a_b = []
b_b = []
ab_b = []
for book in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 1:
        heappush(ab_b, t)
    elif a == 1:
        heappush(a_b, t)
    elif b ==1:
        heappush(b_b, t)
a_like = 0
b_like = 0
result = 0
while True:
    if a_like < k and b_like < k:
        if len(ab_b) == 0:
            if len(a_b) == 0:
                print(-1)
                exit()
            else:
                result += heappop(a_b)
                a_like += 1
            if len(b_b) == 0:
                print(-1)
                exit()
            else:
                result += heappop(b_b)
                b_like += 1
        else:
            anext = a_b[0] if len(a_b) > 0 else m.inf
            bnext = b_b[0] if len(b_b) > 0 else m.inf
            if anext + bnext < ab_b[0]:
                result += heappop(a_b)
                a_like += 1
                result += heappop(b_b)
                b_like += 1
            else:
                result += heappop(ab_b)
                a_like += 1
                b_like += 1
    elif a_like < k:
        if len(ab_b) == 0 and len(a_b) == 0:
            print(-1)
            exit()
        elif len(ab_b) == 0:
            result += heappop(a_b)
        elif len(a_b) == 0:
            result += heappop(ab_b)
        elif a_b[0] < ab_b[0]:
            result += heappop(a_b)
        else:
            result += heappop(ab_b)
    elif b_like < k:
        if len(ab_b) == 0 and len(b_b) == 0:
            print(-1)
            exit()
        elif len(ab_b) == 0:
            result += heappop(b_b)
        elif len(b_b) == 0:
            result += heappop(ab_b)
        elif b_b[0] < ab_b[0]:
            result += heappop(b_b)
        else:
            result += heappop(ab_b)
    else:
        break
print(result)

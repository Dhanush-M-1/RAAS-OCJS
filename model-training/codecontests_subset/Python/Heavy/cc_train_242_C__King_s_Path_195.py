from collections import deque, defaultdict
import itertools

x, y, xf, yf = map(int, input().split())

n = int(input())

allowed_cell = set()

for _ in range(n):
    r, a, b = map(int, input().split())
    for cell in range(a, b+1):
        allowed_cell.add((r, cell))



dst = defaultdict(lambda: -1)
dst[(x,y)] = 0
q = deque()
q.append((x, y))



while len(q):
    i, j = q.popleft()

    for d in itertools.product((0,1, -1), repeat=2):
        ni = i + d[0]
        nj = j + d[1]

        if 0 < ni <= 10**9 and 0 <nj <= 10**9 and (ni, nj) in allowed_cell and dst[(ni,nj)] == -1:
            dst[(ni, nj)] = dst[(i, j)] + 1
            q.append((ni, nj))
            if (ni, nj) == (xf, yf):
                break


print(dst[(xf, yf)])




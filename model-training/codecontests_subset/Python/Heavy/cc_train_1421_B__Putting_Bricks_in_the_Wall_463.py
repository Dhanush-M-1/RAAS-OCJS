import sys
from collections import deque
from itertools import product
from copy import deepcopy

sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline
f_inf = float('inf')
mod = 10 ** 9 + 7


def resolve():
    def bfs(num):
        que = deque([[0, 0]])
        visited = [[False] * n for _ in range(n)]
        visited[0][0] = True
        while que:
            h, w = que.popleft()
            for dh, dw in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                next_h, next_w = h + dh, w + dw
                if next_h < 0 or next_h >= n or next_w < 0 or next_w >= n:
                    continue
                if visited[next_h][next_w]:
                    continue
                elif S[next_h][next_w] == num or S[next_h][next_w] == "F":
                    visited[next_h][next_w] = True
                    que.append([next_h, next_w])
        return visited[-1][-1]

    t = int(input())
    for j in range(t):
        n = int(input())
        S_init = [list(input().rstrip()) for _ in range(n)]
        target = [(0, 1), (1, 0), (n - 2, n - 1), (n - 1, n - 2)]
        flg = False
        for pattern in product([0, 1], repeat=4):
            if flg:
                break
            if sum(pattern) > 2:
                continue
            S = deepcopy(S_init)
            res = []
            for idx, p in enumerate(pattern):
                if p == 1:
                    y, x = target[idx]
                    S[y][x] = "0" if S[y][x] == "1" else "1"
                    res.append([y + 1, x + 1])

            if not bfs("0") and not bfs("1"):
                print(len(res))
                for i in res:
                    print(*i)
                flg = True


if __name__ == '__main__':
    resolve()

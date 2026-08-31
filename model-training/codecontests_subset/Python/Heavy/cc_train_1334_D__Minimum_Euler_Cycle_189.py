import io
import os

from collections import Counter, defaultdict, deque


def solve(N, L, R):
    M = R - L + 1
    ans = []
    count = 0
    done = False
    for i in range(N - 1, -1, -1):
        if count + 2 * i < L:
            count += 2 * i
        else:
            curr = N - i
            for j in range(curr + 1, N + 1):
                if count + 1 >= L:
                    ans.append(str(curr))
                    if len(ans) == M:
                        done = True
                        break
                count += 1
                if count + 1 >= L:
                    ans.append(str(j))
                    if len(ans) == M:
                        done = True
                        break
                count += 1
            if done:
                break

    if len(ans) < M:
        ans.append("1")

    return " ".join(ans)


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        N, L, R = [int(x) for x in input().split()]
        ans = solve(N, L, R)
        print(ans)

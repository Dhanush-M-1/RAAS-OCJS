from collections import deque

def main():
    N, u, v, *AB = map(int, open(0).read().split())

    E = [[] for _ in range(N + 1)]
    for a, b in zip(*[iter(AB)] * 2):
        E[a].append(b)
        E[b].append(a)

    def solve(s):
        D = [-1] * (N + 1)
        D[s] = 0

        Q = deque([s])
        while Q:
            a = Q.popleft()
            for b in E[a]:
                if D[b] != -1:
                    continue
                D[b] = D[a] + 1
                Q.append(b)

        return D[1:]

    T = solve(u)
    A = solve(v)

    print(-1 + max(a for t, a in zip(T, A) if t < a))

main()
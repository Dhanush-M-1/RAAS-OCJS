import sys
input = sys.stdin.readline


def treeDist(u, E):
    D = [-1]*len(E)
    q = [(u, 0)]
    while q:
        i, d = q.pop()
        if D[i] != -1:
            continue
        D[i] = d
        for j in E[i]:
            q.append((j, d+1))
    return D


def main():
    N, u, v = map(int, input().split())
    E = [[] for i in range(N)]
    for _ in range(N-1):
        a, b = map(int, input().split())
        E[a-1].append(b-1)
        E[b-1].append(a-1)

    D1 = treeDist(u-1, E)
    D2 = treeDist(v-1, E)
    ans = 0
    for d1, d2 in zip(D1, D2):
        if d1 < d2:
            ans = max(ans, d2)
    print(ans-1)


if __name__ == '__main__':
    main()

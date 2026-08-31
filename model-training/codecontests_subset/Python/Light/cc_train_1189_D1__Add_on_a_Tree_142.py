
if __name__ == '__main__':
    n = int(input())
    g = [[] for _ in range(n)]
    for _ in range(n - 1):
        u, v = map(int, input().split())
        g[u - 1].append(v - 1)
        g[v - 1].append(u - 1)

    if list(filter(lambda x: len(x) == 2, g)):
        print("NO")
    else:
        print("YES")
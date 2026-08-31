from sys import stdin


def main():
    n, m, points = map(int, stdin.readline().split())
    mat = []
    for _ in range(n):
        mat.append(list(stdin.readline()))
    check = [[False for _ in range(m)] for _ in range(n)]
    q = []
    end = {}
    time = 0
    for i in range(n):
        for j in range(m):
            if not check[i][j] and mat[i][j] == '.':
                q.append((i, j))
                check[i][j] = True
                while q:
                    x, y = q.pop()
                    time += 1
                    dx = [-1, 1, 0, 0]
                    dy = [0, 0, -1, 1]
                    candidates = []
                    for k in range(4):
                        if 0 <= x + dx[k] < n and 0 <= y + dy[k] < m:
                            if not check[x + dx[k]][y + dy[k]] and mat[x + dx[k]][y + dy[k]] == '.':
                                candidates.append((x + dx[k], y + dy[k]))
                                check[x + dx[k]][y + dy[k]] = True
                    if not candidates:
                        end[(x, y)] = time
                    else:
                        q.append((x, y))
                        for p in candidates:
                            q.append(p)
    keys = list(end.keys())
    keys.sort(key=lambda key: end[key])
    for i in range(points):
        x, y = keys[i]
        mat[x][y] = 'X'
    for r in mat:
        print(''.join(r), end="")


if __name__ == '__main__':
    main()

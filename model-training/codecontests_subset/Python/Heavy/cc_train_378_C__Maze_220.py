def solve(matrix, n, m, k):
    from collections import deque
    answer = []
    tovisit = deque()
    quit = False
    visited = set()
    for i in range(n):
        if quit:
            break
        for j in range(m):
            if matrix[i][j] == '.':
                tovisit.append((i, j))
                quit = True
                break
    while len(tovisit) > 0:
        i, j = tovisit.pop()
        if (i, j) in visited:
            continue
        answer.append((i, j))
        visited.add((i, j))
        for a in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
            if 0 <= i+a[0] < n and 0 <= j+a[1] < m:
                if matrix[i+a[0]][j+a[1]] == '.':
                    if (i+a[0], j+a[1]) not in visited:
                        tovisit.append((i+a[0], j+a[1]))
    for i in range(k):
        matrix[answer[-i-1][0]][answer[-i-1][1]] = 'X'
    for x in matrix:
        print(''.join(x))

def main():
    n, m, k = tuple(map(int, input().rstrip().split()))
    matrix = []
    for i in range(n):
        matrix.append(list(input().rstrip()))
    solve(matrix, n, m, k)

if __name__ == '__main__':
    main()

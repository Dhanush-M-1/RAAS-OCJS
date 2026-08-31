import itertools

def solve(matrix):
    n = len(matrix)
    cells = [
        (0, 1),
        (1, 0),
        (n - 1, n - 2),
        (n - 2, n - 1)
    ]
    for ncells in range(3):
        for combi in itertools.combinations(cells, ncells):
            for y, x in combi:
                matrix[y][x] = '1' if matrix[y][x] == '0' else '0'

            if matrix[0][1] == matrix[1][0] != matrix[n - 1][n - 2] == matrix[n - 2][n - 1]:
                return combi

            for y, x in combi:
                matrix[y][x] = '1' if matrix[y][x] == '0' else '0'




for _ in range(int(input())):
    n = int(input())
    matrix = []
    for _ in range(n):
        *row, = input()
        matrix.append(row)
    ans = solve(matrix)
    print(len(ans))
    for y, x in ans:
        print(y + 1, x + 1)

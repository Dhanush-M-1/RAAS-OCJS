import itertools
import copy


def index(grid, ix):
    return grid[ix[0]][ix[1]]

def index_set(grid, ix, val):
    grid[ix[0]][ix[1]] = val

def index_flip(grid, ix):
    bit = ord(index(grid, ix)) - ord('0')
    new = chr((1 - bit) + ord('0'))
    index_set(grid, ix, new)


def solve(n, grid):
    ri = (0, 1)
    di = (1, 0)
    ui = (n - 2, n - 1)
    li = (n - 1, n - 2)

    indices = [ri, di, ui, li]

    for p in itertools.product(*([range(2)] * 4)):
        if sum(p) > 2:
            continue

        # flip
        new_grid = copy.deepcopy(grid)
        for i, x in enumerate(p):
            if x == 1:
                # flip this index
                index_flip(new_grid, indices[i])

        # check
        r = index(new_grid, ri)
        d = index(new_grid, di)
        u = index(new_grid, ui)
        l = index(new_grid, li)
        if r == d and u == l and r != u:
            return [(r + 1, c + 1) for i, (r, c) in enumerate(indices) if p[i] == 1]


def main():
    nt = int(input())
    for _ in range(nt):
        n = int(input())
        grid = []
        for _ in range(n):
            grid.append(list(input()))

        sol = solve(n, grid)
        print(len(sol))
        for r, c in sol:
            print(r, c)


def test():
    n = 4
    grid = [list(r) for r in ['S010', '0001', '1000', '111F']]
    print(solve(n, grid))


if __name__ == '__main__':
    main()
    # test()


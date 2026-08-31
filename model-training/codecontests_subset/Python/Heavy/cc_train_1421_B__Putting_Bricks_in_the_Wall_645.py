from sys import stdin, gettrace

if gettrace():
    inputi = input
else:
    def input():
        return next(stdin)[:-1]


    def inputi():
        return stdin.buffer.readline()


def solve():
    n = int(input())
    grid = []
    for _ in range(n):
        grid.append(input())
    res = []
    if grid[0][1] == grid[1][0]:
        if grid[-1][-2] == grid[0][1]:
            res.append((n,n-1))
        if grid[-2][-1] == grid[0][1]:
            res.append((n-1,n))
    elif grid[-1][-2] == grid[-2][-1]:
        if grid[0][1] == grid[-1][-2]:
            res.append((1,2))
        if grid[1][0] == grid[-2][-1]:
            res.append((2,1))
    else:
        if grid[0][1] == '1':
            res.append((1,2))
        else:
            res.append((2,1))
        if grid[-1][-2] == '0':
            res.append((n,n-1))
        else:
            res.append((n-1, n))
    print(len(res))
    for x,y in res:
        print(x, y)



def main():
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == "__main__":
    main()

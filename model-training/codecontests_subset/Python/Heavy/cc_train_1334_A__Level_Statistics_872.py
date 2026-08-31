def solve(n, parr, carr):
    if parr[0] < carr[0]:
        return False
    for i in range(1, n):
        if parr[i - 1] > parr[i]:
            return False
        if carr[i - 1] > carr[i]:
            return False
        if parr[i] - parr[i - 1] < carr[i] - carr[i - 1]:
            return False
    return True


for _ in range(int(input())):
    n = int(input())
    parr, carr = list(), list()
    for i in range(n):
        p, c = map(int, input().split())
        parr.append(p)
        carr.append(c)
    print('YES') if solve(n, parr, carr) else print('NO')

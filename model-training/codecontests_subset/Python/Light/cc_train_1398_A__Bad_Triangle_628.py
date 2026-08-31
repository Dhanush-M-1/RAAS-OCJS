def checker(n, lst):
    if lst[0] + lst[1] <= lst[-1]:
        return 1, 2, n
    return -1,


for _ in range(int(input())):
    m = int(input())
    a = [int(i) for i in input().split()]
    print(*checker(m, a))

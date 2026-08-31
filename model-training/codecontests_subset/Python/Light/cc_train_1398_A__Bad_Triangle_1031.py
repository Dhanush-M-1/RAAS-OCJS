for _ in range(int(input())):
    rets = [-1]
    lens = int(input())
    arrs = sorted([int(x) for x in input().split()])
    if arrs[0] + arrs[1] <= arrs[-1]:
        rets = [1, 2, lens]
    print(*rets)
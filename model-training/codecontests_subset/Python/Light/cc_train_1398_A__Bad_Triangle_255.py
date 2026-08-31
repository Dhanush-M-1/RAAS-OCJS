def solve(a):
    if a[0] + a[1] <= a[-1]:
        return 1, 2, len(a)
    return [-1]

for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    print(*solve(a))

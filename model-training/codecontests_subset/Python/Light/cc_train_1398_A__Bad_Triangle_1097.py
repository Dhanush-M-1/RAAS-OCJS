t = int(input())

for _ in range(t):
    n = int(input())
    lst = [int(c) for c in input().split()]
    if lst[0] + lst[1] > lst[-1]:
        print(-1)
    else:
        print(1, 2, n)

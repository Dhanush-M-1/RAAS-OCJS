t = int(input())

for test in range(0, t):
    n = int(input())
    sides = list(map(int, input().split(' ')))

    if sides[0] + sides[1] <= sides[n-1]:
        print(1, 2, n)
    else:
        print(-1)

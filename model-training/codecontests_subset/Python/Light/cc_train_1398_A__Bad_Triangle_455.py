from sys import stdin

for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    a = list(map(int, stdin.readline().split()))
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)
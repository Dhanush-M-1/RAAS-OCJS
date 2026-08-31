from sys import stdin

inp = lambda : stdin.readline().strip()

t = int(inp())
for _ in range(t):
    n = int(inp())
    a = [int(x) for x in inp().split()]
    flag = False
    for i in range(2, n):
        if a[i] >= a[0] + a[1]:
            print(1, 2, i+1)
            flag = True
            break
    if not flag:
        print(-1)
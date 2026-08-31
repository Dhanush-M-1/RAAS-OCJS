from sys import stdin

inp = stdin.readline
t = int(inp().strip())
for _ in range(t):
    n = int(inp().strip())
    a = []
    prevP = 0
    prevC = 0
    for i in range(n):
        a.append([int(x) for x in inp().strip().split()])
    for i in range(n):
        if a[i][0] < a[i][1]:
            print("NO")
            break
        elif a[i][0] < prevP:
            print("NO")
            break
        elif a[i][1] < prevC:
            print("NO")
            break
        elif a[i][1]-prevC > a[i][0] - prevP:
            print("NO")
            break
        prevC = a[i][1]
        prevP = a[i][0]
    else:
        print("YES")

